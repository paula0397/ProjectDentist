package main.dao;

import main.model.Dentist;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DentistDaoH2 implements IDao<Dentist> {

    private static final String SQL_INSERT_DENTIST = "INSERT INTO DENTIST" + "VALUES (?,?,?,?,?,?)";

    private static final String SQL_DELETE_DENTIST = "DELETE FROM DENTIST WHERE ID = ?";

    private static final String SQL_SELECT_DENTIST = "DELETE * FROM DENTIST WHERE ID = ?";

    private static final Logger LOGGER= Logger.getLogger(DentistDaoH2.class);



    @Override
    public Dentist save(Dentist dentist) {
        LOGGER.info("Dentist incorporation request was initiated");
        Connection connection = null;

        try{
            connection = DB.getConnection();

            PreparedStatement psInsertDentist = connection.prepareStatement(SQL_INSERT_DENTIST);
            psInsertDentist.setInt(1, dentist.getId());
            psInsertDentist.setString(2, dentist.getFirstName());
            psInsertDentist.setString(3, dentist.getLastName());
            psInsertDentist.setString(4, dentist.getEmail());
            psInsertDentist.setString(5, dentist.getPassword());
            psInsertDentist.setString(6, dentist.getRegistration());

            psInsertDentist.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception x){
                x.printStackTrace();
            }
        }
        return dentist;
    }


    @Override
    public void remove(Integer id) {
        Connection connection = null;

        try{
            LOGGER.info("The removal dentist id has started " + id );
            connection=DB.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE_DENTIST);
            psDelete.setInt(1, id);
            psDelete.execute();
            LOGGER.error("The id has been deleted " + id);
        }catch (Exception e){
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception x){
                x.printStackTrace();
            }
        }

    }

    @Override
    public Dentist search(Integer id) {
        Connection connection = null;

        Dentist dentist = null;

        try{
            LOGGER.info("Search for id: " + id);
            connection = DB.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT_DENTIST);
            psSelect.setInt(1, id);
            ResultSet res = psSelect.executeQuery();

            while (res.next()){
                dentist = new Dentist(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception x){
                x.printStackTrace();
            }
        }return dentist;
    }
}
