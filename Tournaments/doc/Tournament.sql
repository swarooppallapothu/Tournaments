CREATE TABLE USERS (
   USER_ID SERIAL  PRIMARY KEY     NOT NULL,
   USER_NAME TEXT    NOT NULL,
   PASSWORD	TEXT   NOT NULL,
   CLEARANCE INT   NOT NULL
);

INSERT INTO USERS (USER_NAME, PASSWORD, CLEARANCE) VALUES ('admin','admin',0);

CREATE TABLE TOURNAMENTS (
    TOURNAMENT_ID SERIAL PRIMARY KEY     NOT NULL,
    TOURNAMENT_NAME TEXT    NOT NULL,
    TOURNAMENT_DATE TIMESTAMP NOT NULL,
    PLACE TEXT NOT NULL,
    CREATED_BY INT NOT NULL,
    CONSTRAINT FK_TRNMNT_UN FOREIGN KEY (CREATED_BY) REFERENCES USERS(USER_ID) ON DELETE CASCADE
);

CREATE TABLE TEAMS (
    TEAM_ID SERIAL  PRIMARY KEY     NOT NULL,
    TEAM_NAME TEXT    NOT NULL,
    CREATED_BY INT NOT NULL,
    CONSTRAINT FK_TEAM_UN FOREIGN KEY (CREATED_BY) REFERENCES USERS(USER_ID) ON DELETE CASCADE
);

CREATE TABLE PLAYERS (
    PLAYER_ID SERIAL PRIMARY KEY NOT NULL,
    PLAYER_NAME TEXT NOT NULL,
    CREATED_BY INT NOT NULL,
    CONSTRAINT FK_PLAYERS_UN FOREIGN KEY (CREATED_BY) REFERENCES USERS(USER_ID) ON DELETE CASCADE
);

CREATE TABLE TEAM_PLAYERS (
    TEAM_PLAYER_ID SERIAL PRIMARY KEY NOT NULL,
    TEAM_ID INT NOT NULL,
    PLAYER_ID INT NOT NULL,
    CONSTRAINT FK_TP_TEAMID FOREIGN KEY (TEAM_ID) REFERENCES TEAMS(TEAM_ID) ON DELETE CASCADE,
    CONSTRAINT FK_TP_PLAYERID FOREIGN KEY (PLAYER_ID) REFERENCES PLAYERS(PLAYER_ID) ON DELETE CASCADE
);

CREATE TABLE PLAYED_MATCHES (
    MATCH_ID SERIAL PRIMARY KEY NOT NULL,
    TEAM1 INT NOT NULL,
    TEAM2 INT NOT NULL,
    TOURNAMENT_ID INT NOT NULL,
    RESULTS INT NOT NULL,
    CREATED_BY INT NOT NULL,
    CONSTRAINT FK_PM_TEAM1 FOREIGN KEY (TEAM1) REFERENCES TEAMS(TEAM_ID) ON DELETE CASCADE,
    CONSTRAINT FK_PM_TEAM2 FOREIGN KEY (TEAM2) REFERENCES TEAMS(TEAM_ID) ON DELETE CASCADE,
    CONSTRAINT FK_PM_TRNMNTID FOREIGN KEY (TOURNAMENT_ID) REFERENCES TOURNAMENTS(TOURNAMENT_ID) ON DELETE CASCADE,
    CONSTRAINT FK_PM_UN FOREIGN KEY (CREATED_BY) REFERENCES USERS(USER_ID) ON DELETE CASCADE
);