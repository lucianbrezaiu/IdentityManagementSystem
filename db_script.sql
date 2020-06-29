create database managementsystem;

CREATE TABLE `organization` (
  `organizationId` int(11) NOT NULL AUTO_INCREMENT,
  `organizationName` varchar(45) DEFAULT NULL,
  `cui` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`organizationId`)
); 

CREATE TABLE `identity` (
  `identityId` int(11) NOT NULL AUTO_INCREMENT,
  `organizationId` int(11) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`identityId`),
  KEY `FK_IDENTITY_ORGANIZATION_idx` (`organizationId`),
  CONSTRAINT `FK_IDENTITY_ORGANIZATION` FOREIGN KEY (`organizationId`) REFERENCES `organization` (`organizationId`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(45) DEFAULT NULL,
  `roleDescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
); 

CREATE TABLE `right` (
  `rightId` int(11) NOT NULL AUTO_INCREMENT,
  `rightName` varchar(45) DEFAULT NULL,
  `rightDescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rightId`)
);

CREATE TABLE `roleright` (
  `roleId` int(11) DEFAULT NULL,
  `rightId` int(11) DEFAULT NULL,
  KEY `FK_right_role_idx` (`roleId`),
  KEY `FK_rightroles_right_idx` (`rightId`),
  CONSTRAINT `FK_rightroles_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_rightroles_right` FOREIGN KEY (`rightId`) REFERENCES `right` (`rightId`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `resource` (
  `resourceId` int(11) NOT NULL AUTO_INCREMENT,
  `resourceName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`resourceId`)
);

CREATE TABLE `identityroleresource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identityId` int(11) DEFAULT NULL,
  `resourceId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_IDENTITYROLERESOURCES_IDENTITY_idx` (`identityId`),
  KEY `FK_IDENTITYROLERESOURCES_ROLE_idx` (`roleId`),
  KEY `FK_IDENTITYROLERESOURCES_RESOURCES_idx` (`resourceId`),
  CONSTRAINT `FK_IDENTITYROLERESOURCES_IDENTITY` FOREIGN KEY (`identityId`) REFERENCES `identity` (`identityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_IDENTITYROLERESOURCES_RESOURCES` FOREIGN KEY (`resourceId`) REFERENCES `resource` (`resourceId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_IDENTITYROLERESOURCES_ROLE` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

//seed pentru baza locala:

SET SQL_SAFE_UPDATES = 0;
delete from managementsystem.identityroleresource;
ALTER TABLE managementsystem.identityroleresource AUTO_INCREMENT = 1;
delete from managementsystem.roleright;
ALTER TABLE managementsystem.roleright AUTO_INCREMENT = 1;
delete from managementsystem.right;
ALTER TABLE managementsystem.right AUTO_INCREMENT = 1;
delete from managementsystem.role;
ALTER TABLE managementsystem.role AUTO_INCREMENT = 1;
delete from managementsystem.resource;
ALTER TABLE managementsystem.resource AUTO_INCREMENT = 1;
delete from managementsystem.identity;
ALTER TABLE managementsystem.identity AUTO_INCREMENT = 1;
delete from managementsystem.organization;
ALTER TABLE managementsystem.organization AUTO_INCREMENT = 1;

insert into managementsystem.organization(organizationName,cui) values 
('IBM','34318904'),
('BCR','98066608'),
('Waters','26167770'),
('IQuest','65785470'),
('Microsoft','21041892'),
('Essensys','59753264'),
('Trimble','40820074');

insert into managementsystem.identity(organizationId,username,email,password,firstName,lastName) values
(1,'admin','admin@outlook.com','admin','admin','admin'),
(6,'lucianbrezaiu#123','lucianbrezaiu@yahoo.com','Copernic@1234','Lucian','Brezaiu'),
(5,'mari#475','mari@gmail.com','Copernic@1234','Marian','Brezaiu'),
(3,'andreea#792','andreeau@gmail.com','Copernic@1234','Andreea','Popescu'),
(3,'bogdan#389','bogdan@gmail.com','Copernic@1234','Bogdan','Sandru');

insert into managementsystem.role(roleName,roleDescription) values
('administrator','administrator of a resource'),
('member','member of a resource'),
('hr','hr of a resource'),
('manager','manager of a resource'),
('analyst','analyst of a resource');

insert into managementsystem.right(rightName,rightDescription) values
('create','create entities'),
('read','read entities'),
('update','update entities'),
('delete','delete entities');

insert into managementsystem.roleright(roleId,rightId) values
(1,1),
(1,2),
(1,3),
(1,4),
(2,2),
(3,1),
(3,3),
(3,3),
(4,2),
(5,1),
(5,3);

insert into managementsystem.resource(resourceName) values 
('Dox'),
('Intranet'),
('Condica'),
('IdentityManagementSystem');

insert into managementsystem.identityroleresource(identityId,roleId,resourceId) values 
(1,1,4),
(1,2,4),
(2,2,4),
(2,3,2),
(2,4,2),
(3,2,4),
(4,2,4),
(5,2,4);

//seed pentru baza din aws:

SET SQL_SAFE_UPDATES = 0;
delete from managementsystemaws.identityroleresource;
ALTER TABLE managementsystemaws.identityroleresource AUTO_INCREMENT = 1;
delete from managementsystemaws.roleright;
ALTER TABLE managementsystemaws.roleright AUTO_INCREMENT = 1;
delete from managementsystemaws.right;
ALTER TABLE managementsystemaws.right AUTO_INCREMENT = 1;
delete from managementsystemaws.role;
ALTER TABLE managementsystemaws.role AUTO_INCREMENT = 1;
delete from managementsystemaws.resource;
ALTER TABLE managementsystemaws.resource AUTO_INCREMENT = 1;
delete from managementsystemaws.identity;
ALTER TABLE managementsystemaws.identity AUTO_INCREMENT = 1;
delete from managementsystemaws.organization;
ALTER TABLE managementsystemaws.organization AUTO_INCREMENT = 1;

insert into managementsystemaws.organization(organizationName,cui) values 
('IBM','34318904'),
('BCR','98066608'),
('Waters','26167770'),
('IQuest','65785470'),
('Microsoft','21041892'),
('Essensys','59753264'),
('Trimble','40820074');

insert into managementsystemaws.identity(organizationId,username,email,password,firstName,lastName) values
(1,'admin','admin@outlook.com','admin','admin','admin'),
(6,'lucianbrezaiu#123','lucianbrezaiu@yahoo.com','Copernic@1234','Lucian','Brezaiu'),
(5,'mari#475','mari@gmail.com','Copernic@1234','Marian','Brezaiu'),
(3,'andreea#792','andreeau@gmail.com','Copernic@1234','Andreea','Popescu'),
(3,'bogdan#389','bogdan@gmail.com','Copernic@1234','Bogdan','Sandru');

insert into managementsystemaws.role(roleName,roleDescription) values
('administrator','administrator of a resource'),
('member','member of a resource'),
('hr','hr of a resource'),
('manager','manager of a resource'),
('analyst','analyst of a resource');

insert into managementsystemaws.right(rightName,rightDescription) values
('create','create entities'),
('read','read entities'),
('update','update entities'),
('delete','delete entities');

insert into managementsystemaws.roleright(roleId,rightId) values
(1,1),
(1,2),
(1,3),
(1,4),
(2,2),
(3,1),
(3,3),
(3,3),
(4,2),
(5,1),
(5,3);

insert into managementsystemaws.resource(resourceName) values 
('Dox'),
('Intranet'),
('Condica'),
('IdentityManagementSystem');

insert into managementsystemaws.identityroleresource(identityId,roleId,resourceId) values 
(1,1,4),
(1,2,4),
(2,2,4),
(2,3,2),
(2,4,2),
(3,2,4),
(4,2,4),
(5,2,4);