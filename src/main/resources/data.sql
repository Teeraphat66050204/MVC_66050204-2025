-- ลบข้อมูลเก่าออกก่อน
DELETE FROM application;
DELETE FROM job;
DELETE FROM candidate;
DELETE FROM company;

-- Companies (2 บริษัท)
INSERT INTO company (company_id, name, email, location) VALUES
('C1000001', 'TechCorp', 'contact@techcorp.com', 'Bangkok'),
('C1000002', 'BizSolutions', 'hr@bizsolutions.com', 'Chiang Mai');

-- Jobs (10 ตำแหน่ง, 2 บริษัท)
INSERT INTO job (job_id, title, description, company_id, deadline, status) VALUES
('J1000001', 'Software Engineer', 'Develop web applications', 'C1000001', '2025-12-31', 'OPEN'),
('J1000002', 'Data Analyst', 'Analyze business data', 'C1000001', '2025-11-30', 'OPEN'),
('J1000003', 'Frontend Developer', 'Build UI with React', 'C1000001', '2025-12-15', 'OPEN'),
('J1000004', 'Backend Developer', 'Build REST APIs', 'C1000001', '2025-12-20', 'OPEN'),
('J1000005', 'DevOps Engineer', 'Maintain CI/CD pipelines', 'C1000001', '2025-10-31', 'OPEN'),

('J1000006', 'HR Manager', 'Manage recruitment', 'C1000002', '2025-11-30', 'OPEN'),
('J1000007', 'Marketing Specialist', 'Create campaigns', 'C1000002', '2025-12-31', 'OPEN'),
('J1000008', 'Sales Executive', 'Handle clients', 'C1000002', '2025-12-15', 'OPEN'),
('J1000009', 'Customer Support', 'Assist customers', 'C1000002', '2025-12-25', 'OPEN'),
('J1000010', 'Project Manager', 'Lead projects', 'C1000002', '2025-11-30', 'OPEN');

-- Candidates (10 คน)
INSERT INTO candidate (candidate_id, first_name, last_name, email) VALUES
('CA100001', 'Alice', 'Smith', 'alice.smith@example.com'),
('CA100002', 'Bob', 'Johnson', 'bob.johnson@example.com'),
('CA100003', 'Charlie', 'Brown', 'charlie.brown@example.com'),
('CA100004', 'David', 'Williams', 'david.williams@example.com'),
('CA100005', 'Eva', 'Taylor', 'eva.taylor@example.com'),
('CA100006', 'Frank', 'Miller', 'frank.miller@example.com'),
('CA100007', 'Grace', 'Wilson', 'grace.wilson@example.com'),
('CA100008', 'Henry', 'Moore', 'henry.moore@example.com'),
('CA100009', 'Ivy', 'Davis', 'ivy.davis@example.com'),
('CA100010', 'Jack', 'Anderson', 'jack.anderson@example.com');

-- Applications (ใบสมัครตัวอย่าง)
INSERT INTO application (job_id, candidate_id, apply_date) VALUES
('J1000001', 'CA100001', '2025-09-21'),
('J1000002', 'CA100002', '2025-09-21'),
('J1000003', 'CA100003', '2025-09-20'),
('J1000004', 'CA100004', '2025-09-19'),
('J1000005', 'CA100005', '2025-09-18'),
('J1000006', 'CA100006', '2025-09-21'),
('J1000007', 'CA100007', '2025-09-19'),
('J1000008', 'CA100008', '2025-09-20'),
('J1000009', 'CA100009', '2025-09-21'),
('J1000010', 'CA100010', '2025-09-20');
