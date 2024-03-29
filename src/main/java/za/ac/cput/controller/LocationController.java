/* AddressController.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.HospitalAPI;
import za.ac.cput.api.LocationAPI;
import za.ac.cput.domain.Hospital;
import za.ac.cput.domain.Location;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/hospital_appointment_management-db/location")
@Slf4j
public class LocationController {

    private LocationAPI api;

    @Autowired public LocationController(LocationAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Location> save(@Valid @RequestBody Location location){
        log.info("Save request: {}", location);
        Location response = this.api.save(location);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{location_id}")
    public ResponseEntity<Location> read(@PathVariable String location_id){
        log.info("Read request: {}", location_id);
        Location response = this.api.read(location_id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{location}")
    public ResponseEntity<Void> delete(@PathVariable Location location){
        log.info("Delete request: {}", location);
        this.api.delete(location);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Location>> getAll(){
        List<Location> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}
