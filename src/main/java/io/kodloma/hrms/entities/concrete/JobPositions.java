package io.kodloma.hrms.entities.concrete;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jobpositions")
public class JobPositions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;

}
