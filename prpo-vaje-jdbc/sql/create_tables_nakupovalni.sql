CREATE TABLE lokacija(
   postna_stevilka SERIAL PRIMARY KEY      NOT NULL,
   naziv           CHAR(50) NOT NULL
);

CREATE TABLE uporabnik(
   id_uporabnik		SERIAL PRIMARY KEY      NOT NULL,
   ime           	CHAR(50) NOT NULL,
   priimek          CHAR(50) NOT NULL,
   uporabnisko_ime  CHAR(50) NOT NULL,
   email           	CHAR(50) NOT NULL,
   postna_stevilka  INT      references lokacija(postna_stevilka)
);

CREATE TABLE izdelek(
   id_izdelek  	 	SERIAL PRIMARY KEY      NOT NULL,
   naziv         	CHAR(50) NOT NULL,
   kategorija      	CHAR(50) NOT NULL,
   cena		       	double precision NOT NULL    
);

CREATE TABLE listek(
   id_listek 		SERIAL PRIMARY KEY      NOT NULL,
   id_uporabnik  	INT      references uporabnik(id_uporabnik)
);

CREATE TABLE listek_izdelek(
   id_listek  	 	INT      references listek(id_listek),
   id_izdelek  		INT      references izdelek(id_izdelek),
   PRIMARY KEY (id_listek, id_izdelek)
);

CREATE TABLE trgovina(
   id_trgovina 		SERIAL PRIMARY KEY      NOT NULL,
   naziv  			CHAR(50) NOT NULL,	
   postna_stevilka	INT      references lokacija(postna_stevilka)
);

CREATE TABLE seznam(
   id_trgovina		INT      references trgovina(id_trgovina),
   id_izdelek		INT      references izdelek(id_izdelek)  ,
   PRIMARY KEY (id_trgovina, id_izdelek)
);