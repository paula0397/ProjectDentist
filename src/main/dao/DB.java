package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    private static final String CREATE_TABLE_PATIENT = "DROP TABLE IF EXISTS PATIENT;" +
            "CREATE TABLE PATIENT (" +
            "ID INT PRIMARY KEY," +
            "FIRSTNAME VARCHAR(100) NOT NULL," +
            "LASTNAME VARCHAR(100) NOT NULL," +
            "EMAIL VARCHAR NOT NULL," +
            "PASSWORD VARCHAR(50) NOT NULL," +
            "DNI INT NOT NULL," +
            "ADDRESS VARCHAR(50) NOT NULL," +
            "PRESENT_DATE VARCHAR(50) NOT NULL" +
            ")";


    private static final String CREATE_TABLE_DENTIST = "DROP TABLE IF EXISTS DENTIST;" +
            "CREATE TABLE DENTIST (" +
            "ID INT PRIMARY KEY," +
            "FIRSTNAME VARCHAR(100) NOT NULL," +
            "LASTNAME VARCHAR(100) NOT NULL," +
            "EMAIL VARCHAR NOT NULL," +
            "PASSWORD VARCHAR(50) NOT NULL," +
            "REGISTRATION INT NOT NULL" +            ")";

    private static final String CREATE_TABLE_TURN = "DROP TABLE IF EXISTS TURN;" +
            "CREATE TABLE TURN ("
            + " ID INT PRIMARY KEY,"
            + " ID_PATIENT INT NOT NULL,"
            + " ID_DENTIST INT NOT NULL,"
            + " ADMISSION_DATE varchar(50) NOT NULL" +
            ")";


    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/h2-OfficeDentist");

        }

        public static void CREATE_TABLE(){
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_PATIENT);
            Statement statement1 = connection.createStatement();
            statement1.execute(CREATE_TABLE_DENTIST);
            Statement statement2 = connection.createStatement();
            statement2.execute(CREATE_TABLE_TURN);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception x){
                x.printStackTrace();
            }
        }

    }
}
