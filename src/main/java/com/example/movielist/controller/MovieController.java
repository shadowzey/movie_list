package com.example.movielist.controller;

import com.example.movielist.models.Movie;
import com.example.movielist.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String movie(Model model) throws Exception{
        List<Movie> movieList = movieService.listAll();
        model.addAttribute("mList", movieList);
        return "movie";
    }

    @RequestMapping(value = "/changeStatus", method = RequestMethod.GET)
    public String changeStatus(@RequestParam("id") Integer id) throws Exception{
        Integer mId = movieService.changeStatus(id);
        return "redirect:/movie";
    }
}
