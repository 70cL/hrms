package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.LanguagesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.LanguageDao;
import io.kodloma.hrms.entities.concrete.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguagesManager implements LanguagesService {

    private LanguageDao languageDao;

    @Autowired
    public LanguagesManager(LanguageDao languageDao){
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Languages>> getAll() {
        return new SuccessDataResult<>("Sistemdeki diller", languageDao.findAll());
    }

    @Override
    public Result addLanguage(Languages languages) {
        return new SuccessDataResult<>("Başarılı", languageDao.save(languages));
    }

    @Override
    public DataResult<List<Languages>> finByName(String language) {
        return new SuccessDataResult<>("Başarılı", languageDao.findByLanguageName(language));
    }


}
