package com.avijeet.contacts.dao.contact;

import com.avijeet.contacts.enums.ContactType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContactResponseDao {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private ContactType contactType;
}