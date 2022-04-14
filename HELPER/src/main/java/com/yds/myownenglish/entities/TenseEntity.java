package com.yds.myownenglish.entities;


import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class TenseEntity {

    private final UUID tenseId;
    private final String tenseName;
    private final TypeEntity tenseType;

}
