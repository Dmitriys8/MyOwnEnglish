package com.yds.myownenglish.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TenseDTO {

    @JsonProperty("tenseName")
    private String tenseName;

    @JsonProperty("cases")
    private List<CaseDTO> caseDTOList;

}
