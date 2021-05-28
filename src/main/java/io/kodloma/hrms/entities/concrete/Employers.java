package io.kodloma.hrms.entities.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
public class Employers extends User {
    @Column(name = "companyname")
    private String company_name;
    @Column(name = "webadress")
    private String web_adress;
    @Column(name = "phonenumber")
    private String phone_number;

}
