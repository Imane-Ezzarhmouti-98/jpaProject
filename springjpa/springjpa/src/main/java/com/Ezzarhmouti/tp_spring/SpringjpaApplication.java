package com.Ezzarhmouti.tp_spring;
import com.Ezzarhmouti.tp_spring.model.Patient;
import com.Ezzarhmouti.tp_spring.model.PatientRepository;
import com.Ezzarhmouti.tp_spring.model.User;
import com.Ezzarhmouti.tp_spring.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringjpaApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringjpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(null, "Ezzarhmouti", "Ezzarhmouti", new String[] {"ADMIN"}));
        patientRepository.save(new Patient(null,"Fatima",new Date(),2300,false));
        patientRepository.save(new Patient(null,"Salma",new Date(),300,true));
        patientRepository.save(new Patient(null,"Malak",new Date(),2200,false));
        patientRepository.save(new Patient(null,"Yassine",new Date(),2000,false));
        patientRepository.save(new Patient(null,"test",new Date(),2000,false));
        patientRepository.save(new Patient(null,"Fatima",new Date(),2500,false));
        patientRepository.save(new Patient(null,"Salma",new Date(),330,true));
        patientRepository.save(new Patient(null,"Malak",new Date(),2200,false));
        patientRepository.save(new Patient(null,"Yassine",new Date(),2000,false));
        patientRepository.save(new Patient(null,"test",new Date(),2000,false));

      

    }
}
