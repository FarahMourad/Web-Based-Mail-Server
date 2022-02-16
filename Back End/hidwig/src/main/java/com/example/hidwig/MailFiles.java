package com.example.hidwig;

import jsonapp.MailJson;
import jsonapp.UserJson;

import java.util.*;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;

public class MailFiles {
   // Filter L = new Filter("ID");
    UserJson userjson = new UserJson();
    MailJson mailJson = new MailJson();
    List list = userjson.readJson( "./accounts/index.json" );
    testSearch search = new testSearch();

    public MailFiles() throws IOException {
    }
    public void sendMail(Mail mail) throws IOException {
        testSearch f = new testSearch(  );
        List list = userjson.readJson( "./accounts/index.json" );
        User sender = (User) (f.search(list,"ID", mail.getId()).get(0));
        String[] str;
        //if(mail.getReceiver().contains( "," )){
        str = mail.getReceiver().split( "," );
        LinkedHashSet<String> str1 = new LinkedHashSet<String>(Arrays.asList(str));
        String[] strReceive = str1.toArray(new String[str1.size()]);
        Queue<String> q = new LinkedList<>();
        for(int i =0 ;i<strReceive.length;i++){
            q.add(strReceive[i]);
        }
        for(int i =0 ;i<strReceive.length; i++){
            sendUser( q.remove(),mail,sender.getMail() );
        }
        mail.setSender(sender.getMail());
        mailJson.writeJson( mail,"./accounts/"+mail.getId()+"/sent/mail.json" );
    }

    public void sendUser(String receiver,Mail mail ,String sender) throws IOException {
        testSearch n = new testSearch();
        List list = userjson.readJson( "./accounts/index.json" );
        List l = n.search( list,"Mail",receiver );
        if(l!= null &&!l.isEmpty()){
            User uSer =(User)l.get(0);
            if(uSer != null){
                Mail received ;
                received = new Mail(mail.getKey(), mail.getReceiver(),mail.getSubject(), mail.getAttachment(), mail.getContent(), mail.getDates(),mail.getId());
                received.setSender(sender);
                // received.setSender(sender.getMail());
                // received.setReceiver( uSer.getMail() );
                mailJson.writeJson( received,"./accounts/"+uSer.getId()+"/inbox/mail.json" );
            }
        }
    }
    /*public void sendMail(Mail mail) throws IOException {
        testSearch n = new testSearch();
        testSearch f = new testSearch(  );
        User sender = (User) (f.search(list,"ID", mail.getId()).get(0));
        if(!n.search( list,"Mail",mail.getReceiver() ).isEmpty() && n.search( list,"Mail",mail.getReceiver() ) != null){
            User uSer =(User) n.search( list,"Mail",mail.getReceiver() ).get(0);
            List list = userjson.readJson( "./accounts/index.json" );
            if(uSer != null){
                Mail received ;
                received = new Mail(mail.getKey(), mail.getReceiver(),mail.getSubject(), mail.getAttachment(), mail.getContent(), mail.getDates(),mail.getId());
                received.setSender(sender.getMail());
                // received.setSender(sender.getMail());
                // received.setReceiver( uSer.getMail() );

                mailJson.writeJson( received,"./accounts/"+uSer.getId()+"/inbox/mail.json" );
        }
        }
        mail.setSender(sender.getMail());
        mailJson.writeJson( mail,"./accounts/"+mail.getId()+"/sent/mail.json" );
    }*/
    public void deleteMail(String date, String folderName, String id) throws IOException {
        if(folderName.equals("trash")){
            List mail = mailJson.readJson("./accounts/"+ id +"/"+ folderName +"/mail.json");
            Mail m = search.search(mail,date);
            mailJson.deleteMassage( m,"./accounts/"+id+"/"+"trash/mail.json" );
        }
        else{
            moveMail( "trash",folderName,date, id);
        }

    }
    public void moveMail(String newFolder, String oldFolder,String date,String id) throws IOException {
        List mail = mailJson.readJson("./accounts/"+ id +"/"+ oldFolder +"/mail.json");
        Mail m = search.search(mail,date);
        mailJson.writeJson( m,"./accounts/"+id+"/"+newFolder+"/mail.json" );
        mailJson.deleteMassage( m,"./accounts/"+id+"/"+oldFolder+"/mail.json" );
    }
    public void autoDelete(String id) throws IOException {
      List l =   mailJson.readJson( "./accounts/"+id+"/trash/mail.json");
        for (int i = 0; i < l.size(); i++) {
            Mail mail = (Mail) l.get( i );
            String Date = mail.getDates().substring(0,10);
            //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            LocalDate dateBefore = LocalDate.parse(Date);
            LocalDate dateAfter = LocalDate.now();
            System.out.println("lala");
            System.out.println("lolo");
            long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
            if(noOfDaysBetween>30)
            {
                mailJson.deleteMassage(mail,"./accounts/"+id+"/trash/mail.json" );
            }
        }
    }

}
