WITH present_simple AS(
    SELECT xtt.tense_type_id AS tense_type_id
    FROM tenses.x_tenses_types xtt
             JOIN tenses.tenses t
                  ON t.tense_id = xtt.tense_id
             JOIN tenses."types" t2
                  ON t2.type_id = xtt.type_id
    WHERE t.tense_name = 'present'
      AND t2.type_name = 'simple'
),
     present_continuous AS (
         SELECT xtt.tense_type_id AS tense_type_id
         FROM tenses.x_tenses_types xtt
                  JOIN tenses.tenses t
                       ON t.tense_id = xtt.tense_id
                  JOIN tenses."types" t2
                       ON t2.type_id = xtt.type_id
         WHERE t.tense_name = 'present'
           AND t2.type_name = 'continuous'
     )
INSERT INTO tenses.cases (tense_type_id, case_name)
VALUES ((SELECT ps.tense_type_id FROM present_simple ps), 'regular actions'),
       ((SELECT ps.tense_type_id FROM present_simple ps), 'facts'),
       ((SELECT ps.tense_type_id FROM present_simple ps), 'people feelings'),
       ((SELECT pc.tense_type_id FROM present_continuous pc), 'actions in progress right now'),
       ((SELECT pc.tense_type_id FROM present_continuous pc), 'actions in progress about now'),
       ((SELECT pc.tense_type_id FROM present_continuous pc), 'temporary situations');

--rollback DELETE FROM tenses.cases