<?php
session_start();
?>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/profil.css">
    <title>Profil</title>
</head>
<body>
<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="data:image/png;base64,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" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                Changer de profil
                                <input type="file" name="file"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        <?php echo $_SESSION['nomClient']; ?>
                                    </h5>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <!-- Test -->
                        <a href="paramettre_profil.php" class="btn-modifier">Modifier</a>
                    </div>
                </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label> Adresse </label>
                                            </div>
                                            <div class="col-md-6">

                                              <h5>
                                                <?php echo $_SESSION['adresse'];  ?>
                                            </h5>>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Code Postal</label>
                                            </div>
                                            <div class="col-md-6">
                                                
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>kshitighelani@gmail.com</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>123 456 7890</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Profession</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Web Developer and Designer</p>
                                            </div>
                                        </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Experience</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Hourly Rate</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>10$/hr</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Total Projects</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>230</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>English Level</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Availability</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>6 months</p>
                                            </div>
                                        </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Your Bio</label><br/>
                                        <p>Your detail description</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form> 
            <a href="../logout.php">Déconnexion</a>   
            <a href="../index.php" class="btn-retour">Retour</a>       
        </div>
    </div>
</body>
</html> 