package io.kodloma.hrms.entities.concrete;

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
@Table(name = "job_advertisement")
public class JobAdvertisements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cities_id", referencedColumnName =  "id" ,nullable = false)
    private Cities cities ;

    @ManyToOne(targetEntity = JobPositions.class ,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_position_id", referencedColumnName =  "id" ,nullable = false)
    private JobPositions jobPositions;

    @ManyToOne(targetEntity = JobPositions.class ,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employers_id", referencedColumnName =  "id" ,nullable = false)
    private Employers employers;

    @Column(name = "description")
    @NotEmpty(message = "description name may not be empty")
    @Size(min = 5, max = 50, message = "description must be between 2 and 32 characters long")
    private String description;

    @Column(name = "min_salary")
    private int min_salary;

    @Column(name = "max_salary")
    private int max_salary;

    @Column(name = "created_date")
    private String created_date;

    @Column(name = "person_need")
    @NotEmpty(message = "person_need number may not be empty")
    private int person_need;

    @Column(name = "application_deadline")
    @NotEmpty(message = "application_deadline may not be empty")
    private String application_deadline;

    @Column(name = "is_active")
    @NotEmpty(message = "is_active may not be empty")
    private boolean is_active;
}
