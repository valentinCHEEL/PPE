
<?php
session_start();
// Initialiser les variables de session
$numClient = $_SESSION['client']['numClient'];
$nomClient = $_POST['nomClient'];
?>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Solutions Organisation et de Gestion</title>
        <link rel="stylesheet" href="styles/styles.css">
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
    <div class="content">
      <div class="card">
        <div class="left">
          <h1>Nos interventions</h1>
            <?php if(isset($_SESSION['numClient']) && isset($_SESSION['nomClient'])): ?>
                <h4>Vous êtes connecté en tant que : 
                    <?php
                    echo "Nom du client : " . $_SESSION['nomClient'];
                    echo "<br>Numéro du client : " . $_SESSION['numClient'];
                    ?>
                </h4>
            <?php endif; ?>
          <p> Nous intervenons sur tout type de problème quel soit logistique et matériel. Découvrer notre page intervention</p>
        </div>

        <div class="right">
          <img src="img/intervention.jpg" alt="">
        </div>

      </div>
    </div>

    <div class="content">
      <div class="card">
        <div class="left">
          <h1>A propos</h1>
          <p> Qui nous somme ? Découvrer notre page a propos </p>
        </div>

        <div class="right">
          <img src="img/apropos.jpg" alt="">
        </div>

      </div>
    </div>

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
