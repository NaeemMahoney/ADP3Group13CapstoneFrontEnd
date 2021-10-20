package za.ac.cput.factory.medication;



import za.ac.cput.entity.medication.Prescription;
import za.ac.cput.util.GenericHelper;

public class PrescriptionFactory {
    public static Prescription buildPrescription(String name, String patientNumber, String bill,String dosage){

        String prescriptionID = GenericHelper.IDGenerator();
        Prescription prescription = new Prescription.Builder()
                .setPrescriptionID(prescriptionID)
                .setName(name)
                .setPatientNumber(patientNumber)
                .setBill(bill)
                .setDosage(dosage)
                .build();


        return prescription;


    }

}
