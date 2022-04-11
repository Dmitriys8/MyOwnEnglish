package com.yds.myownenglish.repo;

import com.yds.myownenglish.repo.entities.Tense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TenseRepo extends JpaRepository<Tense, UUID> {
}