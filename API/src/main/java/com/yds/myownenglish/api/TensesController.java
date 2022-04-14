package com.yds.myownenglish.api;

import com.yds.myownenglish.converters.TenseConverter;
import com.yds.myownenglish.dtos.TenseDTO;
import com.yds.myownenglish.repo.TenseRepo;
import com.yds.myownenglish.services.CasesService;
import com.yds.myownenglish.services.ExampleService;
import com.yds.myownenglish.services.TenseService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tenses")
@Tag(name = "Information about all tenses")
public class TensesController {

    TenseService tenseService;
    TenseRepo tenseRepo;
    ExampleService exampleService;
    CasesService casesService;

    TensesController (
            TenseService tenseService,
            TenseRepo tenseRepo,
            ExampleService exampleService,
            CasesService casesService
    ){
        this.tenseService = tenseService;
        this.tenseRepo = tenseRepo;
        this.exampleService = exampleService;
        this.casesService = casesService;
    }


    @GetMapping
    public String hello(){
        return "Hello it's API part for work with tenses";
    }

    @GetMapping("/{tenseName}")
    public List<TenseDTO> findByName(
            @Parameter(name = "Tense name", description = "Name or part of name of tense")
            @PathVariable("tenseName") String tenseName
    ){
        return TenseConverter.convertFromModel(tenseService.finByName(tenseName));
    }

    @GetMapping("/all")
    public List<TenseDTO> getAllTenses(){
        return TenseConverter.convertFromModel(tenseService.getAll());
    }

}
