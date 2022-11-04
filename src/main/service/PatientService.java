package main.service;

import main.dao.IDao;
import main.dao.PatientDaoH2;
import main.model.Patient;

public class PatientService {

    private IDao<Patient> patientIDao;

    public  PatientService(){
        patientIDao = new PatientDaoH2();
    }

    public Patient save (Patient patient){
        return patientIDao.save(patient);
    }
}
