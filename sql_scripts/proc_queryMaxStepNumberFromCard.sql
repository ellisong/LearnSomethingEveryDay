-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `queryMaxStepNumberFromCard`(IN cardId INT(11), OUT maxSteps INT(11))
BEGIN
	SELECT MAX(step.Number)
	INTO maxSteps
	FROM step
	WHERE step.card_CardId = cardId;
END