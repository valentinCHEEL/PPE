<?php
  session_start();
    require_once("controleur/controleur.class.php");
    $unControleur = new Controleur();
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Solutions Organisation et de Gestion</title>
        <link rel="stylesheet" href="styles/intervention.css">
    </head>
<body>
  <nav>
    <h1>SOG</h1>
    <div class ="onglets";>
      <a href="index.php">Accueil</a>
      <a href="gestion_intervention.php">Intervention</a>
      <a href="contact.php">Contact</a>
      <a href="">A propos</a>
    </div>
    <div class="profil">
      <a href="profil/profil.php">Votre Profil</a>
      </div>
    </div>

</nav>
<header>
    <h1>Solution d'Organisation et de Gestion </h1>
    <h4> Votre entreprise d'informatique préféré </h4>

</header>

<section class ="main" id="intervention">

</section>


<center>
  <h2 style="color: white;">Gestion des Interventions</h2>

  <?php

      $leIntervention = null; //INTERVENTION a modifier
      if (isset($_GET['action']) && isset($_GET['numI']))
      {
          $action = $_GET['action'];
          $numI = $_GET['numI'];

          switch($action)
          {
              case "sup" : $unControleur->deleteIntervention($numI); 
              break;
              
              case "edit" :$leIntervention=$unControleur->selectWhereIntervention ($numI);         
              break;
          }
      }

      require_once ("vue/vue_insert_intervention.php");
      
      if (isset($_POST['Valider']))
      {
          $unControleur->insertIntervention ($_POST);
      }
      if (isset($_POST['Modifier']))
      {
          $unControleur->updateIntervention ($_POST);
          header("location: gestion_intervention.php?");
      }

      if (isset($_POST['Filtrer']))
      {
          $filtre = $_POST['filtre'];
          $lesInterventions = $unControleur->searchAllInterventions($filtre, $_SESSION['numClient']);
      
      }else{
          $lesInterventions = $unControleur->selectAllInterventions ($_SESSION['numClient']);
      }
      require_once ("vue/vue_select_intervention.php");

  ?>
</center>
</section>
  <footer>
    <h1>Contact</h1>

    <div class="contact">
      <div class="contact">
        <h3> Instagram</h3>
        <p></p>
      </div>
      <div class="contact">
        <h3>Twitter</h3>
        <p></p>
      </div>
      <div class="contact">
        <h3>Meta</h3>
        <p></p>
      </div>
    </div>

    <p id="contact"> Contact : 06 31 49 30 80 | SOG.pro@gmail.com
  </footer>

</body>
</html>
