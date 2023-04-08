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
INSERT INTO carteata.user VALUES (11,'Balan','Corina','balancorina@gmail.com','corina26');
commit;
INSERT INTO carteata.user VALUES (12,'Pintea','Catalina','catalinapintea@gmail.com','pintea25');
commit;
INSERT INTO carteata.user VALUES (13,'Zgureanu','Ionela','ionelazgureanu@gmail.com','zgureanu.22');
commit;
INSERT INTO carteata.user VALUES (14,'Cihan','Ecaterina','ecaterinacihan@gmail.com','ecaterina.79');
commit;
INSERT INTO carteata.user VALUES (15,'Cihan','Ana','anacihan@gmail.com','cihan.ana14');
commit;
INSERT INTO carteata.user VALUES (16,'Fotescu','Ana','fotescuana@gmail.com','ana.fotescu');
commit;
INSERT INTO carteata.user VALUES (17,'Bodrug','Elena','elenabodrug@gmail.com','elena.96');
commit;
INSERT INTO carteata.user VALUES (18,'Nica','Gheorghe','gheorghenica@gmail.com','george.nica.96');
commit;
INSERT INTO carteata.user VALUES (19,'Bors','Vasile','borsvasile@gmail.com','bors123');
commit;
INSERT INTO carteata.user VALUES (20,'Bulmaga','Mihail','bulmagamihail@gmail.com','maikal34');
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
INSERT INTO carteata.book VALUES (11,"Cel mai bogat om din babilon.jpg","Cel mai bogat om din babilon",11,"Amaltea",2004,144,"Belistrica",195525);
commit;
INSERT INTO carteata.book VALUES (12,"Creerul copilului tau.jpg","Creerul copilului tau",12,"For You",2009,162,"Belistrica",562173);
commit;
INSERT INTO carteata.book VALUES (13,"fluturi.jpg","Fluturi",13,"For You",2013,681,"Belistrica",315280);
commit;
INSERT INTO carteata.book VALUES (14,"ipoteza fericirii.jpg","Ipoteza fericirii",14,"Humanitas",2020,421,"Belistrica",689368);
commit;
INSERT INTO carteata.book VALUES (15,"Lumea creata de inteligenta artificiala.jpg","Superputerile inteligentei artificiale",8,"Corint",2021,352,"Belistrica",682414);
commit;
INSERT INTO carteata.book VALUES (16,"Rezerva.jpg","Rezerva",15,"Nemira",2023,456,"Belistrica",705702);
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
INSERT INTO carteata.author VALUES (11,'Clason','Samuel Clason',82,'SUA');
commit;
INSERT INTO carteata.author VALUES (12,'Siegel','Dan',66,'SUA');
commit;
INSERT INTO carteata.author VALUES (13,'Binder','Irina',38,'Ramania');
commit;
INSERT INTO carteata.author VALUES (14,'Haidt','Jonathan',60,'SUA');
commit;
INSERT INTO carteata.author VALUES (15,'Printul','Harry',39,'Marea Britanie');
commit;


UPDATE carteata.book
SET EditionName = 'Bons Offices'
WHERE BookId = 5;


