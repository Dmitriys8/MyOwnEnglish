package com.yds.myownenglish.repo.mappers;

import com.yds.myownenglish.entities.TenseEntity;
import com.yds.myownenglish.entities.TypeEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class TenseMapper implements RowMapper<TenseEntity> {

    @Override
    public TenseEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
        return TenseEntity.builder()
                .tenseId(rs.getObject("tense_id", UUID.class))
                .tenseName(rs.getString("tense_name"))
                .tenseType(TypeEntity.builder()
                        .typeId(rs.getObject("type_id", UUID.class))
                        .typeName(rs.getString("type_name"))
                        .build()
                )
                .build();
    }
}
