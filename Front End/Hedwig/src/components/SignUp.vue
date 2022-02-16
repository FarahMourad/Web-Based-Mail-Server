<template>
    <form>
      <br><br>
          <img src="logo1.png" height="185" width="200" id="logo" style="margin-left:550px">
          <h1 style="margin-left:550px">First Name</h1>
          <div class="ie" style="margin-left:550px">
          <input class="input" placeholder="Sam" id="fn" style="margin-left:0px">
          </div>
          <h1 style="margin-left:550px">Last Name</h1>
          <div class="ie" style="margin-left:550px">
          <input class="input" placeholder="Mourad" id="ln" style="margin-left:0px">
          </div>
          <h1 style="margin-left:550px">E-mail address</h1>
          <div class="ie" style="margin-left:550px">
          <input class="input" placeholder="someone@hedwig.com" id="ml" style="margin-left:0px">
          </div>
          <br>
          <h1 style="margin-left:550px">Password</h1>
          <div class="ie" style="margin-left:550px">
          <input type="password" class="input" id="password"  style="margin-left:0px">
          <img src="view1.png" @click="show" id="show" style="margin-left:0px;cursor:pointer">
          </div>
          <div style="margin-left:550px">
          <br>
          Do you have an account?
          <router-link to="/">Sign in</router-link>.
          <br><br>
          <input type="button" class="button" @click ="signup()" style="margin-left:110px" value="Sign up">
          </div>
    
    </form>
</template>

<script>
  import Vue from 'vue';
  import axios from 'axios'
  import VueAxios from 'vue-axios'
  Vue.use(VueAxios,axios)
  export default {
    data()
    {
      var id = "3";
      return {
      id,
      }
    },
methods: {
  show()
  {
    if(document.getElementById("password").getAttribute("type")=="password")
    {
      document.getElementById("password").setAttribute("type","text");
    } else
    {
      document.getElementById("password").setAttribute("type","password");
    }
  },
  signup()
  {
    console.log(this.id);
    var fn =document.getElementById("fn").value;
    var ln =document.getElementById("ln").value;
    var ml =document.getElementById("ml").value.toLowerCase();
    var ps =document.getElementById("password").value;
    var lst= ml.slice(ml.length-11,ml.length);
    var ea= ml.slice(0,ml.length-11);
    var a=false;
    var b=false;
    var d=false;
    var c;var k;
    //const self=this;
    for(k=0;k<ea.length;k++)
      {
        c=ea.charCodeAt(k);
        if (!( ( c >= 48 && c <= 57 ) || ( c >= 65 && c <= 90 ) || (c==46) || (c==95) || ( c >= 97 && c <= 122 ) ))
        {b=true;
          break;}}
    for(k=0;k<fn.length;k++)
      {
        c=fn.charCodeAt(k);
        if (!(( c >= 65 && c <= 90 ) || ( c >= 97 && c <= 122 ) ))
        {a=true;
          break;}}
    for(k=0;k<ln.length;k++)
      {
        c=ln.charCodeAt(k);
        if (!(( c >= 65 && c <= 90 ) || ( c >= 97 && c <= 122 ) ))
        {
          d=true;
          break;
      }
      }
    console.log(b);
    if (fn == '')
      alert('First Name field is required');
    else if (a)
      alert('First Name is invalid');
    else if (ln == '')
      alert('Last Name field is required');
    else if (d)
      alert('Last Name is invalid');
    else if (ml == '')
      alert('E-maill Address field is required');
    else if((lst.toLowerCase())!=('@hedwig.com'.toLowerCase()) || b)
      alert('Invalid e-mail address');  
    else if (ps == '')
      alert('Password field is required');
    else if (ps.length<8)
      alert('Password cannot be less than 8 characters');
    else 
      {//var user = { "firstName": fn , "lastName": ln , "mail": ml, "pass":ps };
      this.user= { "firstName": fn , "lastName": ln , "mail": ml, "pass":ps };
      axios.post("http://localhost:8081/Api/signup",{
        firstName: fn ,
        lastName: ln ,
        mail: ml,
        pass:ps
      }).then(response => {
                var r = response.data;
                if(r==0)
                  alert('E-mail address already exits');
                else
                {console.log(r);
                 this.$router.push({name: 'account',params: {id:r}});}
                }) .catch(error => alert(error))}
  }
  
  }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
form
{
  margin: 20px 550px;
}

            .button{
                background-color: #ffe713;
                border: none;
                color:#0f0f0f;   
                font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                text-align: center;
                text-decoration: none;
                margin: 0px 120px;
                font-size: 18px;
                font-weight:500;
                width:120px;
                height:50px;
                border-radius: 2px;
                cursor: pointer;
            }
            .input{
              background-color:inherit;
              color:#e2e2e2 ;
              font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
              font-size: 17px;
              font-weight:lighter;
              height:30px;
              width: 350px;
              /*margin: 50px 550px;*/
              margin: inherit;
              border:none;
              padding-left: 5px;
              outline: none;
            }
            #password
            {
              width: 320px;
            }
            
            #show
            {
              margin-top: 5px;
              height: 20px;
              width: 20px;
            }
            #logo
            {
              margin-left: 90px;
            }
              .ie
              {
                border:1px solid #e2e2e2;
                display:inline-block;  
                border-radius: 4px;
                height:30px;
                width: 350px;
              }
            h1
            {
              font-size: 20px;
              color: #ffe713;
              font-weight: lighter;
            }
            form {
                display: inline-block;
                overflow: hidden;
                
            }
            a
            {
              color: #ffe713;
              
            }
            a:hover
            {
              text-decoration: underline;
            }
            button
            {
              cursor: pointer;
            }
</style>
