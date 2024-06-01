<?php
  session_start();
  require('config.php');
  require_once("controleur/controleur.class.php");
  $unControleur = new Controleur();
?>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="styles/login.css"/>
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
if (isset($_POST['nomClient'])){
  $nomClient = stripslashes($_REQUEST['nomClient']);
  $nomClient = mysqli_real_escape_string($conn, $nomClient);
  $passwordc = stripslashes($_REQUEST['passwordc']);
  $passwordc = mysqli_real_escape_string($conn, $passwordc);
  
  $client = $unControleur->verifConnexion ( $nomClient, $passwordc );
 
  if($client != null){
      $_SESSION['nomClient'] =  $client['nomClient'];
      $_SESSION['adresse'] =  $client['adresse'];
      $_SESSION['ville'] =  $client['ville'];
      $_SESSION['codePostal'] =  $client['codePostal'];
      $_SESSION['numTel'] =  $client['numTel'];
      $_SESSION['adressemail'] =  $client['adressemail'];
      $_SESSION['passwordc'] =  $client['passwordc'];



      //pour récupérer l'id du client
      $_SESSION['numClient']= $client['numClient'];

      
      header("Location: index.php");
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