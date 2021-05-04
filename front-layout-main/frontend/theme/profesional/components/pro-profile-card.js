const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
    <style>

:host // ([theme~="profile-card"]) [part~="overlay"]
{
  position: absolute;
  top: 50px;
  right: 10px;
  padding: 0px;
#  transform: translate(-50%,-50%);
}

.container{
  width: 280px;
  height: 450px;
  background: #fff;
  position: relative;
#  border-radius: 10px;
#  box-shadow: 0 2px 10px 0 rgba(0,0,0,0.16), 0 2px 10px 0 rgba(0,0,0,0.12);
}

.container .profile-img{
  width: 100px;
  height: 100px;
  border-radius: 50%;
  position: relative;
  top: 0px;
  left: 85px;
  border: 5px solid white;
}

.content{
  top: 100px;
#  padding: 145px 20px 20px;
}

.content .sub-content{
  text-align: center;
}

.content .sub-content h1{
top:100px;
  font-size: 24px;
  margin-bottom: 0px;
  color: green;
}

.content .sub-content h2{
  font-size: 14px;
  margin-bottom: 0px;
  color: green;
}

.content .sub-content span{
  font-size: 10px;
  margin-top: 0px;
  color: green;
}

.content .sub-content p{
  margin-top: 5px;
  font-weight: 600;
}

.content .sub-content span.location{
  display: block;
  margin: 5px 0 20px;
}

.content .sub-content span.location .fa{
  font-size: 18px;
  margin-right: 5px;
}

.content .sub-content a{
  color: green;
}

.data{
  width: 100%;
  overflow: hidden;
  margin: 30px 0 20px;
}

.inner-data{
  width: 33.3%;
  float: left;
  text-align: center;
}

.inner-data span .fa{
  font-size: 30px;
  margin-bottom: 5px;
  color: green;
}

.btn{
  position: absolute;
  left: 10%;
  bottom: 20px;
  clear: both;
  text-align: center;
  width: 80%;
#  height: 45px;
#  background: green;
#   color: #fff;
#  text-transform: uppercase;
#  line-height:38px;
#  font-weight: 600;
  cursor: pointer;
#  border-radius: 5px;
#  text-shadow: 0 0 10px rgba(0,0,0,0.5);
}

    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);