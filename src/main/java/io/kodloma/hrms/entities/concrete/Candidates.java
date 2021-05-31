package io.kodloma.hrms.entities.concrete;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
public class Candidates extends User {
    @Column(name = "firstname")
    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String first_name;
    @Column(name = "lastname")
    @NotEmpty(message = "Last name may not be empty")
    @Size(min = 2, max = 32, message = "Last name must be between 2 and 32 characters long")
    private String last_name;
    @Column(name = "nationalidentity")
    @NotEmpty(message = "TCK name may not be empty")
    @Size(min = 11, max = 11, message = "TCK must be 11 number long")
    private String nationalidentity;
    @Size(min=1, message= "enter year")
    @Column(name = "birthofyear")
    private String birth_of_year;
}
