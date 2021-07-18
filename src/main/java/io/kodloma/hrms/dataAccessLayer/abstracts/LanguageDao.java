package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.Languages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageDao extends JpaRepository<Languages, Integer> {
    List<Languages> findByLanguageName(String language);
}
