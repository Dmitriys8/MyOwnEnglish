package com.yds.myownenglish.repo.mappers;

import com.yds.myownenglish.entities.CaseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class CasesMapper implements RowMapper<CaseEntity> {

    @Override
    public CaseEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CaseEntity.builder()
                .caseId(rs.getObject("case_id", UUID.class))
                .caseName(rs.getString("case_name"))
                .tenseTypeId(rs.getObject("tense_type_id", UUID.class))
                .build();
    }
}
