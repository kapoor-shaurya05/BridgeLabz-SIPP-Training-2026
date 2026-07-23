/*-- Use Case 21 --*/ 
CREATE VIEW LatestCovidData AS
SELECT c.country,
       c.report_date,
       c.confirmed,
       c.deaths,
       c.recovered
FROM covid_cases c
JOIN (
    SELECT country,
           MAX(report_date) AS latest_date
    FROM covid_cases
    GROUP BY country
) latest
ON c.country = latest.country
AND c.report_date = latest.latest_date; 

/*-- Use Case 22 --*/ 
DELIMITER $$

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE mortality DECIMAL(10,2);

    SELECT
        (deaths / confirmed) * 100
    INTO mortality
    FROM covid_cases
    WHERE country = p_country
      AND report_date = p_date;

    RETURN mortality;
END $$

DELIMITER ;

/*-- Use case 23 --*/ 
DELIMITER $$

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_confirmed INT,
    IN p_deaths INT,
    IN p_recovered INT
)
BEGIN

    UPDATE covid_cases
    SET confirmed = p_confirmed,
        deaths = p_deaths,
        recovered = p_recovered
    WHERE country = p_country
      AND report_date = p_date;

END $$

DELIMITER ;

/*-- Use Case 24 --*/ 
DELIMITER $$

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100)
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE recovery DECIMAL(10,2);

    SELECT
        (recovered / confirmed) * 100
    INTO recovery
    FROM covid_cases
    WHERE country = p_country
    ORDER BY report_date DESC
    LIMIT 1;

    RETURN recovery;
END $$

DELIMITER ;

/*-- Use Case 25 --*/ 
CREATE TABLE covid_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100),
    report_date DATE,

    old_confirmed INT,
    new_confirmed INT,

    old_deaths INT,
    new_deaths INT,

    old_recovered INT,
    new_recovered INT,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);