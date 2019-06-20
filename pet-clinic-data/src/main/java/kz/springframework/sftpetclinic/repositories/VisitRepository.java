package kz.springframework.sftpetclinic.repositories;

import kz.springframework.sftpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
