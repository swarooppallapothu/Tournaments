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
    TEAM_ID INT NOT NULL,
    CREATED_BY INT NOT NULL,
    CONSTRAINT FK_PLAYERS_TEAM FOREIGN KEY (TEAM_ID) REFERENCES TEAMS(TEAM_ID) ON DELETE CASCADE,
    CONSTRAINT FK_PLAYERS_UN FOREIGN KEY (CREATED_BY) REFERENCES USERS(USER_ID) ON DELETE CASCADE
);

CREATE TABLE PLAYED_MATCHES (
    MATCH_ID SERIAL PRIMARY KEY NOT NULL,
    MATCH_NAME TEXT NOT NULL,
    TEAMA INT NOT NULL,
    TEAMB INT NOT NULL,
    TOURNAMENT_ID INT NOT NULL,
    WINNER INT NULL,
    RESULTS INT NOT NULL,
    CREATED_BY INT NOT NULL,
    CONSTRAINT FK_PM_TEAMA FOREIGN KEY (TEAMA) REFERENCES TEAMS(TEAM_ID) ON DELETE CASCADE,
    CONSTRAINT FK_PM_TEAMB FOREIGN KEY (TEAMB) REFERENCES TEAMS(TEAM_ID) ON DELETE CASCADE,
    CONSTRAINT FK_PM_WINNER FOREIGN KEY (WINNER) REFERENCES TEAMS(TEAM_ID) ON DELETE CASCADE,
    CONSTRAINT FK_PM_TRNMNTID FOREIGN KEY (TOURNAMENT_ID) REFERENCES TOURNAMENTS(TOURNAMENT_ID) ON DELETE CASCADE
);