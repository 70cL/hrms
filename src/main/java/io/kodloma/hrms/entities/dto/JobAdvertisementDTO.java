package io.kodloma.hrms.entities.dto;

import com.fasterxml.jackson.annotation.*;
import io.kodloma.hrms.entities.concrete.*;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDTO {
    private Integer id;
    private WorkingType workingType;
    private WorkingLocation workingLocations;
    @JsonIgnore
    private Employers employers;
    private Cities cities;
    private JobPositions jobPositions;
    private String description;
    private Integer min_salary;
    private Integer max_salary;
    private Integer person_need;
}
