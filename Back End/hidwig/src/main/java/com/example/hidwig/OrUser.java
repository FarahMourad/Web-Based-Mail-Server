package com.example.hidwig;

import java.util.List;

public class OrUser implements ICriteriaUser{
    ICriteriaUser criteria;
    ICriteriaUser criteria2;
    public OrUser(ICriteriaUser criteria, ICriteriaUser criteria2){
        this.criteria = criteria;
        this.criteria2 = criteria2;
    }
    @Override
    public List<User> meetCriteria(List<User> contacts, String criteria) {
        List<User> first = this.criteria.meetCriteria( contacts,criteria );
        List<User> second = criteria2.meetCriteria( contacts,criteria );
        for (User m :second) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        return first;
    }
}
