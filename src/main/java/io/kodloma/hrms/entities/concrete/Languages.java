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
@Table(name = "languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Resumes"})
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_level")
    private int languageLevel;

    //@ManyToOne
    //@JoinColumn(name = "resume_id", referencedColumnName = "id")
    //private Resumes resumes;

}
