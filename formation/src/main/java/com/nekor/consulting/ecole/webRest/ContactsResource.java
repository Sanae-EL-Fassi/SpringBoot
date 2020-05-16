package com.nekor.consulting.ecole.webRest;

import com.nekor.consulting.ecole.exceptions.MyException;
import com.nekor.consulting.ecole.model.Contact;
import com.nekor.consulting.ecole.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsResource {

    @Autowired
    private ContactRepository contactRepository;

    private final Logger logger = LoggerFactory.getLogger(ContactsResource.class);

//    private static Set<Contact> contacts = new HashSet<>();
//
//
//
//    @PostConstruct
//    private void init() {
//        Contact contact = new Contact("Sanae", "Sanae", Boolean.TRUE);
//        contacts.add(contact);
//        contact = new Contact("Mehdi", "Mehdi", Boolean.TRUE);
//        contacts.add(contact);
//    }

    @GetMapping
    public List<Contact> getAllContacts() throws MyException {

        logger.info("Enter getAllContacts");
        List<Contact> contacts = this.contactRepository.findAll();
        logger.debug("Nombre de contact dans la DB :" + contacts.size());
        throw new MyException("myException");
//        return contacts;

    }

    @GetMapping("/byName")
    public Contact getByName(@RequestParam(name = "name") String name) {
        return this.contactRepository.findByNom(name);
    }


    @DeleteMapping("/{monMail}")
    public void deleteContact(@PathVariable String monMail) {
        this.contactRepository.findById(monMail).ifPresent(contact -> {
            this.contactRepository.delete(contact);
        });
    }

    @PutMapping
    public void updateContact(@RequestBody Contact contact) {
        this.contactRepository.save(contact);
    }

    @PostMapping
    public void createContact(@RequestBody Contact contact) {
        this.contactRepository.save(contact);
    }


//    @GetMapping("/short/{nbChar}/{startWith}")
//    public static Set<String> getShortContacts(@PathVariable(value = "nbChar", required = true) int nbChar,
//                                               @PathVariable(value = "startWith", required = true) String startWith) {
//        return contacts.stream().filter(ct -> ct.length() < nbChar && ct.startsWith(startWith)).map(v -> v).collect(Collectors.toSet());
//    }

//    @PostMapping
//    public void addContact(@RequestBody(required = false) Contact contact) {
//        contacts.add(contact);
//    }
}
