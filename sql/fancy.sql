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
-- FAMOUS METAL
CREATE VIEW Y2 AS (
  SELECT
    metal,
    count(*) AS cnt
  FROM Orders
  GROUP BY metal);

CREATE VIEW M2 AS (
  SELECT max(cnt) AS max
  FROM Y2
);

SELECT name
FROM M2, Metals, Y2
WHERE Metals.m_id = Y2.metal AND Y2.cnt = M2.max;

DROP VIEW Y;
DROP VIEW M;

--FAMOUS JEWELRY
CREATE VIEW Y3 AS (
  SELECT
    jewelry,
    count(*) AS cnt
  FROM Orders
  GROUP BY jewelry);

CREATE VIEW M3 AS (
  SELECT max(cnt) AS max
  FROM Y3
);

SELECT name
FROM M3, Jewelry, Y3
WHERE Jewelry.j_id = Y3.jewelry AND Y3.cnt = M3.max;

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

CREATE VIEW payType AS
(SELECT
  P.type,
  count(*) AS cnt
FROM Payments AS P
GROUP BY P.type);

SELECT type
FROM payType
WHERE cnt = (SELECT MAX(cnt) FROM payType);
