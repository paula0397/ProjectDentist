package main.service;

import main.dao.DentistDaoH2;
import main.dao.IDao;
import main.model.Dentist;

public class DentistService {

    private IDao<Dentist> dentistIDao;

    public DentistService(){ dentistIDao = new DentistDaoH2();}

    public Dentist save(Dentist dentist){return dentistIDao.save(dentist);}




}
