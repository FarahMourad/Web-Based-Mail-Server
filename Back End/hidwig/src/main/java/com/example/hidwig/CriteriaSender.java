package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSender implements ICriteria{
    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String sender) {
        List<Mail> mailS = new ArrayList<Mail>();
        for (Mail m:mails) {
            if(m.getSender().toLowerCase().contains( sender.toLowerCase() )){
                mailS.add( m );
            }
        }
        return mailS;
    }
}
