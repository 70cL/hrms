package io.kodloma.hrms.entities.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
public class Employers extends User {
    @Column(name = "companyname")
    @NotEmpty(message = "Company name may not be empty")
    @Size(min = 2, max = 32, message = "Company must be between 2 and 32 characters long")
    private String company_name;
    @Column(name = "webadress")
    @NotEmpty(message = "Web address may not be empty")
    @Size(min = 2, max = 32, message = "Web address must be between 2 and 32 characters long")
    private String web_address;
    @Column(name = "phonenumber")
    @NotEmpty(message = "Phone Number may not be empty")
    @Size(min = 10, max = 10, message = "Phone Number length must be 10 number long")
    private String phone_number;

}
