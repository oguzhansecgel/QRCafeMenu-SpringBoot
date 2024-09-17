package com.cafem.CafeMenu.controller;

import com.cafem.CafeMenu.dto.request.contact.CreateContactRequest;
import com.cafem.CafeMenu.dto.request.contact.UpdateContactRequest;
import com.cafem.CafeMenu.dto.response.contact.CreateContactResponse;
import com.cafem.CafeMenu.dto.response.contact.GetAllContactResponse;
import com.cafem.CafeMenu.dto.response.contact.GetByIdContactResponse;
import com.cafem.CafeMenu.dto.response.contact.UpdateContactResponse;
import com.cafem.CafeMenu.service.abstracts.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/getByIdContact/{id}")
    public Optional<GetByIdContactResponse> getContactById(@PathVariable int id) {
        return contactService.getByIdContact(id);
    }

    @GetMapping("/getAllContact")
    public List<GetAllContactResponse> getAllContact() {
        return contactService.getAllContact();
    }

    @DeleteMapping("/deleteContact/{id}")
    public void deleteContact(@PathVariable int id) {
        contactService.deleteContact(id);
    }

    @PostMapping("/createContact")
    public CreateContactResponse createContact(@RequestBody CreateContactRequest createContactRequest) {
        return contactService.createContact(createContactRequest);
    }

    @PutMapping("/updateContact/{id}")
    public UpdateContactResponse updateContact(@PathVariable int id, @RequestBody UpdateContactRequest updateContactRequest) {
        return contactService.updateContact(updateContactRequest, id);
    }
}
