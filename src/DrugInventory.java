import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DrugInventory {

    public static void main(String[] args) {
        
            
        String[] drugList=new String[5];
        drugList[0]="Acetaminophen-100";
        drugList[1]="Amlodipine-200";
        drugList[2]="Lorazepam-150";
        drugList[3]="Oxycodone-20";
        drugList[4]="Ibuprofen-500";
    
        
        Prescription[] prescriptionList=new Prescription[5];
        prescriptionList[0]=new Prescription("SABU", "Acetaminophen", 99);
        prescriptionList[1]=new Prescription("ANOOP", "Amlodipine", 64);
        prescriptionList[2]=new Prescription("TARA", "Lorazepam", 22);
        prescriptionList[3]=new Prescription("MEGHNA", "Ibuprofen", 11);
        prescriptionList[4]=new Prescription("REEJA", "Oxycodone", 33);
        
        Scanner sc=new Scanner(System.in);
        int counter=sc.nextInt();
        
        Prescription p=null;
        String result=null;
        if(counter==1)
        {
            p=new Prescription("NEENA", "Lorazepam", 149);
            result=checkDrugDispense(p, drugList);
            System.out.println(result);
            
            Prescription res = findPrescriptionWithMinQuantity(prescriptionList);
            System.out.println("Drug name - "+ res.getDrugName()+" Drug Quantity -"+ res.getQuantity());
        }
        else if(counter==2)
        {
            p=new Prescription("SITA", "Ibuprofen", 501);
            result=checkDrugDispense(p, drugList);
            System.out.println(result);
            
            prescriptionList[3]=new Prescription("MEGHNA", "Ibuprofen", 23);
            Prescription res = findPrescriptionWithMinQuantity(prescriptionList);
            System.out.println("Drug name - "+ res.getDrugName()+" Drug Quantity -"+ res.getQuantity());
        }
        else if(counter==3)
        {
            p=new Prescription("SHYAM", "Amoodipine", 34);
            result=checkDrugDispense(p, drugList);
            System.out.println(result);
            
            prescriptionList[0]=new Prescription("SABU", "Acetaminophen", 2);
            Prescription res = findPrescriptionWithMinQuantity(prescriptionList);
            System.out.println("Drug name - "+ res.getDrugName()+" Drug Quantity -"+ res.getQuantity());
        }
                
        sc.close();
    }//main method ends
    
   //Implement the two static methods here 
    public static Prescription findPrescriptionWithMinQuantity(Prescription[] prescriptionList){
    	for(int i=0;i<prescriptionList.length;i++) {
    		for(int j=i+1;j<prescriptionList.length;j++) {
    			if(prescriptionList[i].getQuantity()>prescriptionList[j].getQuantity()) {
    				Prescription temp=prescriptionList[i];
    				prescriptionList[i]=prescriptionList[j];
    				prescriptionList[j]=temp;
    			}
    		}
    	}
    	return prescriptionList[0];
    }
    public static String checkDrugDispense(Prescription prescription,String[] drugList) {
    	for(int i=0;i<drugList.length;i++) {
    		//String pro=drugList[i];
    		String[] pro=drugList[i].split("-");
    		if(prescription.getDrugName().equalsIgnoreCase(pro[0])) {
    			int k=Integer.parseInt(pro[1]);
    			if(prescription.getQuantity()<=k) {
    				return "Drug Found and can be dispensed";
    				
    			}
    			else
    			{
    				return "Drug Found but cannot be dispensed";
    			}
    		}
    		else {
    			return "Drug not found";
    		}
    	}
    	return "shubham";
    }
    
        
}//end of DrugInventory class

class Prescription
{
    //Implement attributes,constructors,getters and setters
	private String patientName;
	private String drugName;
	private int quantity;
	public Prescription(String patientName, String drugName, int quantity) {
		super();
		this.patientName = patientName;
		this.drugName = drugName;
		this.quantity = quantity;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}