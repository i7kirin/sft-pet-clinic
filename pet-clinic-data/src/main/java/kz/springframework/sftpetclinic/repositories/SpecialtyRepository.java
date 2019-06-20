package kz.springframework.sftpetclinic.repositories;

import kz.springframework.sftpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
