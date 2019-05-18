package kz.springframework.sftpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets","/vet/index","/vet/index.html"})
    public String listVets(){
        return "vet/vetIndex";
    }
}
