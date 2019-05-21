package kz.springframework.sftpetclinic.bootstrap;

import kz.springframework.sftpetclinic.model.Owner;
import kz.springframework.sftpetclinic.model.Vet;
import kz.springframework.sftpetclinic.services.OwnerService;
import kz.springframework.sftpetclinic.services.VetService;
import kz.springframework.sftpetclinic.services.map.OwnerServiceMap;
import kz.springframework.sftpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Duman");
        owner1.setLastName("Zhanbolatov");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Askar");
        owner1.setLastName("Mamin");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Miron");
        vet1.setLastName("Kalkamanov");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Tasbek");
        vet1.setLastName("Ermekov");

        vetService.save(vet2);
    }
}
