DROP DATABASE lab2;
CREATE DATABASE lab2;
USE lab2;

CREATE TABLE Gems (
  g_id  INTEGER AUTO_INCREMENT PRIMARY KEY,
  name  VARCHAR(20) NOT NULL,
  price REAL        NOT NULL
);

CREATE TABLE Metals (
  m_id  INTEGER AUTO_INCREMENT PRIMARY KEY,
  name  VARCHAR(50) NOT NULL,
  price REAL        NOT NULL
);

CREATE TABLE Jewelry (
  j_id  INTEGER AUTO_INCREMENT PRIMARY KEY,
  name  VARCHAR(20) NOT NULL,
  price REAL        NOT NULL
);

CREATE TABLE Customers (
  login_name VARCHAR(50) PRIMARY KEY,
  name       VARCHAR(50) NOT NULL,
  address    VARCHAR(150),
  phone      VARCHAR(35) NOT NULL
);

CREATE TABLE Payments (
  p_id       INTEGER AUTO_INCREMENT PRIMARY KEY,
  login_name VARCHAR(50),
  type       VARCHAR(10) NOT NULL,
  amount     REAL        NOT NULL,
  date       DATE        NOT NULL,

  FOREIGN KEY (login_name) REFERENCES Customers (login_name)
);

CREATE TABLE Orders (
  o_id       INTEGER AUTO_INCREMENT PRIMARY KEY,
  login_name VARCHAR(50),
  jewelry    INTEGER,
  metal      INTEGER,
  gem        INTEGER,
  price      REAL NOT NULL,
  paid       BOOL,

  FOREIGN KEY (jewelry) REFERENCES Jewelry (j_id),
  FOREIGN KEY (metal) REFERENCES Metals (m_id),
  FOREIGN KEY (gem) REFERENCES Gems (g_id),
  FOREIGN KEY (login_name) REFERENCES Customers (login_name)
);

/*Gems*/
INSERT INTO Gems (name, price) VALUES ('Garnet', 500.00);
INSERT INTO Gems (name, price) VALUES ('Amethyst', 200.00);
INSERT INTO Gems (name, price) VALUES ('Aquamarine', 240.00);
INSERT INTO Gems (name, price) VALUES ('Diamond', 340.00);
INSERT INTO Gems (name, price) VALUES ('Emerald', 530.00);
INSERT INTO Gems (name, price) VALUES ('Pearl', 650.00);
INSERT INTO Gems (name, price) VALUES ('Ruby', 220.00);
INSERT INTO Gems (name, price) VALUES ('Peridot', 500.00);
INSERT INTO Gems (name, price) VALUES ('Sapphire', 430.00);
INSERT INTO Gems (name, price) VALUES ('Opal', 400.00);
INSERT INTO Gems (name, price) VALUES ('Topaz', 230.00);
INSERT INTO Gems (name, price) VALUES ('Turquoise', 450.00);


/*Metals*/
INSERT INTO Metals (name, price) VALUES ('White Gold', 200.00);
INSERT INTO Metals (name, price) VALUES ('Gold', 100.00);
INSERT INTO Metals (name, price) VALUES ('Rose Gold', 150.50);
INSERT INTO Metals (name, price) VALUES ('Silver', 170.00);
INSERT INTO Metals (name, price) VALUES ('Platinum', 260.00);
INSERT INTO Metals (name, price) VALUES ('Titanium', 420.00);
INSERT INTO Metals (name, price) VALUES ('Nickel', 80.50);
INSERT INTO Metals (name, price) VALUES ('Copper', 75.00);
INSERT INTO Metals (name, price) VALUES ('Stainless Steal', 190.00);
INSERT INTO Metals (name, price) VALUES ('Sterling Silver', 180.00);
INSERT INTO Metals (name, price) VALUES ('Brass', 170.00);
INSERT INTO Metals (name, price) VALUES ('Tungsten', 140.30);


/*Jewelry*/
INSERT INTO Jewelry (name, price) VALUES ('Earrings', 40);
INSERT INTO Jewelry (name, price) VALUES ('Ring', 51);
INSERT INTO Jewelry (name, price) VALUES ('Necklace', 65);
INSERT INTO Jewelry (name, price) VALUES ('Bracelet', 32);
INSERT INTO Jewelry (name, price) VALUES ('Anklelet', 27);


/*Customers*/
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('rharri05', 'Rebecca Harrison', '1144 Buchon St. #10, SLO, CA 93401', '778-785-7825');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('swen', 'Shanghai Wen', '1445 Ser Way, SLO, CA 93401', '565-785-7823');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('meps@gmail.com', 'Dakota Meps', '1144 Bucky Road #34, Stocken, CA 45937', '123-785-7825');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('ricksta', 'Ricky Esco', '123 Cupeito Blvd, Bakersfield, CA 93401', '245-785-2323');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('kevers', 'Kevin Benson', '2344 Equine Dr., Elk Grove, CA 23455', '678-341-7825');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('tablue2@yahoo.com', 'Red Devin', '1442 North Texas Way, MI 65802', '436-785-7825');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('Gaorade', 'Datloa MacBet', '23434 Key St., Inseterr, FL 34578', '778-327-6789');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('Benelton', 'Dierks Bentley', '4234 Erriden Ct. #7, Chancer, RI 44234', '423-335-7825');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('VanilSandy', 'Holder Cinser', '24334 Strong Street, SLO, CA 93401', '778-785-7825');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('layOn434', 'Fouxer Hay', '1442 N. Texas Springfield, MO 65802', '246-785-4654');
INSERT INTO Customers (login_name, name, address, phone)
VALUES ('fawe3445@aol.com', 'Kons Sokey', '4234 Shoens Court Houston, TX 93435', '457-785-9008');


/*Payments/Orders*/
INSERT INTO Payments (login_name, type, amount, date)
VALUES ('rharri05', 'Credit', 690.50, '2016-03-13');
INSERT INTO Orders (login_name, jewelry, metal, gem, price, paid)
VALUES ('rharri05', 1, 3, 8, 690.50, TRUE);

INSERT INTO Payments (login_name, type, amount, date)
VALUES ('meps@gmail.com', 'Credit', 455, '2016-05-13');
INSERT INTO Payments (login_name, type, amount, date)
VALUES ('meps@gmail.com', 'Credit', 455, '2016-05-15');
INSERT INTO Orders (login_name, jewelry, metal, gem, price, paid)
VALUES ('meps@gmail.com', 1, 5, 12, 910.00, TRUE);

INSERT INTO Payments (login_name, type, amount, date)
VALUES ('fawe3445@aol.com', 'Cash', 867, '2016-11-15');
INSERT INTO Orders (login_name, jewelry, metal, gem, price, paid)
VALUES ('fawe3445@aol.com', 5, 8, 5, 867, TRUE);

INSERT INTO Payments (login_name, type, amount, date)
VALUES ('ricksta', 'Check', 841.3, '2015-10-13');
INSERT INTO Orders (login_name, jewelry, metal, gem, price, paid)
VALUES ('ricksta', 2, 11, 5, 841.3, TRUE);

INSERT INTO Payments (login_name, type, amount, date)
VALUES ('kevers', 'Credit', 100, '2015-04-13');
INSERT INTO Orders (login_name, jewelry, metal, gem, price, paid)
VALUES ('kevers', 5, 7, 2, 302, FALSE);

INSERT INTO Payments (login_name, type, amount, date)
VALUES ('rharri05', 'Credit', 485, '2014-03-11');
INSERT INTO Orders (login_name, jewelry, metal, gem, price, paid)
VALUES ('rharri05', 3, 9, 3, 485, TRUE);

INSERT INTO Payments (login_name, type, amount, date)
VALUES ('Benelton', 'Cash', 557, '2014-01-21');
INSERT INTO Orders (login_name, jewelry, metal, gem, price, paid)
VALUES ('Benelton', 4, 8, 12, 557, TRUE);

INSERT INTO Payments (login_name, type, amount, date)
VALUES ('tablue2@yahoo.com', 'Check', 651, '2016-03-13');
INSERT INTO Orders (login_name, jewelry, metal, gem, price, paid)
VALUES ('tablue2@yahoo.com', 2, 2, 7, 651, TRUE);
