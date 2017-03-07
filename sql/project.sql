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
  c_id       INTEGER AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(50) NOT NULL,
  address    VARCHAR(150),
  phone      VARCHAR(15) NOT NULL,
  login_name VARCHAR(50) UNIQUE
);

CREATE TABLE Payments (
  p_id   INTEGER AUTO_INCREMENT PRIMARY KEY,
  customer_id   INTEGER,
  type   VARCHAR(10) NOT NULL,
  amount REAL        NOT NULL,
  date   DATE        NOT NULL,

  FOREIGN KEY (customer_id) REFERENCES Customers (c_id)
);

CREATE TABLE Orders (
  o_id        INTEGER AUTO_INCREMENT PRIMARY KEY,
  customer_id INTEGER,
  jewelry     INTEGER,
  metal       INTEGER,
  gem         INTEGER,
  price       REAL NOT NULL,
  paid        VARCHAR(5),

  FOREIGN KEY (jewelry) REFERENCES Jewelry (j_id),
  FOREIGN KEY (metal) REFERENCES Metals (m_id),
  FOREIGN KEY (gem) REFERENCES Gems (g_id),
  FOREIGN KEY (customer_id) REFERENCES Customers (c_id)
);