package io.kodloma.hrms.entities.concrete;

import javax.persistence.*;

@Entity
@Table(name = "job_positions")
public class JobPositions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;

    public JobPositions(){

    }

    public JobPositions(int id, String title){
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public JobPositions setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public JobPositions setTitle(String title) {
        this.title = title;
        return this;
    }
}
