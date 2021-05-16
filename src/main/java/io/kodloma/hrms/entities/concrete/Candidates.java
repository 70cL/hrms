package io.kodloma.hrms.entities.concrete;

public class Candidates extends User {
    private String first_name;
    private String last_name;
    private String national_identity;
    private int date_of_birth;

    public Candidates(){
        super();
    }

    public Candidates(int id, String mail, String password, String first_name, String last_name, String national_identity, int date_of_birth){
        super(id, mail, password);
        this.first_name = first_name;
        this.last_name = last_name;
        this.national_identity = national_identity;
        this.date_of_birth = date_of_birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Candidates setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public Candidates setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getNational_identity() {
        return national_identity;
    }

    public Candidates setNational_identity(String national_identity) {
        this.national_identity = national_identity;
        return this;
    }

    public int getDate_of_birth() {
        return date_of_birth;
    }

    public Candidates setDate_of_birth(int date_of_birth) {
        this.date_of_birth = date_of_birth;
        return this;
    }
}
