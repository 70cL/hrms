package io.kodloma.hrms.entities.concrete;

public class Emloyees extends User {
    private String first_name;
    private String last_name;

    public Emloyees(){
        super();
    }

    public Emloyees(int id, String mail, String password, String first_name, String last_name){
        super(id, mail, password);
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Emloyees setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public Emloyees setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }
}
