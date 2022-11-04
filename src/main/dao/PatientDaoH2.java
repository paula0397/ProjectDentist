package main.dao;

import main.model.Patient;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDaoH2 implements IDao<Patient>{


    private static final String SQL_INSERT_PATIENT = "INSERT INTO PATIENT(id, firstName, lastName, email, password, DNI, address, present_date)" + "VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_DELETE_PATIENT = "DELETE FROM PATIENT WHERE ID = ?";

    private static final String SQL_SELECT_PATIENT = "DELETE * FROM PATIENT WHERE ID = ?";
    private static final Logger LOGGER= Logger.getLogger(PatientDaoH2.class);


    @Override
    public Patient save(Patient patient) {
        LOGGER.info("A patient incorporation request was initiated");
        Connection connection = null;

        try{

        connection = DB.getConnection();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT_PATIENT);

            psInsert.setInt(1, patient.getId());
            psInsert.setString(2, patient.getFirstName());
            psInsert.setString(3, patient.getLastName());
            psInsert.setString(4, patient.getEmail());
            psInsert.setString(5, patient.getPassword());
            psInsert.setInt(6, patient.getDNI());
            psInsert.setString(7, patient.getAddress());
            psInsert.setString(8, patient.getPresent_Date());

            psInsert.execute();


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception x){
                x.printStackTrace();
            }
        }
        return patient;
    }

    @Override
    public void remove(Integer id) {
        Connection connection = null;

        try{
            LOGGER.info("Delete patient with id started " + id);
            connection = DB.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE_PATIENT);
            psDelete.setInt(1,id);
            psDelete.execute();
            LOGGER.error("id has been delete: " + id);
        }catch (Exception e){
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception x){
                x.printStackTrace();
            }
        }

    }

    @Override
    public Patient search(Integer id) {
        Connection connection = null;

        Patient patient = null;

        try {
            LOGGER.info("Search patient with id has started: " + id);
            connection = DB.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT_PATIENT);
            psSelect.setInt(1, id);
            ResultSet res = psSelect.executeQuery();

            while (res.next()){
                patient = new Patient(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getString(8));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception x){
                x.printStackTrace();
            }
        }
        return patient;
    }

}
