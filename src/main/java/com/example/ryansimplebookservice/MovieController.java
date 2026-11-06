package com.example.ryansimplebookservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>();

    public MovieController() {
        movies.add(new Movie(
                1,
                "The Shawshank Redemption",
                "Frank Darabont",
                "Columbia Pictures",
                14.99
        ));

        movies.add(new Movie(
                2,
                "The Godfather",
                "Francis Ford Coppola",
                "Paramount Pictures",
                17.99
        ));

        movies.add(new Movie(
                3,
                "The Dark Knight",
                "Christopher Nolan",
                "Warner Bros. Pictures",
                19.99
        ));
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movies;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable int id) {

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return ResponseEntity.ok(movie);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {

        int newId = movies.size() + 1;
        movie.setId(newId);

        movies.add(movie);

        return ResponseEntity.status(201).body(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movies.remove(movie);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie) {

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movie.setTitle(updatedMovie.getTitle());
                movie.setDirector(updatedMovie.getDirector());
                movie.setPublisher(updatedMovie.getPublisher());
                movie.setPrice(updatedMovie.getPrice());

                return ResponseEntity.ok(movie);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
