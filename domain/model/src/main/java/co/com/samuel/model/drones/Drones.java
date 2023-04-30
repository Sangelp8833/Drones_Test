package co.com.samuel.model.drones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drones {

    private Long id;
    private String name;
    private String email;
    private Long nit;
    private String role;

}
