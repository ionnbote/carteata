INSERT INTO carteata.user VALUES (1,'Cihan-Catarau','Svetlana','cihansvetlana@gmail.com','sveta.11');
commit;
INSERT INTO carteata.user VALUES (2,'Catarau','Vadim','vadikatarau@yahoo.com','vadim.12');
commit;
INSERT INTO carteata.user VALUES (3,'Botezatu','Ion','ionbotezatu@gmail.com','ionbotezatu');
commit;
INSERT INTO carteata.user VALUES (4,'Botezatu','Nadejda','nadeabotezatu@gmail.com','nadeabotezatu');
commit;
INSERT INTO carteata.user VALUES (5,'Botezatu','Marius','bmariusotezatu@gmail.com','mariusbotezatu1');
commit;
INSERT INTO carteata.user VALUES (6,'Cihan','Maria','cihanmaria@gmail.com','mariacihan18');
commit;
INSERT INTO carteata.user VALUES (7,'Fotescu','Ecaterina','ecaterinafotescu@gmail.com','fotescu1998');
commit;
INSERT INTO carteata.user VALUES (9,'Bodrug','Daniela','danielabodrug@gmail.com','daniela26');
commit;
INSERT INTO carteata.user VALUES (10,'Moscaliuc','Vasile','vasilemoscaliuc@gmail.com','stefania26');
commit;

INSERT INTO carteata.book VALUES (1,"Retete pentru pofticiosi.jpg","Retete pentru pofticiosi",2,"For You",2002,226,"Belistrica",562172);
commit;
INSERT INTO carteata.book VALUES (2,"un om fericit.jpg","Un om fericit",1,"Art",2022,240,"Belistrica",704440);
commit;
INSERT INTO carteata.book VALUES (3,"1001 de carti.jpg","1001 de carti",3,"RAO",2016,223,"Belistrica",521856);
commit;
INSERT INTO carteata.book VALUES (4,"Ghidul unei familii durabile_.jpg","Ghidul unei familii durabile",4,"Curtea Veche",2022,272,"Belistrica",687000);
commit;
INSERT INTO carteata.book VALUES (5,"Abecedarul egalitatii.jpg","Abecedarul egalitatii",5,"Bons Offices",2022,114,"Carti pentru copii",705750);
commit;
INSERT INTO carteata.book VALUES (6,"abecedarul amuzant.jpg","Abecedarul amuzant",6,"Bons Offices",2022,127,"Carti pentru copii",704769);
commit;
INSERT INTO carteata.book VALUES (7,"Hotul de carti.jpg","Hotul de carti",7,"RAO",2011,568,"Belistrica",381756);
commit;
INSERT INTO carteata.book VALUES (8,"Omul in epoca inteligentei artificiale.jpg","Omul in epoca inteligentei artificiale",8,"Corint",2021,352,"Belistrica",682413);
commit;
INSERT INTO carteata.book VALUES (9,"Portretul lui Dorian Gray.jpg","Portretul lui Dorian Gray",9,"Humanitas",2021,296,"Belistrica",665556);
commit;
INSERT INTO carteata.book VALUES (10,"Totul incepe cu noi.jpg","Totul incepe cu noi",10,"Epica",2023,368,"Belistrica",708390);
commit;


INSERT INTO carteata.author VALUES (1,'Kay','Jim',48,'Northamptonshire');
commit;
INSERT INTO carteata.author VALUES (2,'Turcan','Valeria',29,'Chisinau');
commit;
INSERT INTO carteata.author VALUES (3,'Boxall','Peter',83,'Marea Britanie');
commit;
INSERT INTO carteata.author VALUES (4,'Chapman','Gary',85,'SUA');
commit;
INSERT INTO carteata.author VALUES (5,'Adamciuc','Ludmila',28,'Republica Moldova');
commit;
INSERT INTO carteata.author VALUES (6,'Gacikevici','Grigore',42,'Republica Moldova');
commit;
INSERT INTO carteata.author VALUES (7,'Zusac','Markus',48,'Australia');
commit;
INSERT INTO carteata.author VALUES (8,'Kai-Fu','Lee',62,'China');
commit;
INSERT INTO carteata.author VALUES (9,'Wilde','Oscar',87,'Dublin');
commit;
INSERT INTO carteata.author VALUES (10,'Hoover','Colleen',43,'SUA');
commit;


UPDATE carteata.book
SET EditionName = 'Bons Offices'
WHERE BookId = 5;


