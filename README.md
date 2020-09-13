# CodeAssignmentPyramed

Code Assignment for Pyramed Telemedicine

SpringBoot Backend  + MySql DB

Rest Endpoints: 
1. "/register" - POST Method
2. "/login" - POST Method
3. "/logout" - GET Method
4. "/postChit" - POST Method
5. "/follow" - POST Method
6. "/getChit" - GET Method - Return -> HashMap<User,Chits By Users>
7. "/getMyChits" - GET Method - Return -> List<String>

Sample Post Body :
Postman - POST - body - raw - JSON:

	"/register" -
		{
	    "userName": "asdfgh",
	    "followingIDs": null,
	    "followersID": null,
	    "password": "asdfgh"
		}
	
	"/login" -
	{
	    "username": "asdfgh",
	    "password": "asdfgh"
	}
	
	"/postChit" -
	{
	    "chit":"test qazxssw qaqawsws"
	}
	
	"/follow" -
	{
	    "userName":"qazxsw"
	}

MySQL to be run at localhost:3306
DBName - "chitter"

Tables-
1. users - To store user related data
2. userpass - to store user's login/password
3. chits - to store chits by users

Query to create tables-

	CREATE TABLE USERS(
	    userid INT PRIMARY KEY AUTO_INCREMENT,
	    username VARCHAR(64),
	    following VARCHAR(255),
	    followers VARCHAR(255),
		CONSTRAINT isnameunique UNIQUE (userid,username)
	    );
		
	CREATE TABLE USERPASS(
	    USERNAME VARCHAR(64),
	    PASSWORD VARCHAR(64)
	);
	
	CREATE TABLE CHITS(
	    chitid INT PRIMARY KEY AUTO_INCREMENT,
		username VARCHAR(64),
	    chit VARCHAR(150),
	    timeofchit TIME 
	);

Create user in MySQL with username = "user" and password = "password".

Method/Function Names are self explanatory.
