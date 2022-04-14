package com.yds.myownenglish.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class TenseModel {

    private UUID tenseId;
    private String tenseName;
    private List<TenseTypeModel> tenseTypeModelList;
    private List<CaseModel> caseModelList;
}
