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
                        <form name="addTournamentForm" autocomplete="off" class="formWrap">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        Tournament Name
                                    </td>
                                    <td>
                                        <input type="text" name="tournamentName" >
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Tournament Date
                                    </td>
                                    <td>
                                        <input type="text" name="tournamentDate" >
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Tournament Place
                                    </td>
                                    <td>
                                        <input type="text" name="tournamentPlace" >
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="button" name="addTournament" value="Add" onclick="onAddTournamentBtnClick()">
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
            function onAddTournamentBtnClick(parameters) {
                var tournamentFormObj = document.forms["addTournamentForm"];
                var tournamentObj = {
                    "tournamentName": tournamentFormObj.tournamentName.value,
                    "tournamentDate": tournamentFormObj.tournamentDate.value,
                    "tournamentPlace": tournamentFormObj.tournamentPlace.value
                };
                console.log(tournamentObj);
            }
        </script>
    </body>
</html>

