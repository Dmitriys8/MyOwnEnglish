WITH reg_act AS (
     SELECT case_id AS case_id
     FROM tenses.cases c
     WHERE c.case_name = 'regular actions'
 ),
 facts AS (
     SELECT case_id AS case_id
     FROM tenses.cases c
     WHERE c.case_name = 'facts'
 ),
 peop_feel AS (
     SELECT case_id AS case_id
     FROM tenses.cases c
     WHERE c.case_name = 'people feelings'
 ),
 right_now AS (
     SELECT case_id AS case_id
     FROM tenses.cases c
     WHERE c.case_name = 'actions in progress right now'
 ),
 about_now AS (
     SELECT case_id AS case_id
     FROM tenses.cases c
     WHERE c.case_name = 'actions in progress about now'
 ),
 temp_sits AS (
     SELECT case_id AS case_id
     FROM tenses.cases c
     WHERE c.case_name = 'temporary situations'
 )
INSERT INTO tenses.examples (case_id, example)
VALUES ((SELECT case_id FROM reg_act), 'I brush my teeth everery day'),
       ((SELECT case_id FROM facts), 'The sky is blue'),
       ((SELECT case_id FROM peop_feel), 'I love books'),
       ((SELECT case_id FROM right_now), 'I am writing this sentence'),
       ((SELECT case_id FROM about_now), 'I am designing database'),
       ((SELECT case_id FROM temp_sits), 'I am studying english ')

--rollback DELETE FROM tenses.examples