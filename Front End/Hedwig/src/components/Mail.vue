<template onload="openbf()">
    <form>
    <div id="all">
      <div style="float:left">
      <div style="display:inline-block">
      <img src="logo1.png" @click="op('logo1.png')" height="120" width="130" id="logo" style="margin: 0px 0px;display:inline-block">
      <input type="button" class="button" @click="shownew(false,'all');shownew(true,'newf');" value="Create New Folder" style="height:30px;width:130px
      ;font-size:14px;display:inline-block;border-radius:5px;font-weight:400">
      </div>
      <br>
      <br>
      
      <input type="button" class="button" @click ="shownew(false,'all');shownew(true,'new');" value="New Message">
      <br>
      <br>
      <div id="buttons" style="overflow-y:scroll;height:483px;width:269px">
      <input type="button" class="button1" id="inbox" @click="check('inbox')" value="Inbox" >
      <br>
      <input type="button" class="button2" id="sent" @click="check('sent')" value="Sent">
      <br>
      <input type="button" class="button2" id="draft" @click="check('draft')" value="Drafts">
      <br>
      <input type="button" class="button2" id="trash" @click="check('trash')" value="Trash">
      <br>
      <div id="bts"></div>
      <!--<input type="button" class="button2" id="contact" @click="check('contact')" value="Contacts">
      <br>-->
      </div>
      </div>
      <div style="position:absolute;">
      <div style="background-color:rgb(39, 39, 39);border-radius:5px;margin: 10px 270px;position:absolute;height:710px;width:1050px;">
        <input type="text" class="search" id="search" style="position:absolue;margin: 20px 20px;width:500px;height:40px" placeholder="Search">
        <img src="search.png" width="30px" height="30px" style="margin-top:5px;cursor:pointer;display:inline-block" @click="search()">
        <img src="filter.png" width="20px" height="20px" style="margin-left:10px;cursor:pointer;display:inline-block" @click="shownew('both','filter')">
        <img src="sort.png" width="20px" height="20px" style="margin-left:10px;cursor:pointer;display:inline-block" @click="shownew('both','sort')">
        <div class="search" id="filter" style="display:inline-block;position:absolute;margin:20px 20px;width:320px;height:75px;padding-top:20px;visibility:hidden">
          <div style="float:left">
          <input type="radio" id="sr" name="filter" value="sender" >
          <label for="sr">Sender</label><br>
          <input type="radio" id="st" name="filter" value="subject" >
          <label for="st">Subject</label><br>
          </div>
          <div style="float:right; margin-right:15px">
            <input type="radio" id="or" name="filter" value="or">
            <label for="or">Sender or Subject</label>
            <br>
            <input type="radio" id="and" name="filter" value="and">
            <label for="and">Sender and Subject</label>
          </div>
          
        </div>
        <div class="search" id="sort" style="display:inline-block;position:absolute;margin:20px 20px;width:320px;height:75px;padding-top:20px;visibility:hidden">
          <div style="float:left">
          <input type="radio" id="datte" name="sort" value="date" @change="sort('Date')" checked>
          <label for="sr">Date</label><br>
          <input type="radio" id="senderr" name="sort" value="sender" @change="sort('Sender')">
          <label for="sr">Sender</label><br>
          <input type="radio" id="subjectt" name="sort" value="subject" @change="sort('Subject')">
          <label for="st">Subject</label><br>
          </div>
          <div style="float:right; margin-right:15px">
            <input type="radio" id="impo" name="sort" value="impo" @change="sort('Priority')">
            <label for="sr">Priority</label><br>
            <input type="radio" id="rec" name="sort" value="rec" @change="sort('Receiver')">
            <label for="or">Recievers</label>
            <br>
            <input type="radio" id="boddy" name="sort" value="boddy" @change="sort('Body')">
            <label for="and">Body</label>
          </div>
          
          
        </div>
        <img src="refresh.png" title="Refresh Page" @click="ref()" width="25px" height="25px" style="float:right;margin-top:10px;margin-right:10px;cursor:pointer;">
        <div id="mailss" class="search" style="margin-left:20px;width:1000px;height:580px;overflow-y:scroll;overflow-x:hidden;">
         
        </div>
          
          
          
          
          
        </div>
        </div>
        </div>


        <div id="Cts" style="position:absolute;margin:0px 0px;visibility:hidden;">
      <div style="background-color:rgb(39, 39, 39);border-radius:5px;margin: 10px 270px;position:absolute;height:710px;width:1050px;">
        <input type="text" class="search" id="Csearch" style="position:absolue;margin: 20px 20px;width:500px;height:40px" placeholder="Search">
        <img src="search.png" width="30px" height="30px" style="margin-top:5px;cursor:pointer;display:inline-block" @click="search()">
        <img src="sort.png" width="20px" height="20px" style="margin-left:10px;cursor:pointer;display:inline-block" @click="shownew('both','sort')">
        
        <div class="search" id="Csort" style="display:inline-block;position:absolute;margin:20px 20px;width:320px;height:75px;padding-top:20px;visibility:hidden">
          <div style="float:left">
          <input type="radio" id="Cname" name="sort" value="date" @change="sort('Date')" checked>
          <label for="sr">Name</label><br>
          <input type="radio" id="Cmail" name="sort" value="sender" @change="sort('Sender')">
          <label for="sr">Mail</label><br>
 
          
          </div>
        </div>
        <img src="refresh.png" title="Refresh Page" @click="ref()" width="25px" height="25px" style="float:right;margin-top:10px;margin-right:10px;cursor:pointer;">
        <div id="Cmailss" class="search" style="margin-left:20px;width:1000px;height:580px;overflow-y:scroll;overflow-x:hidden;">
         
            
          
          
      
      
        </div>
      </div>
        </div>
      
      <div id="new">
            <input type="button" id="bor" class="bor" value="New Message" style="cursor:pointer" @click="send('d')" title="Collapse Window">
            <br>
            <input type="text" id="To" class="new" placeholder="Receiver1,Receiver2,etc..">
            <br>
            <input type="text" id="Subject" class="new" placeholder="Subject">
            <br>
            <div>
            <textarea type="text" id="mail" class="new" placeholder="Mail content"></textarea>
            </div>
            <div id="att">
            </div>
            <input type="button" value="Send" class="send" @click="send('s')" title="Send">
            <!--<div class="image-upload" >
            <label for="file-input">
                <img src="at.png" height="23px" width="23px" style="cursor:pointer;float:right;margin-right:10px;margin-top: 6px;" title="Attach files">
            </label>-->
            <img src="star.png" id="star" @click="star(getE('star'),'star.png','starr.png');strd();" style=" float:right;margin:5px 10px;width:25px;height:25px;cursor:pointer" title="Priority">
            <input id="file-input" type="file" style="visibility:hidden;cursor:none" @change="processSelectedFiles()"/>
            
        
      
     </div>
     <div id="vMail" class="newf" style="visibility:hidden;width: 700px;
  height: 430px;position:absolute;margin: 100px 400px;">
            <input type="button" id="bor" class="bor" value="Mail" style="cursor:pointer" @click="shownew(false,'vMail')" title="Collapse Window">
            <br>
            <input type="text" id="vSender" title="Sender" class="new" readonly>
            <br>
            <input type="text" id="vReceiver" title="Receiver" class="new" readonly>
            <br>
            <input type="text" id="vSubject" title="Subject" class="new" readonly>
            <br>
            <div>
            <textarea type="text" id="vBody" title="Body" style="height:220px;padding-top;1px" class="new" readonly></textarea>
            </div>
            <div id="att">
            </div>
            <img src="star.png" id="vStar" style=" float:right;margin:5px 10px;width:25px;height:25px;" title="Priority">
            
     </div>
     <div id="newf" class="newf" style="visibility:hidden">
            <input type="button" id="NewFolder" class="bor" value="New Folder" style="cursor:pointer;width:300px" @click="shownew(false,'newf');empty('Folder');">
            <br>
            <input type="text" id="Folder" class="new"  style="width:293px" placeholder="Folder Name">
            <br>
            <input type="button" value="Create" id="create" class="send" @click="createF()">
     </div>
     <div id="renamef" class="newf" style="visibility:hidden">
            <input type="button" id="RenameFolder" class="bor" value="Rename Folder" style="cursor:pointer;width:300px" @click="shownew(false,'renamef');
            empty('RenFolder');">
            <br>
            <input type="text" id="RenFolder" class="new"  style="width:293px" placeholder="Folder Name">
            <br>
            <input type="button" value="Rename" id="rename" style="width:60px" class="send" @click="renamef()">
     </div>
     <div id="moveMail" class="newf" style="margin:100px 600px;visibility:hidden;height:300px">
            <input type="button" id="MoveFolder" class="bor" value="Destination Folder" style="cursor:pointer;width:300px" @click="shownew(false,'moveMail');
            ">
            <div id="fldrs" style="overflow-y:scroll;height:235px"></div>
            <!--<input type="text" id="MovFolder" class="new"  style="width:293px" placeholder="Destination Folder">-->
            <!--<input type="button" value="Move" id="move" style="width:60px" class="send" @click="moveFolder()">-->
     </div>
     <div class="dropdown" style="margin:30px 1080px;position:absolute">
  <button class="dropbtn">Account</button>
  <div class="dropdown-content">
    <p style="cursor:pointer;" @click="Info()">View Account</p>
    <p @click="signOut()">Sign Out</p>
  </div>
  
</div>
  
    <form action="/action_page.php">
</form>

    </form>
    
    
    
</template>
<script type='text/javascript'>
  import Vue from 'vue';
  import axios from 'axios'
  import VueAxios from 'vue-axios'
//import { delete } from 'vue/types/umd';
  //import SignUp from '@/components/SignUp.vue'
//import { component } from 'vue/types/umd';
  //import Store from '../store'
 // this.sendd;
  Vue.use(VueAxios,axios)
/* window.onload = function() {
  //openbf(this.f,this.$route.params.id);
  console.log();
  console.log(this.$route.params.id);
};*/
  //window.onload=this.beforeMount();
  export default {
    //components: {SignUp,},
    data()
    {
      //component {SignUp}
      return {
        //SignUp,
        idn : 1,
        idnf :0,
        rf:'',
        f:'inbox',
        fid:'inbox',
        editedMails:[],
        mvd:'',
        userId:this.$route.params.id,
        isStrd:2,
        sortt:"",
        
      }
    },
    beforeMount(){
    this.openbf()
 },
methods: {
  displayConts()
  {

    if(document.getElementById("Cts").style.visibility=="visible")
      document.getElementById("Cts").style.visibility="hidden";
    else
      document.getElementById("Cts").style.visibility="visible";
    
  },
  getE(str)
  {
    return document.getElementById(str);
  },
  strd()
  {
    var x=this.isStrd;
    if(x==2)
      this.isStrd=1;
    else //x==true
      this.isStrd=2;
  },
  ref()
  {
    location.reload();
  },
  signOut()
  {
      this.$router.push({name: 'SignIn'});
  },
  Info()
  {
    //var r=2;
    var r=this.$route.params.id;
    //this.$router.pop({name: 'mail',params: {id:r}});
    this.$router.push({name: 'account',params:{id:r}});
  },
  sort(str)
  {
    console.log(str);
    this.sortt=str;
    const self=this;
    if(document.getElementById("mailss")!=null)
      document.getElementById("mailss").innerHTML='';
    axios.get("http://localhost:8081/Api/sort",{
        params :{
                    id:self.$route.params.id,
                    folderName: self.f,
                    type:str
                    
                }
        
      }).then(response => {

                response;
                console.log(response.data);
                for(var j=0;j<response.data.length;j++)
                {
                  self.displayMail(response.data[j].sender,response.data[j].subject,response.data[j].dates);
                }
                //self.openbf();
                
                console.log(self.idnf);
                }) .catch(error => alert(error))
  },
  search()
  {
    var t='0';
    const self=this;
    var w=document.getElementById("search").value;
    if(document.getElementById("mailss")!=null)
      document.getElementById("mailss").innerHTML='';
    if(document.getElementById("sr").checked)
    {t="Sender";}
    else if(document.getElementById("st").checked)
    {t="Subject";}
    else if(document.getElementById("or").checked)
    {t="Any";}
    else if(document.getElementById("and").checked)
    {t="both";}
    console.log(t);
  if(t=='0')
    {axios.get("http://localhost:8081/Api/searchmail",{
        params :{
                    folderName: self.f,
                    id:self.$route.params.id,
                    word:w
                    
                }
        
      }).then(response => {

                response;
                console.log(response.data);

                for(var j=0;j<response.data.length;j++)
                {
                  self.displayMail(response.data[j].sender,response.data[j].subject,response.data[j].dates);
                }
                self.loadf();
                
                console.log(self.idnf);
                }) .catch(error => alert(error))}
  else
    { console.log(self.f);
                console.log(self.$route.params.id);
                console.log(w);
                console.log(t);
      axios.get("http://localhost:8081/Api/filter",{
        params :{
                    folderName: self.f,
                    id:self.$route.params.id,
                    word:w,
                    choice:t,
                    
                }
        
      }).then(response => {

                response;
                
                

                for(var j=0;j<response.data.length;j++)
                {
                  self.displayMail(response.data[j].sender,response.data[j].subject,response.data[j].dates);
                }
                self.loadf();
                
                console.log(self.idnf);
                }) .catch(error => alert(error))}
  },
  nsort()
  {
    document.getElementById('datte').checked=true;
    document.getElementById("senderr").checked=false;
    document.getElementById("subjectt").checked=false;
    document.getElementById("impo").checked=false;
    document.getElementById("rec").checked=false;
    document.getElementById("boddy").checked=false;
  },
  openbf()
  {
    if(document.getElementById("mailss")!=null)
      document.getElementById("mailss").innerHTML='';
    const self = this;
    axios.get("http://localhost:8081/Api/open",{
        params :{
                    folderName: self.f,
                    id:self.$route.params.id,
                    
                }
        
      }).then(response => {

                response;
                //console.log(response.data[0].sender);
                for(var j=0;j<response.data.length;j++)
                {
                  self.displayMail(response.data[j].sender,response.data[j].subject,response.data[j].dates);
                }
                self.loadf();
                
                console.log(self.idnf);
                }) .catch(error => alert(error))
  },
  moveFolder(x)
  {
      //var x=document.getElementById("MovFolder").value;
      //document.getElementById("MovFolder").value=""
      document.getElementById("moveMail").style.visibility='hidden';
      var y=this.f;
      //console.log(x);
      //document.getElementById(this.rf).value=x;
      //this.check(this.rf);
      const self=this;
      console.log(x);
      console.log(y);
      console.log(self.$route.params.id);
      console.log(self.mvd);
      axios.get("http://localhost:8081/Api/movemail",{
          params :{
                      newFolder:x ,
                      oldFolder:y,
                      id:self.$route.params.id,
                      date:self.mvd,
                  }
          
        }).then(response => {response;self.openbf();this.rf='';}).catch(error => alert(error))
      //x;y;
      
  },
      viewmail(dt)
      {
        const self=this;
        axios.get("http://localhost:8081/Api/view",{
          params :{
                      date:dt ,
                      id:self.$route.params.id,
                      folderName:self.f,
                  }
          
        }).then(response =>
         {
           document.getElementById("vSender").setAttribute("value","Sender: "+response.data.sender);
           document.getElementById("vReceiver").setAttribute("value","Receiver: "+response.data.receiver);
           document.getElementById("vSubject").setAttribute("value","Subject: "+response.data.subject);
           document.getElementById("vBody").value=response.data.content;
           console.log(response.data.key);
           if(response.data.key=='1')
              document.getElementById("vStar").src='starr.png';
           else
              document.getElementById("vStar").src='star.png';
          document.getElementById("vMail").style="visibility:visible;width: 700px;height: 430px;position:absolute;margin: 100px 400px;"
           }).catch(error => alert(error))
      },
     /* bulk(str)
      {
        var j;
        const self=this;
        if(str=='m')
          {for(j=this.editedMails.length-1;j>=0;j--)
            {
              this.mvd=this.editedMails[j];
              this.creatm();
              this.editedMails.pop();
            }
          }
        else
        {
          for(j=this.editedMails.length-1;j>=0;j--)
          {var dd=this.editedMails[j];
          axios.get("http://localhost:8081/Api/delete",{
          params :{
                    date: dd,
                    id: self.$route.params.id,
                    folderName:self.f,
                }
      }).then(response => {console.log(dd);
      if(j==0)
        {self.sort(self.sortt);}
      self.editedMails.pop();response}).catch(error => alert(error))}
        }
        

      }*/
      displayMail(sr,sj,dt)
  {
      var element = document.getElementById("mailss");
      var space = document.createElement("div");
      var mail = document.createElement("div");
      var dms = document.createElement("div");
      var d = document.createElement("img");
      var m = document.createElement("img");
      var s = document.createElement("img");
      var r = document.createElement("img");
      var date = document.createElement("p");
      var sender = document.createElement("p");
      var srdiv = document.createElement("div");
      var sjdiv = document.createElement("div");
      var subject = document.createElement("p");
      var lb = document.createElement("br");
      const self= this;
      space.style="height:10px";
      mail.className="button3";
      dms.style="float:right;overflow:hidden;height: 35px"
      d.src="delete.png";
      d.onclick=function(){
        /*space.parentNode.removeChild(space);
        mail.parentNode.removeChild(mail);*/
        axios.get("http://localhost:8081/Api/delete",{
        params :{
                    date: dt,
                    id: self.$route.params.id,
                    folderName:self.f,
                }
      }).then(response => {self.openbf();response}).catch(error => alert(error))
        
      }
      d.style="float:right;margin:10px 10px;width:25px;height:25px";
      d.title="Delete Mail";
      
      m.src="move.png";
      m.onclick=function(){
        self.mvd=dt;
        document.getElementById("moveMail").style.visibility='visible';
        self.createm();
        
      }
      r.style="float:right;margin:7px 10px;width:23px;height:23px";
      r.title="View Mail";
      r.src="read.png";
      r.onclick=function(){
        //self.mvd=dt;
        self.viewmail(dt);

        //self.createm();
        
      }
      m.style="float:right;margin:7px 0px;width:30px;height:30px";
      m.title="Move Mail";
      s.src="bselect.png";
      s.onclick=function(){
        self.star(s,'bselect.png','aselect.png');
        self.editedMails.push(dt);
        console.log(self.editedMails[0]);
        

      }
      s.style="float:left;margin:5px 20px;width:30px;height:30px";
      s.title="Select";
      date.style="float:right;font-size:15px;margin-right:10px";
      srdiv.style="height:70px;width:200px;overflow:hidden;display:inline-block;margin:0px 20px";
      sjdiv.style="height:70px;width:400px;overflow:hidden;display:inline-block;";
      sender.style="display:inline;font-size:25px";
      subject.style="display:inline;font-size:25px";
      date.innerHTML=dt.slice(0,18);
      sender.innerHTML=sr;
      subject.innerHTML=sj;
      element.insertBefore(space,null);
      dms.insertBefore(d,null);
      dms.insertBefore(m,null);
      dms.insertBefore(r,null);
      mail.insertBefore(lb,null);
      mail.insertBefore(dms,null);
      mail.insertBefore(date,null);
      mail.insertBefore(lb,null);
      srdiv.insertBefore(sender,null);
      sjdiv.insertBefore(subject,null);
      //mail.insertBefore(s,null);
      mail.insertBefore(srdiv,null);
      mail.insertBefore(sjdiv,null);
      element.insertBefore(mail,null);
    
  },
  op(src)
  {
    var a='http://localhost:8080/'+src;
    console.log(a);
    window.open(a);
  },
  de(id)
  {
    document.getElementById(id).parentNode.removeChild(document.getElementById(id));
  },
  star(el,s1,s2)
  {
    if(el.getAttribute("src")==s2)
      {el.src=s1;}
    else
      {el.src=s2;}

  },
    check(i)
    {
        this.nsort();
        document.getElementById("inbox").setAttribute("class","button2");
        document.getElementById("sent").setAttribute("class","button2");
        document.getElementById("draft").setAttribute("class","button2");
        document.getElementById("trash").setAttribute("class","button2");
        //document.getElementById("contact").setAttribute("class","button2");
        if(this.idnf>0)
        {
          var sd;
          for(var j=0;j<this.idnf;j++)
            {sd='f'+j;
            console.log(sd);
            document.getElementById(sd).className='button2';}
        }
        this.fid=i;
        //document.getElementById(i).className='button1';
        var q=document.getElementById(i).getAttribute("value");
        if(i=='inbox' || i=='sent' || i=='draft' || i=='trash')
          this.f=i;
        else
          this.f=q;
        this.openbf();
        console.log(this.f);
        
    },
  empty(id)
  {
    document.getElementById(id).value = "";
  },
  shownew(b,id)
  {
    if(id=='all')
    {this.shownew(b,'renamef');
    this.shownew(b,'new');
    this.shownew(b,'newf');
    this.shownew(b,'moveMail');
    }
    else
    {if(b==true)
      document.getElementById(id).style.visibility="visible";
    else if (b==false)
      document.getElementById(id).style.visibility="hidden";
    else
      {
        if(document.getElementById(id).style.visibility=="hidden")
          document.getElementById(id).style.visibility="visible";
        else
          document.getElementById(id).style.visibility="hidden";
          }
    }
  },
  send(a)
  {
    
    if(document.getElementById("To").value!="")
    {
      //console.log(document.getElementById("Subject").value);
      
      const self=this;
      var today = new Date();
      var dd = String(today.getDate()).padStart(2, '0');
      var mm = String(today.getMonth() + 1).padStart(2, '0');
      var yyyy = today.getFullYear();
      var ss= String(today.getSeconds()).padStart(2, '0');
      var hh= String(today.getHours()).padStart(2, '0');
      var m= String(today.getMinutes()).padStart(2, '0');
      today = yyyy + '-' + mm + '-' + dd + " " + hh + ":" + m + ":"+ ss;
      console.log(today);
      var n;
      var v;
      n=document.getElementById("Subject").value;
      v=document.getElementById("mail").value;
      var q= (document.getElementById("To").value).toLowerCase();
      if(n==null)
        n='';
      if(v==null)
        n='';
      console.log(n);
      console.log(v);
      if(a=='s')
    {axios.post("http://localhost:8081/Api/send",{
        sender: '' ,
        receiver:  q,
        subject: n,
        dates:today,
        attachment: '' ,
        content: v,
        key: self.isStrd,
        id:self.$route.params.id,
        })}
        else
        {axios.post("http://localhost:8081/Api/draft",{
        sender: '' ,
        receiver: q,
        subject: n,
        dates:today,
        attachment: '' ,
        content: v ,
        key: self.isStrd,
        id:self.$route.params.id,
        })}
    document.getElementById("To").value="";
    document.getElementById("Subject").value="";
    document.getElementById("mail").value="";
    document.getElementById("att").innerHTML = "";
    this.isStrd=2;
    document.getElementById('star').src='star.png';
    while(this.idn>1)
    {
      this.idn--;
    }
    this.shownew(false,"new");
    this.sort(this.sortt);
    } else
      {
        if(a=='s')
          alert("You have to enter at least a recepient");
        else
        {this.shownew(false,"new");
        this.isStrd=2;
        document.getElementById('star').src='star.png';
        this.sort(this.sortt);}
      }
  },
    renamef()
    {
      if(document.getElementById("RenFolder").value!="")
    {
      var x=document.getElementById("RenFolder").value;
      document.getElementById("RenFolder").value=""
      document.getElementById("renamef").style.visibility='hidden';
      var y=document.getElementById(this.rf).innerHTML;
      //document.getElementById(this.rf).value=x;
      //this.check(this.rf);
      const self=this;
      axios.get("http://localhost:8081/Api/renamefolder",{
          params :{
                      id: self.$route.params.id,
                      oldName:y,
                      newName:x,
                  }
          
        }).then(response => {response;self.loadf();this.rf='';}).catch(error => alert(error))
      
    }
    },
    loadm()
    {
        axios.get("http://localhost:8081/Api/loadfolders",{
        params :{
                    id: self.$route.params.id,
                }
        
      }).then(response=>{
        for(var j=0;j<response.data.length;j++)
        {
          console.log(response.data);
          self.creatm(response.data[j]);
        }
        console.log(self.fid);
        document.getElementById(self.fid).className='button1';
      })
      .catch(error => alert(error))
    },
    createm()
    {
      const self = this;
      axios.get("http://localhost:8081/Api/loadfolders",{
        params :{
                    id: self.$route.params.id,
                }
        
      }).then(response=>{
        for(var j=0;j<response.data.length;j++)
        {
          self.createmm(response.data[j]);
        }
      })
      .catch(error => alert(error))
      


    },
    createmm(x)
    {
      const self = this;
        var para = document.createElement("button");
        var linebreak = document.createElement("br");
        var element=document.getElementById("fldrs");
        para.innerHTML=x;
        para.value=x;
        para.onclick=function(){
          console.log(x);
          self.moveFolder(x);
          element.innerHTML='';
        }
       
        para.className="button";
        para.style="border-bottom:1px solid black;width:270px;margin-left:10px"
        element.insertBefore(linebreak,null);
        element.insertBefore(para,null);
    },
    loadf()
    {
      document.getElementById("bts").innerHTML="";
      this.idnf=0;
      const self = this;
      axios.get("http://localhost:8081/Api/loadfolders",{
        params :{
                    id: self.$route.params.id,
                }
        
      }).then(response=>{
        for(var j=0;j<response.data.length;j++)
        {
          console.log(response.data[j]+"2");
          self.createFolder(response.data[j]);
        }
        console.log(self.fid);
        document.getElementById(self.fid).className='button1';
      })
      .catch(error => alert(error))
    },
  createF()
  {
    if(document.getElementById("Folder").value!="")
    {
      const self=this;
      var x=(document.getElementById("Folder").value).trim();
      var t=true;
      var e;
    if(x.toLowerCase()=='inbox'.toLowerCase() || x.toLowerCase()=='trash'.toLowerCase() || x.toLowerCase()=='draft'.toLowerCase() || x.toLowerCase()=='drafts'.toLowerCase() || x.toLowerCase()=='sent'.toLowerCase())
      {
        
        t=false;
      }
      if(t==true)
        {axios.get("http://localhost:8081/Api/loadfolders",{
          params :{
                      id: self.$route.params.id,
                  }
          
        }).then(response=>{
          for(var j=0;j<response.data.length;j++)
          {
            e=response.data[j].toLowerCase();
            console.log(e);
            if(x.toLowerCase()==e)
              {
                t=false;
                break;}
          }
          console.log(t);
          if(t)
        {
      axios.get("http://localhost:8081/Api/createfolder",{
        params :{
                    id: self.$route.params.id,
                    folderName:x,
                }
        
      }).then(response => {response;self.loadf();}).catch(error => alert(error))}
      else
        alert("Name already exists");
        })
        .catch(error => alert(error))}
        else{
      console.log(t);
      if(t)
        {
      axios.get("http://localhost:8081/Api/createfolder",{
        params :{
                    id: self.$route.params.id,
                    folderName:x,
                }
        
      }).then(response => {response;self.loadf();}).catch(error => alert(error))}
      else
        alert("Name already exists");
        }
    }
  },
  delFol(x)
  {
    const self=this;
    console.log(x+"2");
    axios.get("http://localhost:8081/Api/deletefolder",{
        params :{
                    id: self.$route.params.id,
                    folderName:x,
                }
        
      }).then(response => {response;self.openbf();}).catch(error => alert(error))
  },
  createFolder(x)
  {
    const self=this;
    
    document.getElementById("Folder").value="";
      document.getElementById("newf").style.visibility="hidden";
      var para = document.createElement("button");
      var linebreak = document.createElement("br");
      var ren = document.createElement("img");
      var img = document.createElement("img");
      img.src="delete.png";
      img.style="width:28px;height:28px;cursor:pointer;margin-left:5px;float:left;margin-top:7px;display:inline-block"
      img.title="Delete";
      ren.src="edit.png";
      ren.style="width:31px;height:31px;cursor:pointer;margin-left:7px;float:left;margin-top:6px;display:inline-block"
      ren.title="Rename";
      ren.onclick=function(){
      self.rf=para.id;
      self.shownew(false,'all');
      self.shownew(true,'renamef');
        
      };
      img.onclick=function(){
        if(para.className=='button1')
          document.getElementById('inbox').className='button1';
        var sd;
        var nd;
        var str;
        var j=para.id;
        str=j.slice(1,j.length);
        str++;
        for(str;str<self.idnf;str++)
          {
            sd='f'+str;
            nd='f'+(str-1);
            document.getElementById(sd).id=nd;
          }
        if(para.className=='button1')
          {self.f='inbox';
          self.fid='inbox';}
        self.idnf--;
        console.log(self.idnf);
        console.log(x);
        self.delFol(x);
        

      }
      para.value = x;
      para.innerHTML=x;
      para.className="button2";
      para.style="width:180px;float:left;"
      para.id='f'+this.idnf;
      console.log(para.id);
      para.onclick= function(){
        self.check(para.id);
        }
      this.idnf++;
      console.log(this.idnf);
      var element = document.getElementById("bts");
      element.insertBefore(para,null);
      element.insertBefore(ren,null);
      element.insertBefore(img,null);
      element.insertBefore(linebreak,null);
  },
  /*lol()
  {
    var fullPath = document.getElementById('file-input').value;
    document.getElementById("d").setAttribute("value",fullPath);
  },*/
  
  processSelectedFiles() {
  var fullPath = document.getElementById('file-input').files[0];
  var fReader = new FileReader();
  fReader.readAsDataURL(fullPath);
  console.log(fReader);
  console.log(fullPath);
  var d=fullPath.name;
  if(d!='')
  {var para = document.createElement("button");
  var para2= document.createElement("button");
  para2.innerHTML="&#10005;";
  para.innerHTML = d;
  para.id='a'+this.idn;
  para2.id=this.idn;
  console.log(para.id);
  console.log(para2);
  const self=this;
  para.onclick= function(){
    
  }
  para2.onclick= function(){
    var sd;
        var nd;
        var str;
        var j=para.id;
        str=j.slice(1,j.length);
        str++;
        for(str;str<self.idn;str++)
          {
            sd='a'+str;
            nd='a'+(str-1);
            document.getElementById(sd).id=nd;
          }
    para.parentNode.removeChild(para);
    para2.parentNode.removeChild(para2);
    self.idn--;}
  this.idn++;
  para.style="font-family:inherit;background-color:#ffe713;margin-left:3px;display:inline-block;border-radius:3px;border:none;";
  para2.style="font-family:inherit;margin:0px 0px;display:inline-block;color:#ffe713;background-color:rgb(32, 32, 32);border:none;";
  var element = document.getElementById("att");
  var hahe = document.getElementById("mail");
  hahe;
  element.insertBefore(para,null);
  element.insertBefore(para2,null);}
  document.getElementById('file-input').value='';
},

  
  }
  }
</script>
<style>

form
{
    margin:0px 0px;
}

input[type='radio'] {
  -webkit-appearance:none;
  width:20px;
  height:20px;
  border:1px solid darkgray;
  border-radius:50%;
  outline:none;
  background-color: inherit;
}
input[type='radio']:before {
  content:'';
  display:block;
  width:50%;
  height:50%;
  margin: 25% auto;    
  border-radius:50%;    
}
input[type='radio']:checked:before {
  background:#ffe713;

}
.button{
                background-color: #ffe713;
                border: none;
                color:#0f0f0f;   
                font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                text-align: center;
                text-decoration: none;
                font-size: 18px;
                font-weight:500;
                width:150px;
                height:50px;
                border-radius: 50px;
                margin: 0px 0px;
                cursor: pointer;
                /*color: rgb(39, 39, 39);*/
            }
.button1{
  background-color: #ffe713;
                border: none;
                color:#0f0f0f;   
                font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                text-align: center;
                text-decoration: none;
                font-size: 18px;
                font-weight:500;
                width:250px;
                height:40px;
                border-top-right-radius: 50px;
                border-bottom-right-radius: 50px;
                border-bottom-color:solid #000000;
                border-right:none;
                border-left:none;
                border-top:none;
                display:inline-block;
                cursor: pointer;
}
.button2{
    background-color: #2c2c2c;
                
                color:#ffe713;   
                font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                text-align: center;
                text-decoration: none;
                font-size: 18px;
                font-weight:300;
                width:250px;
                height:40px;
                border-top-right-radius: 50px;
                border-bottom-right-radius: 50px;
                border-bottom-color:solid #000000;
                border-right:none;
                border-left:none;
                border-top:none;
                display:inline-block;
  white-space: nowrap;
    overflow-x: auto;
    overflow-y: hidden;
    cursor: pointer;
                
}
.button3
{
  background-color:rgb(39, 39, 39);border-radius:5px;border: none; color:rgb(112, 112, 112);
  width: 973px;height:100px;cursor: pointer;
}
button{
  cursor: pointer;
}
.dropbtn {
  background-color: #ffe713;
  color: black;
  padding: 16px;
  font-family: inherit;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content p {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content p:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #ffe713;}
</style>
  