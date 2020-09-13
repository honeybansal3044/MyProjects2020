INSERT INTO enrollee (Id, birth_date, full_name, is_active, phone_number)
VALUES (101, parsedatetime('01-01-2000', 'dd-MM-yyyy'), 'John', true, '9876543210');

INSERT INTO enrollee (Id, birth_date, full_name, is_active, phone_number)
VALUES (102, parsedatetime('01-01-2001', 'dd-MM-yyyy'), 'James', false, '9876543211');

INSERT INTO enrollee (Id, birth_date, full_name, is_active)
VALUES (103, parsedatetime('01-01-2002', 'dd-MM-yyyy'), 'Smith', true);

INSERT INTO enrollee (Id, birth_date, full_name, is_active)
VALUES (104, parsedatetime('01-01-2003', 'dd-MM-yyyy'), 'Honey', true);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (105, parsedatetime('01-01-2010', 'dd-MM-yyyy'), 'John Jr.', 101);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (106, parsedatetime('01-01-2011', 'dd-MM-yyyy'), 'John Jr2.', 101);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (107, parsedatetime('01-01-2010', 'dd-MM-yyyy'), 'James Jr.', 102);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (108, parsedatetime('01-01-2011', 'dd-MM-yyyy'), 'James Jr2.', 102);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (109, parsedatetime('01-01-2010', 'dd-MM-yyyy'), 'Smith Jr.', 103);