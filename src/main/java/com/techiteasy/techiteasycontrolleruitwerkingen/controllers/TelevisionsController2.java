package com.techiteasy.techiteasycontrolleruitwerkingen.controllers;

import com.techiteasy.techiteasycontrolleruitwerkingen.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tv") // set base URL path

public class TelevisionsController2 {

    @GetMapping("/all")
    public ResponseEntity<Object> getAllTelevisions() {
        // ok = code 200
        return ResponseEntity.ok("All televisions");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable int id) {
        // ok = code 200
        return ResponseEntity.ok("Television" + id); //wil je het volle object, dan benoem de naam, anders specefiëk wat je wil
    }

    // Path Variable gebruik je alleen om een pad op te zoeken (1 variabele opvragen)
    // Request Param - kun geen /{id} gebruiken.
    // Path Variable kun je alleen niet via key en value in postman checken. Omdat het in de url meegegeven moet worden.

    @PostMapping("addTelevision")
    public ResponseEntity<Object> addTelevision(@RequestBody String television) {
        return ResponseEntity.created(null).body(television);
    }

    @PutMapping("updateTelevision/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) { //normaal zou je datatype(object).naam doen
        return ResponseEntity.accepted().body(television + " " +  id);
    }

    @DeleteMapping("deleteTelevision/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id){
        return ResponseEntity.noContent().build(); //als je iets verwijderd wil je terug naar een homepage of gebruikspagina.
    }
}
