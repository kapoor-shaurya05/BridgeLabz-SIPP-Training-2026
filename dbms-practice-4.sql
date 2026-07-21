/*-- Use Case 16 : --*/
SELECT Country, Deaths
FROM covid_deaths
WHERE Deaths >
(
    SELECT AVG(Deaths)
    FROM covid_deaths
);

/*-- Use Case 17 : --*/
SELECT DISTINCT Country
FROM covid_cases
WHERE Country IN
(
    SELECT Country
    FROM covid_cases
    GROUP BY Country
    HAVING MAX(Confirmed_Cases) > 1000000
);

/*-- Use Case 18 : --*/ 
SELECT
    c1.Date,
    c1.State,
    c1.Confirmed_Cases,
    CASE
        WHEN c1.Confirmed_Cases =
        (
            SELECT MAX(c2.Confirmed_Cases)
            FROM covid_cases c2
            WHERE c2.State = c1.State
        )
        THEN 'Peak Wave'
        ELSE 'Normal Day'
    END AS Wave_Status
FROM covid_cases c1
WHERE c1.State = 'Mumbai'
ORDER BY c1.Date;

/*-- Use Case 19 : --*/ 
SELECT
    Country,
    'Vaccinated' AS Status,
    Vaccinated AS Population_Count
FROM covid_vaccination

UNION

SELECT
    Country,
    'Unvaccinated' AS Status,
    (Population - Vaccinated) AS Population_Count
FROM covid_vaccination;

/*-- Use Case 20 : --*/ 
SELECT DISTINCT Country
FROM covid_deaths
WHERE Country NOT IN
(
    SELECT Country
    FROM covid_cases
);