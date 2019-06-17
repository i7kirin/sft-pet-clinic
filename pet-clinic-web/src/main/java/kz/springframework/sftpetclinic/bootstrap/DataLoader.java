package kz.springframework.sftpetclinic.bootstrap;

import kz.springframework.sftpetclinic.model.Owner;
import kz.springframework.sftpetclinic.model.Pet;
import kz.springframework.sftpetclinic.model.PetType;
import kz.springframework.sftpetclinic.model.Vet;
import kz.springframework.sftpetclinic.services.OwnerService;
import kz.springframework.sftpetclinic.services.PetTypeService;
import kz.springframework.sftpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Duman");
        owner1.setLastName("Zhanbolatov");
        owner1.setAddress("123 Ast");
        owner1.setCity("Astana");
        owner1.setTelephone("123123132");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDay(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Askar");
        owner2.setLastName("Mamin");
        owner2.setAddress("123 Ast");
        owner2.setCity("Almaty");
        owner2.setTelephone("123123132");

        Pet givCat = new Pet();
        givCat.setPetType(savedCatType);
        givCat.setBirthDay(LocalDate.now());
        givCat.setOwner(owner2);
        givCat.setName("JustCat");
        owner2.getPets().add(givCat);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Miron");
        vet1.setLastName("Kalkamanov");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tasbek");
        vet2.setLastName("Ermekov");

        vetService.save(vet2);
    }
}
