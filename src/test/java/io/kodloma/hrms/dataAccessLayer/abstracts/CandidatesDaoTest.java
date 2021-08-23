package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.Candidates;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CandidatesDaoTest {

    @Autowired
    CandidatesDao underTest;

    @Test
    void existsBynationalidentity() {
    }

    @Test
    void existsBymail() {
        Candidates candidates = Candidates.builder().mail("ovunc.girgin2@gmail.com")
                .password("123123123").first_name("Övünç").last_name("Girgin").nationalidentity("39733484532")
                .birth_of_year("1992").build();

        System.out.println(candidates.getPassword());

    }
}