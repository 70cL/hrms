package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.adapters.concrete.MernisService;
import io.kodloma.hrms.business.abtracts.CandidatesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.CandidatesDao;
import io.kodloma.hrms.entities.concrete.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SuccessDataResult<List<Candidates>>> getAll() {
        return new ResponseEntity<>(
                new SuccessDataResult<>("Başarılı", candidatesDao.findAll()),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataResult<Candidates>> add(Candidates candidates) {
        if(isDupMail(candidates))
            return new ResponseEntity<>(new ErrorDataResult<>("mail sistemde mevcut", candidates),HttpStatus.CONFLICT);
        if (isDupTcno(candidates))
            return new ResponseEntity<>(new ErrorDataResult<>("tcno sistemde mevcut", candidates),HttpStatus.CONFLICT);
        //if(!mernisService.ApiControl(candidates)) // çalıştırılamadı
            //return new ErrorDataResult<>("Tc no diğer bilgiler ile uyumsuz", candidates);

        candidatesDao.save(candidates);
        return new ResponseEntity<>(new SuccessDataResult<>("Başarılı", candidates), HttpStatus.OK);
    }

    private boolean isDupMail(Candidates candidates){
        return candidatesDao.existsBymail(candidates.getMail());
    }

    private boolean isDupTcno(Candidates candidates){
        return candidatesDao.existsBynationalidentity(candidates.getNationalidentity());
    }
}
