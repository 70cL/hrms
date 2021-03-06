package io.kodloma.hrms.entities.concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Resumes"})
public class Educations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department")
    private String department;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "is_graduated")
    private boolean isGraduated;

//    @ManyToOne
//    @JoinColumn(name = "resume_id", referencedColumnName = "id")
//    private Resumes resumes;


}
