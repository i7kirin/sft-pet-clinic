package kz.springframework.sftpetclinic.repositories;

import kz.springframework.sftpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
