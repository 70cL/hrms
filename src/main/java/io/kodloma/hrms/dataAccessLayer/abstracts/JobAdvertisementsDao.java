package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.JobAdvertisements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisements, Integer> {
    List<JobAdvertisements> findByActive(boolean status);
    List<JobAdvertisements> findByActiveOrderByApplicationDeadline(boolean status);
    List<JobAdvertisements> findByActiveAndEmployers_CompanyName(boolean status, String companyName);
}
