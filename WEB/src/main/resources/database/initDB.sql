

CREATE TABLE IF NOT EXISTS tenses.tenses(
	tense_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	tense_name VARCHAR(50) NOT NULL
);