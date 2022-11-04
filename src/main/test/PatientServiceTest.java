package main.test;


import main.model.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientServiceTest {

    @Test
    public void goodPassword(){
        Patient patient1 = new Patient(1,"Paula", "Hernandez", "paula@gmail.com","123",524,"cra", "3 noviembre" );


        boolean isCorrect = patient1.getPassword() == "123";
        assertTrue(isCorrect);

    }









}
