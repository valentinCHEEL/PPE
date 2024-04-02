



Base sql a mettre :
CREATE TABLE client (
    numClient INT(5) AUTO_INCREMENT PRIMARY KEY,
    nomClient VARCHAR(30),
    adresse VARCHAR(50),
    ville VARCHAR(30),
    codePostal INT(5),
    numTel INT(12) UNIQUE,
    adressemail VARCHAR(50) UNIQUE,
    passwordc VARCHAR(100) NOT NULL,
    typeClient ENUM('Entreprise','Particulier') NOT NULL,
    siret INT(14)
);

CREATE TABLE contrat (
    numContrat INT(5) AUTO_INCREMENT PRIMARY KEY,
    dateFin DATE,
    dateV DATE,
    montantMHt DECIMAL(10,3),
    numClient INT(3),
    FOREIGN KEY (numClient) REFERENCES client(numClient)
);

CREATE TABLE entreprise (
    numClient INT(5) AUTO_INCREMENT PRIMARY KEY,
    nomEntreprise VARCHAR(100),
    adresse VARCHAR(50),
    ville VARCHAR(30),
    codePostal int(5),
    numTel INT(12) UNIQUE,
    adressemail VARCHAR(50) UNIQUE,
    passwordc VARCHAR(100) NOT NULL,
    siret VARCHAR(14) NOT NULL
);

CREATE TABLE particulier (
    numClient INT(5) AUTO_INCREMENT PRIMARY KEY,
    nomParticulier VARCHAR(100),
    prenom VARCHAR(50) NOT NULL,
    adresse VARCHAR(50),
    ville VARCHAR(30),
    codePostal int(5),
    numTel INT(12) UNIQUE,
    adressemail VARCHAR(50) UNIQUE,
    passwordc VARCHAR(100) NOT NULL
);

CREATE TABLE technicien (
    matricule INT(3) AUTO_INCREMENT PRIMARY KEY,
    nomT VARCHAR(100),
    prenomT VARCHAR(100),
    poste ENUM('materiel','acceuil','mecanicien'),
    disponibilite ENUM('oui','non'),
    tarifHoraire DECIMAL(10,2)
);

CREATE TABLE intervention (
    numI INT(3) AUTO_INCREMENT PRIMARY KEY,
    dateAffectation DATETIME,
    dateArrive DATETIME,
    dateFin DATETIME,
    etat ENUM('en cours','accepter','refuser','terminer'),
    libelleMateriel VARCHAR(25),
    matricule INT(3),
    FOREIGN KEY (matricule) REFERENCES technicien(matricule)
);

CREATE TABLE user (
    iduser INT(3) AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    email VARCHAR(50),
    mdp VARCHAR(255),
    role ENUM('admin','user')
);

insert into user values 
    (null, "Kilian","Schaar", "a@gmail.com", "123", "admin"),
    (null, "Valentin", "Cheel", "b@gmail.com", "456", "user");
