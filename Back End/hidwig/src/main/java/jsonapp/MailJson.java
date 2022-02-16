package jsonapp;

import com.example.hidwig.Mail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MailJson  {
    public MailJson(){}
    ObjectMapper mapper = new ObjectMapper();
    public void writeJson(Mail obj, String path) throws IOException {
        List<Mail> list = readJson( path );
        list.add( obj );

        mapper.writeValue( new File( path ), list );
    }
    public void overwriteJson(List obj, String path) throws IOException {
        List list = readJson(path);
        list.clear();
        for (int i = 0; i < obj.size(); i++) {
            list.add( obj.get(i) );
        }
        mapper.writeValue( new File( path ), list );
    }
    public List<Mail> readJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if(!(new File(path)).exists()){
            return new ArrayList<Mail>();
        }
        else{
            List<Mail> listMail = mapper.readValue(new File(path), new TypeReference<ArrayList<Mail>>(){});
            return listMail;
        }
    }
    public void deleteMassage(Mail mail,String path) throws IOException {
        List<Mail> mailList = readJson( path );
        mailList = delete( mailList,mail );

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue( new File( path ), mailList );
    }
    public List<Mail> delete(List<Mail> l, Mail obj){
        for (int i = 0; i < l.size(); i++) {
            Mail m = (l.get( i ));
            boolean check = m.getSubject().compareTo( obj.getSubject()  )==0 && obj.getSender().compareTo( m.getSender() ) ==0&&obj.getContent().compareTo( m.getContent() )==0&&obj.getDates().compareTo( m.getDates() )==0&&obj.getReceiver().compareTo( m.getReceiver())==0&&obj.getAttachment().compareTo( m.getAttachment())==0&&obj.getKey().compareTo( m.getKey())==0;
            if(check){
                l.remove( i );
            }
        }
        return  l;
    }
}
