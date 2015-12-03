CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getPriorityList`()
BEGIN
	SELECT StreamName,MainStreamPriority
	FROM stream
	ORDER BY MainStreamPriority DESC;
END