package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class CriteriaBody implements ICriteria {

    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String criteria) {
        List<Mail> mailS = new ArrayList<Mail>();
        for (Mail m:mails) {

            if(m.getContent().toLowerCase().contains( criteria.toLowerCase() )) {
                mailS.add( m );
            }
        }
        return mailS;
    }
}
