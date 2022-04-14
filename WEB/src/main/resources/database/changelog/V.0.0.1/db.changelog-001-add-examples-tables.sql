CREATE TABLE IF NOT EXISTS tenses.cases(
    case_id UUID PRIMARY KEY default uuid_generate_v4(),
    tense_type_id UUID NOT NULL REFERENCES tenses.x_tenses_types(tense_type_id) ON UPDATE RESTRICT ON DELETE RESTRICT,
    case_name VARCHAR(200) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS tenses.examples(
    example_id UUID PRIMARY KEY default uuid_generate_v4(),
    case_id UUID NOT NULL REFERENCES tenses.cases(case_id) ON UPDATE RESTRICT ON DELETE RESTRICT,
    example VARCHAR(500) NOT NULL UNIQUE
);