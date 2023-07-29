package com.example.springdynamodemo.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.example.springdynamodemo.model.Contact;
import com.example.springdynamodemo.model.ContactType;

import java.util.List;

public class ContactTypeConverter implements DynamoDBTypeConverter<String, ContactType> {
    @Override
    public String convert(ContactType object) {
        return object.name();
    }

    @Override
    public ContactType unconvert(String object) {
        return ContactType.valueOf(object);
    }
}
