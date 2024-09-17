package com.cafem.CafeMenu.service.abstracts;

import com.cafem.CafeMenu.dto.request.contact.CreateContactRequest;
import com.cafem.CafeMenu.dto.request.contact.UpdateContactRequest;
import com.cafem.CafeMenu.dto.response.contact.CreateContactResponse;
import com.cafem.CafeMenu.dto.response.contact.GetAllContactResponse;
import com.cafem.CafeMenu.dto.response.contact.GetByIdContactResponse;
import com.cafem.CafeMenu.dto.response.contact.UpdateContactResponse;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<GetAllContactResponse> getAllContact();
    Optional<GetByIdContactResponse> getByIdContact(int id);
    CreateContactResponse createContact(CreateContactRequest request);
    UpdateContactResponse updateContact(UpdateContactRequest request, int id);
    void deleteContact(int id);
}
