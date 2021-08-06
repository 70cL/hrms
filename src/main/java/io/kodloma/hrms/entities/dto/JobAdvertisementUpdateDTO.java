package io.kodloma.hrms.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.kodloma.hrms.entities.concrete.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementUpdateDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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
