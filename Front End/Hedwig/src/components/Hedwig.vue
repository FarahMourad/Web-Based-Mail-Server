<template>
    
    <form>
          <p style="display:inline;color:#ffe713;padding-left:6px">                                            </p>
          <br><br><br><br><br><br>
          <img src="logo1.png" height="185" width="200" id="logo" style="margin-left:550px">
          <h1 style="margin-left:550px">E-mail address</h1>
          <div class="ie" style="margin-left:550px">
          <input class="input" placeholder="someone@hedwig.com" id="ml" style="margin-left:0px">
          </div>
          <br>
          <h1 style="margin-left:550px">Password</h1>
          <div class="ie" style="margin-left:550px">
          <input type="password" class="input" id="password" style="margin-left:0px">
          <img src="view1.png" @click="show" id="show" style="margin-left:0px;cursor:pointer">
          </div>
          <br>
          <div style="margin-left:550px">
          Don't have an account?
          <router-link to="SignUp">Sign up</router-link>.
          <br><br>
          <input type="button" class="button" @click ="signin()" style="margin-left:110px" value="Sign in">
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
      return {
        
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
  signin()
  {
    var ml =(document.getElementById("ml").value).toLowerCase();
    var ps =document.getElementById("password").value;
    var lst= ml.slice(ml.length-11,ml.length);
    var ea= ml.slice(0,ml.length-11);
    var b=false;
    var c;var k;
    for(k=0;k<ea.length;k++)
      {
        c=ea.charCodeAt(k);
        if (!( ( c >= 48 && c <= 57 ) || ( c >= 65 && c <= 90 ) || (c==46) || (c==95) || ( c >= 97 && c <= 122 ) ))
        {b=true;
          break;}}
    console.log(b);
    if (ml == '')
      alert('E-maill Address field is required');
    else if(lst!='@hedwig.com' || b)
      alert('Invalid e-mail address');  
    else if (ps == '')
      alert('Password field is required');
    else if (ps.length<8)
      alert('Password cannot be less than 8 characters');
    else 
      {axios.get("http://localhost:8081/Api/signin",{
        params :{
                    mail: ml,
                    pass:ps,
                }
        
      }).then(response => {
                var r = response.data;
                console.log(r);
                if (r==-1)
                  alert('E-mail not found'); 
                else if(r==0)
                  alert('Wrong Password');
                else
                  {this.$router.push({name: 'mail',params: {id:r}});}
                }) .catch(error => alert(error))}

      
  }
  
  }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
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
            button{
              cursor: pointer;
            }
</style>
