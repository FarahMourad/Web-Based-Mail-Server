package com.example.hidwig;

import jsonapp.MailJson;
import jsonapp.UserJson;

import java.io.IOException;
import java.util.List;

public class Facade {
    FolderManipulator folderManipulator = new FolderManipulator();
    MailFiles mailFiles = new MailFiles();
    MailJson mailJson = new MailJson();
    ICriteria criteriaSender = new CriteriaSender();
    ICriteria criteriaSubject = new CriteriaSubject();
    ICriteria criteriaOr = new OrCriteria( criteriaSender,criteriaSubject );
    ICriteria criteriaAnd = new AndCriteria( criteriaSender,criteriaSubject );
    UserJson userJson = new UserJson();
    public Facade() throws IOException {
    }
    //to sign in
    public String signIn(String mail, String pass) throws IOException {
        ISignIn sign = new SignInProxy();
        String id = sign.allow( mail,pass );
        openFolder( "inbox" ,id );
        return id;
    }
    //to sign up
    public String signUp(User user) throws IOException {
        SignUp signUp = new SignUp();
        return signUp.addToIndex( user );
    }
    //to click on a folder
    public List openFolder(String folderName,String id) throws IOException {
        List list ;// readList( folderName,id );
        if(folderName.equals("trash")){
            mailFiles.autoDelete( id );
        }
       list =  sort(id,folderName,"Date");
        return list;
    }
    //to write a new folder
    public void createFolder(String folder,String id) throws IOException {
        folderManipulator.createFolder(id,folder );
    }
    // while loading return created folders
    public List returnExtra(String id) throws IOException {
        return folderManipulator.readExtra(id);
    }
    // when renaming rename extraFolder
    public void renameFolder(String id, String oldName,String newName ) throws IOException {
        folderManipulator.renameFolder( id,oldName,newName );
    }
    // edit extraFolders after deleting
    public void deleteFolder(String id, String name) throws IOException {
        folderManipulator.deleteFolder(  id,name);
    }
    //send massage
    public void newMassage(Mail mail) throws IOException {
        mailFiles.sendMail( mail);
    }
    //move a massage from folder to another
    public void moveMail(String newFolder, String oldFolder,String id, String date) throws IOException {
        mailFiles.moveMail(newFolder,oldFolder,date,id);
    }
    //to delete a mail
    public void deleteMail(String date, String id, String folderName) throws IOException {
        mailFiles.deleteMail(date,folderName,id);
    }
    //to filter
    public List filter(String id, String currentFolder,String word,String choice) throws IOException {
       // List list = readList( currentFolder,id );
        List list = SearchBy(currentFolder,id,word);
        if(choice.compareTo("Sender")==0  ){
            list = criteriaSender.meetCriteria( list,word );
        }
        else if(choice.compareTo("Subject")==0){
            list = criteriaSubject.meetCriteria( list,word );
        }
        else if(choice.compareTo("Any") == 0){
            list = criteriaOr.meetCriteria( list,word );
        }
        else if(choice.compareTo("both") == 0){
            list = criteriaAnd.meetCriteria( list,word );
        }
        return list;
    }

    public void changeInfo(String firstName,String lastName, String password,String id) throws IOException {
       User user =  searchUserById( id );
       User temp = user;
       user.setPass( password );
        user.setFirstName( firstName );
        user.setLastName( lastName );
        user.setId(id);
        userJson.deleteUser(temp,"./accounts/index.json");
        userJson.writeJson(user,"./accounts/index.json");
    }
    public Mail view(String date,String Folder, String id) throws IOException {
        testSearch testSearch = new testSearch();
        return testSearch.search(mailJson.readJson("./accounts/"+id+"/"+Folder+"/mail.json" ),date);
    }
    public User searchUserById(String id) throws IOException {
        UserJson userjson = new UserJson();
        List list = userjson.readJson( "./accounts/index.json" );
        testSearch f = new testSearch(  );
        User user = (User) (f.search(list,"ID",id).get(0));
        return user;
    }
    public List sort(String id, String folderName ,String typeofSort ) throws IOException {
        List list = readList(folderName, id);
        if (typeofSort.equals("Priority")) {
            PriorityManipulator p = new PriorityManipulator();
          p.Queue(list);

        } else {
            Sorting sort = new Sorting();
            sort.sort(list, typeofSort);
        }
        return list;
    }
    public void massageNotSent(Mail mail, String id) throws IOException {
       User use =  searchUserById(id);
       mail.setSender(use.getMail());
        writeTo( mail,"draft",id );
       // mailJson.writeJson( mail,"./accounts/" + id + "/draft/mail.json" );
    }
    public List SearchBy(String folderName, String id, String word ) throws IOException {
        List list = readList( folderName,id );
        ICriteria criteriaSender = new CriteriaSender();
        ICriteria criteriaSubject = new CriteriaSubject();
        ICriteria criteriaAttachment = new CriteriaAttachment();
        ICriteria criteriaBody = new CriteriaBody();
        ICriteria criteriaImportance = new CriteriaImportance();
        ICriteria criteriaDate = new CriteriaDate();
        ICriteria criteriaReceiver = new CriteriaReceiver();
        ICriteria search = new SearchDif( criteriaAttachment,criteriaBody,criteriaDate,criteriaImportance,criteriaReceiver,criteriaSender,criteriaSubject );
       return  search.meetCriteria( list, word);
    }
    public List readList(String folderName, String id) throws IOException {
        List list = mailJson.readJson( "./accounts/" + id + "/" + folderName + "/mail.json" );
        return list;
    }
    public void writeTo(Mail mail,String folderName, String id) throws IOException {
        mailJson.writeJson( mail,"./accounts/" + id + "/"+folderName+"/mail.json" );
    }
}
