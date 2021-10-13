USE m14_whitecollar;

CREATE TABLE IF NOT EXISTS shops (
  `shop_id` INT NOT NULL AUTO_INCREMENT,
  `shop_name` VARCHAR(255) NOT NULL,
  `shop_capacity` INT NOT NULL,
  `shop_creationdata` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`shop_id`));

CREATE TABLE IF NOT EXISTS pictures (
  `picture_id` INT NOT NULL AUTO_INCREMENT,
  `picture_author` VARCHAR(255) NOT NULL,
  `picture_name` VARCHAR(255) NOT NULL,
  `picture_price` DOUBLE NOT NULL,
  `picture_registrationdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `shop_id` INT NOT NULL,
  PRIMARY KEY (`picture_id`),
  INDEX `fk_pictures_shops_idx` (`shop_id` ASC),
  CONSTRAINT `fk_pictures_shops`
    FOREIGN KEY (`shop_id`)
    REFERENCES shops (`shop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);