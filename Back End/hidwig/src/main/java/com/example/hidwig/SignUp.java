package com.example.hidwig;

import jsonapp.IdJSon;
import jsonapp.UserJson;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SignUp {
   private File index;
   private File sent;
   private File draft;
   private File trash;

    public String addToIndex(User user) throws IOException {
        FolderManipulator d = new FolderManipulator();
        d.createAccounts();
        UserJson json = new UserJson();
        IdJSon idJSon = new IdJSon();
        String id = "";
        List list = json.readJson( "./accounts/index.json" );
        if(list != null && !list.isEmpty()){
            testSearch n = new testSearch();
            List l = n.search(list,"Mail",user.getMail().toLowerCase());
            if(l == null || l.isEmpty()){
                id = idJSon.readJson("./accounts/ids.json");
                if(id =="0"){
                    id = "1";
                }
                createFolders(id);
                user.setId(id);
                json.writeJson( user ,"./accounts/index.json" );
                idJSon.writeJson(id,"./accounts/ids.json");
                return  id;
            }


        }
        else{
            user.setId("1");
            json.writeJson(user,"./accounts/index.json") ;
            // IdJSon idJSon = new IdJSon();

            idJSon.writeJson("1","./accounts/ids.json");

            createFolders("1");
            return "1";
        }
        return "0";
    }
    public void createFolders(String id) throws IOException {
        FolderManipulator folder = new FolderManipulator();
        index  = folder.createFolder( id, "inbox");
        sent = folder.createFolder( id, "sent");
        trash = folder.createFolder( id, "trash");
        draft = folder.createFolder( id, "draft");
    }
}
