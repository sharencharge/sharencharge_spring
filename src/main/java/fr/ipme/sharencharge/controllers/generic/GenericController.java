package fr.ipme.sharencharge.controllers.generic;

import fr.ipme.sharencharge.exceptions.DataIdNotFoundException;
import fr.ipme.sharencharge.pojos.IdentifiablePojo;
import fr.ipme.sharencharge.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//@RestController
public abstract class GenericController<T extends IdentifiablePojo>{

    @Autowired
    private GenericService<T> generiqueService;

    public GenericController() {
    }

    @GetMapping("/")
    public  ResponseEntity<List<T>> getAll(@RequestParam(required = false) String limit,
                                           @RequestParam(required = false) String page
                                           ){
        if( limit != null && page != null){
            return ResponseEntity.ok(generiqueService.findAllPageable(limit, page));
        } else {
            return ResponseEntity.ok((List<T>) generiqueService.findAll());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) throws DataIdNotFoundException {

        return  ResponseEntity.ok(generiqueService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<T> add(@Valid @RequestBody T updated){
        return ResponseEntity.ok(generiqueService.save(updated));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T updated, @PathVariable Long id){

        return ResponseEntity.ok(generiqueService.update(updated, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        generiqueService.deleteById(id);
        return ResponseEntity.ok("Ok");
    }

}
