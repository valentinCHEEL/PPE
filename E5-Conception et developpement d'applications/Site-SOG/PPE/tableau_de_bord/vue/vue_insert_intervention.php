<h3 style="color: white;"> Les réservations de nos client</h3>
<style>
        body {
            background-image: url("images/arriereplan.jpg");
            background-size: cover; /* pour ajuster l'image à la taille de la fenêtre */
        }
        </style>
<form method="post">
    <table style="color: white;">
        <tr>
            <td> dateAffectation </td>
            <td> <input type="datetime-local" name="dateAffectation"
                value="<?= ($leIntervention!=null)?$leIntervention['dateAffectation']:''?>"></td>
        </tr>

        <tr>
            <td> dateArrive</td>
            <td> <input type="datetime-local" name="dateArrive"
                value="<?= ($leIntervention!=null)?$leIntervention['dateArrive']:''?>"></td>
        </tr>

        <tr>
            <td>dateFin</td>
            <td> <input type="datetime-local" name="dateFin"
                value="<?= ($leIntervention!=null)?$leIntervention['dateFin']:''?>"></td>
        </tr>

        <tr>
            <td>État</td>
            <td>
                <select name="etat">
                    <option value="en cours" <?= ($leIntervention != null && $leIntervention['etat'] == 'en cours') ? 'selected' : '' ?>>En cours</option>
                    <option value="accepter" <?= ($leIntervention != null && $leIntervention['etat'] == 'accepter') ? 'selected' : '' ?>>Accepter</option>
                    <option value="refus" <?= ($leIntervention != null && $leIntervention['etat'] == 'refus') ? 'selected' : '' ?>>Refus</option>
                    <option value="terminer" <?= ($leIntervention != null && $leIntervention['etat'] == 'terminer') ? 'selected' : '' ?>>Terminer</option>
                </select>
            </td>
        </tr>


        <tr>
            <td> libelleMateriel </td>
            <td> <input type="text" name="libelleMateriel"
                value="<?= ($leIntervention!=null)?$leIntervention['libelleMateriel']:''?>"></td>
        </tr>
       
        
        <tr>
            <td> <input type="reset" name="Annuler" value="Annuler"></td>
            <td> <input type="submit" 
                <?= ($leIntervention!=null)? 'name="Modifier" 
                value="Modifier" ' : ' name="Valider"
                value="Valider" ' 
                ?>
            ></td>
        </tr>
</table>
<?=
($leIntervention!=null)?'<input type="hidden" name ="numI" value="'.$leIntervention['numI'].'">' : ''
?>
</form>