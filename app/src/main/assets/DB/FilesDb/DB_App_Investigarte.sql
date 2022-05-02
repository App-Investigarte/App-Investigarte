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
password TEXT NOT NULL DEFAULT 1017,
email TEXT,
name TEXT NOT NULL,
phone_number INTEGER,
image TEXT,
date_user TEXT,
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
INSERT INTO Subregions(id, name, id_department) VALUES (0, "sin definir", 1);
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
-- sin definir
INSERT INTO Municipality(id, name, id_subregions) VALUES (0, "sin definir", 0);

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
INSERT INTO Community(id, name) VALUES(0, "Sin Definir");
INSERT INTO Community(id, name) VALUES(1, "ASOCIACION DE MUJERES DE BAJIRA- ASOMUPROBA");
INSERT INTO Community(id, name) VALUES(2, "Embera-chamí");
INSERT INTO Community(id, name) VALUES(3, "Campesinos");
INSERT INTO Community(id, name) VALUES(4, "Embera Katío: Resguardo Polines");
INSERT INTO Community(id, name) VALUES(5, "Emberas dóbidas");
INSERT INTO Community(id, name) VALUES(6, "Consejo comunitario afro vereda San Andrés");
INSERT INTO Community(id, name) VALUES(7, "Comunidades de indígenas zenúes");
INSERT INTO Community(id, name) VALUES(8, "Organización de mujeres artesanas");
INSERT INTO Community(id, name) VALUES(9, "Artesanas de las banaeras de Urabá y Artesanías de Colombia");
INSERT INTO Community(id, name) VALUES(10, "Embera Katío: Jaikerazabi");
INSERT INTO Community(id, name) VALUES(11, "Embera Katío: Choromandó");

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
-- Uraba Antioquenio
-- id, nombre, id_ municipio, id_ comunidad, id_clasificación_artesanal, id_categoría_ropa, id_categoría_patrimonial

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (1, "Artesanias en calceta de plátano ", "description", "history", "1", "video", "coments", 114, 9, 0, 1, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (2, "Prendas en saburete y molas", "description", "history", "2", "video", "coments", 114, 0, 1, 1, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (3, "Prendas en saburete y molas",  "description", "history", "image", "video", "coments", 111, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (4, "Tejido en chaquira",  "description", "history", "4", "video", "coments", 111, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (5, "Accesorios en calceta de plátano", "description", "history", "5", "video", "coments", 105, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (6, "Tejido diagonal", "Oficio: Bisuteria, Ténica: Telar, mano alzada, tejido diagonal y sarga, Materia Prima: Chaquiras.", "history", "6", "video", "coments", 107, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (7, "Cesteria BIJAO e IRACA", "Oficio: Cesteria Iraca", "history", "7", "video", "coments", 108, 4, 1, 1, 0 );


INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (8, "bolsos con zuncho", "description", "history", "image", "video", "coments", 108, 0, 3, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (9, "Tejido en chaquira", "description", "history", "image", "video", "coments", 108, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (10, "Artesanías en totumo","description", "history", "10", "video", "coments", 108, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (11, "Bolsos cestería en calceta de plátano", "description", "history", "11", "video", "coments", 108, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (12, "Sombreros en fibra, tipo sombrero vueltiado", "description", "history", "12", "video", "coments", 113, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (13, "Canastos y esteras con la fibra de la iraca y el bodré", "description", "history", "image", "video", "coments", 110, 10, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (14, "Artesanías afrocolombianas", "description", "history", "image", "video", "coments", 110, 1, 2, 0, 0 );


-- Suroete Antioquenio

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (15, "Carriel tradicional de 12 bolsillos", "description", "history", "15", "video", "coments", 93, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (16, "Accesorios en chaquiras", "description", "history", "16", "video", "coments", 92, 2, 2, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (17, "Técnica de yoyo-ropa hogar", "description", "history", "image", "video", "coments", 92, 3, 2, 2, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (18, "Kipará", "description", "history", "18", "video", "coments", 83, 0, 1, 1, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (19, "Tejido en chaquiras", "description", "history", "image", "video", "coments", 83, 4, 1, 0, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (20, "Sombrero aguadeño","Se utiliza como parte del traje típico en el festival y danzas", "history", "20", "video", "coments", 85, 0, 0, 0, 0);


INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (21, "Ruana",  "description", "history", "image", "video", "coments", 87, 0, 2, 1, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (22, "Atuendo tradicional arriero y vestuario de la mula", "description", "history", "image", "video", "coments", 88, 0, 2, 0, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (23, "Atuendo tradicional arriero y atuendo trovador alpargatas fabricadas de cabuya, carriel, poncho o ruana y sombrero", "description", "history", "image", "video", "coments", 89, 0, 2, 1, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (24, "Vestuario indígena Emberá, vestidos, collares, pintura corporal, El costurero retazos, Colcha de retazos", "description", "history", "image", "video", "coments", 102, 0, 0, 0, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (25, "Traje de chapolera desde lo tradicional/ desde lo actual gorra (sombrero, pañoleta), botas de caucho, manga larga", "description", "history", "image", "video", "coments", 90, 0, 2, 1, 0);

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (26, "Joyería en filigrana en oro y plata", "description", "history", "26", "video", "coments", 56, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (27, "Mascaras y vesturios performático", "Fiesta de los diablitos", "history", "27", "video", "coments", 56, 0, 2, 1, 5 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (28, "Sombrero Aguadeño", "Sombrero de paja o iraca", "history", "28", "video", "coments", 57, 0, 2, 1, 3 );


INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (29, "Artesanías en barro Vereda Untí", "description", "history", "image", "video", "coments", 43, 0, 2, 0, 0 );


INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (30, "Cestería en  Bijao e iraca", "description", "history", "30", "video", "coments", 46, 11, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (31, "Costura, bordado, tejido", "description", "history", "31", "video", "coments", 48, 0, 2, 1, 0 );


--Norte Antioquenio

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (32, "Atuendo trovador alpargatas fabricadas de cabuya, carriel, poncho o ruana y sombrero", "description", "history", "image", "video", "coments", 28, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (33, "Ropas afro coloridas con musica", "description", "history", "33", "video", "coments", 121, 6, 2, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (34, "Muleras, Atuendo tradicional", "description", "history", "image", "video", "coments", 124, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (35, "Peinados afro", "description", "history", "image", "video", "coments", 124, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (36, "Joyeria en filigrana", "description", "history", "image", "video", "coments", 3, 0, 2, 1, 0 );


INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (37, "Cañaflecha", "description", "history", "37", "video", "coments", 5, 7, 2, 1, 1 );



--Magdalena Medio
INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (38, "Atuendo del pesacador cotidiano",  "description", "history", "image", "video", "coments", 9, 0, 2, 1, 0 );



-- Nordeste Antioquenio

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (39, "Pañolones, mantillas, mantones",  "description", "history", "image", "video", "coments", 14, 0, 2, 2, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (40, "Pañoles, mantillas, mantones",  "description", "history", "image", "video", "coments", 16, 0, 2, 2, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (41, "bisutería con alusión al tigre",  "description", "history", "image", "video", "coments", 13, 8, 3, 0, 0);


-- Orinete Antioquenio
INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (42, "Taller de artesanias, en telares (producion en lana)",  "description", "history", "42", "video", "coments", 64, 0, 2, 1, 4 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (43, "Bisuteria en ceramica",  "description", "history", "43", "video", "coments", 64, 0, 3, 1, 2 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (44, "Ruana Perrileña", "description", "history", "44", "video", "coments", 81, 0, 0, 1, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (45, "Sombrero aguadeño", "description", "history", "image", "video", "coments", 81, 0, 0, 0, 0 );



-- Sin ubicasion
-- id, nombre, id_ municipio, id_ comunidad, id_clasificación_artesanal, id_categoría_ropa, id_categoría_patrimonial

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (46, "Tapapinche o delantal tapapinche", "description", "history", "46", "video", "coments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (47, "Alpargatas o cotizas", "description", "history", "47", "video", "coments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (48, "Poncho", "description", "history", "48", "video", "coments", 0, 0, 2, 1, 3 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (49, "Pañolones, mantillas, mantones", "description", "history", "image", "video", "coments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (50, "Pantalones coje puerco", "description", "history", "image", "video", "coments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (51, "La mulera", "description", "history", "51", "video", "coments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (52, "El chingue o el camisón", "description", "history", "image", "video", "coments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (53, "Carriel femenino", "description", "history", "image", "video", "coments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (54, "Jíquera", "description", "history", "54", "video", "coments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, description, history, image, video, coments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (55, "Rosario y Camándula", "description", "history", "55", "video", "coments", 0, 0, 0, 0, 0 );

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

/*

SELECT * from Municipality m

select *
FROM Artifact a inner join Municipality m on a.id_municipality = m.id



select a.id, a.name, a.image, a.id_municipality, m.name, m.id_subregions
FROM Artifact a inner join Municipality m on a.id_municipality = m.id WHERE m.id_subregions = "8"

select COUNT(*) FROM Artifact a inner join Municipality m on a.id_municipality = m.id WHERE m.id_subregions = "8"

*/
