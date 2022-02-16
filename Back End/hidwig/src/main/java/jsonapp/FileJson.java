package jsonapp;

import com.example.hidwig.Contacts;
import com.example.hidwig.Mail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileJson {
    ObjectMapper mapper = new ObjectMapper();
    public void writeJson(Object obj, String path) throws IOException {
        List list = readJson( path );
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
    public List readJson(String path) throws IOException {
        if(!(new File(path)).exists()){
            return new ArrayList<>();
        }
        else{
            List listuser = mapper.readValue(new File(path), new TypeReference<ArrayList>(){});
            return listuser;
        }
    }
    public List<Contacts> readCJson(String path) throws IOException {
        if(!(new File(path)).exists()){
            return new ArrayList<Contacts>();
        }
        else{
            List<Contacts> listuser = mapper.readValue(new File(path), new TypeReference<ArrayList<Contacts>>(){});
            return listuser;
        }
    }
}
