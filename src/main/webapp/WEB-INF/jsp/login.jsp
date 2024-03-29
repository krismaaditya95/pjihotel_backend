<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>SI Hotel - Login</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  </head>
  <body>
    <div class="formwrapper">
      ${error}
      ${sessionScope.idPengguna}
      <h3 class="formtitle">Sistem Reservasi Hotel</h3>
      <form class="loginform" method="post">
        <label for="txtUsername">Username</label>
        <input type="text" name="username" placeholder="username">

        <label for="txtPassword">Password</label>
        <input type="password" name="userpass" placeholder="password">

        <font color="red">${errorMessage}</font>
        <input id="loginbtn" type="submit" value="LOGIN">
      </form>


    </div>
  </body>
</html>

<script>
  // parseInt digunakan untuk meng-casting seperti ini, misal :
  var angka = '10';
  var angka2 = parseInt(angka);

  console.log(angka2);
</script>

<style media="screen">
body{
  font-family: sans-serif;
  font-size: 0.9em;
}
.formwrapper{
  margin: auto;
  margin-top: 100px;
  width: 350px;
  /* border: 1px solid green; */
}

.formtitle{
  margin: auto;
  width: auto;
  /* border: 1px solid #aaa; */
  text-align: center;
  padding: 30px 0 30px 0;
  border-radius: 5px 5px 0 0;

  /* border-style: solid; */
  /* border-width: 1px 1px 0px 1px; */
  /* border-color: #ccc; */

  background-color: #286DA8;
  color: white;
  box-shadow: 1px 0px 3px -1px gray;
}

.loginform label{
  /* color: white; */
  font-size: 0.8em;

}

.loginform{
  /* border width dipakai untuk 4 value :
  atas kanan bawah kiri */
  border-style: solid;
  border-width: 0px 1px 1px 1px;
  border-color: #ccc;

  padding: 40px 30px;
  border-radius: 0 0 5px 5px;
  /* background-color: #286DA8; */
  /* background-color: #CD5360; */
  /* background-color: #B37D4E; */
  /* background-color: #438496; */
  /* background-color: #f2f2f2; */
  /* Box Shadow: horizontal offset ; vertical offset ; blur radius ; spread radius */
  box-shadow: 1px 1px 3px -1px gray;
}

.loginform input[type=text], input[type=password]{
  width: 100%;
  padding: 10px;
  box-sizing: border-box;
  border: none;
  /* border: 1px solid #ccc; */
  border-bottom: 2px solid #CD5360;
  /* border-radius: 4px; */
  margin: 8px 0;
  transition: 0.5s;
}

.loginform input[type=text]:focus,
input[type=password]:focus{
  /* border: 1px solid #CD5360; */
  border-bottom: 2px solid #438496;
}

.loginform input[type=submit]{
  /* background-color: #438496; */
  width: 100%;
  background-color: #CD5360;
  border: none;
  color: white;
  padding: 10px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 20px;
  transition: 0.9s;
}

.loginform input[type=submit]:hover{
  background-color: #286DA8;
}

/*
#286DA8
#CD5360
#B37D4E
#438496 */

</style>
