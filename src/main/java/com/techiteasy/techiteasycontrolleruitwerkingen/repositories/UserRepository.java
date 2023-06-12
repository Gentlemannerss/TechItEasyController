package com.techiteasy.techiteasycontrolleruitwerkingen.repositories;


import com.techiteasy.techiteasycontrolleruitwerkingen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
