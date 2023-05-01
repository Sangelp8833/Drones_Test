package co.com.samuel.model.medication.gateway;

import co.com.samuel.model.medication.Medication;

public interface MedicationRepository {


    Medication findByMedicationCode(String medicationCode);

}
