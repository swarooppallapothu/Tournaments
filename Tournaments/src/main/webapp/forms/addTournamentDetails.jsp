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
                        <s:form name="addTournamentDetailsForm" autocomplete="off" class="formWrap">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        <s:textfield name="matchName"  label="Match Name" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:select name="tournament.tournamentId"  label="Tournamentame" list="{}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:select name="teamA.teamId"  label="Team A" list="{}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:select name="teamB.teamId"  label="Team B" list="{}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="button" name="addTournamentDet" value="Add" onclick="onAddTournamentDetBtnClick()">
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
            var tournamentDetFormObj = document.forms["addTournamentDetailsForm"];
            function onAddTournamentDetBtnClick(parameters) {
                var validations = {
                    "matchName": {
                        "name": "matchName",
                        "message": "Match Name required."
                    }
                };
                var validation = validateForm(tournamentDetFormObj, validations, "notEmpty");
                if (validation) {
                    var confObj = {
                        action: "addTournamentDetails",
                        form: "addTournamentDetailsForm"
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
                var teamBSelect = $(tournamentDetFormObj["teamB.teamId"]);
                teamBSelect.find('option').remove();
                $.each(teams, function (key, value) {
                    $('<option>').val(key).text(value).appendTo(teamBSelect);
                });
            }
            function loadTournamentDetails() {
                var tournaments = getTournaments();
                var tournamentSelect = $(tournamentDetFormObj["tournament.tournamentId"]);
                tournamentSelect.find('option').remove();
                $.each(tournaments, function (key, value) {
                    $('<option>').val(key).text(value).appendTo(tournamentSelect);
                });
            }
            loadTeamDetails();
            loadTournamentDetails();
        </script>
    </body>
</html>

