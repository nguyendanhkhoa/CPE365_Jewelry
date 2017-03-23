/*Fancy Shit*/

/*best selling items*/
CREATE VIEW Y AS (
  SELECT
    gem,
    count(*) AS cnt
  FROM Orders
  GROUP BY gem);

CREATE VIEW M AS (
  SELECT max(cnt) AS max
  FROM Y
);

SELECT name
FROM M, Gems, Y
WHERE Gems.g_id = Y.gem AND Y.cnt = M.max;

DROP VIEW Y;
DROP VIEW M;

CREATE VIEW Y AS (
  SELECT
    metal,
    count(*) AS cnt
  FROM Orders
  GROUP BY metal);

CREATE VIEW M AS (
  SELECT max(cnt) AS max
  FROM Y
);

SELECT name
FROM M, Metals, Y
WHERE Metals.m_id = Y.metal AND Y.cnt = M.max;

DROP VIEW Y;
DROP VIEW M;

CREATE VIEW Y AS (
  SELECT
    jewelry,
    count(*) AS cnt
  FROM Orders
  GROUP BY jewelry);

CREATE VIEW M AS (
  SELECT max(cnt) AS max
  FROM Y
);

SELECT name
FROM M, Jewelry, Y
WHERE Jewelry.j_id = Y.jewelry AND Y.cnt = M.max;

DROP VIEW Y;
DROP VIEW M;


/*most valuable customer*/
CREATE VIEW X AS (SELECT
                    login_name,
                    sum(amount) AS spent
                  FROM Payments AS P
                  GROUP BY P.login_name);
SELECT
  login_name,
  spent
FROM X
WHERE spent = (SELECT max(spent)
               FROM X);
DROP VIEW X;

/*most frequent payment type*/
SELECT
  P.type,
  count(*)
FROM Payments AS P
GROUP BY P.type;
