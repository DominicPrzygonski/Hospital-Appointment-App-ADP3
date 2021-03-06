package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.entity.patientGender;
import za.ac.cput.util.Helper;

public class patientGenderFactory {
    public static patientGender createPatientGender(String patientID, String genderID){
        //-----Checking for empty or null variables------
        if(Helper.isNullEmpty(patientID) || Helper.isNullEmpty(genderID))
            return null;

        //-----Generating AppointmentID-----
        String patientIDGen = Helper.generateID();

        return new patientGender.patientGenderBuilder().setPatientID(patientID)
                                                       .setGenderID(genderID)
                                                       .Builder();
    }
}
