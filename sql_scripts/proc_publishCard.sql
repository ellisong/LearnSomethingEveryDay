CREATE DEFINER=`root`@`localhost` PROCEDURE `publishCard`(IN cardId INT(11), IN publish INT(11))
BEGIN
	SELECT publish
    FROM card
    WHERE CardId=cardId;
END