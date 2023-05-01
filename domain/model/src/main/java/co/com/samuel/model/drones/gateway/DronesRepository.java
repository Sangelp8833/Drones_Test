package co.com.samuel.model.drones.gateway;

import co.com.samuel.model.drones.Drones;
import co.com.samuel.model.drones.DronesDto;
import co.com.samuel.model.medication.Medication;

import java.util.List;
import java.util.Map;

public interface DronesRepository {

    Drones saveDrone(Drones drones);
    Drones registerDrones(DronesDto dronesDto);
    Drones findBySerialNumber(String serialNumber);
    Drones loadingMedication(String serialNumber, List<String> medicationCodes);
    List<Medication> checkingLoadedMedication(String serialNumber);
    List<Drones> findAvailableDrones();
    List<Drones> findAll();
    void checkingBatteryLevel(String serialNumber);

}
