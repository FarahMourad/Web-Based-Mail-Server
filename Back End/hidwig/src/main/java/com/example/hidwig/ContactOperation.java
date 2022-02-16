package com.example.hidwig;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonapp.FileJson;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContactOperation {
    FileJson fileJson = new FileJson();
    public void add(Contacts contact,String id) throws IOException {
        fileJson.writeJson( contact,"./accounts/"+id+"/contacts.json" );
    }
    public void delete(Contacts contact,String id) throws IOException {
            List<Contacts> list = fileJson.readCJson("./accounts/"+id+"/contacts.json");
        for (int i=0; i<list.size();i++) {

            if(list.get( i ).getEmail().equals( contact.getEmail() )&&list.get( i ).getName().equals( contact.getName() )){
                list.remove(i);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue( new File( "./accounts/"+id+"/contacts.json" ), list );
    }
    public void edit(Contacts contact,Contacts newContact,String id) throws IOException {
        delete(contact,id);
        add(newContact,id);
    }
    public List searchExistedContact(String id,String str) throws IOException {
       List<Contacts> list =fileJson.readJson("./accounts/"+id+"/contacts.json");
       ICriteriaContact criteria = new CriteriaContactMail();
       ICriteriaContact criteria1 = new CriteriaContactMail();
        ICriteriaContact criteria2 = new OrContact( criteria,criteria1 );
      List l =  criteria2.meetCriteria( list,str );
      return l;

    }
    public void searchNewContact(String str) throws IOException {

        List<User> list =fileJson.readJson("./accounts/index.json");
        ICriteriaUser criteria = new CriteriaUSerMail();
        ICriteriaUser criteria1 = new CriteriaUserName();
        ICriteriaUser criteria2 = new OrUser( criteria,criteria1 );
        criteria2.meetCriteria( list,str );
    }

    public List sortContact(String typeOfSort, String id) throws IOException {
        List<Contacts> list = fileJson.readCJson("./accounts/"+id+"/contacts.json");
        Sorting sorting = new Sorting();
        sorting.sort(list,typeOfSort);
        return list;
    }
    public List showContact(String id) throws IOException {
        return fileJson.readCJson( "./accounts/"+id+"/contacts.json");
    }


}
