/* Creating Database */
Create Database AutoGrader;

use AutoGrader;

/* Table: User*/
CREATE TABLE User
    (
	UserID			INT NOT NULL AUTO_INCREMENT,
	UserName		VARCHAR(30) NOT NULL,
	Password		VARCHAR(20) NOT NULL,
	EmailAdd		VARCHAR(50),
	Role			CHAR(1),
    Name			VARCHAR(50),
    PRIMARY KEY(UserID)
	);

/* Table: Course*/
CREATE TABLE Course
    (
	CourseID			INT NOT NULL AUTO_INCREMENT,
    	CourseName			VARCHAR(50),
 
    PRIMARY KEY(CourseID)
	);

/* Table: Seat*/
CREATE TABLE Seat
    (
	SeatID						INT NOT NULL AUTO_INCREMENT,
    CourseID					INT NOT NULL,
    UserID						INT NOT NULL,

    PRIMARY KEY(SeatID),
	FOREIGN KEY(CourseID) REFERENCES Course (CourseID) ON DELETE CASCADE,
	FOREIGN KEY(UserID) REFERENCES User (UserID) ON DELETE CASCADE
	);

	 
/* Table: Assignment */
CREATE TABLE Assignment
    (
	AssignmentID		INT NOT NULL AUTO_INCREMENT,
    	CourseID		INT NOT NULL,
	MaxPoints 			Double,
	AssignmentType		VARCHAR(20),
	ConfigurationFile	VARCHAR(100),

    	PRIMARY KEY(AssignmentID),	
	FOREIGN KEY(CourseID) REFERENCES Course (CourseID) ON DELETE CASCADE
	);

/* Table: AssignmentFile */
CREATE TABLE AssignmentFile
    (
	AssignmentFileID	INT NOT NULL AUTO_INCREMENT,
    	AssignmentID		INT NOT NULL,
	UserID				INT NOT NULL,
	AssignmentFileName	VARCHAR(50) NOT NULL,
    Score				Double,
    IsSolution			BOOLEAN,

    PRIMARY KEY(AssignmentFileID),
	FOREIGN KEY(AssignmentID) REFERENCES Assignment (AssignmentID) ON DELETE CASCADE,
	FOREIGN KEY(UserID) REFERENCES User (UserID) ON DELETE CASCADE
	);





