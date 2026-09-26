package com.avijeet.contacts.dao.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContactRequestDao {
    private String name;
    private String email;
    private String phoneNumber;
    private Integer age;
    private String contactType;
}