package io.kodloma.hrms.entities.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "resumes")
public class Resumes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "summary")
    private String summary;

    @Column(name = "photo")
    private String photo;

    @Column(name = "update_date")
    private String updateDate;

    @OneToMany
    @JoinColumn(name = "resume_id", referencedColumnName = "id")
    private List<JobExperiences> jobExperiencesList;

    @OneToMany
    @JoinColumn(name = "resume_id", referencedColumnName = "id")
    private List<Languages> languagesList;

    @OneToMany
    @JoinColumn(name = "resume_id", referencedColumnName = "id")
    private List<Educations> educationsList;

    @OneToMany
    @JoinColumn(name = "resume_id", referencedColumnName = "id")
    private List<Technologies> technologiesList;

}
