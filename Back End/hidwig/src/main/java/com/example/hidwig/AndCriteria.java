package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class AndCriteria implements ICriteria {
    ICriteria criteria;
    ICriteria criteria2;
    public AndCriteria(ICriteria criteria, ICriteria criteria2){
        this.criteria = criteria;
        this.criteria2 = criteria2;
    }
    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String criteria) {
        List<Mail> first = this.criteria.meetCriteria( mails,criteria );

        return criteria2.meetCriteria( first,criteria );
    }
}
