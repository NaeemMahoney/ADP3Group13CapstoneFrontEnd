package za.ac.cput.entity.medication;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/* Prescription.java
This is the entity for the prescription
Author: Ratidzai Makondo - (218187289)
Date: 11 June 2021
 */

@Entity
//@Table(name="Prescription")
public class  Prescription  {
    @Id
    private String prescriptionID ;
    private String name;
    private String patientNumber;
    private String bill;
    private String dosage;


    public Prescription() {

    }

    private Prescription(Builder builder) {
        this.prescriptionID = builder.prescriptionID;
        this.name = builder.name;
        this.patientNumber = builder.patientNumber;
        this.bill = builder.bill;
        this.dosage = builder.dosage;
    }
    public String getPrescriptionID() {
        return prescriptionID;
    }

    public String getName() {
        return name;
    }

    public String getPatientNumber() {
        return patientNumber;
    }
    public String getBill() {
        return bill;
    }

    public String getDosage() {
        return dosage;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId='" + prescriptionID + '\'' +
                ", name='" + name + '\'' +
                ", patientNumber='" + patientNumber + '\'' +
                ", bill=" + bill + '\'' +
                ", dosage=" + dosage +
                '}';
    }

    public static class Builder{
        private String prescriptionID;
        private String name;
        private String patientNumber;
        private String bill;
        private String dosage;


        public Builder setPrescriptionID(String prescriptionID){
            this.prescriptionID  = prescriptionID;
            return this;

        }
        public Builder setName(String name) {
            this.name= name;
            return this;
        }
        public Builder setPatientNumber(String patientNumber) {
            this.patientNumber = patientNumber;
            return this;
        }

        public Builder setBill(String bill) {
            this.bill = bill;
            return this;
        }
        public Builder setDosage(String dosage) {
            this.dosage = dosage;
            return this;
        }

        public Builder copy(Prescription prescription) {
            this.prescriptionID = prescription.prescriptionID;
            this.name = prescription.name;
            this.patientNumber = prescription.patientNumber;
            this.bill = prescription.bill;
            this.dosage = prescription.dosage;

            return this;
        }

        public Prescription build() {
            return new Prescription(this);

        }

    }
}