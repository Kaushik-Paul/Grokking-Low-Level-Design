package com.example.lowleveldesign.bookmyshow.movie;

import com.example.lowleveldesign.bookmyshow.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    private Map<City, List<Movie>> moviesByCity;
    private List<Movie> allMovies;

    public MovieController() {
        this.moviesByCity = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(City city, Movie movie) {
        this.allMovies.add(movie);

        List<Movie> movies = this.moviesByCity.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        this.moviesByCity.put(city, movies);
    }

    public Movie getMovieByName(String movieName) {
        for (Movie movie : this.allMovies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city) {
        return this.moviesByCity.getOrDefault(city, new ArrayList<>());
    }

    public void removeMovieFromCity(City city, Movie movie) {
        List<Movie> movies = this.moviesByCity.getOrDefault(city, new ArrayList<>());
        movies.remove(movie);
        this.moviesByCity.put(city, movies);
    }

    public void updateMovieFromCity(City city, String movieName) {
        List<Movie> movies = this.moviesByCity.getOrDefault(city, new ArrayList<>());
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                movie.setMovieDurationInMinutes(120);
            }
        }
    }
}
