package co.com.samuel.model.drones;

import lombok.Data;

@Data
public class DronesDto {
    private String serialNumber;
    private String model;
    private Double weightLimit;
    private Double batteryCapacity;
    private String state;
}
