package com.techiteasy.techiteasycontrolleruitwerkingen.controllers;

import com.techiteasy.techiteasycontrolleruitwerkingen.exceptions.IndexOutOfBoundsException;
import com.techiteasy.techiteasycontrolleruitwerkingen.exceptions.RecordNotFoundException;
/*import org.apache.tomcat.util.http.fileupload.MultipartStream;*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@RestController
public class TelevisionsController {
    private List<String> allTV = new ArrayList<>();

    @PostMapping("/addTV") //het is beter om een @PostMapping toe te voegen voor meerdere tv's
    public void addTV(@RequestParam String tv) {
        allTV.add(tv);
    }

    /*@PostMapping("/addMultipleTv")
    public void addMultipleTV(@RequestParam List<String> alltv) {
       alltv.add(tv);
    }*/

    @GetMapping("/getAllTV")
    public List<String> getAllTV() {
        return this.allTV;
    }

    @GetMapping("/getTV")
    public String getTV() {
        return this.allTV.get(0);
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
    }
}
