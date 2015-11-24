CREATE DEFINER=`root`@`localhost` PROCEDURE `insertLatestStepForCard`(IN cardId INT(11), IN userId INT(11), IN timeToComplete TIME, IN imageLink VARCHAR(256), IN description VARCHAR(512), IN heading VARCHAR(128))
BEGIN
	DECLARE maxStep INT signed DEFAULT 0;
	CALL queryMaxStepNumberFromCard(cardId, maxStep);
	SET maxStep = maxStep + 1;
	INSERT INTO step (card_CardId, card_USER_UserId, Number, TimeToComplete, ImageLink, Description, Heading)
	VALUES (cardId, userId, maxStep, timeToComplete, imageLink, description, heading);
END