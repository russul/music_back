package com.example.music.dao;

import com.example.music.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {
}
