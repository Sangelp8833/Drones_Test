package co.com.samuel.jpa.drones;

import co.com.samuel.jpa.medications.MedicationsData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "drones")
public class DronesData {

    @Id
    @Column(name = "drones_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String serialNumber;

    @NotNull
    private String model;

    @NotNull
    private Double weightLimit;

    @NotNull
    private Double batteryCapacity;

    @NotNull
    private String state;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "dronesData")
    private List<MedicationsData> medicationList;

}
