package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class CriteriaDate implements ICriteria {
    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String date) {
        List<Mail> mailS = new ArrayList<Mail>();
        for (Mail m:mails) {

            if(m.getDates().contains( date )) {
                mailS.add( m );
            }
        }
        return mailS;
    }
}
