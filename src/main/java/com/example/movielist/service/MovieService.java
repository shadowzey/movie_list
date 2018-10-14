package com.example.movielist.service;

import com.example.movielist.models.Movie;
import com.example.movielist.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieMapper movieMapper;

    public List<Movie> listAll() {
        return movieMapper.listAllMovie();
    }

    public List<Movie> get(String name) {
        return movieMapper.findByName(name);
    }

    public int insert(String title, String director, String mainActor, String tag, Integer status) {
        return movieMapper.insert(title, director, mainActor, tag, status);
    }

    public int delete(Integer id) {
        return movieMapper.delete(id);
    }

    public Integer changeStatus(Integer id) {
        Movie m = movieMapper.findMovieById(id);
        Integer changedStatus = Math.abs(m.getStatus() - 1);
        return movieMapper.update(id, changedStatus);
    }

}
