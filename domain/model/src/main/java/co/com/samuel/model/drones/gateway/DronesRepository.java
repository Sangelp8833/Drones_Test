package co.com.samuel.model.drones.gateway;

import co.com.samuel.model.drones.Drones;
import co.com.samuel.model.drones.ClientsDto;

import java.util.Map;

public interface DronesRepository<T,E> {

    Drones save(ClientsDto clientsDto);
    Drones findById(Long id);
    E findAll(T pageable);
    boolean delete(Long id);
    boolean update(Map<String, Object> partialUpdate, Long id);

}
