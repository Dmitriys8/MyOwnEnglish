package com.yds.myownenglish.converters;

import com.yds.myownenglish.dtos.CaseDTO;
import com.yds.myownenglish.entities.CaseEntity;
import com.yds.myownenglish.models.CaseModel;

import java.util.List;

public class CaseConverter {

    public static CaseModel convertFromEntity(final CaseEntity caseEntity){
        return CaseModel.builder()
                .caseId(caseEntity.getCaseId())
                .caseName(caseEntity.getCaseName())
                .tenseTypeId(caseEntity.getTenseTypeId())
                .build();
    }


    public static List<CaseModel> convertFromEntity(final List<CaseEntity> caseEntity){
        return caseEntity.stream()
                .map(CaseConverter::convertFromEntity)
                .toList();
    }

    public static CaseDTO convertFromModel(final CaseModel caseModelList){
        return CaseDTO.builder()
                .caseId(caseModelList.getCaseId())
                .caseName(caseModelList.getCaseName())
                .exampleDTOList(ExampleConverter.convertFromModel(caseModelList.getExampleModelList()))
                .build();
    }

    public static List<CaseDTO> convertFromModel(final List<CaseModel> caseModelList){
        return caseModelList.stream()
                .map(CaseConverter::convertFromModel)
                .toList();
    }
}
