INSERT INTO enrollee (Id, birth_date, full_name, is_active, phone_number)
VALUES (1, parsedatetime('01-01-2000', 'dd-MM-yyyy'), 'John', true, '9876543210');

INSERT INTO enrollee (Id, birth_date, full_name, is_active, phone_number)
VALUES (2, parsedatetime('01-01-2001', 'dd-MM-yyyy'), 'James', false, '9876543211');

INSERT INTO enrollee (Id, birth_date, full_name, is_active)
VALUES (3, parsedatetime('01-01-2002', 'dd-MM-yyyy'), 'Smith', true);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (1, parsedatetime('01-01-2010', 'dd-MM-yyyy'), 'John Jr.', 1);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (2, parsedatetime('01-01-2011', 'dd-MM-yyyy'), 'John Jr2.', 1);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (3, parsedatetime('01-01-2010', 'dd-MM-yyyy'), 'James Jr.', 2);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (4, parsedatetime('01-01-2011', 'dd-MM-yyyy'), 'James Jr2.', 2);

INSERT INTO dependent(Id, birth_date, full_name, enrollee_id)
VALUES (5, parsedatetime('01-01-2010', 'dd-MM-yyyy'), 'Smith Jr.', 3);