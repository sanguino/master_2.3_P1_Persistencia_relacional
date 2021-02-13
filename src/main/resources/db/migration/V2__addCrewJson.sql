ALTER TABLE flight
ADD crew_list_id JSON NOT NULL;


UPDATE flight SET crew_list_id = '[15, 16]' WHERE id = 9;
UPDATE flight SET crew_list_id = '[17, 18]' WHERE id = 10;
UPDATE flight SET crew_list_id = '[15, 19]' WHERE id = 11;
UPDATE flight SET crew_list_id = '[16, 19]' WHERE id = 12;
UPDATE flight SET crew_list_id = '[17, 18]' WHERE id = 13;
UPDATE flight SET crew_list_id = '[16, 18]' WHERE id = 14;




ALTER TABLE plane
ADD reviews JSON NOT NULL;


UPDATE plane SET reviews = '[{"initDate": "2012-2-15", "endDate":"2012-2-17", "timeSpent":"43", "mechanic":6, "type": "yearly review", "description": "normal yearly review", "airport": 4}, {"initDate": "2019-4-29", "endDate":"2019-4-30", "timeSpent":"5", "mechanic":7, "type": "avionic review", "description": "yearly avionic review", "airport": 3}, {"initDate": "2018-7-28", "endDate":"2018-7-31", "timeSpent":"64", "mechanic":6, "type": "landing review", "description": "extra landing review", "airport": 4}]' WHERE id = 1;
UPDATE plane SET reviews = '[{"initDate": "2015-3-8", "endDate":"2015-3-12", "timeSpent":"23", "mechanic":7, "type": "avionic review", "description": "yearly avionic review", "airport": 3}, {"initDate": "2018-12-23", "endDate":"2018-12-26", "timeSpent":"12", "mechanic":8, "type": "landing review", "description": "extra landing review", "airport": 4}]' WHERE id = 2;
