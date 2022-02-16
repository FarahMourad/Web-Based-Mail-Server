<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {

  name: 'App',
  props: ['id'],
    data()
    {
      return {
      }
    },
}
</script>


<style>
  body{
    background-color:rgb(32, 32, 32);
    color:white;  
    font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  }
  button{
    cursor:pointer;
  }
  #mail
{
  background-color:rgb(32, 32, 32);
  color:white;
  height: 238px;
  width: 691px;
  border-bottom-color:solid #000000;
                border-right:none;
                border-left:none;
                border-top:none;
  font-family: inherit;
  resize: none;
  display:inline-block;
  
}
.send
{
  background-color:#ffe713;
  color:#0f0f0f;
  font-family: inherit;
  border: none;
  height: 23px;
  width: 50px;
  border-radius: 3px;
  font-weight: 500;
  margin-top: 6px ;
  margin-left: 0px;
  cursor: pointer;
  float: right;
  margin-right: 10px;
}
#new
{
  margin: 100px 400px;
  border: solid rgb(136, 136, 136);
  border-width: 2px;
  border-radius: 7px;
  width: 700px;
  height: 430px;
  border-bottom-width: 2px;
  visibility: hidden;
  position:absolute;
  background-color:rgb(32, 32, 32) ;
  text-align: start;
}
.newf
{
  margin: 270px 600px;
  border: solid rgb(136, 136, 136);
  border-width: 2px;
  border-radius: 7px;
  width: 300px;
  height: 90px;
  border-bottom-width: 2px;
  visibility: visible;
  position:absolute;
  background-color:rgb(32, 32, 32) ;
}
.bor
{
  background-color: #030303;
  color: inherit;
  text-align: left;
  height: 25px;
  width: 700px;
  border-top-right-radius: 7px;
  border-top-left-radius: 7px;
  border: none;
  font-family: inherit;
  font-weight: bold;
  display:inline-block;
  
}
.new
{
  background-color:rgb(32, 32, 32);
  color:white;
  border-bottom-color:solid #000000;
  border-bottom-width: 1px;
                border-right:none;
                border-left:none;
                border-top:none;
                display:inline-block;
  width: 691px;
  padding-left: 5px ;
  
}
.search
{
  background-color:rgb(32, 32, 32);
  color: #949494;
  font-weight: lighter;
  font-family: inherit;
  font-size: 17px;
  border: none;
  border-radius: 4px;
  padding-left: 9px;
}
#att
{
  width:700px;height:70px;border: solid rgb(136, 136, 136);
  border-width: 1px;border-top:none;border-left:none;border-right:none;overflow-y:scroll;
}
::-webkit-scrollbar {
  width: 10px;
}

/* Track */
::-webkit-scrollbar-track {
  background: rgb(44, 44, 44);
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background:
   rgb(163, 163, 163);
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background:
   rgb(163, 163, 163);
}
</style>
