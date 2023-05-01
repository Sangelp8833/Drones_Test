package co.com.samuel.jpa.medications;

import co.com.samuel.jpa.drones.DronesData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "medication")
public class MedicationsData {

    @Id
    @Column(name = "medication_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Double weight;

    @NotNull
    private String code;

    @NotNull
    private String imageLink;

    @ManyToOne
    @JoinColumn(name = "drones_id")
    private DronesData dronesData;
}
