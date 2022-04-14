package com.yds.myownenglish.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class ExampleEntity {

    private final UUID exampleId;
    private final UUID caseId;
    private final String example;

}
