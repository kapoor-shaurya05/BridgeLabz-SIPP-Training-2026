/*--
Use Case 1 : 
CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    Last_Updated TIMESTAMP,

    PRIMARY KEY (Country, Date)
);

Use Case 2 : 
CREATE TABLE countries (
    Country VARCHAR(100) PRIMARY KEY,
    Continent VARCHAR(100),
    Population BIGINT
);

Use Case 3 : 
ALTER TABLE covid_cases
MODIFY Country VARCHAR(100) NOT NULL;

ALTER TABLE covid_cases
MODIFY Date DATE NOT NULL;

ALTER TABLE covid_cases
MODIFY Confirmed_Cases INT NOT NULL;

Use Case 4 : 
CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT DEFAULT 0,
    Last_Updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

Use Case 5 : 
ALTER TABLE covid_cases
ADD CONSTRAINT unique_country_date
UNIQUE (Country, Date);
--*/