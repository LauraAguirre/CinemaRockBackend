package cinema.Soft2.Service;

import cinema.Soft2.Model.Movies;
import cinema.Soft2.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;


    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    public Optional<Movies> findById(Long idMovie) {
        return moviesRepository.findById(idMovie);
    }
    public <S extends Movies> S save(S movie) {
        return moviesRepository.save(movie);
    }

    public void deleteById(Long idMovie) {
        moviesRepository.deleteById(idMovie);
    }

}