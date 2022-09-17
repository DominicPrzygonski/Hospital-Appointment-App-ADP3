package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.domain.PatientGender;
import za.ac.cput.util.Helper;

public class PatientGenderFactory {
    public static PatientGender createPatientGender(String patientID, String genderID){
        //Check for empty or null
        if(Helper.isNullEmpty(patientID) || Helper.isNullEmpty(genderID))
            return null;

        //Generating patientGenderID
        String patientIDGen = Helper.generateID();

        return new PatientGender.patientGenderBuilder().setPatientID(patientID)
                                                       .setGenderID(genderID)
                                                       .Builder();
    }
}
