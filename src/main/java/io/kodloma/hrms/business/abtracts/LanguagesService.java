package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Languages;

import java.util.List;

public interface LanguagesService {
    DataResult<List<Languages>> getAll();
    Result addLanguage(Languages languages);
    DataResult<List<Languages>> finByName(String language);
}
