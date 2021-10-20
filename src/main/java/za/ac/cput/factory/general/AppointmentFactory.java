package za.ac.cput.factory.general;
/* AppointmentFactory.java
   Factory class for Appointment
   Author: Nolusindiso Makosa (219023557)
   Due Date: 20 October 2021
*/

import za.ac.cput.entity.general.Appointment;
import za.ac.cput.util.GenericHelper;

public class AppointmentFactory {
    public static Appointment build(String date, String time, String reason,
                                    String patientNumber, String doctorNumber, String receptionistNumber)
    {
        String appointmentID = GenericHelper.IDGenerator();

        Appointment appointment = new Appointment.Builder()
                .setAppointmentID(appointmentID)
                .setDate(date)
                .setTime(time)
                .setReason(reason)
                .setPatientNumber(patientNumber)
                .setDoctorNumber(doctorNumber)
                .setReceptionistNumber(receptionistNumber)
                .build();

        return appointment;
    }
}
