CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;

USE `mydb` ;

CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `cod_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome_usuario` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`cod_usuario`));

CREATE TABLE IF NOT EXISTS `mydb`.`tarefa` (
  `cod_tarefa` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `confere` INT NOT NULL,
  `usuario` INT NOT NULL,
  PRIMARY KEY (`cod_tarefa`),
  INDEX `tab_usuario` (`usuario` ASC),
  CONSTRAINT `usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `mydb`.`usuario` (`cod_usuario`)
);