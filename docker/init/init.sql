CREATE DATABASE tenses_db;
\connect tenses_db;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA tenses;
--
CREATE USER tenses_app WITH PASSWORD 'tenses_app';
GRANT ALL PRIVILEGES ON DATABASE tenses_db to tenses_app;
GRANT ALL PRIVILEGES ON SCHEMA tenses to tenses_app;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA tenses TO tenses_app;
--
-- GRANT ALL PRIVILEGES ON tenses_db TO tenses_db_app;