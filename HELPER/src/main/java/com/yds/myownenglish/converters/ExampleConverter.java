package com.yds.myownenglish.converters;

import com.yds.myownenglish.dtos.ExampleDTO;
import com.yds.myownenglish.entities.ExampleEntity;
import com.yds.myownenglish.models.ExampleModel;

import java.util.List;

public class ExampleConverter {

    public static ExampleDTO convertFromModel(final ExampleModel exampleModel){
        return ExampleDTO.builder()
                .example(exampleModel.getExample())
                .caseId(exampleModel.getCaseId())
                .build();
    }

    public static List<ExampleDTO> convertFromModel(final List<ExampleModel> exampleModel){
        return exampleModel.stream()
                .map(ExampleConverter::convertFromModel)
                .toList();
    }

    public static ExampleModel convertFromEntity(final ExampleEntity exampleEntity){
        return ExampleModel.builder()
                .example(exampleEntity.getExample())
                .build();
    }

    public static List<ExampleModel> convertFromEntity(final List<ExampleEntity> exampleEntity){
        return exampleEntity.stream()
                .map(ExampleConverter::convertFromEntity)
                .toList();
    }
}
