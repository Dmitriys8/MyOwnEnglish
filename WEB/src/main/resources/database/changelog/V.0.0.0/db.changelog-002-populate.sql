
INSERT INTO tenses.tenses (tense_name)
VALUES ('present'),('future'),('past'),('conditional');

INSERT INTO tenses.types (type_name)
VALUES ('simple'),('continuous'),('perfect'),('perfect continuous');

INSERT INTO tenses.x_tenses_types (tense_id, type_id)
SELECT ts.tense_id
     ,t.type_id
FROM tenses.tenses ts
CROSS JOIN tenses."types" t;

--rollback
-- DELETE FROM tenses.x_tenses_types
-- DELETE FROM tenses.types
-- DELETE FROM tenses.tenses