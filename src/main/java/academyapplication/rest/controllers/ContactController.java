package academyapplication.rest.controllers;

import academyapplication.rest.models.domain.ContactDTO;
import academyapplication.rest.models.domain.NewContactDTO;

import academyapplication.rest.services.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contacto")
public class ContactController {
    ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @PostMapping
    public NewContactDTO createContact(@RequestBody ContactDTO contactDTO){
        return contactService.add(contactDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> searchContact(@PathVariable long id){
        return ResponseEntity.ok(contactService.findById(id));
    }

    @PutMapping
    public void uptdateContact(@RequestBody ContactDTO contactDTO){
        contactService.update(contactDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContact(@PathVariable Long id){

        int result = contactService.delete(id);

        if(result == 1)
            return ResponseEntity.ok("Se ha eliminado el contacto");
        return ResponseEntity.notFound().build();
    }



}

/*
* post
* get
* put
* delete
* */
