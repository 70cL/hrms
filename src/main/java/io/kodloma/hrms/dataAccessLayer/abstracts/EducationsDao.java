package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.Educations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationsDao extends JpaRepository<Educations, Integer> {
}
