package kz.springframework.sftpetclinic.bootstrap;

import kz.springframework.sftpetclinic.model.*;
import kz.springframework.sftpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count ==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Duman");
        owner1.setLastName("Zhanbolatov");
        owner1.setAddress("123 Ast");
        owner1.setCity("Astana");
        owner1.setTelephone("123123132");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
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
        givCat.setBirthDate(LocalDate.now());
        givCat.setOwner(owner2);
        givCat.setName("JustCat");
        owner2.getPets().add(givCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(givCat);
        catVisit.setVisitDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Miron");
        vet1.setLastName("Kalkamanov");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tasbek");
        vet2.setLastName("Ermekov");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
    }
}
