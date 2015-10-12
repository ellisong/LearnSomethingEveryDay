CREATE DEFINER=`root`@`localhost` PROCEDURE `queryCards_SortBy`(IN sortparam VARCHAR(50))
BEGIN
	SELECT card.CardId,
           card.USER_UserId,
	       card.Title, 
           card.Description, 
		   card.DateCreated, 
           card.DateModified, 
           card.ImageLink, 
           card.Comments,
           card.TimeToComplete
    FROM card
    ORDER BY CASE WHEN sortparam = 'CardId' THEN CardId
                  WHEN sortparam = 'USER_UserId' THEN USER_UserId
                  WHEN sortparam = 'Title' THEN Title
	              WHEN sortparam = 'DateCreated' THEN DateCreated
	              WHEN sortparam = 'DateModified' THEN DateModified
                  WHEN sortparam = 'TimeToComplete' THEN TimeToComplete
                  ELSE CardId
			 END ASC;
END