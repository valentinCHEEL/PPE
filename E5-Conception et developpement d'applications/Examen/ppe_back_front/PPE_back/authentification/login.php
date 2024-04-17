<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="styles/login.css" />
  <script>
    function togglePassword() {
      var passwordField = document.getElementById("passwordc");
      var toggleButton = document.getElementById("toggleButton");

      if (passwordField.type === "password") {
        passwordField.type = "text";
        toggleButton.textContent = "Masquer";
      } else {
        passwordField.type = "password";
        toggleButton.textContent = "Afficher";
      }
    }
  </script>
</head>
<body>
<?php
require('config.php');
session_start();

if (isset($_POST['nomClient'])){
  $nomClient = stripslashes($_REQUEST['nomClient']);
  $nomClient = mysqli_real_escape_string($conn, $nomClient);
  $passwordc = stripslashes($_REQUEST['passwordc']);
  $passwordc = mysqli_real_escape_string($conn, $passwordc);
    $query = "SELECT * FROM Client WHERE nomClient='$nomClient' and passwordc='$passwordc'";
  $result = mysqli_query($conn,$query) or die(mysql_error());
  $rows = mysqli_num_rows($result);
  $client = mysqli_fetch_assoc($result);
  if($rows==1){
      $_SESSION['nomClient'] = $nomClient;
      $_SESSION['client'] = $client; 
      header("Location: ../gestion_intervention.php");
  }else{
    $message = "Le nom d'utilisateur ou le mot de passe est incorrect.";
  }
}
?>
<form class="box" action="" method="post" name="login">

<h1 class="box-title">Connexion</h1>
<input type="text" class="box-input" name="nomClient" placeholder="Nom d'utilisateur">
<input type="password" class="box-input" name="passwordc" id="passwordc" placeholder="Mot de passe">
<button type="button" id="toggleButton" onclick="togglePassword()">Afficher</button>
<input type="submit" value="Connexion " name="submit" class="box-button">
<p class="box-register">Vous êtes nouveau ici? <a href="register.php">S'inscrire</a></p>
<?php if (! empty($message)) { ?>
    <p class="errorMessage"><?php echo $message; ?></p>
<?php } ?>
</form>
</body>
</html>