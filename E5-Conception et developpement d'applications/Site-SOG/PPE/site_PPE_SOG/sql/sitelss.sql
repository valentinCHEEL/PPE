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
        mdp varchar(100),
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
        dateFin datetime,
        /* dateV = date limite ou de validitÃ© */
        dateV datetime,
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
    before insert on Client
    for each row
    begin
    if (select length(new.siret))<>14 and new.typeClient='Entreprise' 
    then 
    signal sqlstate'45000'
    set message_text='Le num siret si vous êtes une entreprise ne convient pas';
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
        SET new.etat = 'en cours';
    END//
    delimiter ;


    --connexion pour le client lourd
CREATE TABLE user (
    iduser INT(3) AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    email VARCHAR(50),
    mdp VARCHAR(255),
    role ENUM('admin','user')
);

/* pour se connecter a l'appli java */
insert into user values 
    (null, "Valentin","Cheel", "a@gmail.com", "123", "admin"),
    (null, "Kilian", "Shaar", "b@gmail.com", "456", "user");

/* a voir c un test*/
insert into technicien values 
    (null, "PEGASUS", "valentin","oui", 12, "1234!AZERTYaze");

insert into technicien values 
    (null, "Rick", "Shane","oui", 30, "1234!AZERTYaze");

insert into technicien values 
    (null, "Glenn", "Parcker","non", 10, "1234!AZERTYaze");

insert into technicien values 
    (null, "Doctor", "Who","non", 10, "1234!AZERTYaze");

/* insertion de client*/
insert into client values
(null, "Guts", "12 rue des fleurs", "Paris", "95000", "0164641574","Guts@gmail.com", "1234!AZERTYeza",  "Particulier", "");

insert into client values
(null, "Vegeto", "15 rue des fleurs", "Paris", "95000", "0164641575","Vegeto@gmail.com", "1234!AZERTYeza",  "Entreprise", "12345678901237");

/* insert intervention */

insert into intervention values
(null," 2024-06-10 12:09:45", null, null, null, "mac", 1, 1);

insert into intervention values
(null," 2025-06-10 13:50:05", null, null, null, "Imprimante, clavier", 1, 1);

insert into intervention values
(null," 2023-06-10 10:10:00", null, null, "terminer", "Ipad", 1, 1);

insert into intervention values
(null," 2023-07-10 18:50:00", "2023-07-10 18:15:00", "2023-06-10 19:30:00", "Accepter", "imprimante", 1, 1);



insert into intervention values
(null," 2024-06-10 03:17:45", null, null, null, "mac", 1, 2);

insert into intervention values
(null," 2025-06-10 22:23:09", null, null, null, "Imprimante", 1, 2);

insert into intervention values
(null," 2023-06-10 17:15:00", null, null, "terminer", "Ipad", 1, 2);

insert into intervention values
(null," 2023-06-10 17:15:00", "2023-06-10 17:15:00", "2023-06-10 17:15:00", "terminer", "Ipad", 1, 2);

update intervention
set etat ="terminer"
where numI = 3;

update intervention
set etat ="terminer"
where numI = 5;
