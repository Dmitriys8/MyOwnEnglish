package com.yds.myownenglish.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CaseModel {

    private final UUID caseId;
    private final String caseName;
    private final UUID tenseTypeId;
    private final List<ExampleModel> exampleModelList;

}
