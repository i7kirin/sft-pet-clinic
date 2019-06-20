package kz.springframework.sftpetclinic.repositories;

import kz.springframework.sftpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
