/*--
Use Case 1 : 
SELECT c.country_name,
       cc.confirmed_cases
FROM covid_cases cc
INNER JOIN countries c
ON cc.country_id = c.country_id
WHERE cc.date = '2021-06-01'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;

Use Case 2 : 
SELECT c.country_name,
       d.death_count,
       v.vaccination_status
FROM covid_deaths d
LEFT JOIN covid_vaccines v
ON d.country_id = v.country_id
AND d.date = v.date
INNER JOIN countries c
ON d.country_id = c.country_id;

Use Case 3 : 
SELECT con.continent_name,
       SUM(cc.total_deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries c
ON cc.country_id = c.country_id
INNER JOIN continents con
ON c.continent_id = con.continent_id
GROUP BY con.continent_name
ORDER BY total_deaths DESC;

Use Case 4 : 
SELECT date,
       AVG(new_deaths) AS average_new_deaths
FROM covid_cases
GROUP BY date
ORDER BY date;

Use Case 5 : 
SELECT c.country_name,
       cc.confirmed_cases,
       c.population,
       (cc.confirmed_cases * 100.0 / c.population) AS infection_rate
FROM covid_cases cc
INNER JOIN countries c
ON cc.country_id = c.country_id
ORDER BY infection_rate DESC;
--*/