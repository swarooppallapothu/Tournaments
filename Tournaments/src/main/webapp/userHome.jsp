<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>

        <title>Play Ground</title>

    </head>

    <body style="margin: 0px; padding: 0px; font-family: 'Trebuchet MS',verdana;">

        <table width="100%" style="height: 100%;" cellpadding="10" cellspacing="0" border="0">
            <tr>
                <td colspan="2" style="height: 100px;" bgcolor="#777d6a"><h1>Play Ground</h1></td></tr>
            <tr>
                <td width="20%" valign="top" bgcolor="#999f8e">
                    <a href="tournment.action">Tournaments</a><br /><br />
                    <a href="teams.action">Teams</a><br />
                </td>
                <td width="80%" valign="top" bgcolor="#d2d8c7">
                    <s:if test="tournmentsList.size() > 0">
                <center>
                    <table border="1" >
                        <tr>
                            <th>#</th>
                            <th>Tournament Name</th>
                            <th>Tournament Date</th>
                            <th>Tournament Place</th>
                            <th>Tournament Rank</th>
                            <th>Add Tournament</th>
                            <th>Edit Tournament</th>
                            <th>Delete Tournament</th>
                        </tr>
                        <s:iterator value="tournmentsList" status="tournament">
                            <tr>
                                <td><s:property value="#tournament.count"/></td>
                                <td><s:property value="tournamentName" /></td>
                                <td><s:property value="tournamentDate" /></td>
                                <td><s:property value="tournamentPlace" /></td>
                                <td><s:property value="tournamentRank" /></td>
                                <td>
                                    <s:url id="addTournamentURL" action="addtournamentform">

                                    </s:url>
                                    <s:a href="%{addTournamentURL}">Add</s:a>
                                    </td>
                                    <td>
                                    <s:url id="editTournamentURL" action="edittournament">
                                        <s:param name="tournamentId" value="%{tournamentId}"></s:param>
                                        <s:param name="tournamentName" value="%{tournamentName}"></s:param>
                                        <s:param name="tournamentDate" value="%{tournamentDate}"></s:param>
                                        <s:param name="tournamentPlace" value="%{tournamentPlace}"></s:param>
                                        <s:param name="tournamentRank" value="%{tournamentRank}"></s:param>
                                    </s:url>
                                    <s:a href="%{editTournamentURL}">Edit</s:a>
                                    </td>
                                    <td>
                                    <s:url id="deleteTournamentURL" action="deletetournament">
                                        <s:param name="tournamentId" value="%{tournamentId}"></s:param>
                                    </s:url>
                                    <s:a href="%{deleteTournamentURL}">Delete</s:a>
                                    </td>
                                </tr>
                        </s:iterator>
                    </table>
                    </celter>
                </s:if>
                </td></tr>
        </table>
    </body>
    <html>

