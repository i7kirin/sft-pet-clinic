package kz.springframework.sftpetclinic.repositories;

import kz.springframework.sftpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
