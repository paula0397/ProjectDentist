package main.model;

public class Patient {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer DNI;
    private String address;
    private String present_Date;

    public Patient(){}

    public Patient(Integer id, String firstName, String lastName, String email, String password, Integer DNI, String address, String present_Date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.DNI = DNI;
        this.address = address;
        this.present_Date = present_Date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPresent_Date() {
        return present_Date;
    }

    public void setPresent_Date(String present_Date) {
        this.present_Date = present_Date;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", DNI=" + DNI +
                '}';
    }
}
