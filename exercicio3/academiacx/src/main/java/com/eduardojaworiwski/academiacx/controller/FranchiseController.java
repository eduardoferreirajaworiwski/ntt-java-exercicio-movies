import com.eduardojaworiwski.academiacx.controller.inter.FranchiseInterfaceController;
import com.eduardojaworiwski.academiacx.entity.FranchiseModel;
import com.eduardojaworiwski.academiacx.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/franchises")
public class FranchiseController implements FranchiseInterfaceController {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<FranchiseModel>> getAllFranchises() {
        List<FranchiseModel> franchises = franchiseRepository.findAll();
        return new ResponseEntity<>(franchises, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FranchiseModel> getFranchiseById(@PathVariable Long id) {
        Optional<FranchiseModel> franchise = franchiseRepository.findById(id);
        return franchise.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<FranchiseModel> createFranchise(@RequestBody FranchiseModel franchise) {
        FranchiseModel newFranchise = franchiseRepository.save(franchise);
        return new ResponseEntity<>(newFranchise, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<FranchiseModel> updateFranchise(@PathVariable Long id, @RequestBody FranchiseModel updatedFranchise) {
        if (!franchiseRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedFranchise.setId(id);
        FranchiseModel savedFranchise = franchiseRepository.save(updatedFranchise);
        return new ResponseEntity<>(savedFranchise, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFranchise(@PathVariable Long id) {
        if (!franchiseRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        franchiseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
