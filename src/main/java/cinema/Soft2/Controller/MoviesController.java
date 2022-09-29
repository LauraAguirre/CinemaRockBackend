package cinema.Soft2.Controller;
import cinema.Soft2.Model.Movies;
import cinema.Soft2.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/movies")

public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/findAll")
    private ResponseEntity<List<Movies>> findAll() {
        return ResponseEntity.ok(moviesService.findAll());
    }

    @GetMapping("/findById/{idMovies}")
    private ResponseEntity<Optional<Movies>> findById(@PathVariable("idMovies") Long idMovies) {
        return ResponseEntity.ok(moviesService.findById(idMovies));
    }

    @PostMapping("/save")
    private ResponseEntity<Movies> save(@RequestBody Movies movies) {
        try {
            Movies moviesGuardado = moviesService.save(movies);
            return ResponseEntity.created(new URI("/api/v1/movies" + moviesGuardado.getIdMovie())).body(moviesGuardado);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/deleteById/{idMovies}")
    private ResponseEntity<Boolean> deleteById(@PathVariable("idMovies") Long idMovies){
        moviesService.deleteById(idMovies);
        return ResponseEntity.ok(true);
    }
}