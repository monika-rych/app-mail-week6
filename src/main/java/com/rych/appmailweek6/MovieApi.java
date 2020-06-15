package com.rych.appmailweek6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieApi {

    private List<Movie> movieList;

    public MovieApi() {
        this.movieList = new ArrayList<>();
        movieList.add(new Movie("Dirty Dancing", 1988, "Disney"));
        movieList.add(new Movie("Dirty Dancing2", 1989, "Disney"));
        movieList.add(new Movie("Dirty Dancing3", 1990, "Disney"));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getCars() {
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping
    @MailAsp
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        boolean add = movieList.add(movie);
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
