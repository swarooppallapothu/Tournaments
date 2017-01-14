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
                        <form name="addPlayerForm" autocomplete="off" class="formWrap">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        Team Name
                                    </td>
                                    <td>
                                        <select type="text" name="team" >
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Player Name
                                    </td>
                                    <td>
                                        <input type="text" name="playerName" >
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="button" name="addPlayer" value="Add" onclick="onAddPlayerBtnClick()">
                                        <input type="reset" name="resetBtn" value="Reset">
                                    </td>
                                </tr>
                            </table>
                        </form>

                    </td>
                </tr>
            </table>
        </div>
        <script>
            var playerFormObj = document.forms["addPlayerForm"];
            function onAddPlayerBtnClick(parameters) {
                
                var playerObj = {
                    "playerName": playerFormObj.playerName.value
                };
                console.log(playerObj);
            }

            function loadTeamDetails() {
                var teams = getTeams();
                var teamSelect = $(playerFormObj.team);
                teamSelect.find('option').remove();
                $.each(teams, function (key, value) {
                    console.log(key, value);
                    $('<option>').val(key).text(value).appendTo(teamSelect);
                });
            }
            loadTeamDetails();
        </script>
    </body>
</html>

