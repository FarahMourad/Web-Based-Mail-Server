package com.example.hidwig;

import java.util.List;

public class OrCriteria implements ICriteria {
    ICriteria criteria;
    ICriteria criteria2;
    public OrCriteria(ICriteria criteria, ICriteria criteria2){
        this.criteria = criteria;
        this.criteria2 = criteria2;
    }
    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String criteria) {
        List<Mail> first = this.criteria.meetCriteria( mails,criteria );
        List<Mail> second = criteria2.meetCriteria( mails,criteria );
        for (Mail m :second) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        return first;
    }
}
