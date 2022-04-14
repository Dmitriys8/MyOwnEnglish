package com.yds.myownenglish.services;

import com.yds.myownenglish.converters.ExampleConverter;
import com.yds.myownenglish.models.ExampleModel;
import com.yds.myownenglish.repo.CasesRepo;
import com.yds.myownenglish.repo.ExamplesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    ExamplesRepo examplesRepo;
    CasesRepo casesRepo;

    ExampleService (
            ExamplesRepo examplesRepo,
            CasesRepo caseRepo
    ){
        this.examplesRepo = examplesRepo;
        this.casesRepo = caseRepo;
    }

    public List<ExampleModel> getAll(){
        return ExampleConverter.convertFromEntity(examplesRepo.getAll());
    }

    public void addExample(ExampleModel exampleModel){
        if (!casesRepo.findById(exampleModel.getCaseId()).isEmpty()){
            examplesRepo.addExample(
                    exampleModel.getExample(),
                    exampleModel.getExampleId()
            );
        }
    }
}
