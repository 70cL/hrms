package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.JobAdvertisements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisements, Integer> {
}
