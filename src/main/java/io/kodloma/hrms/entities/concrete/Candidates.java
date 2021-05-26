package io.kodloma.hrms.entities.concrete;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidates extends User {
    @Column(name = "firstname")
    private String first_name;
    @Column(name = "lastname")
    private String last_name;
    @Column(name = "nationalidentity")
    private String national_identity;
    @Column(name = "birthofdate")
    private int date_of_birth;
}
