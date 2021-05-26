package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.CandidatesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.CandidatesDao;
import io.kodloma.hrms.entities.concrete.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesManager implements CandidatesService {

    private CandidatesDao candidatesDao;

    @Autowired
    public CandidatesManager(CandidatesDao candidatesDao){
        this.candidatesDao = candidatesDao;
    }

    @Override
    public DataResult<List<Candidates>> getAll() {
        return new SuccessDataResult<>("Başarılı", candidatesDao.findAll());
    }
}
