package jsonapp;

import com.example.hidwig.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IdJSon {
    public IdJSon(){}
    public void writeJson(String use, String path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        if(use==null){
            mapper.writeValue(new File(path), "0");
        }
        else
        {
            mapper.writeValue(new File(path), use);
        }

    }
    public String readJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if(!(new File(path)).exists()){

           writeJson("0",path);
           return "0";
        }
        else{
            String id = mapper.readValue(new File(path), String.class);
            return (Integer.parseInt(id) +1)+"";
        }
    }
}
