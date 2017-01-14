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
                    <td width="80%" valign="top" class="contentBody gridWrap">
                        <a href="<%=request.getContextPath()%>/addTeamView.action">Add Team</a>
                        <table border='0' width='100%' align='center'>
                            <tr>
                                <th>#</th>
                                <th>Team Name</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <s:iterator value="teamsList" status="team">
                                <tr>
                                    <td><s:property value="#team.count"/></td>
                                    <td><s:property value="teamName" /></td>
                                    <td>
                                    <s:url id="editTeamURL" action="editTeamView">
                                            <s:param name="teamId" value="%{teamId}"></s:param>
                                            </s:url>
                                        <s:a href="%{editTeamURL}">Edit</s:a>
                                </td>
                                <td>
                                <s:url id="deleteTeamURL" action="deleteTeam">
                                             <s:param name="teamId" value="%{teamId}"></s:param>
                                        </s:url>
                                        <s:a href="%{deleteTeamURL}">Delete</s:a>
                                </td>
                                </tr>
                            </s:iterator>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        <script>
        </script>
    </body>
</html>

