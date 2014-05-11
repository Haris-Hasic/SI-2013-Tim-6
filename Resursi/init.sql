SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';



CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `mydb` ;



-- -----------------------------------------------------

-- Table `mydb`.`KONTINENT`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`KONTINENT` (

  `KONTINENT_ID` INT NOT NULL ,

  `KONTINENT_IME` VARCHAR(30) NULL ,

  PRIMARY KEY (`KONTINENT_ID`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`DRZAVA`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`DRZAVA` (

  `DRZAVA_ID` INT NOT NULL ,

  `DRZAVA_IME` VARCHAR(30) NULL ,

  `KONTINENT_ID` INT NOT NULL ,

  PRIMARY KEY (`DRZAVA_ID`) ,

  INDEX `fk_DRZAVA_KONTINENT_idx` (`KONTINENT_ID` ASC) ,

  CONSTRAINT `fk_DRZAVA_KONTINENT`

    FOREIGN KEY (`KONTINENT_ID` )

    REFERENCES `mydb`.`KONTINENT` (`KONTINENT_ID` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`LOKACIJA`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`LOKACIJA` (

  `LOKACIJA_ID` INT NOT NULL ,

  `ADRESA` VARCHAR(30) NULL ,

  `POSTANSKI_KOD` INT NULL ,

  `GRAD` VARCHAR(30) NULL ,

  `OPCINA` VARCHAR(30) NULL ,

  `DRZAVA_ID` INT NOT NULL ,

  PRIMARY KEY (`LOKACIJA_ID`) ,

  INDEX `fk_LOKACIJA_DRZAVA1_idx` (`DRZAVA_ID` ASC) ,

  UNIQUE INDEX `POSTANSKI_KOD_UNIQUE` (`POSTANSKI_KOD` ASC) ,

  CONSTRAINT `fk_LOKACIJA_DRZAVA1`

    FOREIGN KEY (`DRZAVA_ID` )

    REFERENCES `mydb`.`DRZAVA` (`DRZAVA_ID` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`POSAO`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`POSAO` (

  `POSAO_ID` INT NOT NULL ,

  `POZICIJA` VARCHAR(30) NULL ,

  PRIMARY KEY (`POSAO_ID`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`LOGIN`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`LOGIN` (

  `LOG_ID` INT NOT NULL ,

  `USERNAME` VARCHAR(45) NOT NULL ,

  `PASSWORD_HASH` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`LOG_ID`) ,

  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC) ,

  UNIQUE INDEX `PASSWORD_UNIQUE` (`PASSWORD_HASH` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`UPOSLENI`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`UPOSLENI` (

  `UPOSLENI_ID` INT NOT NULL ,

  `IME` VARCHAR(30) NULL ,

  `PREZIME` VARCHAR(30) NULL ,

  `JMBG` INT NULL ,

  `ADRESA` VARCHAR(30) NULL ,

  `DATUM_RODENJA` DATE NULL ,

  `DATUM_ZAPOSLENJA` DATE NULL ,

  `PLATA` DOUBLE NULL ,

  `BROJ_TELEFONA` VARCHAR(30) NULL ,

  `EMAIL` VARCHAR(30) NULL ,

  `PREBIVALISTE` INT NOT NULL ,

  `POSAO_ID` INT NOT NULL ,

  `LOGIN` INT NOT NULL ,

  PRIMARY KEY (`UPOSLENI_ID`) ,

  UNIQUE INDEX `JMBG_UNIQUE` (`JMBG` ASC) ,

  INDEX `fk_UPOSLENI_LOKACIJA1_idx` (`PREBIVALISTE` ASC) ,

  INDEX `fk_UPOSLENI_POSAO1_idx` (`POSAO_ID` ASC) ,

  INDEX `fk_UPOSLENI_LOGIN1_idx` (`LOGIN` ASC) ,

  CONSTRAINT `fk_UPOSLENI_LOKACIJA1`

    FOREIGN KEY (`PREBIVALISTE` )

    REFERENCES `mydb`.`LOKACIJA` (`LOKACIJA_ID` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_UPOSLENI_POSAO1`

    FOREIGN KEY (`POSAO_ID` )

    REFERENCES `mydb`.`POSAO` (`POSAO_ID` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_UPOSLENI_LOGIN1`

    FOREIGN KEY (`LOGIN` )

    REFERENCES `mydb`.`LOGIN` (`LOG_ID` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`KLIJENT`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`KLIJENT` (

  `KLIJENT_JIB` INT NOT NULL ,

  `NAZIV` VARCHAR(30) NULL ,

  `TIP` VARCHAR(30) NULL ,

  `BROJ_TELEFONA` VARCHAR(30) NULL ,

  `EMAIL` VARCHAR(30) NULL ,

  `WEB` VARCHAR(45) NULL ,

  `PREBIVALISTE` INT NOT NULL ,

  PRIMARY KEY (`KLIJENT_JIB`) ,

  INDEX `fk_KUPAC_LOKACIJA1_idx` (`PREBIVALISTE` ASC) ,

  CONSTRAINT `fk_KUPAC_LOKACIJA1`

    FOREIGN KEY (`PREBIVALISTE` )

    REFERENCES `mydb`.`LOKACIJA` (`LOKACIJA_ID` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`UREDAJ`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`UREDAJ` (

  `UREDAJ_JIB` INT NOT NULL ,

  `KLIJENT_JIB` INT NOT NULL ,

  `TIP` VARCHAR(45) NULL ,

  `IBFU` VARCHAR(45) NULL ,

  `IBFM` VARCHAR(45) NULL ,

  PRIMARY KEY (`UREDAJ_JIB`) ,

  UNIQUE INDEX `IBFM_UNIQUE` (`IBFM` ASC) ,

  UNIQUE INDEX `IBFU_UNIQUE` (`IBFU` ASC) ,

  INDEX `fk_UREDAJ_KLIJENT1_idx` (`KLIJENT_JIB` ASC) ,

  CONSTRAINT `fk_UREDAJ_KLIJENT1`

    FOREIGN KEY (`KLIJENT_JIB` )

    REFERENCES `mydb`.`KLIJENT` (`KLIJENT_JIB` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`ZADATAK`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`ZADATAK` (

  `BROJ` INT NOT NULL ,

  `ZAVRSITI_DO` DATETIME NULL ,

  `ZAHTJEV_PODNESEN` DATETIME NULL ,

  `DONIJETI_DO` DATETIME NULL ,

  `UPOSLENI` INT NOT NULL ,

  `UREDAJ` INT NOT NULL ,

  PRIMARY KEY (`BROJ`) ,

  INDEX `fk_ZADATAK_UPOSLENI1_idx` (`UPOSLENI` ASC) ,

  INDEX `fk_ZADATAK_UREDAJ1_idx` (`UREDAJ` ASC) ,

  CONSTRAINT `fk_ZADATAK_UPOSLENI1`

    FOREIGN KEY (`UPOSLENI` )

    REFERENCES `mydb`.`UPOSLENI` (`UPOSLENI_ID` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_ZADATAK_UREDAJ1`

    FOREIGN KEY (`UREDAJ` )

    REFERENCES `mydb`.`UREDAJ` (`UREDAJ_JIB` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;



USE `mydb` ;





SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;