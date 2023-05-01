package co.com.samuel.usecase.drones;

import co.com.samuel.model.drones.Drones;
import co.com.samuel.model.drones.DronesDto;
import co.com.samuel.model.drones.gateway.DronesRepository;
import co.com.samuel.model.medication.Medication;
import co.com.samuel.model.medication.gateway.MedicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log
public class DronesUsecases {

    private final DronesRepository dronesRepository;
    private final MedicationRepository medicationRepository;

    Drones saveDrones(Drones drone){
        Drones drones = dronesRepository.saveDrone(drone);
        if(drone != null){
            log.info("saving a drone information");
            return drone;
        }
        return null;
    }

    Drones registerDrones(DronesDto dronesDto) {
        Drones drone = dronesRepository.registerDrones(dronesDto);
        if(drone != null){
            log.info("Registering a new Drone");
            return drone;
        }
        return null;
    }

    Drones findBySerialNumber(String serialNumber) {
        Drones drone = dronesRepository.findBySerialNumber(serialNumber);
        if(drone != null){
            log.info("A drone has been found");
            return drone;
        }
        return null;
    }

    //TODO: Verificar cada que se cargue el dron que no quedé con más peso del que puede cargar.
    Drones loadingMedication(String serialNumber, List<String> medicationCodes) {
        Drones drone = findBySerialNumber(serialNumber);
        if(drone != null){
            List<Medication> medications = new ArrayList<>();
            medicationCodes.forEach(mc -> {
                Medication medication  = medicationRepository.findByMedicationCode(mc);
                if(medication != null){
                    medications.add(medication);
                }
            });
            drone.setMedicationList(medications);
            Drones savedDrone = saveDrones(drone);
            assert savedDrone != null;
            log.info("The drone has been loaded");
            return saveDrones(savedDrone);
        }
        return null;
    }

    List<Medication> checkingLoadedMedication(String serialNumber) {
        Drones drone = findBySerialNumber(serialNumber);
        if(drone != null){
            List<Medication> medicationList = drone.getMedicationList();
            return medicationList;
        }
        return Collections.emptyList();
    }

    List<Drones> findAvailableDrones() {
        List<Drones> dronesList = dronesRepository.findAll();
        List<Drones> availableDrones = new ArrayList<>();
        dronesList.forEach(d -> {
            List<Double> medicationsWeight = checkingLoadedMedication(d.getSerialNumber())
                    .stream().map(Medication::getWeight).collect(Collectors.toList());
            Double totalWeight = medicationsWeight.stream().reduce(Double::sum).orElse(null);
            assert totalWeight != null;
            if(totalWeight <= d.getWeightLimit()){
                availableDrones.add(d);
            }
        });
        log.info("Available drones");
        return availableDrones;
    }

    void checkingBatteryLevel(String serialNumber) {
    }

}
