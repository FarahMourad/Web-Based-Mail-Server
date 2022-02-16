package jsonapp;
import com.example.hidwig.Mail;
import com.example.hidwig.User;
import com.example.hidwig.testSearch;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserJson  {
    public UserJson(){}
    ObjectMapper mapper = new ObjectMapper();
    public void writeJson(User use, String path) throws IOException {
        List<User> list = readJson( path );
        list.add( use );

        mapper.writeValue(new File(path), list);
    }
    public List<User> readJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if(!(new File(path)).exists()){

            return new ArrayList<User>();
        }
        else{
            List<User> listUser = mapper.readValue(new File(path), new TypeReference<ArrayList<User>>(){});
            return listUser;
        }

    }
    public void deleteUser(User mail, String path) throws IOException {
        List<User> mailList = readJson( path );
        mailList = delete( mailList,mail );
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue( new File( path ), mailList );
    }
    public List<User> delete(List<User> l, User obj){
        for (int i = 0; i < l.size(); i++) {
            User m = (l.get( i ));
            boolean check = m.getId().compareTo( obj.getId()  )==0;
            if(check){
                l.remove( i );
            }
        }
        return  l;
    }

}
