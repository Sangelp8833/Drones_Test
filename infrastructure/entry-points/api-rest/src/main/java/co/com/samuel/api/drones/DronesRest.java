package co.com.samuel.api.drones;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = DronesRest.ENTRY_POINT)
public class DronesRest {
    protected static final String ENTRY_POINT = "/drones";
}
