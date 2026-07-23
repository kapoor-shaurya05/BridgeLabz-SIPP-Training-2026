/*-- Use Case 26 --*/ 
SELECT *
FROM covid_cases
WHERE country = 'India'
AND report_date = '2021-05-01'; 

/*-- Use Case 27 --*/ 
SELECT country,
       infection_rate
FROM covid_cases
ORDER BY infection_rate DESC
LIMIT 10; 

/*-- Use Case 28 --*/ 
EXPLAIN
SELECT c.country,
       c.confirmed,
       v.total_vaccinations
FROM covid_cases c
JOIN vaccine_data v
ON c.country = v.country
WHERE c.confirmed > 1000000; 

/*-- Use Case 29 --*/ 
START TRANSACTION;

INSERT INTO vaccine_data
(country, report_date, total_vaccinations, people_vaccinated, people_fully_vaccinated)
VALUES
('India', '2021-05-01', 150000000, 120000000, 30000000);

INSERT INTO vaccine_data
(country, report_date, total_vaccinations, people_vaccinated, people_fully_vaccinated)
VALUES
('USA', '2021-05-01', 250000000, 180000000, 90000000);

COMMIT; 

/*-- Use Case 30 --*/ 
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

START TRANSACTION;

SELECT confirmed
FROM covid_cases
WHERE country = 'India';

COMMIT; 