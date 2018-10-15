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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id) throws Exception{
        Integer mId = movieService.delete(id);
        return "redirect:/movie";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) throws Exception{
        model.addAttribute("movie", new Movie());
        return "movieAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@ModelAttribute Movie movie) throws Exception{
        movieService.insert(movie.getTitle(), movie.getDirector(), movie.getMain_actor(), movie.getTag(), movie.getStatus());
        return "redirect:/movie";
    }
}
