<!DOCTYPE html>
<html>
<head>
    <title>Gestion des Clients</title>
    <style>
        body {
            background-color: #333333;
            color: white;
        }
        table {
            background-color: #FFFFFF;
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h3>Liste des clients</h3>
    <form method="post">
        Filtrer par : <input type="text" name="filtre">
        <input type="submit" name="Filtrer" value="Filtrer">
    </form>
    <br>
    <table>
        <tr>
            <th>Numéro Client</th>
            <th>Nom</th>
            <th>Adresse</th>
            <th>Ville</th>
            <th>Code Postal</th>
            <th>Actions</th>
        </tr>
        <?php
        // Affichage des clients
        require_once('ClientManager.php'); // Assurez-vous de bien inclure le fichier contenant la classe ClientManager
        $pdo = new PDO('mysql:host=localhost;dbname=ma_base_de_donnees', 'username', 'password'); // Changez les paramètres de connexion à la base de données
        $clientManager = new ClientManager($pdo);

        $lesClients = isset($_POST['Filtrer']) ? $clientManager->searchAllClients($_POST['filtre']) : $clientManager->selectAllClients();

        foreach ($lesClients as $unClient) {
            echo "<tr>";
            echo "<td>" . htmlspecialchars($unClient['numClient']) . "</td>";
            echo "<td>" . htmlspecialchars($unClient['nomClient']) . "</td>";
            echo "<td>" . htmlspecialchars($unClient['adresse']) . "</td>";
            echo "<td>" . htmlspecialchars($unClient['ville']) . "</td>";
            echo "<td>" . htmlspecialchars($unClient['codePostal']) . "</td>";
            echo "<td>
                    <a href='gestion_client.php?action=sup&numClient=" . htmlspecialchars($unClient['numClient']) . "'>
                        <img src='img/suppr.jpeg' height='30' width='30' alt='Supprimer'>
                    </a>
                    <a href='gestion_client.php?action=edit&numClient=" . htmlspecialchars($unClient['numClient']) . "'>
                        <img src='img/edit.jpeg' height='30' width='30' alt='Éditer'>
                    </a>
                  </td>";
            echo "</tr>";
        }
        ?>
    </table>
</body>
</html>
