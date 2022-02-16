package com.example.hidwig;

import jsonapp.MailJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PriorityManipulator {

    MailJson mailJson = new MailJson();

    public PriorityManipulator() throws IOException {
    }

    public void Queue(List<Mail> l) throws IOException {
        PriorityQueue p = new PriorityQueue();
        //List<Mail> l=  mailJson.readJson( "./accounts/"+ id+"/"+folderName+".json" );
        for (int i = 0; i < l.size(); i++) {
            Mail mail = l.get( i );
            int key = Integer.parseInt( mail.getKey() );
            p.insert( mail,key);
        }
        for(int i = 0;i< p.size();i++){
            l.set(i, (Mail) p.removeMin());
        }
    }
}
