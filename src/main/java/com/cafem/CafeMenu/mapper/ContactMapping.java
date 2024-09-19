package com.cafem.CafeMenu.mapper;

import com.cafem.CafeMenu.dto.request.contact.CreateContactRequest;
import com.cafem.CafeMenu.dto.request.contact.UpdateContactRequest;
import com.cafem.CafeMenu.dto.response.contact.GetAllContactResponse;
import com.cafem.CafeMenu.dto.response.contact.GetByIdContactResponse;
import com.cafem.CafeMenu.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapping {


    ContactMapping INSTANCE = Mappers.getMapper(ContactMapping.class);


    Contact createContact(CreateContactRequest request);
    Contact updateContact(UpdateContactRequest request, @MappingTarget Contact contact);

    GetByIdContactResponse getByIdContact(Contact contact);

    GetAllContactResponse getAllContact(Contact contact);
    List<GetAllContactResponse> contactToListContactResponse(List<Contact> contacts);
}
