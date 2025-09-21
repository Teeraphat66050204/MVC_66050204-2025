DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS candidate;
DROP TABLE IF EXISTS company;

CREATE TABLE company (
    company_id VARCHAR(8) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
);

CREATE TABLE candidate (
    candidate_id VARCHAR(8) PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE job (
    job_id VARCHAR(8) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    company_id VARCHAR(8),
    deadline DATE,
    status VARCHAR(10),
    FOREIGN KEY (company_id) REFERENCES company(company_id)
);

CREATE TABLE application (
    job_id VARCHAR(8),
    candidate_id VARCHAR(8),
    apply_date DATE,
    PRIMARY KEY (job_id, candidate_id),
    FOREIGN KEY (job_id) REFERENCES job(job_id),
    FOREIGN KEY (candidate_id) REFERENCES candidate(candidate_id)
);
