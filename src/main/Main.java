package main;

import main.dao.DB;
import main.model.Dentist;
import main.model.Patient;
import main.service.DentistService;
import main.service.PatientService;

public class Main {

    public static void main(String[] args) {

        DB.CREATE_TABLE();
        PatientService patientService = new PatientService();

        Patient patient1 = new Patient(1,"Paula", "Hernandez", "paula@gmail.com","123",524,"cra", "3 noviembre" );
        Patient patient2 = new Patient(2,"Carlos", "Gutierrez", "carlos@gmail.com","456",963,"cra", "3 noviembre" );

        patientService.save(patient1);
        patientService.save(patient2);

        DentistService dentistService = new DentistService();
        Dentist dentist1 = new Dentist(1,"Camila", "Lopez", "camila@gmail.com","789","555");
        Dentist dentist2 = new Dentist(2,"Sofia", "Rodriguez", "sofia@gmail.com","123","528");

        dentistService.save(dentist1);
        dentistService.save(dentist2);

    }
}
