set search_path to public;
INSERT INTO contact (id,phone_number,email,profile_link) VALUES (1,'8800553535', 'trubu@mai.ru','first profile');
INSERT INTO contact (id,phone_number,email,profile_link) VALUES (2,'8900553535', 'yryry@mai.ru','second profile');
INSERT INTO contact (id,phone_number,email,profile_link) VALUES (3,'8700553535', 'kazbek@mai.ru','third profile');

INSERT INTO medical_card (id,client_status,med_status,registry_dt,comment) VALUES (1,'i', 'b','8-10-22','first card');
INSERT INTO medical_card (id,client_status,med_status,registry_dt,comment) VALUES (2,'g', 'g','2-10-22','second card');
INSERT INTO medical_card (id,client_status,med_status,registry_dt,comment) VALUES (3,'i', 'g','3-10-22','third card');

INSERT INTO person_data (id,last_name,first_name,birth_dt,age,sex,contact_id,medical_card_id) VALUES (1,'Mary', 'Whinchester','3-10-97',49,'f',1,1);
INSERT INTO person_data (id,last_name,first_name,birth_dt,age,sex,contact_id,medical_card_id,parent_id) VALUES (2,'Din', 'Whinchester','3-10-17',5,'m',2,2,1);
INSERT INTO person_data (id,last_name,first_name,birth_dt,age,sex,contact_id,medical_card_id) VALUES (3,'Albert', 'Jigit','3-10-87',59,'m',3,3);

INSERT INTO illness (id,medical_card_id,type_id,heaviness,appearance_dtta,recovery_dt) VALUES (1,1, 11,'h','04-06-2001','04-06-2001');
INSERT INTO illness (id,medical_card_id,type_id,heaviness,appearance_dtta,recovery_dt) VALUES (2,2, 22,'n','04-06-2001','05-06-2001');
INSERT INTO illness (id,medical_card_id,type_id,heaviness,appearance_dtta,recovery_dt) VALUES (3,3, 33,'h','04-06-2001','06-06-2001');

INSERT INTO address (id,contact_id,country_id,sity,index,street,building,flat) VALUES (1,1, 27,'Nizhnyi Novgorod',128,'Gorkova','12','156');
INSERT INTO address (id,contact_id,country_id,sity,index,street,building,flat) VALUES (2,2, 27,'Nizhnyi Novgorod',129,'Belinka','13','16');
INSERT INTO address (id,contact_id,country_id,sity,index,street,building,flat) VALUES (3,3, 27,'Nizhnyi Novgorod',128,'Tverslaia','112','6');
