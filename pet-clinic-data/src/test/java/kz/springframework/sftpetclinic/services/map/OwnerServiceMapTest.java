package kz.springframework.sftpetclinic.services.map;

import kz.springframework.sftpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long id = 1L;
    final String lastName = "Duman";

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder().id(id).lastName(lastName).build());

    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {

        ownerServiceMap.deleteById(id);

        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(id));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
    }

    @Test
    void findById() {

        Owner owner = ownerServiceMap.findById(id);

        assertEquals(id, owner.getId());

    }

    @Test
    void findByLastName() {

        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertEquals(lastName, owner.getLastName());

    }
}