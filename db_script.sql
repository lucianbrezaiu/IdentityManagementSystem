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
)

insert into organization(organizationName,cui) values 
('IBM','34318904'),
('Atos','98066608'),
('Waters','26167770'),
('IQuest','65785470'),
('Siemens','21041892'),
('Trimble','40820074'),
('Essensys','59753264');

insert into identity(organizationId,username,email,password,firstName,lastName) values
(1,'admin','admin@outlook.com','admin','admin','admin'),
(7,'lucianbrezaiu','lucianbrezaiu@yahoo.com','Copernic@1234','Lucian','Brezaiu');

insert into role(roleName,roleDescription) values
('admin','administrator');

insert into resource(resourceName) values 
('Identity Management System');

insert into identityroleresource(identityId,roleId,resourceId) values 
(1,1,1);

