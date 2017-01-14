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
                        <table align="center" style="width: 100%">
                            <tr>
                                <td>
                                    <a href="void(0)">Tournaments</a> 
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="void(0)">Teams</a><br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="void(0)">Players</a><br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="void(0)">Team Details</a><br>
                                </td>
                            </tr>                            
                        </table>
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
            function onAddPlayerBtnClick(parameters) {
                var playerFormObj = document.forms["addPlayerForm"];
                var playerObj = {
                    "playerName": playerFormObj.playerName.value
                };
                console.log(playerObj);
            }
        </script>
    </body>
</html>

