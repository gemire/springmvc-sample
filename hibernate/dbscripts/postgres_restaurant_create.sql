-- postgres restaurant and reviews loading script
DROP TABLE IF EXISTS restaurant CASCADE;
CREATE TABLE restaurant (
        id SERIAL PRIMARY KEY,
        name  CHAR(255),
        version  INT,
        zip_code  CHAR(10),
        city  CHAR(255),
        state  CHAR(255) 
    );
DROP TABLE IF EXISTS reviews CASCADE;	
CREATE TABLE reviews (
	id SERIAL PRIMARY KEY,
	reviewListing CHAR(255),
	stampDate timestamp,
	startRating INT,
	restaurant_id INT

);


insert into restaurant (name, city, state, zip_code, version) values('Subway', 'Plymouth', 'WI', '53073', 1);
insert into restaurant (name, city, state, zip_code, version) values('Boston Market', 'Gaithersburg', 'MD', '20877', 1);
insert into restaurant (name, city, state, zip_code, version) values('Subway Subs', 'Santa Teresa', 'NM', '88008', 1);
insert into restaurant (name, city, state, zip_code, version) values('Arby''s Roast Beef Restaurant', 'Klamath Falls', 'OR', '97603', 1);
insert into restaurant (name, city, state, zip_code, version) values('Bellefleur Winery & Restaurant', 'Carlsbad', 'CA', '92008', 1);
insert into restaurant (name, city, state, zip_code, version) values('Huddle House', 'Calhoun', 'GA', '30701', 1);
insert into restaurant (name, city, state, zip_code, version) values('John Browne''s Pub & Eatery', 'Indianapolis', 'IN', '46235', 1);
insert into restaurant (name, city, state, zip_code, version) values('Ling''s Express', 'Milwaukee', 'WI', '53217', 1);
insert into restaurant (name, city, state, zip_code, version) values('Chubys''s', 'Odell', 'OR', '97044', 1);
insert into restaurant (name, city, state, zip_code, version) values('Bojangles', 'Columbia', 'SC', '29203', 1);
insert into restaurant (name, city, state, zip_code, version) values('NPC International', 'Memphis', 'TN', '38134', 1);
insert into restaurant (name, city, state, zip_code, version) values('Pancake Cafe', 'Naperville', 'IL', '60540', 1);
insert into restaurant (name, city, state, zip_code, version) values('Hong & Kong Restaurant', 'Chelmsford', 'MA', '01824', 1);
insert into restaurant (name, city, state, zip_code, version) values('The Chicken Cooperative', 'Ketchum', 'OK', '74349', 1);
insert into restaurant (name, city, state, zip_code, version) values('Subway', 'Lonoke', 'AR', '72086', 1);
insert into restaurant (name, city, state, zip_code, version) values('Domino''s Pizza', 'Loveland', 'CO', '80537', 1);
insert into restaurant (name, city, state, zip_code, version) values('Carl''s Jr', 'Peoria', 'IL', '61615', 1);
insert into restaurant (name, city, state, zip_code, version) values('El Toro Bar & Grill', 'Shawnee', 'KS', '66216', 1);
insert into restaurant (name, city, state, zip_code, version) values('Subway Sandwiches & Salads', 'New Orleans', 'LA', '70123', 1);
insert into restaurant (name, city, state, zip_code, version) values('Subway', 'Decatur', 'GA', '30030', 1);
insert into restaurant (name, city, state, zip_code, version) values('Arby''s', 'Indianapolis', 'IN', '46268', 1);
insert into restaurant (name, city, state, zip_code, version) values('China King', 'Cedar Rapids', 'IA', '52404', 1);
insert into restaurant (name, city, state, zip_code, version) values('Subway Sandwiches & Salads', 'Knoxville', 'TN', '37924', 1);
insert into restaurant (name, city, state, zip_code, version) values('Luciano Italian Restaurant', 'Oakton', 'VA', '22124', 1);
insert into restaurant (name, city, state, zip_code, version) values('Fruition', 'Portland', 'OR', '97210', 1);
insert into restaurant (name, city, state, zip_code, version) values('Blough''s Delicatessen', 'Davidsville', 'PA', '15928', 1);
insert into restaurant (name, city, state, zip_code, version) values('Hardee''s of Murfreesboro No 4', 'Murfreesboro', 'TN', '37128', 1);
insert into restaurant (name, city, state, zip_code, version) values('Dairy Queen restaurant ', 'Carter Lake', 'IA', '51510', 1);
insert into restaurant (name, city, state, zip_code, version) values('Imperial Wok Chinese Restaurant', 'Shreveport', 'LA', '71118', 1);
insert into restaurant (name, city, state, zip_code, version) values('Hardee''s', 'Waldorf', 'MD', '20601', 1);
insert into restaurant (name, city, state, zip_code, version) values('Cinnabon', 'Gainesville', 'FL', '32605', 1);
insert into restaurant (name, city, state, zip_code, version) values('Angle Inn Restaurant', 'Rockford', 'IL', '61103', 1);
insert into restaurant (name, city, state, zip_code, version) values('Casey''s Carry Out Pizza', 'Thomson', 'IL', '61285', 1);
insert into restaurant (name, city, state, zip_code, version) values('Sonic Drive In', 'Salt Lake City', 'UT', '84118', 1);
insert into restaurant (name, city, state, zip_code, version) values('Mcdonald''s restaurant ', 'Racine', 'WI', '53406', 1);
insert into restaurant (name, city, state, zip_code, version) values('Huhot Mongolian Grill', 'Omaha', 'NE', '68154', 1);
insert into restaurant (name, city, state, zip_code, version) values('Giovanni''s Pizzeria', 'Las Vegas', 'NV', '89123', 1);
insert into restaurant (name, city, state, zip_code, version) values('Bangkok Royal', 'Waco', 'TX', '76706', 1);
insert into restaurant (name, city, state, zip_code, version) values('Golden Coin Bake Shop & Restaurant', 'Waipahu', 'HI', '96797', 1);
insert into restaurant (name, city, state, zip_code, version) values('Cristaudo''s Grand Avenue', 'Carbondale', 'IL', '62901', 1);
insert into restaurant (name, city, state, zip_code, version) values('O''Charley''s Restaurant', 'Independence', 'MO', '64057', 1);
insert into restaurant (name, city, state, zip_code, version) values('A1 Ocean Cafe', 'San Francisco', 'CA', '94104', 1);
insert into restaurant (name, city, state, zip_code, version) values('Alberto''s Mexican Food', 'Corona', 'CA', '92880', 1);
insert into restaurant (name, city, state, zip_code, version) values('Beach Dog Computer Center', 'Hilo', 'HI', '96720', 1);
insert into restaurant (name, city, state, zip_code, version) values('Burger King', 'Houston', 'TX', '77070', 1);
insert into restaurant (name, city, state, zip_code, version) values('Fox River Brew Pub', 'Oshkosh', 'WI', '54901', 1);
insert into restaurant (name, city, state, zip_code, version) values('Buffas Delicatessen', 'New York', 'NY', '10012', 1);
insert into restaurant (name, city, state, zip_code, version) values('Maria''s Mexican Bistro Inc', 'Brooklyn', 'NY', '11215', 1);
insert into restaurant (name, city, state, zip_code, version) values('Sue''s Restaurant', 'Providence', 'RI', '02903', 1);
insert into restaurant (name, city, state, zip_code, version) values('Dairy Queen Brazier', 'Cameron', 'MO', '64429', 1);
	
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 5, 1);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 2, 1);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 2, 1);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 5, 2);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Mediocre soups and disgusting desserts', '2015-02-03 11:54:38.318', 6, 2);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 5, 2);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 1, 3);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 6, 4);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 8, 5);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 3, 6);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 4, 6);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 2, 7);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 1, 8);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 6, 8);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 4, 8);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 6, 9);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 7, 9);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 6, 9);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 5, 9);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 4, 10);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 7, 10);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 3, 10);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 5, 10);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 1, 11);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 2, 12);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 1, 12);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 1, 12);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 4, 12);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 5, 13);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 5, 13);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 3, 13);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 1, 14);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 4, 15);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 2, 16);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 7, 16);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 2, 16);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 4, 16);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 4, 17);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 2, 17);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 7, 17);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 1, 18);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 4, 18);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 2, 19);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 5, 19);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 2, 20);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 1, 20);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 6, 21);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 5, 22);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 8, 23);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 8, 24);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 1, 24);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 4, 24);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 7, 24);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Mediocre soups and disgusting desserts', '2015-02-03 11:54:38.318', 8, 25);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 4, 25);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Mediocre soups and disgusting desserts', '2015-02-03 11:54:38.318', 6, 26);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 3, 26);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 4, 26);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 3, 26);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 3, 27);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 1, 27);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 8, 27);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 1, 27);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 6, 28);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 1, 29);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 2, 29);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Mediocre soups and disgusting desserts', '2015-02-03 11:54:38.318', 5, 29);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 1, 30);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 1, 31);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 4, 31);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 5, 32);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 3, 32);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 8, 32);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Mediocre soups and disgusting desserts', '2015-02-03 11:54:38.318', 8, 32);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 1, 33);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 7, 33);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 7, 33);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 6, 34);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Mediocre soups and disgusting desserts', '2015-02-03 11:54:38.318', 1, 34);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 3, 34);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 1, 34);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 2, 35);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 2, 36);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 5, 36);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 3, 36);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 4, 36);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 2, 37);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 6, 37);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 1, 37);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 2, 37);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 2, 38);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 4, 38);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 6, 38);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 6, 39);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 2, 39);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 2, 39);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 6, 39);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 1, 40);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Get a job, instead of eating here!', '2015-02-03 11:54:38.318', 8, 40);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 7, 41);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 6, 41);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 5, 42);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 6, 42);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 4, 42);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 2, 42);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 6, 43);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 7, 43);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 7, 43);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 7, 43);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Can you say "gastric bypass"?', '2015-02-03 11:54:38.318', 1, 44);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 3, 44);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 3, 44);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 5, 45);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 4, 45);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 5, 46);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 6, 46);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 5, 47);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 6, 47);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A real gas', '2015-02-03 11:54:38.318', 3, 48);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 4, 49);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 5, 49);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Impeccable service!', '2015-02-03 11:54:38.318', 7, 49);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('A root canal would be better', '2015-02-03 11:54:38.318', 3, 49);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('Consider suicide first', '2015-02-03 11:54:38.318', 7, 50);
	INSERT INTO "public".reviews (reviewlisting, stampdate, startrating, restaurant_id) VALUES ('You don''t know what you are missing', '2015-02-03 11:54:38.318', 8, 50);
	
	
	ALTER TABLE   reviews ADD CONSTRAINT   reviews_fk  FOREIGN KEY ( restaurant_id ) REFERENCES   restaurant  ( id );
	
	
	