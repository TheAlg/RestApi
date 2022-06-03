-- spring.jpa.defer-datasource-initialization=true

-- create table chambre ;
-- create table adress ;
-- create table Hotel ;

--agencies
insert into agency(name,description)
values('BasicAgency','This is a basic agency.');
insert into agency(name,description)
values('DeluxeAgency','This is a deluxe agency.');
insert into agency(name,description)
values('SecondBasicAgency','this is a secondary basic agency');

-- Adresses
insert into Adress(country, city, street_number, street_name, GPS)
values ('France', 'Montpellier', 14, 'Boulevard Jourdan', 'GPS' );
insert into Adress(country, city, street_number, street_name, GPS)
values ('France', 'Paris', 12, 'Avenue Panorama', 'GPS' );
insert into Adress(country, city, street_number, street_name, GPS)
values ('France', 'Paris', 2, 'Rte de nimes', 'GPS' );
insert into Adress(country, city, street_number, street_name, GPS)
values ('France', 'Paris', 35, 'Quartier des boucher', 'GPS' );
insert into Adress(country, city, street_number, street_name, GPS)
values ('Maroc', 'Rabat', 178, 'Rte ElJadida', 'GPS' );

-- Hotel
insert into Hotel(name, adress_ID, stars, agency_id)
values('Sangho',1,4, 1);
insert into Hotel(name, adress_ID, stars, agency_id)
values('Mazagan',2, 2, 1);
insert into Hotel(name, adress_ID, stars, agency_id)
values('Merzouga',3, 3, 2);
insert into Hotel(name, adress_ID, stars, agency_id)
values('Eljazira',4,4, 2);
insert into Hotel(name, adress_ID, stars, agency_id)
values('Ibis',5,4, 3);

-- chambres

--hotel1
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('sweet', 9, 2000,'"/image/1.jpeg"', 1  );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('studio', 3, 300,'"/image/2.jpeg"', 2 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('Appartement', 9, 700, '/image/3.jpeg"', 1 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('villa', 15, 1200 , '"/image/4.jpeg"', 2);
insert into chambre(category, Nbplace , price, image, hotel_id)
values('chalé', 2, 500, '"/image/5.jpeg"', 1);

--hotel2
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('sweet', 6, 1000,'"/image/1.jpeg"', 2 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('studio', 3, 200, '"/image/2.jpeg"',3);
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('Appartement', 9, 700,'"/image/3.jpeg"', 2 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('villa', 8, 1200 , '"/image/4.jpeg"',1);
insert into chambre(category, Nbplace , price, image, hotel_id)
values('chalé', 7, 500, '"/image/5.jpeg"',2);

--hotel3
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('sweet', 6, 1000, '"/image/1.jpeg"',3 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('studio', 3, 200, '"/image/1.jpeg"',5);
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('Appartement', 10, 700,'"/image/1.jpeg"', 4 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('villa', 8, 1200 , '"/image/1.jpeg"',3);
insert into chambre(category, Nbplace , price, image, hotel_id)
values('chambre', 2, 500, '"/image/1.jpeg"',3);

--hotel4
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('sweet', 6, 1000,'"/image/1.jpeg"',4 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('studio', 3, 200, '"/image/2.jpeg"',4);
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('Appartement', 9, 700,'"/image/3.jpeg', 4 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('villa', 8, 1200 , '"/image/4.jpeg"',4);
insert into chambre(category, Nbplace , price, image, hotel_id)
values('chambre', 2, 500, '"/image/5.jpeg"', 4);

--hotel5
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('sweet', 6, 1000, '"/image/1.jpeg"',5 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('studio', 3, 200, '"/image/2.jpeg"',4);
insert into chambre(category, Nbplace , price, image, hotel_id)
values ('Appartement', 10, 1700, '"/image/3.jpeg',5 );
insert into chambre(category, Nbplace , price, image, hotel_id)
values('villa', 8, 11200 , '"/image/4.jpeg"',4);
insert into chambre(category, Nbplace , price, image, hotel_id)
values('chambre', 2, 500, '"/image/5.jpeg"',4);
