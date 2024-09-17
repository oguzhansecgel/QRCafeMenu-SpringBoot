package com.cafem.CafeMenu.repositories;

import com.cafem.CafeMenu.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepositories extends JpaRepository<Contact, Integer> {
}
