package com.yds.myownenglish.services;

import com.yds.myownenglish.converters.TenseConverter;
import com.yds.myownenglish.entities.CaseEntity;
import com.yds.myownenglish.entities.TenseEntity;
import com.yds.myownenglish.models.TenseModel;
import com.yds.myownenglish.repo.CasesRepo;
import com.yds.myownenglish.repo.ExamplesRepo;
import com.yds.myownenglish.repo.TenseRepo;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class TenseService {

    private TenseRepo tenseRepo;
    private CasesRepo casesRepo;
    private ExamplesRepo examplesRepo;

    TenseService (
            TenseRepo tenseRepo,
            CasesRepo casesRepo,
            ExamplesRepo examplesRepo
    ){
        this.tenseRepo = tenseRepo;
        this.casesRepo = casesRepo;
        this.examplesRepo = examplesRepo;
    }

    public List<TenseModel> getAll() {
        return TenseConverter.convertFromEntity(tenseRepo.getALl());
    }

    public List<TenseModel> finByName(@NotNull final String name){
        return TenseConverter.convertFromEntity(tenseRepo.findByName(name));
    }
}
