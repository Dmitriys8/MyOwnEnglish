package com.yds.myownenglish.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ExampleModel {

    private final UUID exampleId;
    private final String example;

    @JsonIgnore
    private final UUID caseId;

}
