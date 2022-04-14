package com.yds.myownenglish.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class ExampleDTO {

    private final String example;
    private final UUID caseId;
}
