CREATE DATABASE wishlist;

USE wishlist;

CREATE TABLE Wishlist (
                      id serial primary key,
                      name VARCHAR(255) NOT NULL,
                      description VARCHAR(255) NOT NULL,
                      );

CREATE TABLE Items (
    id serial primary key,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    link VARCHAR(255) NOT NULL,
    reserved bit NOT NULL
);


CREATE TABLE Combo (
    wishlistID int not null,
    itemID int not null,
    FOREIGN KEY (wishlistID) REFERENCES Wishlist(id),
    FOREIGN KEY (itemID) REFERENCES Item(id),

);