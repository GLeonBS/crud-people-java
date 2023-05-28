package com.user.cruduser.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.user.cruduser.dto.ContactDTO;
import com.user.cruduser.model.Contact;

@Component
public class ContactMapper {

    public ContactDTO toDTO(Contact contact) {
        if(contact == null){
            return null;
        }
        return new ContactDTO(contact.getId(), contact.getName(), contact.getEmail(), contact.getPhoneNumber());
    }

    public Contact toEntity(ContactDTO contactDTO) {
        if(contactDTO == null){
            return null;
        }
        Contact contact = new Contact();
        if(contactDTO._id() != null){
            contact.setId(contactDTO._id());
        }
        contact.setName(contactDTO.name());
        contact.setEmail(contactDTO.email());
        contact.setPhoneNumber(contactDTO.phoneNumber());
        return contact;
    }

    public List<Contact> toListContactsEntity(List<ContactDTO> contactsDTO){
        List<Contact> contacts = new ArrayList<>();
        for(ContactDTO contactDTO : contactsDTO) {
            contacts.add(this.toEntity(contactDTO));
        }
        return contacts;
        
    }

    public List<ContactDTO> toListContactsDTO(List<Contact> contacts){
        List<ContactDTO> contactsDTO = new ArrayList<>();
        for(Contact contactDTO : contacts) {
            contactsDTO.add(this.toDTO(contactDTO));
        }
        return contactsDTO;
        
    }
}
