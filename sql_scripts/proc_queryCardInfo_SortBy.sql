CREATE DEFINER=`root`@`localhost` PROCEDURE `queryCardInfo_SortBy`(IN sortparam VARCHAR(50))
BEGIN
	SELECT CARD.Title, 
           CARD.Description, 
		   CARD.DateCreated, 
           CARD.DateModified, 
           CARD.ImageLink, 
           CARD.EmbedLink
    FROM CARD
    ORDER BY CASE WHEN sortparam = 'Title' THEN Title
                  WHEN sortparam = 'Description' THEN Description
	              WHEN sortparam = 'DateCreated' THEN DateCreated
	              WHEN sortparam = 'DateModified' THEN DateModified
	              WHEN sortparam = 'ImageLink' THEN ImageLink
	              WHEN sortparam = 'EmbedLink' THEN EmbedLink
                  ELSE Title
			 END ASC;
END