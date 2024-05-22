<h3 style="color: white;"> Réserver une intervention auprès de nos techniciens</h3>
<style>
        body {
            background-image: url("images/arriereplan.jpg");
            background-size: cover; /* pour ajuster l'image à la taille de la fenêtre */
        }
        </style>
<form method="post">
    <table>
        
        <tr>
            <td style="color: white;"> dateAffectation </td>
            <td> <input type="datetime-local" name="dateAffectation"
                value="<?= ($leIntervention!=null)?$leIntervention['dateAffectation']:''?>"></td>
        </tr>
        
        <tr>
            <td style="color: white;"> libelleMateriel </td>
            <td> <input type="text" name="libelleMateriel"
                value="<?= ($leIntervention!=null)?$leIntervention['libelleMateriel']:''?>"></td>
        </tr>

<!-- cle etrangere a choisir :
        		
			<tr>
		<td> numCLient</td>
		<td>
			<select name="numClient">
				<?php
            
				foreach($lesClient as $unClient){
					echo "<option value='" .$unClient['numClient']."'";
					echo ">";
					echo $unClient['nomClient'];
					echo "</option>"; 
				}
				?>
			</select>
		</td>
	</tr>
            -->       
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