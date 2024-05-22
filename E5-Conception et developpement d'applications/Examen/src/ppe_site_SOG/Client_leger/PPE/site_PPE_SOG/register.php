<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/styles.css" />
<script>
    function validerMotDePasse() {
      var motDePasse = document.getElementById("passwordc").value;

      // Le mot de passe doit contenir au moins une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial
      var regexMotDePasse = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]+$/;

      if (!regexMotDePasse.test(motDePasse)) {
        alert("Le mot de passe doit contenir au moins une majuscule, une minuscule, un chiffre et un caractère spécial.");
        return false;
      }

      return true;
    }

    function validerEmail() {
      var email = document.getElementById("adressemail").value;

      // L'adresse e-mail doit contenir au moins un "@" suivi d'un "."
      var regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

      if (!regexEmail.test(email)) {
        alert("L'adresse e-mail doit contenir au moins un '@' suivi d'un '.'");
        return false;
      }

      return true;
    }
  </script>
</head>
<body>
<?php


require('config.php');
if (isset($_REQUEST['nomClient'], $_REQUEST['adressemail'], $_REQUEST['passwordc'], $_REQUEST['typeClient'])){
  // récupérer le nom d'utilisateur et supprimer les antislashes ajoutés par le formulaire
  $nomClient = stripslashes($_REQUEST['nomClient']);
  $nomClient = mysqli_real_escape_string($conn, $nomClient); 
  // récupérer l'email et supprimer les antislashes ajoutés par le formulaire
  $adresse = stripslashes($_REQUEST['adresse']);
  $adresse = mysqli_real_escape_string($conn, $adresse);
  // récupérer l'email et supprimer les antislashes ajoutés par le formulaire
  $ville = stripslashes($_REQUEST['ville']);
  $ville = mysqli_real_escape_string($conn, $ville);
  // récupérer l'email et supprimer les antislashes ajoutés par le formulaire
  $codePostal = stripslashes($_REQUEST['codePostal']);
  $codePostal = mysqli_real_escape_string($conn, $codePostal);
  // récupérer l'email et supprimer les antislashes ajoutés par le formulaire
  $numTel = stripslashes($_REQUEST['numTel']);
  $numTel = mysqli_real_escape_string($conn, $numTel);
  // récupérer l'email et supprimer les antislashes ajoutés par le formulaire
  $adressemail = stripslashes($_REQUEST['adressemail']);
  $adressemail = mysqli_real_escape_string($conn, $adressemail);
  // récupérer le mot de passe et supprimer les antislashes ajoutés par le formulaire
  $passwordc = stripslashes($_REQUEST['passwordc']);
  $passwordc = mysqli_real_escape_string($conn, $passwordc);
  // récupérer l'email et supprimer les antislashes ajoutés par le formulaire
  $typeClient = stripslashes($_REQUEST['typeClient']);
  $typeClient = mysqli_real_escape_string($conn, $typeClient);

  $typeClient = isset($_REQUEST['typeClient']) ? $_REQUEST['typeClient'] : '';
$siret = isset($_REQUEST['siret']) ? $_REQUEST['siret'] : '';

    // Initialiser le champ SIRET avec une chaîne vide si non défini
    $siret = isset($_REQUEST['siret']) ? $_REQUEST['siret'] : '';

    //requéte SQL + mot de passe crypté
    $query = "INSERT into Client (nomClient, adresse, ville, codePostal, numTel, adressemail, typeClient, passwordc, siret)
              VALUES ('$nomClient', '$adresse', '$ville', '$codePostal', '$numTel', '$adressemail', '$typeClient','$passwordc', '$siret')";
    // Exécuter la requête sur la base de données
    $res = mysqli_query($conn, $query);
    if($res){
       echo "<div class='sucess'>
             <h3>Vous êtes inscrit avec succès.</h3>
             <p>Cliquez ici pour vous <a href='login.php'>connecter</a></p>
       </div>"; 
    }

}else{
?>
<form class="box" action="" method="post" onsubmit="return validerMotDePasse()  && validerEmail();">
        <h1 class="box-title">S'inscrire</h1>
        <input type="text" class="box-input" name="nomClient" placeholder="Nom d'utilisateur" required />
        <input type="text" class="box-input" name="adresse" placeholder="Numero, Type de voie" required />
        <input type="text" class="box-input" name="ville" placeholder="Ville" required />
        <input type="text" class="box-input" name="codePostal" placeholder="Code postal" required />
        <input type="text" class="box-input" name="numTel" placeholder="Numero de Téléphone" required />
        <input type="text" class="box-input" name="adressemail" id="adressemail" placeholder="Email" required />
        <input type="password" class="box-input" name="passwordc" id="passwordc" placeholder="Mot de passe" required />
        <select class="box-input" name="typeClient" id="typeClient" onchange="showSiretForm()">
            <option value="particulier">Particulier</option>
            <option value="entreprise">Entreprise</option>
        </select>
        <div id="siretForm" style="display: none;">
            <label for="siret">SIRET de l'entreprise:</label>
            <input type="text" class="box-input" name="siret" id="siret" placeholder="SIRET de l'entreprise" />
        </div>
        <input type="submit" name="submit" value="S'inscrire" class="box-button" />
        <p class="box-register">Déjà inscrit? <a href="login.php">Connectez-vous ici</a></p>
    </form>
    <script>
        function showSiretForm() {
            var typeClient = document.getElementById("typeClient").value;
            var siretForm = document.getElementById("siretForm");
            if (typeClient === "entreprise") {
                siretForm.style.display = "block";
            } else {
                siretForm.style.display = "none";
            }
        }
    </script>
    <?php
}
?>
</body>
</html>
