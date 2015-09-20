CREATE PROCEDURE `insertUserInfo`
	(IN username VARCHAR(32), IN passw VARCHAR(128), IN fullName VARCHAR(48), 
	 IN favoriteColor VARCHAR(8), IN favoriteActivity VARCHAR(16))
BEGIN
	INSERT INTO USER (Username, Password, FullName, FavoriteColor, FavoriteActivity)
	VALUES (username, passw, fullName, favoriteColor, favoriteActivity);
END
