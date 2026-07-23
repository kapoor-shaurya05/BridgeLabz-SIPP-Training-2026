/*-- Challenge 1:

CREATE DATABASE IF NOT EXISTS covidDB;

USE covidDB;

Challenge 2:

INSERT INTO covid19
(`Sno`, `Date`, `Time`, `State/UnionTerritory`,
`ConfirmedIndianNational`, `ConfirmedForeignNational`,
`Cured`, `Deaths`, `Confirmed`)
VALUES
(447, '2020-03-15', '10:00 AM',
'India', 100, 0, 50, 2, 100);

Challenge 3:

UPDATE covid19
SET Confirmed = 120
WHERE Sno = 447;

Challenge 4:

DELETE FROM covid19
WHERE `State/UnionTerritory` = 'IN';

Challenge 5:

ALTER TABLE covid19
ADD vaccination_rate FLOAT;
*/