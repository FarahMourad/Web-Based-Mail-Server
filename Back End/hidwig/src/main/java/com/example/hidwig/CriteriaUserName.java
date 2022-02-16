package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class CriteriaUserName implements ICriteriaUser {
    public List<User> meetCriteria(List<User> contacts, String criteria){
        List<User> contact = new ArrayList<User>();
        for (User m:contacts) {
            String name = m.getMail();
            if(name.contains( criteria )) {
                contact.add( m );
            }
        }
        return contact;
    }
}
