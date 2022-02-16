package com.example.hidwig;

import java.util.ArrayList;
import java.util.List;

public class testSearch {
    public List<User> search(List<User> list, String typeofSearch, String id){
        List<User> l = new ArrayList<>();
        if(typeofSearch.compareTo("Mail")==0){
            for (User m:list) {
                if(m.getMail().compareTo(id)==0){
                    l.add(m);
                }
            }
        }
        if(typeofSearch.compareTo("Password")==0){
            for (User m:list) {
                if(m.getPass().compareTo(id)==0){
                    l.add(m);
                }
            }
        }
        if(typeofSearch.compareTo("ID")==0){
            for (User m:list) {
                if(m.getId().compareTo(id)==0){
                    l.add(m);
                }
            }
        }
        return l;
    }
    public Mail search(List<Mail> list,String date ){

        for (Mail m:list) {
            if(m.getDates().compareTo(date) == 0){
                return m;
            }
        }
        return null;
    }

}
