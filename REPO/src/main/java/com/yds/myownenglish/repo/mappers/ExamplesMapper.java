package com.yds.myownenglish.repo.mappers;

import com.yds.myownenglish.entities.ExampleEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ExamplesMapper implements RowMapper<ExampleEntity> {

    @Override
    public ExampleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
       return ExampleEntity.builder()
               .exampleId(rs.getObject("example_id", UUID.class))
               .example(rs.getString("example"))
               .build();
    }
}
