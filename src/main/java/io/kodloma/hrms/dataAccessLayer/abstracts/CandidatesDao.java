package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesDao extends JpaRepository<Candidates, Integer> {
}
