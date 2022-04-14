package com.yds.myownenglish.repo;

import com.yds.myownenglish.entities.ExampleEntity;
import com.yds.myownenglish.repo.mappers.ExamplesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ExamplesRepo {

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    ExamplesMapper examplesMapper;

    ExamplesRepo (
            JdbcTemplate jdbcTemplate,
            NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            ExamplesMapper examplesMapper
    ){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.examplesMapper = examplesMapper;
    }

    public List<ExampleEntity> getAll(){
        return jdbcTemplate.query("""
                SELECT ex.example_id, ex.example
                FROM tenses.examples ex
                JOIN tenses.cases c 
                ON c.case_id = ex.case_id                
                """,
                examplesMapper
        );
    }

    public void addExample(
            final String example,
            final UUID caseId
    ){
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("caseId", caseId)
                .addValue("example",example);
        namedParameterJdbcTemplate.update("""
                INSERT INTO tenses.examples (case_id, example)
                VALUES (:caseId, :example)
                """,
                params
        );
    }
}
