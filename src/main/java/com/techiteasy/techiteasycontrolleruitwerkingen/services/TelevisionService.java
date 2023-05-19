package com.techiteasy.techiteasycontrolleruitwerkingen.services;

import com.techiteasy.techiteasycontrolleruitwerkingen.dtos.TelevisionDto;
import com.techiteasy.techiteasycontrolleruitwerkingen.models.Television;
import com.techiteasy.techiteasycontrolleruitwerkingen.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository; //Dit kun je ook repos noemen. Maar een betere beschrijving is duidelijker.

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        for (Television television : televisions) {
            // Voor elke tv een eigen dto aanmaken.
            televisionDtos.add(transferTelevisionToDto(television));
            // Voor elke for loop, halen we een televisie uit de lijst, en in de methode zet hij de dto om naar een televisie.
        }
        return televisionDtos;
    }

    public TelevisionDto getTelevisionById(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            Television television = optionalTelevision.get();
            return transferTelevisionToDto(television);
        }
        return null;
    }

    public List<TelevisionDto> getTelevisionsByBrand(String brand) {
        List<Television> televisions = televisionRepository.findByBrand(brand);
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        for (Television television : televisions) {
            televisionDtos.add(transferTelevisionToDto(television));
        }
        return televisionDtos;
    }

    public TelevisionDto addTelevision(TelevisionDto televisionDto) {
        Television television = transferDtoToTelevision(televisionDto);
        Television savedTelevision = televisionRepository.save(television);
        return transferTelevisionToDto(savedTelevision);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionDto televisionDto) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            Television existingTelevision = optionalTelevision.get();
            existingTelevision.setName(televisionDto.getName());
            existingTelevision.setBrand(televisionDto.getBrand());
            televisionRepository.save(existingTelevision);
            return transferTelevisionToDto(existingTelevision);
        }
        return null;
    }

    public boolean deleteTelevision(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            televisionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private TelevisionDto transferTelevisionToDto(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();
        televisionDto.setName(television.getName());
        televisionDto.setBrand(television.getBrand());
        return televisionDto;
    }

    private Television transferDtoToTelevision(TelevisionDto televisionDto) {
        Television television = new Television();
        television.setName(televisionDto.getName());
        television.setBrand(televisionDto.getBrand());
        return television;
    }
}
