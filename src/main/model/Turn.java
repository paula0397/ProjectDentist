package main.model;

public class Turn {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private String date_hour;

    public Turn(){}

    public Turn(Integer id, Patient patient, Dentist dentist, String date_hour) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.date_hour = date_hour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public String getDate_hour() {
        return date_hour;
    }

    public void setDate_hour(String date_hour) {
        this.date_hour = date_hour;
    }
}
