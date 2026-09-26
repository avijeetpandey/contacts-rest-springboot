package com.avijeet.contacts.services;

import org.springframework.stereotype.Service;

import com.avijeet.contacts.dao.contact.ContactRequestDao;
import com.avijeet.contacts.dao.contact.ContactResponseDao;
import com.avijeet.contacts.entities.Contact;
import com.avijeet.contacts.enums.ContactType;
import com.avijeet.contacts.repository.ContactsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactService {
    private final ContactsRepository contactsRepository;

    public ContactResponseDao addContact(ContactRequestDao contactRequest) {
        Contact contact = new Contact();
        if (contactRequest != null) {
            contact.setName(contactRequest.getName());
            contact.setEmail(contactRequest.getEmail());
            contact.setPhone(contactRequest.getPhoneNumber());
            contact.setAge(contactRequest.getAge());
            contact.setContactType(ContactType.valueOf(contactRequest.getContactType().toUpperCase()));
            Contact savedContact = contactsRepository.save(contact);
            return mapToContactResponseDao(savedContact);
        }
        return null;
    }

    public ContactResponseDao getContactById(Long id) {
        Contact contact = contactsRepository.findById(id).orElse(null);
        if (contact != null) {
            return mapToContactResponseDao(contact);
        }
        return null;
    }

    private ContactResponseDao mapToContactResponseDao(Contact contact) {
        ContactResponseDao contactResponseDao = new ContactResponseDao();
        contactResponseDao.setName(contact.getName());
        contactResponseDao.setEmail(contact.getEmail());
        contactResponseDao.setPhoneNumber(contact.getPhone());
        contactResponseDao.setContactType(contact.getContactType());
        contactResponseDao.setId(contact.getId());
        return contactResponseDao;
    }

    private Contact mapToContact(ContactRequestDao contactRequest) {
        Contact contact = new Contact();
        contact.setName(contactRequest.getName());
        contact.setEmail(contactRequest.getEmail());
        contact.setPhone(contactRequest.getPhoneNumber());
        contact.setAge(contactRequest.getAge());
        return contact;
    }
}
