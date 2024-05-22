<?php
session_start();

?>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Solustions Organisation et de Gestion</title>
        <link rel="stylesheet" href="styles/contact.css">
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
    <div class="sucess">
    <a href="logout.php">Déconnexion</a>
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

<link href="https://fonts.googleapis.com/css?family=Oswald:700|Patua+One|Roboto+Condensed:700" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<section id="contact" class="content-section text-center">
        <div class="contact-section">
            <div class="container">
              <h2>Contact-nous</h2>
              <p>Si vous avez n'importe quelle question ou problème, n'hesité pas a nous conctact en mettant vos information ci-dessus. Nous vous répondrons dans les plus bref délais.</p>
              <div class="row">
                <div class="col-md-8 col-md-offset-2">
                  <form class="form-horizontal">
                    <div class="form-group">
                      <label for="exampleInputName2">Nom</label>
                      <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail2">Email</label>
                      <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
                    </div>
                    <div class="form-group ">
                      <label for="exampleInputText">Votre demande/question</label>
                     <textarea  class="form-control" placeholder="Description"></textarea> 
                    </div>
                    <button type="submit" class="btn btn-default">Send Message</button>
                  </form>

                  <hr>
                </div>
              </div>
            </div>
        </div>
      </section>
</body>
</html>

