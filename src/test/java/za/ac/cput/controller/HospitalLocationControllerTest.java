/* AddressControllerTest.java
 Test class for AddressController
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HospitalLocationControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private HospitalLocationController hospitalLocationController;
    @Autowired private TestRestTemplate restTemplate;

    private HospitalLocation hospitalLocation;
    private Hospital hospital;
    private Location location;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(hospitalLocationController);
        this.location = LocationFactory.createLocation("Johnson",75,"Deip River",7600);
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.hospitalLocation = HospitalLocationFactory.createHospitalLocation(hospital, location);

        this.baseUrl = "http://localhost:"+ this.port + "hospital_appointment_management-db/hospitalLocation/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<HospitalLocation> response = this.restTemplate.postForEntity(url, this.hospitalLocation, HospitalLocation.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl+"read/" + this.hospitalLocation.getHospitalLocationId();
        System.out.println(url);
        ResponseEntity<HospitalLocation> response = this.restTemplate.getForEntity(url, HospitalLocation.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<HospitalLocation[]> response = this.restTemplate.getForEntity(url, HospitalLocation[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.hospitalLocation.getHospitalLocationId();
        this.restTemplate.delete(url);
    }


}