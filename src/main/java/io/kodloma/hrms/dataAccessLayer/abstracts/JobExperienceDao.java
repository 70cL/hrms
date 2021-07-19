package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.JobExperiences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExperienceDao extends JpaRepository<JobExperiences, Integer> {
}
