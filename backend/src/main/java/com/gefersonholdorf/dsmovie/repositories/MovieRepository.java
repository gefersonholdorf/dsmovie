package com.gefersonholdorf.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gefersonholdorf.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
