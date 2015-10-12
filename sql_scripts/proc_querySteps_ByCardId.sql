CREATE DEFINER=`root`@`localhost` PROCEDURE `querySteps_ByCardId`(IN id INT(11))
BEGIN
	SELECT StepId,
           Number,
           TimeToComplete,
           ImageLink,
           Description
	FROM step
    WHERE card_CardId = id;
END