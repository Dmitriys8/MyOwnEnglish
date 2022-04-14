package com.yds.myownenglish.api;

import com.yds.myownenglish.converters.ExampleConverter;
import com.yds.myownenglish.dtos.ExampleDTO;
import com.yds.myownenglish.services.ExampleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examples")
@Tag(name = "Examples of tenses usage")
public class ExamplesController {

    ExampleService exampleService;

    ExamplesController (ExampleService exampleService){
        this.exampleService = exampleService;
    }

    @GetMapping("/all")
    public List<ExampleDTO> getAll(){
        return ExampleConverter.convertFromModel(exampleService.getAll());
    }
}
