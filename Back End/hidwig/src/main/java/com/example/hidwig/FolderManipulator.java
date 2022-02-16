package com.example.hidwig;

import jsonapp.FileJson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FolderManipulator {
    public void createAccounts()  {
        this.path = "./accounts";
        File file = new File( path );
        try {
            if(!file.exists()) {
                file.mkdir();
            }
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }
    private String path;
    FileJson json = new FileJson();
    public File createFolder(String id,String name) throws IOException {
        createAccounts();
        createUserFolder(id);
        this.path = "./accounts/"+id+"/"+name;
      File file = new File( this.path );
      try {
            if(!file.exists()) {
                file.mkdir();
            }
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
      //creates extra folder
        if(!name.equals("inbox") && !name.equals("sent") && !name.equals("trash") && !name.equals("draft"))
            addToExtra( id,name );
      return file;
    }
    public void createUserFolder(String id) throws IOException {
        this.path = "./accounts/"+id;
        File file = new File( path );
        try {
            if(!file.exists()) {
                file.mkdir();
            }
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }
    public File renameFolder(String id,String oldName,String newName) throws IOException {
        File sourceFile = new File("./accounts/"+id+"/"+oldName);
        File destFile = new File("./accounts/"+id+"/"+newName);

        if (sourceFile.renameTo(destFile)) {
            System.out.println("Directory renamed successfully");
        } else {
            System.out.println("Failed to rename directory");
        }
        renameExtra( id,oldName,newName );
        return destFile;
    }
    public void deleteFolder(String id,String oldName) throws IOException {
        String path = "./accounts/" + id + "/" + oldName;
        File file = new File( path );
        if(file.exists()){
            FileUtils.deleteDirectory( file );
            deleteExtra( id,oldName );
        }
    }
    public void addToExtra(String id, String FolderName) throws IOException {
        json.writeJson( FolderName ,"./accounts/"+id +"/extrafolders.json" );
    }
    public void renameExtra(String id, String FolderName,String newName) throws IOException {
        List<String> list = json.readJson( "./accounts/"+id +"/extrafolders.json" );
        int n = list.indexOf(FolderName);
        list.set(n,newName);
        //list.remove( FolderName );
        json.overwriteJson( list, "./accounts/"+id +"/extrafolders.json");
        //addToExtra( id,newName );
    }
    public void deleteExtra(String id, String FolderName) throws IOException {
        List list = json.readJson( "./accounts/"+id +"/extrafolders.json" );
        list.remove( FolderName );
        json.overwriteJson( list, "./accounts/"+id +"/extrafolders.json");
    }
    public List readExtra(String id) throws IOException {
      return json.readJson("./accounts/"+id +"/extrafolders.json");
    }

}
