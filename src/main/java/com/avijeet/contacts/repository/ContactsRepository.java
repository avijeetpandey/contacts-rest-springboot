package com.avijeet.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avijeet.contacts.entities.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Long> {
}