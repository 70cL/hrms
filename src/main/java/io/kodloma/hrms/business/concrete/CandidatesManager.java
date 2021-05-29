package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.adapters.concrete.MernisManager;
import io.kodloma.hrms.adapters.concrete.MernisService;
import io.kodloma.hrms.business.abtracts.CandidatesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.CandidatesDao;
import io.kodloma.hrms.dataAccessLayer.abstracts.UserDao;
import io.kodloma.hrms.entities.concrete.Candidates;
import io.kodloma.hrms.entities.concrete.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesManager implements CandidatesService {

    private CandidatesDao candidatesDao;
    private MernisService<Candidates> mernisService;

    @Autowired
    public CandidatesManager(CandidatesDao candidatesDao, MernisService<Candidates> mernisService){
        this.candidatesDao = candidatesDao;
        this.mernisService = mernisService;
    }

    @Override
    public DataResult<List<Candidates>> getAll() {
        return new SuccessDataResult<>("Başarılı", candidatesDao.findAll());
    }

    @Override
    public Result add(Candidates candidates) {
        if(!IsDuplicate(candidates) && mernisService.ApiControl(candidates)) {
            candidatesDao.save(candidates);
            return new ErrorDataResult<>("mail yada tc no sistemde mevcut", candidates);
        }

        return new SuccessDataResult<>("Başarı ile kaydedildi", candidates);
    }

    private boolean IsDuplicate(Candidates candidates){
        return  candidatesDao.existsBymail(candidates.getMail()) &&
                candidatesDao.existsBynationalidentity(candidates.getNationalidentity());
    }
}
