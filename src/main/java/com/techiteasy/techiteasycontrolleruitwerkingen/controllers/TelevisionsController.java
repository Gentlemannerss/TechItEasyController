package com.techiteasy.techiteasycontrolleruitwerkingen.controllers;

import com.techiteasy.techiteasycontrolleruitwerkingen.dtos.TelevisionDto;
import com.techiteasy.techiteasycontrolleruitwerkingen.exceptions.IndexOutOfBoundsException;
import com.techiteasy.techiteasycontrolleruitwerkingen.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasycontrolleruitwerkingen.exceptions.ToManyCharException;
import com.techiteasy.techiteasycontrolleruitwerkingen.models.Television;
import com.techiteasy.techiteasycontrolleruitwerkingen.repositories.TelevisionRepository;
import com.techiteasy.techiteasycontrolleruitwerkingen.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/tv")
public class TelevisionsController {

    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        return ResponseEntity.ok().body(televisionService.getAllTelevisions());
    }

    /* WORKING ON CODE HERE:*/

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable("id") Long id) {
        TelevisionDto television = televisionService.getTelevisionById(id);
        if (television != null) {
            return ResponseEntity.ok().body(television);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<TelevisionDto>> getTelevisionsByBrand(@PathVariable("brand") String brand) {
        List<TelevisionDto> televisions = televisionService.getTelevisionsByBrand(brand);
        if (!televisions.isEmpty()) {
            return ResponseEntity.ok().body(televisions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> addTelevision(@RequestBody TelevisionDto televisionDto) {
        TelevisionDto addedTelevision = televisionService.addTelevision(televisionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTelevision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable("id") Long id, @RequestBody TelevisionDto televisionDto) {
        TelevisionDto updatedTelevision = televisionService.updateTelevision(id, televisionDto);
        if (updatedTelevision != null) {
            return ResponseEntity.ok().body(updatedTelevision);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable("id") Long id) {
        boolean deleted = televisionService.deleteTelevision(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /*public TelevisionsController(TelevisionRepository repository) {
        this.televisionRepository = repository;
    }

    private List<String> allTV = new ArrayList<>();

    @PostMapping("/addTelevision")
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) throws ToManyCharException {
        if (television.getBrand().length() > 20) {
            throw new ToManyCharException("Mag niet langer dan 20 letters zijn");
        }
        televisionRepository.save(television);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(television.getId()).toUri();
        return ResponseEntity.created(location).body(television);
    }


    @GetMapping("/getTV/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) throws RecordNotFoundException {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isEmpty()) {
            throw new RecordNotFoundException("The value of id " + id + " doesn't exist");
        }
        Television television = optionalTelevision.get();
        return ResponseEntity.ok().body(television);
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions(@RequestParam )
        List<Television> televisions;

    if (brand == null) {
        televisions = televisionRepository
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Television>> getAllTelevisions(){
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @PutMapping("/allTV/{id}")
    public ResponseEntity<String> updateTV(@PathVariable int id, @RequestBody String newTv) {
        if (id >= 0 && id < allTV.size()) {
            allTV.set(id, newTv);
            return ResponseEntity.ok("Name updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{tv}")
    public ResponseEntity<String> deleteTV(@PathVariable String tv) {
        if (Objects.equals(tv, "test")) {
            throw new RecordNotFoundException("This name doesn't exist");
        }
        if (parseInt(tv) >= allTV.size()) {
            throw new IndexOutOfBoundsException("out of index");
        }
        if (allTV.contains(tv)) {
            allTV.remove(tv);
            return ResponseEntity.ok("TV item " + tv + " deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
