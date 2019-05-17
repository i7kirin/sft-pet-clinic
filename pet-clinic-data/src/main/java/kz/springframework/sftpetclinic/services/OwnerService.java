package kz.springframework.sftpetclinic.services;

import kz.springframework.sftpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
