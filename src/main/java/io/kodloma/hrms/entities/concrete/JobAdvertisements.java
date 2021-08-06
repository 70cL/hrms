package io.kodloma.hrms.entities.concrete;

import lombok.*;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.Type;

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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "working_type_id", referencedColumnName = "id")
    private WorkingType workingType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "working_location_id", referencedColumnName = "id")
    private WorkingLocation workingLocations;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "cities_id", referencedColumnName =  "id")
    private Cities cities;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "job_position_id", referencedColumnName =  "id")
    private JobPositions jobPositions;

    @ManyToOne( optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "employers_id", referencedColumnName =  "id")
    private Employers employers;

    @Column(name = "description")
    @NotEmpty(message = "description name may not be empty")
    @Size(min = 5, max = 50, message = "description must be between 2 and 32 characters long")
    private String description;

    @Column(name = "min_salary")
    private Integer min_salary;

    @Column(name = "max_salary")
    private Integer max_salary;

    @Column(name = "created_date")
    private String created_date;

    @Column(name = "person_need")
    @NotEmpty(message = "person_need number may not be empty")
    private Integer person_need;

    @Column(name = "application_deadline")
    @NotEmpty(message = "application_deadline may not be empty")
    private String applicationDeadline;

    @Column(name = "active")
    @NotEmpty(message = "active may not be empty")
    private boolean active;
}
