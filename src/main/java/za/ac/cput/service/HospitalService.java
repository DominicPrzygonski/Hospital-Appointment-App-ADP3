/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Hospital;
import za.ac.cput.repository.IHospitalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService implements IHospitalService{

    private static IHospitalRepository repository = null;

    @Autowired
    private HospitalService(IHospitalRepository hospitalRepository){
        this.repository = hospitalRepository;
    }

    @Override
    public Hospital save(Hospital hospital) {
        return this.repository.save(hospital);
    }

    @Override
    public Optional<Hospital> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Hospital hospital) {
        this.repository.delete(hospital);
    }

    @Override
    public List<Hospital> getAll() {
        return this.repository.findAll();
    }
}
