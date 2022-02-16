package com.example.hidwig;

import java.util.List;

public class OrContact implements ICriteriaContact{
    ICriteriaContact criteria;
    ICriteriaContact criteria2;
    public OrContact(ICriteriaContact criteria, ICriteriaContact criteria2){
        this.criteria = criteria;
        this.criteria2 = criteria2;
    }
    @Override
    public List<Contacts> meetCriteria(List<Contacts> contacts, String criteria) {
        List<Contacts> first = this.criteria.meetCriteria( contacts,criteria );
        List<Contacts> second = criteria2.meetCriteria( contacts,criteria );
        for (Contacts m :second) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        return first;
    }
}
