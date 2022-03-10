package com.gefersonholdorf.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.dsmovie.dto.MovieDTO;
import com.gefersonholdorf.dsmovie.dto.ScoreDTO;
import com.gefersonholdorf.dsmovie.entities.Movie;
import com.gefersonholdorf.dsmovie.entities.Score;
import com.gefersonholdorf.dsmovie.entities.User;
import com.gefersonholdorf.dsmovie.repositories.MovieRepository;
import com.gefersonholdorf.dsmovie.repositories.ScoreRepository;
import com.gefersonholdorf.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setUser(user);
		score.setMovie(movie);
		score.setValue(dto.getValue());
		
		score = scoreRepository.saveAndFlush(score);
		
		Double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += sum + s.getValue();
		}
		
		Double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}

}
