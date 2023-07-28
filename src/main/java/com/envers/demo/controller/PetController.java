package com.envers.demo.controller;


import com.envers.demo.entity.Pet;
import com.envers.demo.exception.PetNotFoundException;
import com.envers.demo.repository.AuditRepository;
import com.envers.demo.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PetController {

    private final PetRepository petRepository;

    private final AuditRepository auditRepository;

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @PostMapping("/pet/new")
    public void addPet(@RequestBody Pet pet) {
        petRepository.save(pet);
        log.info("Added new pet {} ", pet);
    }

    @GetMapping("/pet/{id}")
    public Pet findById(@PathVariable Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    @PutMapping("/pet/donate/{id}/{donation}")
    public void updatePetDonation(@PathVariable Long id, @PathVariable double donation) {
        Optional<Pet> petToUpdate = petRepository.findById(id);
        if (petToUpdate.isPresent()) {
            petToUpdate.get().setDonation(petToUpdate.get().getDonation() + donation);
            petRepository.save(petToUpdate.get());
            log.info("Save updated pet {} ", petToUpdate);
        } else {
            throw new PetNotFoundException(id);
        }
    }

    @DeleteMapping("/pet/{id}")
    public void deleteById(@PathVariable Long id) {
        petRepository.deleteById(id);
    }

    @GetMapping("/pets/audit/{id}")
    public List<Pet> getAllPetsAudit(@PathVariable Long id) {
        return auditRepository.getRevisions(Pet.class, "id", id);
    }
}
