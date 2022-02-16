package com.example.hidwig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Api")
@CrossOrigin
public class Controller {
    Facade f= new Facade();
    public Controller() throws IOException {
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody Map<String,Object> user) throws IOException {
        ObjectMapper m=new ObjectMapper();
        User user1 = m.convertValue(user,User.class);
        return f.signUp(user1);
    }
    @GetMapping ("/signin")
    public String signIn(String mail,String pass) throws IOException {
        return f.signIn(mail,pass);
    }
    @GetMapping("/open")
    public List openFolder(String folderName, String id) throws IOException {
       return  f.openFolder(folderName,id);
    }
    @PostMapping("/send")
    public void sendMessage(@RequestBody Map<String,Object> mail) throws IOException {
        ObjectMapper m=new ObjectMapper();
        Mail mail1 = m.convertValue(mail, Mail.class);
        f.newMassage(mail1);
    }
    @GetMapping("/delete")
    public void deleteMessage(String date,String id,String folderName) throws IOException {
        f.deleteMail(date,id, folderName);
    }
    @GetMapping("/createfolder")
    public void createFolder(String id,String folderName) throws IOException {
        f.createFolder(folderName,id);
    }
    @GetMapping("/loadfolders")
    public List loadFolders(String id) throws IOException {
        return f.returnExtra(id);
    }
    @GetMapping("/deletefolder")
    public void deleteFolders(String id,String folderName) throws IOException {
        //System.out.println(folderName+"2");
        f.deleteFolder(id,folderName);
    }
    @GetMapping("/renamefolder")
    public void renameFolders(String id, String oldName, String newName) throws IOException {
        f.renameFolder(id,oldName,newName);
    }
    @GetMapping("/movemail")
    public void moveMail(String newFolder, String oldFolder,String id, String date) throws IOException{
        f.moveMail(newFolder,oldFolder,id,date);
    }
    @PostMapping("/draft")
    public void draft(@RequestBody Map<String,Object> mail) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Mail m = objectMapper.convertValue(mail,Mail.class);
        f.massageNotSent(m,m.getId());
    }
    @GetMapping("/searchmail")
    public List search(String folderName, String id,String word ) throws IOException{
        return f.SearchBy(folderName,id,word);
    }
    @GetMapping("/filter")
    public List Filter(String id, String folderName,String word , String choice) throws IOException{
        return f.filter(id,folderName,word,choice);
    }
    @GetMapping("/sort")
    public List Sort(String id, String folderName,String type) throws IOException {
        return f.sort(id,folderName,type);
    }
    @GetMapping("/change")
    public void change(String firstName,String lastName, String password,String id) throws IOException {
        f.changeInfo(firstName,lastName,password,id);
        }
    @GetMapping("/info")
    public User info(String id) throws IOException {
        return f.searchUserById(id);
    }
    @GetMapping("/view")
    public  Mail view(String date, String id, String folderName) throws IOException {
        return f.view(date,folderName,id);
    }
}
