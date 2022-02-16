package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class CriteriaImportance implements ICriteria {
    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String importance) {
        List<Mail> mailS = new ArrayList<Mail>();
        for (Mail m:mails) {

            if(m.getKey()+"" == importance) {
                mailS.add( m );
            }
        }
        return mailS;
    }
}
