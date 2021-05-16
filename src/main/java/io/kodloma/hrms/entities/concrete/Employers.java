package io.kodloma.hrms.entities.concrete;

public class Employers extends User {
    private String company_name;
    private String web_adress;
    private String phone_number;

    public Employers(){
        super();
    }

    public Employers(int id, String mail, String password, String company_name, String web_adress, String phone_number){
        super(id, mail, password);
        this.company_name = company_name;
        this.web_adress = web_adress;
        this.phone_number = phone_number;
    }

    public String getCompany_name() {
        return company_name;
    }

    public Employers setCompany_name(String company_name) {
        this.company_name = company_name;
        return this;
    }

    public String getWeb_adress() {
        return web_adress;
    }

    public Employers setWeb_adress(String web_adress) {
        this.web_adress = web_adress;
        return this;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public Employers setPhone_number(String phone_number) {
        this.phone_number = phone_number;
        return this;
    }
}
