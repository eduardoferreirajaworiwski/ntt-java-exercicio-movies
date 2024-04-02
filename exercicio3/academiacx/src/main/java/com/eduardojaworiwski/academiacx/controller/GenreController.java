import com.eduardojaworiwski.academiacx.controller.inter.GenreInterfaceController;
import com.eduardojaworiwski.academiacx.entity.GenreModel;
import com.eduardojaworiwski.academiacx.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController implements GenreInterfaceController {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<GenreModel>> getAllGenres() {
        List<GenreModel> genres = genreRepository.findAll();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GenreModel> getGenreById(@PathVariable Long id) {
        Optional<GenreModel> genre = genreRepository.findById(id);
        return genre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<GenreModel> createGenre(@RequestBody GenreModel genre) {
        GenreModel newGenre = genreRepository.save(genre);
        return new ResponseEntity<>(newGenre, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<GenreModel> updateGenre(@PathVariable Long id, @RequestBody GenreModel updatedGenre) {
        if (!genreRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedGenre.setId(id);
        GenreModel savedGenre = genreRepository.save(updatedGenre);
        return new ResponseEntity<>(savedGenre, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        if (!genreRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        genreRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
