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
                    <a href="loginpage.action">Teams</a><br />
                </td>
                <td width="80%" valign="top" bgcolor="#d2d8c7">
                    <s:if test="tournmentsList.size() > 0">
                <center>
                    <table border="1" >
                        <tr>
                            <th>#</th>
                            <th>Tournament Name</th>
                            <th>Team Name</th>
                            <th>Add Team</th>
                            <th>Edit Team</th>
                            <th>Delete Team</th>
                        </tr>
                        <s:iterator var="tournament" value="tournmentsList">
                            <s:iterator var="team" value="#tournament.teamsList" status="ts">
                                <tr>
                                    <td><s:property value="#ts.count"/></td>
                                    <td><s:property value="tournamentName" /></td>
                                    <td><s:property value="#team.teamName" /></td>
                                    <td>
                                        <s:url id="addTeamURL" action="getaddteamform">
                                            <%--<s:param name="tournamentId" value="%{tournamentId}"></s:param>--%>
                                        </s:url>
                                        <s:a href="%{addTeamURL}">Add</s:a>
                                        </td>
                                        <td>
                                        <s:url id="editTeamURL" action="geteditteam">
                                            <s:param name="teamId" value="%{teamId}"></s:param>
                                            <s:param name="teamName" value="%{teamName}"></s:param>
                                        </s:url>
                                        <s:a href="%{editTeamURL}">Edit</s:a>
                                        </td>
                                        <td>
                                        <s:url id="deleteTeamURL" action="deleteteam">
                                            <s:param name="teamId" value="%{teamId}"></s:param>
                                        </s:url>
                                        <s:a href="%{deleteTeamURL}">Delete</s:a>
                                        </td>
                                    </tr>
                            </s:iterator>
                        </s:iterator>
                    </table>
                    </celter>
                </s:if>
                </td></tr>
        </table>
    </body>
    <html>

