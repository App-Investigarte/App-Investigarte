CREATE TABLE Department (
id INTEGER  UNIQUE NOT NULL,
name TEXT NOT NULL,
description TEXT,
CONSTRAINT Department_pk PRIMARY KEY (id)
);


CREATE TABLE Subregions (
id INTEGER PRIMARY key AUTOINCREMENT UNIQUE,
name TEXT NOT NULL,
description TEXT,
id_department INTEGER NOT NULL,
CONSTRAINT Department_fk FOREIGN KEY (id_department) REFERENCES Department(id)
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
materials Text,
description TEXT,
history TEXT,
image TEXT,
video TEXT,
comments TEXT,
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
INSERT INTO Department(id, name) VALUES (1, "Antioquía");


--subregiones
INSERT INTO Subregions(id, name, id_department) VALUES (0, "Sin definer", 1);
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
-- Sin definer
INSERT INTO Municipality(id, name, id_subregions) VALUES (0, "Se encuentra en todos los municipios.", 0);

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
INSERT INTO Community(id, name) VALUES(0, "Sin definer");
INSERT INTO Community(id, name) VALUES(1, "ASOCIACION DE MUJERES DE BAJIRA- ASOMUPROBA");
INSERT INTO Community(id, name) VALUES(2, "Embera-chamí");
INSERT INTO Community(id, name) VALUES(3, "Campesinos");
INSERT INTO Community(id, name) VALUES(4, "Embera Katío: Resguardo Polines");
INSERT INTO Community(id, name) VALUES(5, "Emberas dóbidas");
INSERT INTO Community(id, name) VALUES(6, "Consejo comunitario afro vereda San Andrés");
INSERT INTO Community(id, name) VALUES(7, "Comunidades de indígenas zenúes");
INSERT INTO Community(id, name) VALUES(8, "Organización de mujeres artesanas");
INSERT INTO Community(id, name) VALUES(9, "Artesanas de las bananeras de Urabá y Artesanías de Colombia");
INSERT INTO Community(id, name) VALUES(10, "Embera Katío: Jaikerazabi");
INSERT INTO Community(id, name) VALUES(11, "Embera Katío: Choromandó");

/**Clasificación de artesanías**/
INSERT INTO Artisan_classification(id, name) VALUES (0, "Sin definer");
INSERT INTO Artisan_classification(id, name) VALUES (1, "Artesanía indígena");
INSERT INTO Artisan_classification(id, name) VALUES (2, "Artesanía tradicional popular");
INSERT INTO Artisan_classification(id, name) VALUES (3, "Artesanía contemporánea o neoartesanía");


/**Categoría de vestuario**/
INSERT INTO Clothing_category(id, name) VALUES (0, "Sin definer");
INSERT INTO Clothing_category(id, name) VALUES (1, "Suplementos del cuerpo (Que nos envuelven- Adheridos al cuerpo- sostenidos)");
INSERT INTO Clothing_category(id, name) VALUES (2, "Modificaciones del cuerpo (Piel- Pelo- Uñas- SME- Dientes- Aliento)");


/**CATEGORÍAS PATRIMONIALES**/
INSERT INTO Patrimonial_category(id, name) VALUES (0, "Sin definer");
INSERT INTO Patrimonial_category(id, name) VALUES (1, "Patrimonio protegido y regulado (BIC- PCI- PES- etc)");
INSERT INTO Patrimonial_category(id, name) VALUES (2, "Patrimonio como bien de consumo (capital cultural consagrado desde lo económico)");
INSERT INTO Patrimonial_category(id, name) VALUES (3, "Patrimonio como recurso turístico (lugares asociados a actividades únicas)");
INSERT INTO Patrimonial_category(id, name) VALUES (4, "Patrimonio como construcción social (Consenso colectivo propias");
INSERT INTO Patrimonial_category(id, name) VALUES (5, "adaptadas o trasladadas");



/**ARTEFACTOS**/
-- Urabá Antioqueño
-- id, nombre, id_ municipio, id_ comunidad, id_clasificación_artesanal, id_categoría_ropa, id_categoría_patrimonial

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (1, "Artesanías en calceta de plátano ", "Calceta de plátano.", 'Las calcetas de plátano son aquellas estructuras cóncavas en forma de canal que forman las cepas o tallos de la planta, las cuales debidamente extraídas y procesadas, se convierten en la materia prima para las artesanías en la fabricación de productos como "individuales", paneras, cofres, cajas, portarretratos, bolsos, o otras artesanías.', "history", "1", "video", "comments", 114, 9, 0, 1, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (2, "Prendas en saburete y molas", "Popelinas, linos, hilos.",  "Los indígenas tule, conocidos también como cuna, se ubican en el golfo de Urabá, específicamente en los departamentos de Chocó y Antioquia, cerca de Panamá, país donde se asienta la mayoría de su población. Las mujeres tule-cuna adhieren a sus prendas de uso diario, como saburetes o faldas, las molas o textiles con diseños angulares, curvos y geométricos que se logran a  partir de la superposición de telas coloridas.", "history", "2", "video", "comments", 114, 0, 1, 1, 0);

INSERT INTO Artifact(id, name,materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (3, "Prendas en saburete y molas",  "Popelinas, linos, hilos.",  "Los indígenas tule, conocidos también como cuna, se ubican en el golfo de Urabá, específicamente en los departamentos de Chocó y Antioquia, cerca de Panamá, país donde se asienta la mayoría de su población. Las mujeres tule-cuna adhieren a sus prendas de uso diario, como saburetes o faldas, las molas o textiles con diseños angulares, curvos y geométricos que se logran a  partir de la superposición de telas coloridas.", "history", "3", "video", "comments", 111, 0, 1, 1, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (4, "Tejido en chaquira",  "", "history", "4", "video", "comments", 111, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (5, "Accesorios en calceta de plátano", "", "Las calcetas de plátano son aquellas estructuras cóncavas en forma de canal que forman las cepas o tallos de la planta, las cuales debidamente extraídas y procesadas, se convierten en la materia prima para las artesanías en la fabricación de productos como individuales, paneras, cofres, cajas, portarretratos, bolsos, y otras artesanías.", "history", "5", "video", "comments", 105, 0, 2, 1, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (6, "Tejido diagonal", "Oficio: Bisutería, Técnica: Telar, mano alzada, tejido diagonal y sarga, Materia Prima: Chaquiras.", "history", "image", "video", "comments", 107, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (7, "Cestería bijao e iraca", "Iraca, bijao, mimbre, bejuco botré, pitigua y abrazapalo o tripa de pollo.", "La cestería es una labor textil con la cual los artesanos, con destreza y delicadeza, elaboran floreros, canastas, cunas, fruteros, bolsos y sombreros. Esta técnica artesanal ha sido el resultado de una tradición transmitida a través de varias generaciones. Nació por la necesidad que tenían los nómadas de contar con recipientes para la conservación y almacenamiento de alimentos.", "history", "7", "video", "comments", 108, 4, 1, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (8, "Bolsos con zuncho", "Zuncho reciclado de las bananeras.", "Algunos sistemas de tejido artesanal  en nuestros países se han ido transformando. Una de las razones es que los artesanos han emigrado a las ciudades, donde pueden disponer más fácilmente de materiales reciclables y reemplazarlos por las fibras naturales que tradicionalmente han utilizado en sus trabajos por generaciones.  La técnica del tejido en zuncho plástico de embalar es similar a la que utilizan los artesanos para tejer canastos de mimbre, fique u otras fibras naturales.", "history", "8", "video", "comments", 108, 0, 3, 1, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (9, "Tejido en chaquira", "", "history", "9", "video", "comments", 108, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (10, "Artesanías en totumo","Totumo, alambres, picos de loro, cautil, estaño.", "En los departamentos de Córdoba y Sucre, el árbol de totumo crece de manera silvestre y tiene diversos usos: la madera se utiliza para la elaboración de herramientas; la pulpa del fruto sirve de comida para los animales y como ingrediente para preparar un jarabe medicinal; la corteza se transforma en totuma o se talla para crear objetos decorativos.", "history", "10", "video", "comments", 108, 0, 1, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (11, "Bolsos cestería en calceta de plátano", "","La cestería es un oficio artesanal clasificado dentro de la tejeduría. Es un trabajo que consiste en la elaboración de objetos mediante la disposición ordenada y estructurada de material vegetal, en este caso calceta de plátano. El material es sometido previamente a procesos de adecuación, para su conversión en tiras que se aplican según la clase de objetos a elaborar. En la región de Urabá, en los municipios de Turbo y Chigorodó se han identificado varios grupos artesanales que realizan trabajos en cestería en calceta de plátano.", "history", "11", "video", "comments", 108, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (12, "Sombreros en fibra, tipo sombrero vueltiao", "", "", "history", "12", "video", "comments", 113, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (13, "Canastos y esteras con la fibra de la iraca y el borde", "Iraca, bijao, mimbre, bejuco botré, pitigua y abrazapalo o tripa de pollo.", "La cestería es una labor textil con la cual los artesanos, con destreza y delicadeza, elaboran floreros, canastas, cunas, fruteros, bolsos y sombreros. Esta técnica artesanal ha sido el resultado de una tradición transmitida a través de varias generaciones. Nació por la necesidad que tenían los nómadas de contar con recipientes para la conservación y almacenamiento de alimentos.", "history", "13", "video", "comments", 110, 10, 0, 0, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (14, "Artesanías afrocolombianas", "", "history", "image", "video", "comments", 110, 1, 2, 0, 0 );


-- Suroeste Antioqueño

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (15, "Carriel tradicional de 12 bolsillos", "Cuero de becerro, vaqueta de falso y de trasero (o carnaza grabada), vaqueta de talabartería, cueros rojos y amarillos, charol, accesorios, ojaletes, argollas cobrizadas, cierres, hebillas e hilos.","Es una adaptación de una alforja proveniente de España en el año 1885 aproximadamente, se amoldó a la costumbre de la época principalmente para los arrieros, quienes lo acogieron como pieza indispensable de su atuendo; tomó su nombre como un extranjerismo del inglés “Carry All” pues en él los arrieros cargaban de todo. El carriel tradicional cuenta con 12 bolsillos, entre ellos algunos secretos. Con el paso del tiempo el carriel se convirtió en todo un símbolo de herencia y tradición paisa, y es hoy una artesanía comprada por miles de visitantes y propios para llevarse a sus hogares un pedazo de la historia paisa.", "history", "15", "video", "comments", 93, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (16, "Accesorios en chaquiras", "Chaquira checa número 10, Hilo bondeado texturizado calibre 60.", "Con el uso de nylon, chaquiras y agujas, los pueblos indígenas fabrican a mano collares, aretes, brazaletes y otros objetos decorativos para el cuerpo; es una expresión cultural.", "history", "16", "video", "comments", 92, 2, 2, 1, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (17, "Técnica de yoyo-ropa hogar", "", "history", "17", "video", "comments", 92, 3, 2, 2, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (18, "Kipará", "", "history", "18", "video", "comments", 83, 0, 1, 1, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (19, "Tejido en chaquiras","Chaquira checa número 10, Hilo bondeado texturizado calibre 60.", "Con el uso de nylon, chaquiras y agujas, los pueblos indígenas fabrican a mano collares, aretes, brazaletes y otros objetos decorativos para el cuerpo; es una expresión cultural.", "history", "19", "video", "comments", 83, 4, 1, 0, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (20, "Sombrero aguadeño","Filamento Iraca (Carludovica Palmata), cinta negra, tafilete.", "El Sombrero Aguadeño es una artesanía de tipo Sombrero de paja toquilla que se ha convertido en símbolo representativo de la región paisa en Colombia y de tradición. Se teje a mano con Iraca en el municipio de Aguadas, departamento de Caldas. Desde el año 2011 el Sombrero Aguadeño es una denominación de origen protegida en Colombia.", "history", "20", "video", "comments", 85, 0, 0, 0, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (18, "Ruana",  "Lana de oveja.","Fiestas de la ruana encuentro nacional de cuentos, mitos y leyendas. La ruana es un tipo de poncho suelto sin mangas y abierto en su parte central bajo el hueco donde se coloca la cabeza de quien lo viste, en forma de capote fabricado de manera artesanal que se usa encima de otras prendas, el cual tiene forma cuadrada o rectangular y que en el centro posee un agujero para pasar la cabeza. Es originaría de los Andes de Colombia y Venezuela.", "history", "18", "video", "comments", 87, 0, 2, 1, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (21, "Ruana",  "Lana de oveja.","Fiestas de la ruana encuentro nacional de cuentos, mitos y leyendas. La ruana es un tipo de poncho suelto sin mangas y abierto en su parte central bajo el hueco donde se coloca la cabeza de quien lo viste, en forma de capote fabricado de manera artesanal que se usa encima de otras prendas, el cual tiene forma cuadrada o rectangular y que en el centro posee un agujero para pasar la cabeza. Es originaría de los Andes de Colombia y Venezuela.", "history", "21", "video", "comments", 87, 0, 2, 1, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (22, "Atuendo tradicional arriero y atuendo trovador", "", "El traje típico del arriero es pantalón de dril, camisa estampada y pañuelo raboegallo amarrado al cuello. Los accesorios principales son: alpargatas, sombrero, poncho, carriel, machete y mulera. El atuendo característico de los trovadores es muy tradicional a la región antioqueña,  alusivo a sus antecesores arrieros y trovadores de la regiones cafeteras; visten alpargatas fabricadas de cabuya, carriel, poncho o ruana y sombrero, visten los trajes más representativos de esta región del país ya que ellos como trovadores son también representantes culturales de Antioquia.", "history", "22", "video", "comments", 89, 0, 2, 1, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (23, "Atuendo tradicional arriero y vestuario de la mula", "", "Fiestas del Arriero. El traje típico del arriero es pantalón de dril, camisa estampada y pañuelo raboegallo amarrado al cuello. Los accesorios principales son: alpargatas, sombrero, poncho, carriel, machete y mulera.", "history", "23", "video", "comments", 88, 0, 2, 0, 0);

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (24, "Vestuario indígena Emberá, vestidos, collares, pintura corporal, El costurero retazos, Colcha de retazos", "", "history", "image", "video", "comments", 102, 0, 0, 0, 0);

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (25, "Traje de chapolera desde lo tradicional/ desde lo actual gorra (sombrero, pañoleta), botas de caucho, manga larga", "", "history", "image", "video", "comments", 90, 0, 2, 1, 0);

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (26, "Joyería en filigrana en oro y plata", "", "history", "26", "video", "comments", 56, 0, 2, 1, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (27, "Máscaras y vestuarios performático", "Fiesta de los diablitos", "history", "27", "video", "comments", 56, 0, 2, 1, 5 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (28, "Sombrero aguadeño", "Filamento Iraca (Carludovica Palmata), cinta negra, tafilete.", "Sombrero de paja toquilla o iraca El Sombrero Aguadeño es una artesanía de tipo Sombrero de paja toquilla que se ha convertido en símbolo representativo de la región paisa en Colombia y de tradición. Se teje a mano con Iraca en el municipio de Aguadas, departamento de Caldas. Desde el año 2011 el Sombrero Aguadeño es una denominación de origen protegida en Colombia.", "history", "28", "video", "comments", 57, 0, 2, 1, 3 );


--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (29, "Artesanías en barro Vereda Untí", "", "history", "image", "video", "comments", 43, 0, 2, 0, 0 );


INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (30, "Cestería en  bijao e iraca", "Iraca, bijao, mimbre, bejuco botré, pitigua y abrazapalo o tripa de pollo.", "La cestería es una labor textil con la cual los artesanos, con destreza y delicadeza, elaboran floreros, canastas, cunas, fruteros, bolsos y sombreros. Esta técnica artesanal ha sido el resultado de una tradición transmitida a través de varias generaciones. Nació por la necesidad que tenían los nómadas de contar con recipientes para la conservación y almacenamiento de alimentos.", "history", "30", "video", "comments", 46, 11, 0, 0, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (31, "Costura, bordado, tejido", "", "history", "31", "video", "comments", 48, 0, 2, 1, 0 );


--Norte Antioqueño

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (32, "Atuendo tradicional arriero y atuendo trovador", "", "El traje típico del arriero es pantalón de dril, camisa estampada y pañuelo raboegallo amarrado al cuello. Los accesorios principales son: alpargatas, sombrero, poncho, carriel, machete y mulera. El atuendo característico de los trovadores es muy tradicional a la región antioqueña,  alusivo a sus antecesores arrieros y trovadores de la regiones cafeteras; visten alpargatas fabricadas de cabuya, carriel, poncho o ruana y sombrero, visten los trajes más representativos de esta región del país ya que ellos como trovadores son también representantes culturales de Antioquia.", "history", "32", "video", "comments", 28, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (33, "Ruana",  "Lana de oveja.","Fiestas de la ruana encuentro nacional de cuentos, mitos y leyendas. La ruana es un tipo de poncho suelto sin mangas y abierto en su parte central bajo el hueco donde se coloca la cabeza de quien lo viste, en forma de capote fabricado de manera artesanal que se usa encima de otras prendas, el cual tiene forma cuadrada o rectangular y que en el centro posee un agujero para pasar la cabeza. Es originaría de los Andes de Colombia y Venezuela.", "history", "18", "video", "comments", 39, 0, 2, 1, 0);

--valle de aburra
--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (33, "Ropa afro coloridas con música", "", "history", "33", "video", "comments", 121, 6, 2, 0, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (31, "Atuendo tradicional arriero y atuendo trovador", "", "El traje típico del arriero es pantalón de dril, camisa estampada y pañuelo raboegallo amarrado al cuello. Los accesorios principales son: alpargatas, sombrero, poncho, carriel, machete y mulera. El atuendo característico de los trovadores es muy tradicional a la región antioqueña,  alusivo a sus antecesores arrieros y trovadores de la regiones cafeteras; visten alpargatas fabricadas de cabuya, carriel, poncho o ruana y sombrero, visten los trajes más representativos de esta región del país ya que ellos como trovadores son también representantes culturales de Antioquia.", "history", "32", "video", "comments", 124, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (34, "Muleras, Atuendo tradicional", "Algodón.","En Colombia, se conocen tres términos: Ruana, cuando es de lana y sirve para proteger del frío y poncho o mulera, cuando es de algodón y que usan los campesinos con preferencia en las zonas de Antioquia, Caldas y Boyacá, para protegerse del frío o del sol, para limpiarse el sudor, para espantar los insectos, para ponerla de almohada o de tendido en el suelo. Es multiuso.", "history", "34", "video", "comments", 124, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (35, "Peinados afro", "", "", "history", "35", "video", "comments", 124, 0, 0, 0, 0 );



-- Bajo Cauca
INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (36, "Joyería en filigrana", "Oro o plata, y cobre (Endurecedor).", "Semana cultural del oro. En El Bagre, para la joyería el proceso de diseño se viene manejando de acuerdo al mercado y a la necesidad del cliente. En algunos casos los joyeros diseñan sus propias piezas, especialmente para las joyas de filigrana. Los dibujos previos se hacen en el momento del encargo para acordar con el cliente las características de la pieza. En la elaboración de la joyería de El Bagre las materias primas utilizadas son el oro y la plata y el cobre como metal de aleación. Usualmente se emplea oro de aluvión extraído en la región, el cual tiene una ley que oscila entre 920 y 940, y se adquiere comprándole a los mineros. También se trabaja la plata que se compra en Medellín.", "history", "36", "video", "comments", 3, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (37, "Cañaflecha", "Fibra vegetal tomada de la planta Gynerium.", "Fibra vegetal tomada de la planta Gynerium.De la palma de caña flecha, se extrae la fibra vegetal con la que los Zenú elaboran diferentes productos bajo el oficio de la tejeduría. Esta materia prima. propia de su región (departamentos de Córdoba y Sucre). crece  en zonas húmedas y pantanosas. Además de crear artesanías con ella, esta comunidad también utiliza la caña flecha para construir sus casas y elaborar las canas de pescar. Razón por la cual, algunos investigadores le atribuyen el nombre de flecha.", "history", "37", "video", "comments", 5, 7, 2, 1, 1 );



--Magdalena Medio
INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (38, "Atuendo del pescador cotidiano (desde lo prosaico) Atarraya",  "", "Noche de los poetas, danzas y música folclórica, La atarraya es un tipo de red de pesca que se lanza a mano. Es común en muchos parajes y recibe nombres como tarraya. atarraya. rallo o rail. Los pescadores de los ríos frecuentemente lo usan por su cómoda figura y su facilidad de manejo en las orillas del agua. por tanto, se utiliza a pie(descalzandose) o bien, con embarcación. El pescador cotidiano utiliza pantalones. camiseta y chanclas para realizar este oficio.", "history", "38", "video", "comments", 9, 0, 2, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (58, "Fiesta del Retorno.", "", "Feria y fiestas del retorno y reinado de la ecología los cuales homenajean su gente al compromiso y amor profundo por sus raíces conectados como lo es al Río Magdalena, tierra de grandes, si de Pescadores. Entre sus actividades se incluyen conciertos, Festival de ajedrez, Concursos, Festival de la canción, Fiesta ochentera, Festival danzas pitos y tambores, Emprendimientos, Exhibición equina, Feria gastronómica, Fiesta del pescador artesanal, Concursos de mascotas y más.", "history", "58", "video", "comments", 9, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (59, "Desfile de balleneros.", "", "Gutierrez Yojan adaptado de nexdu.com. En el corregimiento de La Pesca renació la tradición. Así vivimos nuestro espectacular desfile de balleneras en estás XLI Fiestas Turísticas del San Juan y San Pedro 2022. Feria y fiestas del retorno y reinado de la ecología los cuales homenajean su gente al compromiso y amor profundo por sus raíces conectados como lo es al Río Magdalena, tierra de grandes, si de Pescadores. Entre sus actividades se incluyen conciertos, Festival de ajedrez, Concursos, Festival de la canción, Fiesta ochentera, Festival danzas pitos y tambores, Emprendimientos, Exhibición equina, Feria gastronómica, Fiesta del pescador artesanal, Concursos de mascotas y más.", "history", "59", "video", "comments", 10, 0, 0, 0, 0 );



-- Nordeste Antioqueño

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (39, "Pañolones, mantillas, mantones", "", "Semana Santa en vivo, Reinado del oro y la minería.", "history", "39", "video", "comments", 14, 0, 2, 2, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (40, "Pañolones, mantillas, mantones", "", "Semana Santa en vivo, Reinado del oro y la minería.", "history", "40", "video", "comments", 16, 0, 2, 2, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (41, "bisutería con alusión al tigre","", "Amalfi es reconocido por ser ‘LA Tierra del Tigre’, debido a la historia del ‘Tigre de Amalfi’ y el uso tradicional y cultural de la bicicleta como medio de transporte. El parque principal del municipio cuenta con monumentos al tigre.", "history", "41", "video", "comments", 13, 8, 3, 0, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (50, "Pantalones coje puerco", "", "Pantalón largo que es doblado en la bota hasta media pierna. En un principio inició su uso en las labores del campo. en las cocheras de cerdos, para no llenar de lodo los pantalones se doblaban a la media pierna, por eso rozan todo el nombre ‘pantalon cogepuerco’.Autor Gutierroz Yojan. adaptado de Arriero. 1894(Fotografía de Meliton Rodrigez tomado de: German Ferro. A lomo de mula. Bancafe, Bogotá, 1994).", "history", "50", "video", "comentarios", 22, 0, 2, 2, 0 );


-- Oriente Antioquenio
INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (42, "Taller de artesanías, en telares (producción en lana)",  "Lana virgen, Crin de caballo, Cabuya.", "La Asociación de Artesanas Telares Santa María, trabaja con el Telar manual de 2 maneras, vertical y horizontal. En el telar horizontal se trabajan los tejidos planos y delgados, como el tejido de los ponchos, muleras, cojines, bufandas, individuales, caminos de mesa y ruanas. Usando el telar horizontal la tijera y el metro. En el telar vertical se trabaja con el tapete grueso para el piso, se hacen los murales para la pared, pie de cama, tapete plano y tapetes trenzados. Usando el telar vertical, la tijera, el peine, y el metro.", "history", "42", "video", "comments", 64, 0, 2, 1, 4 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (43, "Bisutería en cerámica",  "Arcillas, Caolines, Feldespato, Cuarzo y carbonato de calcio.", "A principios del siglo XX, El Carmen de Viboral se convirtió en el hogar de los mejores ceramistas del país. En la publicación El Carmen de Viboral: el jardín llevado a la loza, del Mincultura (2014), se explica que don Eliseo Pareja fue el primero de ellos que se instaló allí en 1898 y tras él fueron llegando otros más. Fue tanto el auge que en 1945 en el municipio se fundó la Escuela Nacional de Cerámica Jorge Eliécer Gaitán. En el Carmen de Viboral además de vajillas, se realizan accesorios artesanales en cerámica pintados a mano, se pueden encontrar aretes, collares y anillos.", "history", "43", "video", "comments", 64, 0, 3, 1, 2 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (44, "Ruana Perrileña", "", "La vereda Perrillo en Sonsón fue por mucho tiempo el hogar de un puñado de familias campesinas  fabricantes de ruanas. Aquellos criaban ovejas y otros cortaban su lana, allí fabricaban el hilo, pero todos hacían ruanas. La Ruana Perrileña es una ruana de lana de ovejo, con los grumos, sin tratar, lana virgen; una ruana pesada, buena para el frío y muy utilizada en las montañas del Páramo de Sonsón y los pueblos cercanos. La comunidad de Perrillo fue reconocida en todo el suroriente antioqueño por la calidad de sus ruanas. Durante casi 100 años, en todo lo que fue el siglo XX, se fabricaron estas ruanas en comunidad, la economía de la vereda Perrillo dependía en gran parte de ello.", "history", "44", "video", "comments", 81, 0, 0, 1, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (45, "Sombrero aguadeño", "Filamento Iraca (Carludovica Palmata), cinta negra, tafilete.", "Sombrero de paja toquilla o iraca El Sombrero Aguadeño es una artesanía de tipo Sombrero de paja toquilla que se ha convertido en símbolo representativo de la región paisa en Colombia y de tradición. Se teje a mano con Iraca en el municipio de Aguadas, departamento de Caldas. Desde el año 2011 el Sombrero Aguadeño es una denominación de origen protegida en Colombia.","history", "20", "video", "comments", 81, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (56, "Festival de Teatro Municipal y regional", "", "El festival de teatro municipal que cuenta con versiones y representaciones, infantil, juvenil y de mayores, festival que  regocija a tanta gente, que une a directores muy jóvenes, con experimentados, que descubre a nuevos libretistas y mantiene presente a los versados dramaturgos; un festival que descubre cada año a muchos y mejores actores y actrices, dispuestos a dar lo mejor de sí poniendo en los escenarios la estética y la cultura de un pueblo, el cual se resiste a desaparecer y combate el letargo, el miedo y el dolor; de esta manera, se ofrece, el festival, como una alternativa que rescata a través del espectacular evento del teatro: La vida, la alegría y la esperanza.", "history", "56", "video", "comments", 22, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (57, "Fiestas del Marquesado y la Molienda en Yolombó.", "", "Generalmente se realiza del jueves al lunes durante la segunda semana del mes de enero de cada año y en este se pueden encontrar diferentes actividades culturales y recreativas. En este evento contiene varias actividades como lo son un reinado popular, cabalgatas, conciertos, carreras de caballos y más.", "history", "57", "video", "comments", 22, 0, 0, 0, 0 );

-- Sin ubicación
-- id, nombre, id_ municipio, id_ comunidad, id_clasificación_artesanal, id_categoría_ropa, id_categoría_patrimonial

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (46, "Atuendo tradicional arriero y atuendo trovador.","", "El traje típico del arriero es pantalón de dril, camisa estampada y pañuelo raboegallo amarrado al cuello. Los accesorios principales son: alpargatas, sombrero, poncho, carriel, machete y mulera. El atuendo característico de los trovadores es muy tradicional a la región antioqueña,  alusivo a sus antecesores arrieros y trovadores de la regiones cafeteras; visten alpargatas fabricadas de cabuya, carriel, poncho o ruana y sombrero, visten los trajes más representativos de esta región del país ya que ellos como trovadores son también representantes culturales de Antioquia.", "history", "23", "video", "comments", 0, 0, 2, 0, 0);

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (47, "Alpargatas o cotizas","Para la suela: Fique. Para la capellada: Algodón, hilaza o cuero.", "La alpargata o esparteña es un tipo de calzado de hilado de fibras naturales como el algodón, pieles de animal, mimbre o lona con suela de esparto, fique o cáñamo, o una mezcla de yute y caranday (en Argentina), esparto (en España y otros países), que se asegura por simple ajuste, un trozo de elástico cosido a la tela o con cintas. Se utiliza principalmente en España, el sur de Francia y varias zonas de América. En Colombia es parte de la indumentaria de la mayoría de los trajes típicos, siendo, en algunos casos, de fique o cocuiza y en otros de cuero. Los habitantes de la cuenca del río Orinoco las fabrican también en piel de animal y las llaman 'cotizas' o cocuizas.", "history", "47", "video", "comments", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (54, "Jíquera", "Cabuya, fique, cáñamo o en la contemporáneidad fibra plástica.", "Es un accesorio generalmente tejido en cabuya o cáñamo grueso. Se hace de diferentes tamaños y es usada para guardar y transportar elementos desde mercado hasta pequeños accesorios de uso cotidiano. Las jíqueras generalmente son realizadas en malla o crochet.", "history", "54", "video", "comentarios", 0, 0, 0, 0, 0 );

INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
VALUES (55, "Rosario y Camándula", "Alambre, pepas, cruces.", "El rosario es un rezo tradicional católico que conmemora veinte «misterios» de la vida de Jesucristo y de la Virgen María, recitando después de cada uno de ellos un Padre nuestro, diez Ave Marías y un Gloria. Es frecuentemente designado como Santo Rosario por los católicos. También se llama «rosario» a la sarta de cuentas que se utiliza para rezar el rosario. Las cuentas están separadas cada diez por otras de distinto tamaño y la sarta está unida por sus dos extremos a una cruz. Rosario de cuentas de madera.", "history", "55", "video", "comentarios", 0, 0, 0, 0, 0 );


--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (48, "Poncho", "", "history", "48", "video", "comments", 0, 0, 2, 1, 3 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (49, "Pañolones, mantillas, mantones", "", "history", "49", "video", "comentarios", 0, 0, 0, 0, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (51, "La mulera", "", "history", "51", "video", "comentarios", 0, 0, 0, 0, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (52, "El chingue o el camisón", "", "history", "image", "video", "comentarios", 0, 0, 0, 0, 0 );

--INSERT INTO Artifact(id, name, materials, description, history, image, video, comments, id_municipality, id_community, id_artisan_classification, id_clothing_category, id_patrimonial_category )
--VALUES (53, "Carriel femenino", "", "history", "image", "video", "comentarios", 0, 0, 0, 0, 0 );


--Consultas

--SELECT * from Department;

--SELECT * from Subregions;

--SELECT * from Municipality;

--SELECT * from Community;

--SELECT * from Artisan_classification;

--SELECT * from Clothing_category;

-- SELECT * from Patrimonial_category;

-- SELECT * from Artifact;


--SELECT * from Municipality m

--select *
--FROM Artifact a inner join Municipality m on a.id_municipality = m.id



--select a.id, a.name, a.image, a.id_municipality, m.name, m.id_subregions
--FROM Artifact a inner join Municipality m on a.id_municipality = m.id WHERE m.id_subregions = "8"

--select COUNT(*) FROM Artifact a inner join Municipality m on a.id_municipality = m.id WHERE m.id_subregions = "8"


