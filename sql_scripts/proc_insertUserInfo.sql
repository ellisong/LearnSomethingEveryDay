CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUserInfo`
  (IN username VARCHAR(32), IN email VARCHAR(64), IN passw VARCHAR(128), 
   IN fullName VARCHAR(48), IN favoriteColor VARCHAR(8), IN favoriteActivity VARCHAR(16))
BEGIN
	INSERT INTO USER (Username, Email, Password, FullName, FavoriteColor, FavoriteActivity)
    VALUES (username, email, passw, fullName, favoriteColor, favoriteActivity);
END