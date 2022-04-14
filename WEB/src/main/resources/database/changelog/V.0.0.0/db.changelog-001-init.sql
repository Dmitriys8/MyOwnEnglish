

CREATE TABLE IF NOT EXISTS tenses.tenses(
	tense_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	tense_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tenses.types(
    type_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    type_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tenses.x_tenses_types(
    tense_type_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tense_id UUID NOT NULL REFERENCES tenses.tenses (tense_id) ON UPDATE RESTRICT ON DELETE RESTRICT,
    type_id UUID NOT NULL REFERENCES tenses.types (type_id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

