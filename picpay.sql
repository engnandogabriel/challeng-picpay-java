-- MySQL Script generated by MySQL Workbench
-- Sat Jun  1 14:06:15 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema picpay
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema picpay
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `picpay` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `picpay` ;

-- -----------------------------------------------------
-- Table `picpay`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `picpay`.`users` (
  `user_id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `document` VARCHAR(15) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `type_user` VARCHAR(10) NOT NULL,
  `amount` DECIMAL(10,2) NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `document_UNIQUE` (`document` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `picpay`.`transfers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `picpay`.`transfers` (
  `transfer_id` VARCHAR(36) NOT NULL,
  `value` DECIMAL(10,2) NOT NULL,
  `payer` VARCHAR(36) NOT NULL,
  `payee` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`transfer_id`),
  UNIQUE INDEX `transfer_id_UNIQUE` (`transfer_id` ASC) VISIBLE,
  INDEX `fk_transfers_users_idx` (`payer` ASC) VISIBLE,
  INDEX `fk_transfers_users1_idx` (`payee` ASC) VISIBLE,
  CONSTRAINT `fk_transfers_users`
    FOREIGN KEY (`payer`)
    REFERENCES `picpay`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transfers_users1`
    FOREIGN KEY (`payee`)
    REFERENCES `picpay`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
