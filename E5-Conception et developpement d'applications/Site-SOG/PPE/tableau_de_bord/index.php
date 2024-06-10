<?php
session_start();
?>
<?php
   require_once("controleur/controleur.class.php");
    $unControleur = new Controleur();
    ?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PPE SOG partie BACK</title>
    <link rel="stylesheet" href="../site_PPE_SOG/styles/intervention.css">
</head>
<body>
    <center>
        <h1 style="color: white;"> Intervention </h2>
        <p style="color: white;">
        <?php if(isset($_SESSION['numTechnicien']) && isset($_SESSION['nomT'])): ?>
            <h4 style="color: white;">Bienvenue technicien
                <?php
                echo $_SESSION['nomT'] . "&nbsp;&nbsp;" .$_SESSION['prenomT'] . "&nbsp;&nbsp;!!!";
                echo "<br>Matricule : " . $_SESSION['numTechnicien'];
                ?>
            </h4>
        <?php endif; ?>

        </p>
     
  <li><a href="gestion_intervention.php">Tableau de bord</a></li>
  <li><a href="../site_PPE_SOG/logout.php" style="color: white;">Déconnexion</a></li>
  <!--<li><a href="liste_client.php" style="color: white;">liste client</a></li>-->

    </center>
</body>
</html>