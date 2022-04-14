package com.yds.myownenglish.repo;

import com.yds.myownenglish.entities.CaseEntity;
import com.yds.myownenglish.repo.mappers.CasesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CasesRepo {

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    CasesMapper casesMapper;

    CasesRepo (
            JdbcTemplate jdbcTemplate,
            NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            CasesMapper casesMapper
    ){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.casesMapper = casesMapper;
    }

    public List<CaseEntity> findById(final UUID caseId){
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("caseId",caseId);
        return namedParameterJdbcTemplate.query("""
                SELECT c.case_id, c.case_name, c.tense_type_id
                FROM tenses.cases c       
                WHERE c.case_id = :caseId            
                """,
                params,
                casesMapper
        );
    }

    public List<CaseEntity> findByTenseTypeIds(final List<UUID> tenseTypeIdList){
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("tenseTypeIdList", tenseTypeIdList);
        return namedParameterJdbcTemplate.query("""
                SELECT c.case_id, c.case_name, c.tense_type_id
                FROM tenses.cases c 
                WHERE c.tense_type_id IN (:tenseTypeIdList)
                """,
                params,
                casesMapper
        );
    }
}
