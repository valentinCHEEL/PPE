
<h3 style="color: white;"> Liste des interventions</h3>
<form method="post" style="color: white;">
    Filter par : <input type="text" name="filtre">
    <input type="submit" name="Filtrer" value="Filtrer">
</form>
<br>
<table border="1", style="background-color:#FFFFFF;">
    <tr>
        <td> numI </td>
        <td> dateAffectation</td>
        <td> dateArrive</td>
        <td> dateFin</td>
        <td> etat</td>
        <td> libelleMateriel </td>
        <td> matricule</td>
        <td> numClient</td>
    </tr>

    <?php
    // Affichage des interventions
    if (isset($lesInterventions)) {
        foreach ($lesInterventions as $uneIntervention) {
            echo "<tr>";
            echo "<td>" . $uneIntervention['numI'] . "</td>";
            echo "<td>" . $uneIntervention['dateAffectation'] . "</td>";
            echo "<td>" . $uneIntervention['dateArrive'] . "</td>";
            echo "<td>" . $uneIntervention['dateFin'] . "</td>";
            echo "<td>" . $uneIntervention['etat'] . "</td>";
            echo "<td>" . $uneIntervention['libelleMateriel'] . "</td>";
            echo "<td>" . $uneIntervention['matricule'] . "</td>";
            echo "<td>" . $uneIntervention['numClient'] . "</td>";

            echo "<td> <a href='gestion_intervention.php?&action=sup&numI=" . $uneIntervention['numI'] . "'>";
            echo "<img src='img/suppr.jpeg' height='30' width='30'></a>";
            echo "<a href='gestion_intervention.php?&action=edit&numI=" . $uneIntervention['numI'] . "'>";
            echo "<img src='img/edit.jpeg' height='30' width='30'></a>";
            echo "</td>";
            echo "</tr>";
        }
    }
    ?>
</table>
