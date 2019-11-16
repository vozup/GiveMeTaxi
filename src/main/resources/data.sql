INSERT INTO operator (id, name, login, password, role) VALUES (1, 'Test1', 'Test1', 'Test1', 'USER');
INSERT INTO operator (id, name, login, password, role) VALUES (2, 'Test2', 'Test2', 'Test2', 'USER');
INSERT INTO operator (id, name, login, password, role) VALUES (3, 'Test2', 'Test3', 'Test3', 'USER');
INSERT INTO SITEMANAGERS (id, name, login, password, role) VALUES (1, 'AdminTest1', 'AdminTest1', 'AdminTest1', 'ADMIN');

INSERT INTO cars (id, CARTYPE, CARNUMBER) VALUES (1, 'STANDART', 'AA2212DD');

INSERT INTO driver (id, FIRSTNAME, smoking, busy) VALUES (1, 'TestDriver1', false, false);

-- UPDATE cars SET driver=1 WHERE id=1 ;
-- UPDATE driver SET car=1 WHERE id=1 ;