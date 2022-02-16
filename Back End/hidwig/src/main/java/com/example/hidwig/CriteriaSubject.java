package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSubject implements ICriteria {
    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String subject) {
        List<Mail> mailSub = new ArrayList<Mail>();
        for (Mail m:mails) {
            if(m.getSubject().toLowerCase().contains( subject.toLowerCase() )){
                mailSub.add( m );
            }
        }
        return mailSub;
    }
}
