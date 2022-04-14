package com.yds.myownenglish.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class CaseEntity {

    private final UUID caseId;
    private final UUID tenseTypeId;
    private final String caseName;

}
