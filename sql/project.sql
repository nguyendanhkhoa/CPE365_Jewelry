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
  phone      VARCHAR(15) NOT NULL
);

CREATE TABLE Payments (
  p_id   INTEGER AUTO_INCREMENT PRIMARY KEY,
  login_name   VARCHAR(50),
  type   VARCHAR(10) NOT NULL,
  amount REAL        NOT NULL,
  date   DATE        NOT NULL,

  FOREIGN KEY (login_name) REFERENCES Customers (login_name)
);

CREATE TABLE Orders (
  o_id        INTEGER AUTO_INCREMENT PRIMARY KEY,
  login_name   VARCHAR(50),
  jewelry     INTEGER,
  metal       INTEGER,
  gem         INTEGER,
  price       REAL NOT NULL,
  paid        BOOL,

  FOREIGN KEY (jewelry) REFERENCES Jewelry (j_id),
  FOREIGN KEY (metal) REFERENCES Metals (m_id),
  FOREIGN KEY (gem) REFERENCES Gems (g_id),
  FOREIGN KEY (login_name) REFERENCES Customers (login_name)
);