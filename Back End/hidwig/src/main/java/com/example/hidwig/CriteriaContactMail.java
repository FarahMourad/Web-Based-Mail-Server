package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class CriteriaContactMail implements ICriteriaContact{
    @Override
    public List<Contacts> meetCriteria(List<Contacts> contacts, String criteria) {
        List<Contacts> contact = new ArrayList<Contacts>();
        for (Contacts m:contacts) {

            if(m.getEmail().contains( criteria )) {
                contact.add( m );
            }
        }
        return contact;
    }
}
