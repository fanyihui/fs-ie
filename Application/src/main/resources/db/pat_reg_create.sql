-- SCHEMA: pat_registry

-- DROP SCHEMA IF EXISTS pat_registry ;

CREATE SCHEMA IF NOT EXISTS pat_registry
    AUTHORIZATION postgres;

-- Table: pat_registry.pat_registry_add

-- DROP TABLE IF EXISTS pat_registry.pat_registry_add;

CREATE TABLE IF NOT EXISTS pat_registry.pat_registry_add
(
    pat_id character varying COLLATE pg_catalog."default",
    status character varying COLLATE pg_catalog."default",
    ssn character varying COLLATE pg_catalog."default",
    name character varying COLLATE pg_catalog."default",
    telecom character varying COLLATE pg_catalog."default",
    gender character varying COLLATE pg_catalog."default",
    birth character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    state character varying COLLATE pg_catalog."default",
    city character varying COLLATE pg_catalog."default",
    county character varying COLLATE pg_catalog."default",
    street_name_base character varying COLLATE pg_catalog."default",
    street_name character varying COLLATE pg_catalog."default",
    house_number character varying COLLATE pg_catalog."default",
    postal character varying COLLATE pg_catalog."default",
    marital character varying COLLATE pg_catalog."default",
    ethnic character varying COLLATE pg_catalog."default",
    occupation_code character varying COLLATE pg_catalog."default",
    employer_name character varying COLLATE pg_catalog."default",
    registry_time character varying COLLATE pg_catalog."default",
    employer_telecom character varying COLLATE pg_catalog."default",
    health_card_no character varying COLLATE pg_catalog."default",
    mrn character varying COLLATE pg_catalog."default",
    health_card_authority character varying COLLATE pg_catalog."default",
    mrn_authority character varying COLLATE pg_catalog."default",
    contact_code character varying COLLATE pg_catalog."default",
    contact_name character varying COLLATE pg_catalog."default",
    contact_telecom character varying COLLATE pg_catalog."default",
    org_id character varying COLLATE pg_catalog."default",
    org_name character varying COLLATE pg_catalog."default",
    insurance_code character varying COLLATE pg_catalog."default",
    insurance_name character varying COLLATE pg_catalog."default",
    register_id character varying COLLATE pg_catalog."default",
    register_name character varying COLLATE pg_catalog."default",
    ethnic_name character varying COLLATE pg_catalog."default",
    marital_name character varying COLLATE pg_catalog."default",
    gender_name character varying COLLATE pg_catalog."default",
    occupation_name character varying COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS pat_registry.pat_registry_add
    OWNER to postgres;

GRANT ALL ON TABLE pat_registry.pat_registry_add TO hipadmin;

GRANT ALL ON TABLE pat_registry.pat_registry_add TO postgres;