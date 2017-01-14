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
                        <s:form name="editPlayerForm" autocomplete="off" class="formWrap">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        <s:hidden name="playerId" value="%{player.playerId}"/>
                                        <s:hidden name="team.oldTeamId" value="%{player.team.teamId}"/>
                                        <s:textfield name="playerName"  label="Player Name" value="%{player.playerName}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:select name="team.teamId"  label="Team Name" list="{}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="button" name="editPlayer" value="Edit" onclick="onEditPlayerBtnClick()">
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
            var playerFormObj = document.forms["editPlayerForm"];
            function onEditPlayerBtnClick(parameters) {
                var validations = {
                    "playerName": {
                        "name": "playerName",
                        "message": "Player Name required."
                    }
                };
                var validation = validateForm(playerFormObj, validations, "notEmpty");
                if (validation) {
                    var confObj = {
                        action: "updatePlayer",
                        form: "editPlayerForm"
                    };
                    overrideSubmit(confObj);
                }
            }

            function loadTeamDetails() {
                var teams = getTeams();
                var teamSelect = $(playerFormObj["team.teamId"]);
                teamSelect.find('option').remove();
                $.each(teams, function (key, value) {
                    $('<option>').val(key).text(value).appendTo(teamSelect);
                });
                teamSelect.val(playerFormObj["team.oldTeamId"].value);
            }
            loadTeamDetails();
        </script>
    </body>
</html>

