package com.yds.myownenglish.services;

import com.yds.myownenglish.repo.CasesRepo;
import com.yds.myownenglish.repo.mappers.CasesMapper;
import org.springframework.stereotype.Service;

@Service
public class CasesService {

    CasesMapper casesMapper;
    CasesRepo casesRepo;

    CasesService (
            CasesMapper casesMapper,
            CasesRepo casesRepo
    ){
        this.casesMapper = casesMapper;
        this.casesRepo = casesRepo;
    }
}
