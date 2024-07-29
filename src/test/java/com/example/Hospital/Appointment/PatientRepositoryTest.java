package com.example.Hospital.Appointment;

import com.example.Hospital.Appointment.Entity.PatientUser;
import com.example.Hospital.Appointment.Repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testFindByEmail() {
        PatientUser user = new PatientUser("John", "Doe", "john.doe@example.com", "password", null);
        patientRepository.save(user);

        PatientUser foundUser = patientRepository.findByEmail("john.doe@example.com");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("john.doe@example.com");
    }
}
