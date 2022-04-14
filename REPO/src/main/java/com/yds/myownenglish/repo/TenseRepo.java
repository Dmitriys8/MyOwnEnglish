package com.yds.myownenglish.repo;

import com.yds.myownenglish.entities.TenseEntity;
import com.yds.myownenglish.repo.mappers.TenseMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public class TenseRepo {

    JdbcTemplate jdbcTemplate ;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    TenseMapper tenseMapper;

    TenseRepo (
            JdbcTemplate jdbcTemplate,
            NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            TenseMapper tenseMapper
    ){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.tenseMapper = tenseMapper;
    }

    public List<TenseEntity> getALl(){
        return jdbcTemplate.query("""
            SELECT ts.tense_id
                ,ts.tense_name
                ,tp.type_id
                ,tp.type_name
            FROM tenses.x_tenses_types xtt
            JOIN tenses.tenses ts
            ON xtt.tense_id = ts.tense_id
            JOIN tenses.types tp
            ON tp.type_id = xtt.type_id""",
                tenseMapper
        );
    }

    public List<TenseEntity> findByName(@NotNull final String tenseName){
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name",tenseName);

        return namedParameterJdbcTemplate.query("""
            SELECT ts.tense_id
                ,ts.tense_name
                ,tp.type_id
                ,tp.type_name
            FROM tenses.x_tenses_types xtt
            JOIN tenses.tenses ts
            ON xtt.tense_id = ts.tense_id
            JOIN tenses.types tp
            ON tp.type_id = xtt.type_id
            WHERE tense_name LIKE '%' ||:name || '%'
            OR tp.type_name LIKE '%' || :name || '%'""",
                params,
                tenseMapper
        );
    }


}