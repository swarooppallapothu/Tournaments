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
                        <a href="<%=request.getContextPath()%>/addTournamentView.action">Add Tournament</a>
                        <table border='0' width='100%' align='center'>
                            <tr>
                                <th>#</th>
                                <th>Tournament Name</th>
                                <th>Tournament Date</th>
                                <th>Tournament Place</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <s:iterator value="tournmentsList" status="tournament">
                                <tr>
                                    <td><s:property value="#tournament.count"/></td>
                                    <td><s:property value="tournamentName" /></td>
                                    <td><s:property value="tournamentDate" /></td>
                                    <td><s:property value="tournamentPlace" /></td>
                                    <td><button type="button" value="edit">Edit</button></td>
                                    <td><button type="button" value="delete">Delete</button></td>
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

