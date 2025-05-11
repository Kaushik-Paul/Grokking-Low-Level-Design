package com.example.lowleveldesign.bookmyshow.theatre;

import com.example.lowleveldesign.bookmyshow.enums.City;
import com.example.lowleveldesign.bookmyshow.movie.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    private Map<City, List<Theatre>> theatresByCity;
    private List<Theatre> allTheatres;

    public TheatreController() {
        this.theatresByCity = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(City city, Theatre theatre) {
        this.allTheatres.add(theatre);

        List<Theatre> theatres = this.theatresByCity.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        this.theatresByCity.put(city, theatres);
    }

    public Map<Theatre, List<Show>> getAllShows(City city, Movie movie) {
        Map<Theatre, List<Show>> showsByTheatre = new HashMap<>();

        List<Theatre> theatres = this.theatresByCity.getOrDefault(city, new ArrayList<>());
        for (Theatre theatre : theatres) {
            List<Show> shows = theatre.getShows();
            for (Show show : shows) {
                if (show.getMovie().getMovieId() == movie.getMovieId()) {
                    List<Show> showsForTheatre = showsByTheatre.getOrDefault(theatre, new ArrayList<>());
                    showsForTheatre.add(show);
                    showsByTheatre.put(theatre, showsForTheatre);
                }
            }
        }
        return showsByTheatre;
    }
}
