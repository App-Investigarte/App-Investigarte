CREATE TABLE Departmen (
id INTEGER  UNIQUE NOT NULL, 
name TEXT NOT NULL, 
description TEXT,
CONSTRAINT Departmen_pk PRIMARY KEY (id)
);


CREATE TABLE Subregions (
id INTEGER PRIMARY key AUTOINCREMENT UNIQUE, 
name TEXT NOT NULL, 
description TEXT, 
id_department INTEGER NOT NULL,
CONSTRAINT Deártmen_fk FOREIGN KEY (id_department) REFERENCES Departmen(id)
);

CREATE TABLE Municipality(
id INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE,
name TEXT NOT NULL,
history TEXT NULL,
id_subregions INTEGER NOT NULL,
FOREIGN KEY (id_subregions) REFERENCES Subregions(id)
);

CREATE TABLE Community(
id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
name TEXT  NOT NULL,
description TEXT,
history TEXT
);


CREATE TABLE Artisan_classification(
id INTEGER UNIQUE NOT NULL,
name TEXT  NOT NULL,
description TEXT,
PRIMARY KEY (id)
);


CREATE TABLE Clothing_category(
id INTEGER UNIQUE NOT NULL,
name TEXT  NOT NULL,
description TEXT,
PRIMARY KEY (id)
);


CREATE TABLE Patrimonial_category(
id INTEGER UNIQUE NOT NULL,
name TEXT  NOT NULL,
description TEXT,
PRIMARY KEY (id)
);


CREATE TABLE Artifact(
id INTEGER UNIQUE NOT NULL,
name TEXT  NOT NULL,
description TEXT,
history TEXT,
image TEXT,
video TEXT,
coments TEXT,
id_municipality INTEGER NOT NULL,
id_community INTEGER NOT NULL,
id_artisan_classification INTEGER NOT NULL,
id_clothing_category INTEGER NOT NULL,
id_patrimonial_category INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_municipality) REFERENCES Municipality(id),
FOREIGN KEY (id_community) REFERENCES Community(id),
FOREIGN KEY (id_artisan_classification) REFERENCES Artisan_classification(id),
FOREIGN KEY (id_clothing_category) REFERENCES Clothing_category(id),
FOREIGN KEY (id_patrimonial_category) REFERENCES Patrimonial_category(id)
); 

CREATE TABLE Users(
id INTEGER UNIQUE NOT NULL,
name TEXT NOT NULL,
password TEXT NOT NULL DEFAULT 1017,
last_name TEXT,
phone_number INTEGER,
email TEXT,
image TEXT,
PRIMARY KEY (id)
);

CREATE TABLE History_view_artifact(
id INTEGER UNIQUE NOT NULL,
description TEXT,
id_users INTEGER NOT NULL,
id_artifact INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_users) REFERENCES  Users(id),
FOREIGN KEY (id_artifact) REFERENCES Artifact(id)
);

CREATE TABLE Games(
id INTEGER UNIQUE NOT NULL,
description TEXT,
id_artifact INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_artifact) REFERENCES Artifact(id)
);

CREATE TABLE Trophies(
id INTEGER UNIQUE NOT NULL,
points INTEGER ,
PRIMARY KEY (id)
);


CREATE TABLE History_games(
id INTEGER UNIQUE NOT NULL,
name TEXT  NOT NULL,
description TEXT,
id_users INTEGER NOT NULL,
id_games INTEGER NOT NULL,
id_trophies INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_users) REFERENCES Users(id),
FOREIGN KEY (id_games) REFERENCES Games(id),
FOREIGN KEY (id_trophies) REFERENCES Trophies(id)
);



/**Ingreso de datos iniciales**/

--Departamento
INSERT INTO Departmen(id, name) VALUES (1, "Antioquia");


--subregiones
INSERT INTO Subregions(name, id_department) VALUES ("Bajo Cauca", 1);
INSERT INTO Subregions(name, id_department) VALUES ("Magdalena Medio", 1);
INSERT INTO Subregions(name, id_department) VALUES ("Nordeste", 1);
INSERT INTO Subregions(name, id_department) VALUES ("Norte", 1);
INSERT INTO Subregions(name, id_department) VALUES ("Occidente", 1);
INSERT INTO Subregions(name, id_department) VALUES ("Oriente", 1);
INSERT INTO Subregions(name, id_department) VALUES ("Suroeste", 1);
INSERT INTO Subregions(name, id_department) VALUES ("Urabá", 1);
INSERT INTO Subregions(name, id_department) VALUES ("Valle de Aburrá", 1);


/**Municipios**/

--bajo cauca
INSERT INTO Municipality(name, id_subregions) VALUES ("Cáceres", 1);
INSERT INTO Municipality(name, id_subregions) VALUES ("Caucasia", 1);
INSERT INTO Municipality(name, id_subregions) VALUES ("El Bagre", 1);
INSERT INTO Municipality(name, id_subregions) VALUES ("Nechí", 1);
INSERT INTO Municipality(name, id_subregions) VALUES ("Tarazá", 1);
INSERT INTO Municipality(name, id_subregions) VALUES ("Zaragoza", 1);

-- Magdalena Medio
INSERT INTO Municipality(name, id_subregions) VALUES ("Caracolí", 2);
INSERT INTO Municipality(name, id_subregions) VALUES ("Maceo", 2);
INSERT INTO Municipality(name, id_subregions) VALUES ("Puerto Berrío", 2);
INSERT INTO Municipality(name, id_subregions) VALUES ("Puerto Nare", 2);
INSERT INTO Municipality(name, id_subregions) VALUES ("Puerto Triunfo", 2);
INSERT INTO Municipality(name, id_subregions) VALUES ("Yondó", 2);

-- Nordeste
INSERT INTO Municipality(name, id_subregions) VALUES ("Amalfi", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("Anorí", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("Cisneros", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("Remedios", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Roque", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("Santo Domingo", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("Segovia", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("Vegachí", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("Yalí", 3);
INSERT INTO Municipality(name, id_subregions) VALUES ("Yolombó", 3);

-- Norte
INSERT INTO Municipality(name, id_subregions) VALUES ("Angostura", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Belmira", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Briceño", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Campamento", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Carolina", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Donmatías", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Entrerríos", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Gómez Plata", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Guadalupe", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Ituango", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Andrés de Cuerquia", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("San José de la Montaña", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Pedro de los Milagros", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Santa Rosa de Osos", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Toledo", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Valdivia", 4);
INSERT INTO Municipality(name, id_subregions) VALUES ("Yarumal", 4);

-- Occidente
INSERT INTO Municipality(name, id_subregions) VALUES ("Abriaquí", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Anzá", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Armenia", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Buriticá", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Caicedo", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Cañasgordas", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Dabeiba", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Ebéjico", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Frontino", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Giraldo", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Heliconia", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Liborina", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Olaya", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Peque", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Sabanalarga", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Jerónimo", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Santa Fe de Antioquia", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Sopetrán", 5);
INSERT INTO Municipality(name, id_subregions) VALUES ("Uramita", 5);

--Oriente
INSERT INTO Municipality(name, id_subregions) VALUES ("Abejorral", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Alejandría", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Argelia", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Cocorná", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Concepción", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("El Carmen de Viboral", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("El Peñol", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("El Retiro", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("El Santuario", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Granada", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Guarne", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Guatapé", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("La Ceja", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("La Unión", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Marinilla", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Nariño", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Rionegro", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Carlos", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Francisco", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Luis", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Rafael", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Vicente", 6);
INSERT INTO Municipality(name, id_subregions) VALUES ("Sonsón", 6);

--Suroeste
INSERT INTO Municipality(name, id_subregions) VALUES ("Amagá", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Andes", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Angelópolis", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Betania", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Betulia", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Caramanta", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Ciudad Bolívar", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Concordia", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Fredonia", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Hispania", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Jardín", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Jericó", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("La Pintada", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Montebello", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Pueblorrico", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Salgar", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Santa Bárbara", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Támesis", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Tarso", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Titiribí", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Urrao", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Valparaíso", 7);
INSERT INTO Municipality(name, id_subregions) VALUES ("Venecia", 7);

--Urabá
INSERT INTO Municipality(name, id_subregions) VALUES ("Apartadó", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("Arboletes", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("Carepa", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("Chigorodó", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("Murindó", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("Mutatá", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("Necoclí", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Juan de Urabá", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("San Pedro de Urabá", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("Turbo", 8);
INSERT INTO Municipality(name, id_subregions) VALUES ("Vigía del Fuerte", 8);

--Valle de Aburrá
INSERT INTO Municipality(name, id_subregions) VALUES ("Barbosa", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("Bello", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("Caldas", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("Copacabana", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("Envigado", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("Girardota", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("Itagüí", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("La Estrella", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("Medellín", 9);
INSERT INTO Municipality(name, id_subregions) VALUES ("Sabaneta", 9);



/**Comunidades**/
INSERT INTO Community(id, name) VALUES (0, "Sin Definir");
INSERT INTO Community(id, name) VALUES (1, "ASOCIACION DE MUJERES DE BAJIRA- ASOMUPROBA");
INSERT INTO Community(id, name) VALUES (2, "Embera-chamí");
INSERT INTO Community(id, name) VALUES (3, "Campesinos");
INSERT INTO Community(id, name) VALUES (4, "Embera Katío");
INSERT INTO Community(id, name) VALUES (5, "Emberas dóbidas");
INSERT INTO Community(id, name) VALUES (6, "Consejo comunitario afro vereda San Andrés");
INSERT INTO Community(id, name) VALUES (7, "Comunidades de indígenas zenúes");
INSERT INTO Community(id, name) VALUES (8, "Organización de mujeres artesanas");


/**Clasificaión de artesanias**/
INSERT INTO Artisan_classification(id, name) VALUES (0, "Sin Definir");
INSERT INTO Artisan_classification(id, name) VALUES (1, "Artesanía indígena");
INSERT INTO Artisan_classification(id, name) VALUES (2, "Artesanía tradicional popular");
INSERT INTO Artisan_classification(id, name) VALUES (3, "Artesanía contemporánea o neoartesanía");


/**Categoría de vestuario**/
INSERT INTO Clothing_category(id, name) VALUES (0, "Sin Definir");
INSERT INTO Clothing_category(id, name) VALUES (1, "Suplementos del cuerpo (Que nos envuelven- Aderidos al cuerpo- sostenidos)");
INSERT INTO Clothing_category(id, name) VALUES (2, "Modicicaciones del cuerpo (Piel- Pelo- Uñas- SME- Dientes- Aliento)");


/**CATEGORIAS PATRIMONIALES**/
INSERT INTO Patrimonial_category(id, name) VALUES (0, "Sin Definir");
INSERT INTO Patrimonial_category(id, name) VALUES (1, "Patrimonio protegido y regulado (BIC- PCI- PES- etc)");
INSERT INTO Patrimonial_category(id, name) VALUES (2, "Patrimonio como bien de consumo (capital cultural consagrado desde lo económico)");
INSERT INTO Patrimonial_category(id, name) VALUES (3, "Patrimonio como recurso turístico (lugares asociados a actividades únicas)");
INSERT INTO Patrimonial_category(id, name) VALUES (4, "Patrimonio como construcción social (Consenso colectivo propias");
INSERT INTO Patrimonial_category(id, name) VALUES (5, "adaptadas o trasladadas");


/**ARTEFACTOS**/


INSERT INTO Artifact(id, name, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category ) 
VALUES (1, "Prendas en saburete y molas", 114, 0, 1, 1, 0);

INSERT INTO Artifact(id, name, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category ) 
VALUES (2, "Prendas en saburete y molas", 111, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category ) 
VALUES (3, "Tejido en chaquira", 111, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category ) 
VALUES (4, "Joyería", 105, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category ) 
VALUES (5, "Accesorios en calceta de plátano", 105, 0, 2, 1, 0 );





-- inserciones nuevas
-- Uraba Antioquenio

-- id, nombre, id_ municipio, id_ comunidad, id_clasificación_artesanal, id_categoría_ropa, id_categoría_patrimonial

INSERT INTO Artifact(id, name, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (6, "bolsos con zuncho", 108, 0, 3, 1, 0 );



--Consultas
/*
SELECT * from Departmen; 

SELECT * from Subregions; 

SELECT * from Municipality; 

SELECT * from Community;

SELECT * from Artisan_classification; 

SELECT * from Clothing_category;

SELECT * from Patrimonial_category;

SELECT * from Artifact;
*/
