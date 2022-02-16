package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class CriteriaReceiver implements ICriteria {
    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String receiver) {
        List<Mail> mailS = new ArrayList<Mail>();
        for (Mail m:mails) {
                if(m.getReceiver().toLowerCase().contains( receiver.toLowerCase() ))
                mailS.add( m );
            }

        return mailS;
    }
}
