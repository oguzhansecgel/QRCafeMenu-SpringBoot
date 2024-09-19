package com.cafem.CafeMenu.service.concretes;

import com.cafem.CafeMenu.core.constant.ContactConstant;
import com.cafem.CafeMenu.core.exception.exceptionhandler.ContactNotFoundException;
import com.cafem.CafeMenu.dto.request.contact.CreateContactRequest;
import com.cafem.CafeMenu.dto.request.contact.UpdateContactRequest;
import com.cafem.CafeMenu.dto.response.contact.CreateContactResponse;
import com.cafem.CafeMenu.dto.response.contact.GetAllContactResponse;
import com.cafem.CafeMenu.dto.response.contact.GetByIdContactResponse;
import com.cafem.CafeMenu.dto.response.contact.UpdateContactResponse;
import com.cafem.CafeMenu.entities.Contact;
import com.cafem.CafeMenu.mapper.ContactMapping;
import com.cafem.CafeMenu.repositories.ContactRepositories;
import com.cafem.CafeMenu.service.abstracts.ContactService;
import org.springframework.stereotype.Service;
import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

import java.io.Serial;
import java.util.List;
import java.util.Optional;
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepositories contactRepositories;

    public ContactServiceImpl(ContactRepositories contactRepositories) {
        this.contactRepositories = contactRepositories;
    }

    @Override
    public List<GetAllContactResponse> getAllContact() {
        List<Contact> contactList = contactRepositories.findAll();
        return ContactMapping.INSTANCE.contactToListContactResponse(contactList);
    }

    @Override
    public Optional<GetByIdContactResponse> getByIdContact(int id) {
        Optional<Contact> contact = contactRepositories.findById(id);
        if (contact.isEmpty()) {
            throw new ContactNotFoundException(ContactConstant.CONTACT_NOT_FOUND_MESSAGE);
        }
        return contact.map(ContactMapping.INSTANCE::getByIdContact);
    }

    @Override
    public CreateContactResponse createContact(CreateContactRequest request) {
        Contact contact = ContactMapping.INSTANCE.createContact(request);
        Contact savedContact = contactRepositories.save(contact);
        return new CreateContactResponse(savedContact.getId(), savedContact.getTitle(), savedContact.getDescription(), savedContact.getFacebook(), savedContact.getInstagram());
    }

    @Override
    public UpdateContactResponse updateContact(UpdateContactRequest request, int id) {
        Optional<Contact> optionalContact = contactRepositories.findById(id);
        if (optionalContact.isEmpty()) {
            throw new ContactNotFoundException(ContactConstant.CONTACT_NOT_FOUND_MESSAGE);
        }
        Contact existingContact = optionalContact.get();
        Contact contact = ContactMapping.INSTANCE.updateContact(request, existingContact);
        Contact savedContact = contactRepositories.save(contact);
        return new UpdateContactResponse(savedContact.getId(), savedContact.getTitle(), savedContact.getDescription(), savedContact.getFacebook(), savedContact.getInstagram());
    }

    @Override
    public void deleteContact(int id) {
        Optional<Contact> contact = contactRepositories.findById(id);
        if (contact.isEmpty())
            throw new ContactNotFoundException(ContactConstant.CONTACT_NOT_FOUND_MESSAGE);
        contactRepositories.deleteById(id);
    }
}
