DROP DATABASE if exists sog ;
create DATABASE sog;
use sog;

    
    CREATE TABLE Client (
        numClient int(5) not null auto_increment,
        nomClient varchar(30),
        adresse varchar (50),
        ville varchar (30),
        codePostal char(5),
        numTel char(12) unique,
        adressemail varchar (50) unique,
        passwordc varchar(100),
        typeClient ENUM('Entreprise', 'Particulier') NOT NULL,
        siret varchar (14),
        primary key(numClient)
);


    create table technicien(
        matricule int(3) not null auto_increment,
        nomT varchar(100),
        prenomT varchar(100),
        disponibilite enum("oui","non"),
        tarifHoraire decimal(5,2),
        primary key (matricule)
    );
    
    create table intervention(
        numI int(3) not null auto_increment,
        /* datetime = permet de mettre date et heure */
        dateAffectation datetime,
        dateArrive datetime,
        dateFin datetime, 
        etat enum('en cours', 'accepter', 'refus', 'terminer'),
        libelleMateriel varchar(25),
        matricule int (3) not null,
        numClient int(3) not null,
        primary key (numI),
        foreign key (matricule) references technicien (matricule),
        foreign key (numClient) references Client (numClient)
    );

    create table Contrat (
        numContrat int(5) not null auto_increment,
        dateFin date,
        /* dateV = date limite ou de validitÃ© */
        dateV date,
        /* montantMHt = montant mensuel ht */
        montantMHt decimal (10,3),
        numClient int(3) not null,
        primary key(numContrat),
        foreign key (numClient) references Client (numClient)      
    );

   --trigger 
    drop trigger if exists verifsiret;
    delimiter //
    create trigger verifsiret
    after insert on Client
    for each row
    begin
    if (select length(new.siret))>14 and new.typeClient='Entreprise'
    then 
    signal sqlstate'45000'
    set message_text='erreur saisie siret';
    end if;
    end //
    delimiter ;

/* a voir pour faire marcher le trigger :*/
    --trigger pour lors de l'insertion d'une intervention 
drop trigger if exists insertIntervention;
delimiter //
CREATE TRIGGER insertIntervention
BEFORE INSERT ON intervention
FOR EACH ROW
BEGIN
    SET NEW.etat = 'en cours';
END//
delimiter ;


-- pour hashe ke mdp en sha1 lors de l'insertion
/*
drop trigger if exists insertClient;
delimiter //
CREATE TRIGGER insertClient
BEFORE INSERT ON client
FOR EACH ROW
BEGIN
    set new.passwordc = concat(sha1(passwordc));
END//
delimiter ;

*/





    --connexion pour le client lourd
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

/* a voir c un test*/
insert into technicien values 
    (null, "val", "val","oui", 12);