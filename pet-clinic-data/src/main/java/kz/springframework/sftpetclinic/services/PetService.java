package kz.springframework.sftpetclinic.services;

import kz.springframework.sftpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}