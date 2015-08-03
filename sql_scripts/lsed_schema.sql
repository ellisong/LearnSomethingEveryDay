-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lsed_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lsed_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lsed_db` DEFAULT CHARACTER SET utf8 ;
USE `lsed_db` ;

-- -----------------------------------------------------
-- Table `lsed_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsed_db`.`USER` (
  `UserId` INT(11) NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(32) NOT NULL,
  `Email` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lsed_db`.`card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsed_db`.`CARD` (
  `CardId` INT(11) NOT NULL AUTO_INCREMENT,
  `USER_UserId` INT(11) NOT NULL,
  `Title` VARCHAR(64) NOT NULL,
  `DateCreated` DATE NOT NULL,
  `DateModified` DATE NOT NULL,
  `Description` VARCHAR(320) NULL DEFAULT NULL,
  `ImageLink` VARCHAR(256) NOT NULL,
  `EmbedLink` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`CardId`, `USER_UserId`),
  INDEX `fk_CARD_USER1_idx` (`USER_UserId` ASC),
  CONSTRAINT `fk_CARD_USER1`
    FOREIGN KEY (`USER_UserId`)
    REFERENCES `lsed_db`.`user` (`UserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lsed_db`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsed_db`.`CATEGORY` (
  `CategoryId` INT(11) NOT NULL AUTO_INCREMENT,
  `Category` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`CategoryId`),
  UNIQUE INDEX `Category_UNIQUE` (`Category` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lsed_db`.`card_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsed_db`.`CARD_CATEGORY` (
  `CardCategoryId` INT(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_CategoryId` INT(11) NOT NULL,
  `CARD_CardId` INT(11) NOT NULL,
  `CARD_USER_UserId` INT(11) NOT NULL,
  PRIMARY KEY (`CardCategoryId`, `CATEGORY_CategoryId`, `CARD_CardId`, `CARD_USER_UserId`),
  INDEX `fk_CARD_CATEGORY_CATEGORY1_idx` (`CATEGORY_CategoryId` ASC),
  INDEX `fk_CARD_CATEGORY_CARD1_idx` (`CARD_CardId` ASC, `CARD_USER_UserId` ASC),
  CONSTRAINT `fk_CARD_CATEGORY_CARD1`
    FOREIGN KEY (`CARD_CardId` , `CARD_USER_UserId`)
    REFERENCES `lsed_db`.`card` (`CardId` , `USER_UserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CARD_CATEGORY_CATEGORY1`
    FOREIGN KEY (`CATEGORY_CategoryId`)
    REFERENCES `lsed_db`.`category` (`CategoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lsed_db`.`prerequisite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsed_db`.`PREREQUISITE` (
  `PrerequisiteId` INT(11) NOT NULL AUTO_INCREMENT,
  `Prerequisite` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`PrerequisiteId`),
  UNIQUE INDEX `Prerequisite_UNIQUE` (`Prerequisite` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lsed_db`.`card_prerequisite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsed_db`.`CARD_PREREQUISITE` (
  `CardPrerequisiteId` INT(11) NOT NULL AUTO_INCREMENT,
  `CARD_CardId` INT(11) NOT NULL,
  `CARD_USER_UserId` INT(11) NOT NULL,
  `PREREQUISITE_PrerequisiteId` INT(11) NOT NULL,
  PRIMARY KEY (`CardPrerequisiteId`, `CARD_CardId`, `CARD_USER_UserId`, `PREREQUISITE_PrerequisiteId`),
  INDEX `fk_CARD_PREREQUISITE_CARD1_idx` (`CARD_CardId` ASC, `CARD_USER_UserId` ASC),
  INDEX `fk_CARD_PREREQUISITE_PREREQUISITE1_idx` (`PREREQUISITE_PrerequisiteId` ASC),
  CONSTRAINT `fk_CARD_PREREQUISITE_CARD1`
    FOREIGN KEY (`CARD_CardId` , `CARD_USER_UserId`)
    REFERENCES `lsed_db`.`card` (`CardId` , `USER_UserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CARD_PREREQUISITE_PREREQUISITE1`
    FOREIGN KEY (`PREREQUISITE_PrerequisiteId`)
    REFERENCES `lsed_db`.`prerequisite` (`PrerequisiteId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
