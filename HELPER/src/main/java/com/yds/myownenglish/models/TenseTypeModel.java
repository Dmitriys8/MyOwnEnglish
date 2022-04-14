package com.yds.myownenglish.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class TenseTypeModel {

    private UUID typeId;
    private String typeName;
    private List<TenseModel> tenseModelList;
}
