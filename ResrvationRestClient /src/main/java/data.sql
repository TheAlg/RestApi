create table chambre;
create table adress;
create table hotel;


-- chambres
insert into chambre(category, Nbplace , price)
values ("sweet", 6, 1000 );
insert into chambre(category, Nbplace , price)
values("studio", 3, 200 );
insert into chambre(category, Nbplace , price)
values ("Appartement", 9, 700 );
insert into chambre(category, Nbplace , price)
values("villa", 8, 1200 );
insert into chambre(category, Nbplace , price)
values("chambre", 2, 500);
-- Adresses
insert into Adress(country, city, StreetNumber, StreetName, GPS)
values ("France", "Montpellier", 14, "Boulevard Jourdan", "GPS" );
insert into Adress(country, city, StreetNumber, StreetName, GPS)
values ("France", "Paris", 12, "Avenue Panorama", "GPS" );
insert into Adress(country, city, StreetNumber, StreetName, GPS)
values ("Maroc", "Marrakech", 2, "Rte Casablanca", "GPS" );
insert into Adress(country, city, StreetNumber, StreetName, GPS)
values ("France", "Paris", 35, "Quartier des boucher", "GPS" );
insert into Adress(country, city, StreetNumber, StreetName, GPS)
values ("Maroc", "Rabat", 178, "Rte ElJadida", "GPS" );

-- Hotel

insert into Hotel(name, adress, stars)
values("Sangho",
	(select city from Adress where city = 'Montpellier'),4);
insert into Hotel(name, adress, stars)
values("Mazagan",
	(select city from Adress where city = 'Montpellier'), 2);
insert into Hotel(name, adress, stars)
values("Merzouga",
	(select city from Adress where city = 'Montpellier'),
    3);
insert into Hotel(name, adress, stars)
values("Eljazira",
	(select city from Adress where city = 'Montpellier'),
    4);
insert into Hotel(name, adress, stars)
values("Ibis",
	(select city from Adress where city = 'Montpellier'),
    4);

