package com.yds.myownenglish.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class CaseDTO {

    private UUID caseId;
    private String caseName;
    private List<ExampleDTO> exampleDTOList;

}
