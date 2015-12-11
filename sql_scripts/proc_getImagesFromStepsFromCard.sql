CREATE DEFINER=`root`@`localhost` PROCEDURE `getImagesFromStepsFromCard`(IN id INT(11))
BEGIN
	SELECT ImageLink
	FROM step
    WHERE (card_CardId = id) AND (ImageLink IS NOT NULL) AND (ImageLink != "")
    ORDER BY Number ASC;
END