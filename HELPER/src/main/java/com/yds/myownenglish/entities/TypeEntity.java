package com.yds.myownenglish.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class TypeEntity {

    private final UUID typeId;
    private final String typeName;

}
