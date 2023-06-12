package com.techiteasy.techiteasycontrolleruitwerkingen.repositories;

import com.techiteasy.techiteasycontrolleruitwerkingen.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findByBrand(String brand);
    List findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
