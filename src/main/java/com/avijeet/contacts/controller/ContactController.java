package com.avijeet.contacts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avijeet.contacts.dao.contact.ContactRequestDao;
import com.avijeet.contacts.dao.contact.ContactResponseDao;
import com.avijeet.contacts.services.ContactService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactResponseDao> addContact(@Valid @RequestBody ContactRequestDao requestDao) {
        ContactResponseDao responseDao = contactService.addContact(requestDao);
        return ResponseEntity.ok(responseDao);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactResponseDao> getContact(@PathVariable String id) {
        ContactResponseDao responseDao = contactService.getContactById(Long.parseLong(id));
        if (responseDao != null) {
            return ResponseEntity.ok(responseDao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}