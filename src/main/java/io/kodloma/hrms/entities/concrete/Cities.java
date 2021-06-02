package io.kodloma.hrms.entities.concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "city name may not be empty")
    @Size(min = 2, max = 15, message = "city must be between 2 and 32 characters long")
    private String city;

//    @OneToMany(
//            mappedBy = "cities",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<JobAdvertisements> jobAdvertisements;
}
