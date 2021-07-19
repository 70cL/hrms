package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.Resumes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumesDao extends JpaRepository<Resumes, Integer> {
}
