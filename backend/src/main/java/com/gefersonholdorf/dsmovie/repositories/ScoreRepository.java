package com.gefersonholdorf.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gefersonholdorf.dsmovie.entities.Score;
import com.gefersonholdorf.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
