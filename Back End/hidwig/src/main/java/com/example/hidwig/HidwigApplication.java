package com.example.hidwig;

import jsonapp.IdJSon;
import jsonapp.UserJson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class HidwigApplication {

    public static void main(String[] args) throws IOException, ParseException {
     /*   SignUp su = new SignUp();
        IdJSon l = new IdJSon();
     /*   User u=new User("Shit");
      //  UserJson j= new UserJson();
        u.setFirstName("Sam");
        u.setLastName("Mlek");
        u.setPass("adadasdadas");
        //System.out.println(u.getId());*/
       // l.writeJson(u,"./i.json");
      /*  User u=new User("Shit");
        UserJson j= new UserJson();
        u.setFirstName("Sam");
        u.setLastName("Mlek");
        u.setPass("adadasdadas");

        //su.createAccounts();
        //su.createFolders(u.getId());
         su.addToIndex(u);*/
       /* User n=new User("Farahg");
        n.setFirstName("Farah");
        n.setLastName("Mourad");
        n.setPass("adadasdadas");
        //System.out.println(j.readJson("./accounts/index.json").get(0).getFirstName());
        Facade f = new Facade();
        System.out.println(f.signUp(n));*/
       //Mail m = new Mail("1","farahmourad@hedwig.com","Ehhhhhhh","hehe","zeftaaaaaa","hehe","1");
      /*  Facade f = new Facade();
        f.newMassage(m,"2");
        System.out.println(((Mail)((f.openFolder("inbox","1")).get(0))).getReceiver());*/
        /*String Date= "2020-10-25";
        LocalDate dateBefore = LocalDate.parse(Date);
        LocalDate dateAfter = LocalDate.now();
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        System.out.println(noOfDaysBetween);*/
       /* MailFiles mai = new MailFiles();
        mai.deleteMail("zz","inbox","1");*/
       /*Facade f = new Facade();
        List<Mail> list = f.filter("1","sent","Backend","Sender");
        for (Mail m :list) {
            System.out.println(m.getSender());
        }
*/
       // QSort.setTypeOfSort("Sender");
       // QSort.iterativeQsort()

      SpringApplication.run(HidwigApplication.class, args);
    }
}
