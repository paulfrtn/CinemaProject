#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: user
#------------------------------------------------------------

CREATE TABLE user(
                     user_id        Int  Auto_increment  NOT NULL ,
                     user_firstname Varchar (255) NOT NULL ,
                     user_lastname  Varchar (255) NOT NULL ,
                     user_mail      Varchar (255) NOT NULL ,
                     user_pseudo    Varchar (255) NOT NULL ,
                     user_password  Varchar (255) NOT NULL ,
                     user_birthday  Date NOT NULL ,
                     user_role      Bool NOT NULL ,
                     user_type      Int NOT NULL
    ,CONSTRAINT user_PK PRIMARY KEY (user_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: salle
#------------------------------------------------------------

CREATE TABLE salle(
                      salle_id       Int  Auto_increment  NOT NULL ,
                      salle_number   Int NOT NULL ,
                      salle_capa_max Int NOT NULL ,
                      salle_dispo    Bool NOT NULL
    ,CONSTRAINT salle_PK PRIMARY KEY (salle_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: film
#------------------------------------------------------------

CREATE TABLE film(
                     film_id           Int  Auto_increment  NOT NULL ,
                     film_title        Varchar (255) NOT NULL ,
                     film_director     Varchar (255) NOT NULL ,
                     film_genre        Varchar (255) NOT NULL ,
                     film_synopsis     Longtext NOT NULL ,
                     film_duration     Int NOT NULL ,
                     film_release_date Date NOT NULL ,
                     film_status       Bool NOT NULL ,
                     film_poster       Varchar (255) NOT NULL
    ,CONSTRAINT film_PK PRIMARY KEY (film_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Seance
#------------------------------------------------------------

CREATE TABLE Seance(
                       seance_id             Int  Auto_increment  NOT NULL ,
                       seance_date           Date NOT NULL ,
                       seance_time           Time NOT NULL ,
                       seance_language       Varchar (255) NOT NULL ,
                       seance_nb_reservation Int NOT NULL ,
                       film_id               Int NOT NULL ,
                       salle_id              Int NOT NULL
    ,CONSTRAINT Seance_PK PRIMARY KEY (seance_id)

    ,CONSTRAINT Seance_film_FK FOREIGN KEY (film_id) REFERENCES film(film_id)
    ,CONSTRAINT Seance_salle0_FK FOREIGN KEY (salle_id) REFERENCES salle(salle_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: offer
#------------------------------------------------------------

CREATE TABLE offer(
                      offer_id          Int  Auto_increment  NOT NULL ,
                      offer_name        Varchar (50) NOT NULL ,
                      offer_description Varchar (255) NOT NULL ,
                      offer_start_date  Date NOT NULL ,
                      offer_end_date    Date NOT NULL ,
                      offer_price       Float ,
                      offer_discount    Float ,
                      offer_limit       Int ,
                      offer_user_type   Int NOT NULL ,
                      offer_status      Bool NOT NULL ,
                      user_id           Int NOT NULL
    ,CONSTRAINT offer_PK PRIMARY KEY (offer_id)

    ,CONSTRAINT offer_user_FK FOREIGN KEY (user_id) REFERENCES user(user_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ticket
#------------------------------------------------------------

CREATE TABLE ticket(
                       ticket_id     Int  Auto_increment  NOT NULL ,
                       ticket_date   Date NOT NULL ,
                       ticket_status Bool NOT NULL ,
                       ticket_price  Float NOT NULL ,
                       user_id       Int NOT NULL ,
                       seance_id     Int NOT NULL ,
                       offer_id      Int
    ,CONSTRAINT ticket_PK PRIMARY KEY (ticket_id)

    ,CONSTRAINT ticket_user_FK FOREIGN KEY (user_id) REFERENCES user(user_id)
    ,CONSTRAINT ticket_Seance0_FK FOREIGN KEY (seance_id) REFERENCES Seance(seance_id)
    ,CONSTRAINT ticket_offer1_FK FOREIGN KEY (offer_id) REFERENCES offer(offer_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: projetter
#------------------------------------------------------------

CREATE TABLE projetter(
                          film_id  Int NOT NULL ,
                          salle_id Int NOT NULL
    ,CONSTRAINT projetter_PK PRIMARY KEY (film_id,salle_id)

    ,CONSTRAINT projetter_film_FK FOREIGN KEY (film_id) REFERENCES film(film_id)
    ,CONSTRAINT projetter_salle0_FK FOREIGN KEY (salle_id) REFERENCES salle(salle_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: recevoir
#------------------------------------------------------------

CREATE TABLE recevoir(
                         user_id  Int NOT NULL ,
                         offer_id Int NOT NULL
    ,CONSTRAINT recevoir_PK PRIMARY KEY (user_id,offer_id)

    ,CONSTRAINT recevoir_user_FK FOREIGN KEY (user_id) REFERENCES user(user_id)
    ,CONSTRAINT recevoir_offer0_FK FOREIGN KEY (offer_id) REFERENCES offer(offer_id)
)ENGINE=InnoDB;

