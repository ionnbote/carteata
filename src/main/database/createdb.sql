CREATE DATABASE carteata;
commit;
CREATE TABLE carteata.User (
    UserId int NOT NULL UNIQUE,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    Email varchar(255),
    Parola varchar(255)
);
commit;
CREATE TABLE carteata.Book (
    BookId int NOT NULL UNIQUE,
    Name varchar(100) NOT NULL,
    AuthorId int NOT NULL,
    EditionName varchar(50),
    EditionYear int,
    Page int,
    ProductType varchar(50) NOT NULL,
    ISBN varchar(50) NOT NULL UNIQUE
);
commit;

CREATE TABLE carteata.Author (
    UserId int NOT NULL UNIQUE,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    Age int,
    City varchar(255)
);
commit;