package com.techiteasy.techiteasycontrolleruitwerkingen.controllers;

import com.techiteasy.techiteasycontrolleruitwerkingen.dtos.input.CiModuleInputDTO;
import com.techiteasy.techiteasycontrolleruitwerkingen.dtos.output.CiModuleOutputDTO;
import com.techiteasy.techiteasycontrolleruitwerkingen.models.CiModule;
import com.techiteasy.techiteasycontrolleruitwerkingen.services.CiModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cimodules")
public class CiModuleController {

    @Autowired
    private CiModuleService ciModuleService;

    @PostMapping("/add/cimodule")
    public ResponseEntity<CiModuleOutputDTO> createCiModule(
            @Validated @RequestBody CiModuleInputDTO ciModuleInputDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); }
        return ResponseEntity.status(HttpStatus.CREATED).body(ciModuleService.createCiModule(ciModuleInputDTO));
    }

    @PostMapping("/addmore/cimodules")
    public ResponseEntity<List<CiModuleOutputDTO>> createCiModules(
            @Validated @RequestBody List<CiModuleInputDTO> ciModulesInputDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); }
        return new ResponseEntity<>(ciModuleService.createCiModules(ciModulesInputDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiModule> getCiModuleById(@PathVariable Long id) {
        return ResponseEntity.ok(ciModuleService.getCiModuleById(id));
    }

    @GetMapping
    public List<CiModule> getAllCiModules() {
        return ciModuleService.getAllCiModules();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiModuleOutputDTO> updateCiModule(
            @Validated @PathVariable Long id, @RequestBody CiModuleInputDTO ciModuleInputDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); }
        return ResponseEntity.ok(ciModuleService.updateCiModule(id, ciModuleInputDTO));
    }

    @PutMapping("/{id}/television/{television_id}")
    public ResponseEntity<String> assignTelevisionToCiModule(@PathVariable Long id, @PathVariable Long television_id) {
        return ResponseEntity.ok(ciModuleService.assignTelevisionToCiModule(id, television_id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiModule(@PathVariable Long id) {
        ciModuleService.deleteCiModule(id);
        return ResponseEntity.noContent().build();
    }
}