package io.kodloma.hrms.entities.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "technologies")
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "technology_name")
    private String technologyName;

    @Column(name = "technology_level")
    private int technologyLevel;

//    @ManyToOne
//    @JoinColumn(name = "resume_id", referencedColumnName = "id")
//    private Resumes resumes;


}
