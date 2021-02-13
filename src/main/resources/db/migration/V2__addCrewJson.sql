ALTER TABLE flight
ADD crew_list_id JSON NOT NULL;

UPDATE flight SET crew_list_id = '[15, 16]' WHERE id = 9;
UPDATE flight SET crew_list_id = '[17, 18]' WHERE id = 10;
UPDATE flight SET crew_list_id = '[15, 19]' WHERE id = 11;
UPDATE flight SET crew_list_id = '[16, 19]' WHERE id = 12;
UPDATE flight SET crew_list_id = '[17, 18]' WHERE id = 13;
UPDATE flight SET crew_list_id = '[16, 18]' WHERE id = 14;
