package com.example.hidwig;

import jsonapp.UserJson;

import java.io.IOException;
import java.util.List;

public class SignInProxy implements ISignIn{
    private SignIn signin = new SignIn();
    @Override
    public String allow(String mail,String pass) throws IOException {
        String v = verify( mail,pass );
        if(v != "-1" && v != "0"){
           return signin.action(v);
        }
        else{
            return  v;
        }
    }
     public String verify(String mail,String pass) throws IOException {
         UserJson json = new UserJson();
         List list = json.readJson( "./accounts/index.json" );
         testSearch n = new testSearch();
         list = n.search(list,"Mail",mail);
         if(list != null && !list.isEmpty() ){
             User uSer =(User) list.get(0);
             if(uSer == null){
                 //wrong mail
                 return -1+"";
             }
             else if(uSer.getPass().compareTo(pass) !=0 ){
                 //wrongPassword
                 return 0+"";
             }
             else{
                 //has access
                 return uSer.getId();
             }
         }
         else{
             //mail not found
             return -1+"";
         }

    }

}
