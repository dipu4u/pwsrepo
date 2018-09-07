CREATE SEQUENCE providerdatamaster_seq as integer START WITH 10 INCREMENT BY 1;  

create table providerdatamaster (providerId integer NOT NULL CONSTRAINT providerdatamaster_pk primary key, 
	providerName varchar(50) not null, countryId integer NOT NULL, pincodes varchar(500));
	
CREATE SEQUENCE providerdataactivitymaster_seq as integer START WITH 10 INCREMENT BY 1;

create table providerdataactivitymaster (serialId integer NOT NULL CONSTRAINT providerdataactivitymaster_pk primary key, 
	providerId integer NOT NULL CONSTRAINT providerdataId_fk REFERENCES providerdatamaster(providerId), runDateTime TIMESTAMP NOT NULL, jobStatus varchar(15));

	
create index providerdatamasterId_idx ON providerdatamaster(providerId);
create index providerdataactivitymasterId_idx ON providerdataactivitymaster(serialId);