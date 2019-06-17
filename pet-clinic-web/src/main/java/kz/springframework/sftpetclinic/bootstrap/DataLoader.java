package kz.springframework.sftpetclinic.bootstrap;

import kz.springframework.sftpetclinic.model.Owner;
import kz.springframework.sftpetclinic.model.PetType;
import kz.springframework.sftpetclinic.model.Vet;
import kz.springframework.sftpetclinic.services.OwnerService;
import kz.springframework.sftpetclinic.services.PetTypeService;
import kz.springframework.sftpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Askar");
        owner2.setLastName("Mamin");

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
