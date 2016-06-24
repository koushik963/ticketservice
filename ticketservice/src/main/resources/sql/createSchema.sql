CREATE TABLE `seat_hold` (
	`id` smallint NOT NULL,
	`email` varchar(100) NOT NULL,
	`holdStatus` tinyint NOT NULL,
	`holdTime` TIMESTAMP NOT NULL,
	`noOfSeats` smallint NOT NULL,
	`totalPrice` smallint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `seat` (
	`id` smallint NOT NULL,
	`number` smallint NOT NULL,
	`seatHoldId` smallint NOT NULL,
	`reserved` tinyint NOT NULL,
	`ttl` DATE NOT NULL,
	`levelId` smallint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `reservation` (
	`id` smallint NOT NULL,
	`confirmationCode` varchar(10) NOT NULL UNIQUE,
	`reservedTime` TIMESTAMP NOT NULL,
	`seatHoldId` smallint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `level` (
	`id` smallint NOT NULL,
	`name` varchar(10) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `levelDetails` (
	`id` smallint NOT NULL,
	`totalSeats` smallint NOT NULL,
	`price` smallint NOT NULL,
	`currentIndex` smallint NOT NULL,
	`levelId` smallint NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `seat` ADD CONSTRAINT `seat_fk0` FOREIGN KEY (`seatHoldId`) REFERENCES `seat_hold`(`id`);

ALTER TABLE `seat` ADD CONSTRAINT `seat_fk1` FOREIGN KEY (`levelId`) REFERENCES `level`(`id`);

ALTER TABLE `reservation` ADD CONSTRAINT `reservation_fk0` FOREIGN KEY (`seatHoldId`) REFERENCES `seat_hold`(`id`);

ALTER TABLE `levelDetails` ADD CONSTRAINT `levelDetails_fk0` FOREIGN KEY (`levelId`) REFERENCES `level`(`id`);
