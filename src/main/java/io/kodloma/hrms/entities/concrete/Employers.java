package io.kodloma.hrms.entities.concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employers extends User {
    @Column(name = "companyname")
    @NotEmpty(message = "Company name may not be empty")
    @Size(min = 2, max = 32, message = "Company must be between 2 and 32 characters long")
    private String companyName;

    @Column(name = "companyphoto")
    @NotEmpty(message = "Company photo should be added")
    private String companyPhoto;

    @Column(name = "webadress")
    @NotEmpty(message = "Web address may not be empty")
    @Size(min = 2, max = 32, message = "Web address must be between 2 and 32 characters long")
    private String web_address;

    @Column(name = "phonenumber")
    @NotEmpty(message = "Phone Number may not be empty")
    @Size(min = 10, max = 10, message = "Phone Number length must be 10 number long")
    private String phone_number;

//    @OneToMany(
//            mappedBy = "employers",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<JobAdvertisements> jobAdvertisements;
}
