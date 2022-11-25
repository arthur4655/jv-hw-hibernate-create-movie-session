package mate.academy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "movie_sessions")
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;
    @Column(name = "time_of_beginning")
    private LocalDateTime timeOfBeginning;

    public MovieSession() {
    }

    public MovieSession(Movie movie, CinemaHall cinemaHall, LocalDateTime timeOfBeginning) {
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.timeOfBeginning = timeOfBeginning;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public LocalDateTime getTimeOfBeginning() {
        return timeOfBeginning;
    }

    public void setTimeOfBeginning(LocalDateTime timeOfBeginning) {
        this.timeOfBeginning = timeOfBeginning;
    }

    @Override
    public String toString() {
        return "MovieSession{" + "id=" + id
                + ", movie=" + movie
                + ", cinemaHall=" + cinemaHall
                + ", timeOfBeginning=" + timeOfBeginning + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieSession that = (MovieSession) o;
        return Objects.equals(id, that.id) && Objects.equals(movie, that.movie)
                    && Objects.equals(cinemaHall, that.cinemaHall)
                    && Objects.equals(timeOfBeginning, that.timeOfBeginning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, cinemaHall, timeOfBeginning);
    }
}