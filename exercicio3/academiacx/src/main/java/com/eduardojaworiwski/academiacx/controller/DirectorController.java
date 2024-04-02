import com.eduardojaworiwski.academiacx.controller.inter.DirectorInterfaceController;
import com.eduardojaworiwski.academiacx.entity.DirectorModel;
import com.eduardojaworiwski.academiacx.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directors")
public class DirectorController implements DirectorInterfaceController {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<DirectorModel>> getAllDirectors() {
        List<DirectorModel> directors = directorRepository.findAll();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DirectorModel> getDirectorById(@PathVariable Long id) {
        Optional<DirectorModel> director = directorRepository.findById(id);
        return director.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<DirectorModel> createDirector(@RequestBody DirectorModel director) {
        DirectorModel newDirector = directorRepository.save(director);
        return new ResponseEntity<>(newDirector, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DirectorModel> updateDirector(@PathVariable Long id, @RequestBody DirectorModel updatedDirector) {
        if (!directorRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedDirector.setId(id);
        DirectorModel savedDirector = directorRepository.save(updatedDirector);
        return new ResponseEntity<>(savedDirector, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        if (!directorRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        directorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
