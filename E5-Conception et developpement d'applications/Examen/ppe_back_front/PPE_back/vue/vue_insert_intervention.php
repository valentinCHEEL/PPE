<h3> Réserver une intervention auprès de nos techniciens</h3>
<style>
        body {
            background-image: url("images/arriereplan.jpg");
            background-size: cover; /* pour ajuster l'image à la taille de la fenêtre */
        }
        </style>
<form method="post">
    <table>
        
        <tr>
            <td> dateAffectation </td>
            <td> <input type="date" name="dateAffectation"
                value="<?= ($leIntervention!=null)?$leIntervention['dateAffectation']:''?>"></td>
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