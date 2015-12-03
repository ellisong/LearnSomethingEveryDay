CREATE DEFINER=`root`@`localhost` PROCEDURE `publishCard`(IN cardId INT(11), IN publish INT(11))
BEGIN
    UPDATE card
    SET isPublished=publish
    WHERE CardId=cardId;
END