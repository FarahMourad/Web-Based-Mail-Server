<template onload="rld()">
    <form id="acc" >
        <div style="position:absolute">
      <br><br>
          <img src="logo1.png" height="160" width="180" id="logo" style="margin-left:640px">
          <h1 style="margin-left:550px">First Name</h1>
          <div class="ie" style="margin-left:550px">
            <input type="text" class="input" id="fn" value="" style="margin-left:0px;cursor:text">
            <div id="fst" @click="change()" style="color:#ffe713;text-decoration: underline;font-weight:light;cursor:pointer;display:inline-block">
              <img src="edit.png" width="20px" height="20px" style="display:inline-block;">
              <p style="display:inline-block;margin-left:4px">Change First Name</p>
            </div>
          </div>
          <h1 style="margin-left:550px">Last Name</h1>
          <div class="ie" style="margin-left:550px">
          <input type="text" class="input" id="ln" value="" style="margin-left:0px;cursor:text"> 
          <div @click="change()" style="color:#ffe713;text-decoration: underline;font-weight:light;cursor:pointer;display:inline-block">
          <img src="edit.png" width="20px" height="20px" style="display:inline-block;">
          <p style="display:inline-block;margin-left:4px">Change Last Name</p>
          </div>
          </div>
          <h1 style="margin-left:550px">E-mail address</h1>
          <div class="ie" style="margin-left:550px">
          <input type="text" class="input" id="ml" value="" style="margin-left:0px" readonly> <div></div>
          </div>
          <br>
          <h1 style="margin-left:550px">Password</h1>
          <div class="ie" style="margin-left:550px">
          <input type="password"  class="input" id="password" style="margin-left:0px;cursor:text" > 
          <img src="view1.png" @click="show" id="show" style="margin-left:0px;cursor:pointer">
          <div @click="change()" style="color:#ffe713;text-decoration: underline;font-weight:light;cursor:pointer;display:inline-block">
          <img src="edit.png" width="20px" height="20px" style="display:inline-block;">
          <p style="display:inline-block;margin-left:4px">Change Password</p>
          </div>
          </div> 
          </div>
          If data is not shown,kindly reload the page :)
          <div style="position:absolute">
              
              <div class="dropdown" style="margin:30px 1350px;position:absolute">
                
  <button class="dropbtn">Account</button>
  <div class="dropdown-content">
    <p @click="mail()">Mail</p>
    <p @click="signOut()">Sign Out</p>
  </div>
</div>
          </div>
          
    
    </form>
</template>

<script>

  import Vue from 'vue';
  import axios from 'axios'
  import VueAxios from 'vue-axios'
  Vue.use(VueAxios,axios)
  
 // document.getElementById("fn").setAttribute("value","Samer");
  export default {
    data()
    {
      return {
        fn:"",
        ln:"",
        ml:"",
        pass:"",
        id:this.$route.params.id,
      }
    },
methods: {
  rld()
  {
    location.reload();
  },
  mail()
  {
    var r = this.id;
    this.$router.push({name: 'mail',params:{id:r}});
  },
  signOut()
  {
    this.$router.push({name: 'SignIn'});
  },
  get()
  {
    console.log(this.$route.params.id);
    console.log(this.id);
  },
  change()
  {
    var f;var l;var p;
    const self=this;
    f=document.getElementById("fn").value;
    l=document.getElementById("ln").value;
    p=document.getElementById("password").value;
    console.log(f);
    console.log(l);
    console.log(p);
    console.log(self.id);
    axios.get("http://localhost:8081/Api/change",{
        params :{
                    firstName:f,
                    lastName:l,
                    password:p,
                    id:self.id,
                }
        
      }).then(response => {

                response;
                
                console.log(response.data);
                }) .catch(error => alert(error))
  },
  show()
  {
    if(document.getElementById("password").getAttribute("type")=="password")
    {
      document.getElementById("password").setAttribute("type","text");
    } else
    {
      document.getElementById("password").setAttribute("type","password");
    }
  }
  
  },
  beforeMount(){
    
    const self=this;
    
    console.log(document.getElementById("acc"));
    //location.reload();
    window.onload= function () {
      console.log(self.id);
      axios.get("http://localhost:8081/Api/info",{
        params :{
                    id:self.id,
                }
        
      }).then(response => {

                response;
                document.getElementById("fn").setAttribute("value",response.data.firstName);
                document.getElementById("ln").setAttribute("value",response.data.lastName);
                document.getElementById("ml").setAttribute("value",response.data.mail);
                document.getElementById("password").setAttribute("value",response.data.pass);
                console.log(response.data);
                }) .catch(error => alert(error))
  document.getElementById("fn").setAttribute("value","Haha");
    
}
 },
  }
</script>