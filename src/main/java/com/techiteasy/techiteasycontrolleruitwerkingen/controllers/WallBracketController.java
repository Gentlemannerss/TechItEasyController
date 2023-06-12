package com.techiteasy.techiteasycontrolleruitwerkingen.controllers;

import com.techiteasy.techiteasycontrolleruitwerkingen.dtos.input.WallBracketInputDTO;
import com.techiteasy.techiteasycontrolleruitwerkingen.dtos.output.WallBracketOutputDTO;
import com.techiteasy.techiteasycontrolleruitwerkingen.models.WallBracket;
import com.techiteasy.techiteasycontrolleruitwerkingen.services.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    @Autowired
    private WallBracketService wallBracketService;

    @PostMapping("/add/wallbracket")
    public ResponseEntity<WallBracketOutputDTO> createWallBracket(
            @Validated @RequestBody WallBracketInputDTO wallBracketInputDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); }
        return ResponseEntity.status(HttpStatus.CREATED).body(wallBracketService.createWallBracket(wallBracketInputDTO));
    }

    @PostMapping("/addmore/wallbrackets")
    public ResponseEntity<List<WallBracketOutputDTO>> createWallBrackets(
            @Validated @RequestBody List<WallBracketInputDTO> wallBracketsInputDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); }
        return new ResponseEntity<>(wallBracketService.createWallBrackets(wallBracketsInputDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracket> getWallBracketById(@PathVariable Long id) {
        return ResponseEntity.ok(wallBracketService.getWallBracketById(id));
    }

    @GetMapping
    public List<WallBracket> getAllWallBrackets() {
        return wallBracketService.getAllWallBrackets();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketOutputDTO> updateWallBracket(
            @Validated @PathVariable Long id, @RequestBody WallBracketInputDTO wallBracketInputDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); }
        return ResponseEntity.ok(wallBracketService.updateWallBracket(id, wallBracketInputDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }
}
