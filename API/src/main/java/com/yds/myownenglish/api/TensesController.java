package com.yds.myownenglish.api;

import com.yds.myownenglish.repo.TenseRepo;
import com.yds.myownenglish.repo.entities.Tense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tenses")
public class TensesController {

    @Autowired
    TenseRepo tenseRepo;

    @GetMapping
    public String hello(){
        return "Hello it's API part for work with tenses";
    }

    @GetMapping("/{tenseName}")
    public String getTenseName(@PathVariable("tenseName") String tenseName){
        return tenseName;
    }

    @GetMapping("/all")
    public List<Tense> getAllTenses(){
        List<Tense> tensesList = tenseRepo.findAll();
        return tensesList;
    }
}
