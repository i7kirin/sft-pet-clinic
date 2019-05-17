package kz.springframework.sftpetclinic.services;

import kz.springframework.sftpetclinic.model.Pet;
import kz.springframework.sftpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Pet owner);

    Set<Vet> findAll();
}
