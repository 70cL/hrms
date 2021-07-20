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
@Table(name = "job_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Resumes"})
public class JobExperiences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "job_position")
    private String jobPosition;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

//    @ManyToOne
//    @JoinColumn(name = "resume_id", referencedColumnName = "id")
//    private Resumes resumes;

}
