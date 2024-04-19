<<?php
   require_once("../controleur/controleur.class.php");
    $unControleur = new Controleur();
?>

<!-- essaie ouverture d'une session -->
<?php
    if ( ! isset($_SESSION['numClient'])){
			require_once("authentification/login.php");
		}
		if (isset($_POST['nomClient'])){
			$numClient = $_POST['numClient']; 
            $nomClient = $_POST['nomCLient'];
			//$passwordc = $_POST['passwordc'];
		
			if ($unClient != null){
				//enregistrement dans la SESSION 
				$_SESSION['numClient'] = $unClient['numClient']; 
				$_SESSION['nomClient'] = $unClient['nomClient']; 
				$_SESSION['passwordc'] = $unClient['passwordc']; 
				//header("Location: index.php?page=1");
			}
        }
?>