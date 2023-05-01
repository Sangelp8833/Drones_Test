package co.com.samuel.model.drones;

import co.com.samuel.model.medication.Medication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drones {

    private Long id;
    private String serialNumber;
    private String model;
    private Double weightLimit;
    private Double batteryCapacity;
    private String state;
    private List<Medication> medicationList;

}
