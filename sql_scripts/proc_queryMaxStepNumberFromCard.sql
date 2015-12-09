CREATE DEFINER=`root`@`localhost` PROCEDURE `queryMaxStepNumberFromCard`(IN cardId INT(11), OUT maxSteps INT(11))
BEGIN
	SELECT IFNULL(MAX(step.Number), 0) as maxNumber
	INTO maxSteps
	FROM step
	WHERE step.card_CardId = cardId;
END