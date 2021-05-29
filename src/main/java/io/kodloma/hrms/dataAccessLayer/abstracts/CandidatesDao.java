package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CandidatesDao extends JpaRepository<Candidates, Integer> {
    boolean existsBynationalidentity(String nationalidentity);
    boolean existsBymail(String mail);
}
