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
                    <td colspan="2"  class="header" width="100%"><div style="float: left"><h1>Play Ground</h1></div> <div style="float: right;"><a href="<%=request.getContextPath()%>/logout.action">Logout</a></div></td>
                </tr>
                <tr>
                    <td width="20%" valign="top" class="sidebar">
                        <%@include file="../sidebar.jsp"%>
                    </td>
                    <td width="80%" valign="top" class="contentBody gridWrap" >
                        <a href="<%=request.getContextPath()%>/addTournamentDetailsView.action" id="addMatch">Add Match</a>
                        <table border='0' width='100%' align='center' id="tournamentDetails">
                            <tr>
                                <th>#</th>
                                <th>Match Name</th>
                                <th>Tournament Name</th>
                                <th>Team A</th>
                                <th>Team B</th>
                                <th>Winner</th>
                                <th>Match Scores</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>                            
                            <s:iterator value="playedMaptchesList" status="tournamentDetails">
                                <tr>
                                    <td><s:property value="#tournamentDetails.count"/></td>
                                    <td><s:property value="matchName" /></td>
                                    <td><s:property value="tournament.tournamentName" /></td>
                                    <td><s:property value="teamA.teamName" /></td>
                                    <td><s:property value="teamB.teamName" /></td>
                                    <td><s:property value="winner.teamName" /></td>
                                    <td><s:property value="results" /></td>
                                    <td>
                                        <s:url id="editTournamentDetailsURL" action="editTournamentDetailsView">
                                            <s:param name="playdMatchId" value="%{matchId}"></s:param>
                                        </s:url>
                                        <s:a href="%{editTournamentDetailsURL}">Edit</s:a>
                                        </td>
                                        <td>
                                        <s:url id="deleteTournamentDetailsURL" action="deleteTournamentDetails">
                                            <s:param name="playdMatchId" value="%{matchId}"></s:param>
                                        </s:url>
                                        <s:a href="%{deleteTournamentDetailsURL}">Delete</s:a>
                                        </td>
                                    </tr>
                            </s:iterator>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        <script>
            function hideColumns() {
                if (userRole !== "admin") {
                    $('#addMatch').hide();
                    $('#tournamentDetails td:nth-child(8), th:nth-child(8)').hide();
                    $('#tournamentDetails td:nth-child(9), th:nth-child(9)').hide();
//                    $('td:nth-child(8)').hide();
                }
            }
            hideColumns();
        </script>
    </body>
</html>

