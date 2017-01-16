<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Play Ground</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/styles.css"></link>
        <script src="<%=request.getContextPath()%>/static/jquery.js"></script>
        <script src="<%=request.getContextPath()%>/static/tournaments.js"></script>
    </head>
    <body>
        <div class="contentDiv">
            <table align="center" class="contentMainTbl">
                <tr>
                    <td colspan="2" class="header" width="100%"><h1>Play Ground</h1></td>
                </tr>
                <tr>
                    <td width="20%" valign="top" class="sidebar">
                        <%@include file="../sidebar.jsp"%>
                    </td>
                    <td width="80%" valign="top" class="contentBody">
                        <s:form name="editTournamentDetailsForm" autocomplete="off" class="formWrap">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        <s:hidden name="matchId" value="%{playerMatches.matchId}"/>
                                        <s:textfield name="matchName"  label="Match Name"  value="%{playerMatches.matchName}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:hidden name="tournament.oldTournamentId" value="%{playerMatches.tournament.tournamentId}"/>
                                        <s:select name="tournament.tournamentId"  label="Tournamentame" list="{}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:hidden name="teamA.oldTeamId" value="%{playerMatches.teamA.teamId}"/>
                                        <s:select name="teamA.teamId"  label="Team A" list="{}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:hidden name="teamB.oldTeamId" value="%{playerMatches.teamB.teamId}"/>
                                        <s:select name="teamB.teamId"  label="Team B" list="{}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:hidden name="winner.oldTeamId" value="%{playerMatches.winner.teamId}"/>
                                        <s:select name="winner.teamId"  label="Winner" list="{}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:hidden name="oldTournamentResult" value="%{playerMatches.results}"/>
                                        <s:select name="results"  label="Result" list="{}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="button" name="editTournamentDet" value="Edit" onclick="onEditTournamentDetBtnClick()">
                                        <input type="reset" name="resetBtn" value="Reset">
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </td>
                </tr>
            </table>
        </div>
        <script>
            var tournamentDetFormObj = document.forms["editTournamentDetailsForm"];
            function onEditTournamentDetBtnClick(parameters) {
                var validations = {
                    "matchName": {
                        "name": "matchName",
                        "message": "Match Name required."
                    }
                };
                var validation = validateForm(tournamentDetFormObj, validations, "notEmpty");
                if (validation) {
                    var confObj = {
                        action: "updateTournamentDetails",
                        form: "editTournamentDetailsForm"
                    };
                    overrideSubmit(confObj);
                }
            }

            function loadTeamDetails() {
                var teams = getTeams();
                var teamASelect = $(tournamentDetFormObj["teamA.teamId"]);
                teamASelect.find('option').remove();
                $.each(teams, function (key, value) {
                    $('<option>').val(key).text(value).appendTo(teamASelect);
                });
                teamASelect.val(tournamentDetFormObj["teamA.oldTeamId"].value);
                var teamBSelect = $(tournamentDetFormObj["teamB.teamId"]);
                teamBSelect.find('option').remove();
                $.each(teams, function (key, value) {
                    $('<option>').val(key).text(value).appendTo(teamBSelect);
                });
                teamBSelect.val(tournamentDetFormObj["teamB.oldTeamId"].value);
            }
            function loadTournamentDetails() {
                var tournaments = getTournaments();
                var tournamentSelect = $(tournamentDetFormObj["tournament.tournamentId"]);
                tournamentSelect.find('option').remove();
                $.each(tournaments, function (key, value) {
                    $('<option>').val(key).text(value).appendTo(tournamentSelect);
                });
                tournamentSelect.val(tournamentDetFormObj["tournament.oldTournamentId"].value);
            }
            function loadReuslts() {
                var results = getTournamentResults();

                var resultSelect = $(tournamentDetFormObj["results"]);
                resultSelect.find('option').remove();
                $.each(results, function (key, value) {
                    $('<option>').val(key).text(value).appendTo(resultSelect);
                });
                resultSelect.val(tournamentDetFormObj["oldTournamentResult"].value);
            }
            function loadWinners() {
                var winners = {};
                winners[tournamentDetFormObj["teamA.teamId"].value] = tournamentDetFormObj["teamA.teamId"].textContent.trim();
                winners[tournamentDetFormObj["teamB.teamId"].value] = tournamentDetFormObj["teamB.teamId"].textContent.trim();

                var winnerSelect = $(tournamentDetFormObj["winner.teamId"]);
                winnerSelect.find('option').remove();
                $.each(winners, function (key, value) {
                    $('<option>').val(key).text(value).appendTo(winnerSelect);
                });
                winnerSelect.val(tournamentDetFormObj["winner.oldTeamId"].value);
            }
            loadReuslts();
            loadTeamDetails();
            loadTournamentDetails();
            loadWinners();
        </script>
    </body>
</html>

