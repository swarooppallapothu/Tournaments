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
                    <td width="80%" valign="top" class="contentBody gridWrap">
                        <table border='0' width='100%' align='center'>
                            <tr>
                                <th>#</th>
                                <th>Tournament Name</th>
                                <th>Tournament Date</th>
                                <th>Tournament Place</th>
                                <th>Matches</th>
                            </tr>
                            <s:iterator value="tournmentsList" status="tournament">
                                <tr>
                                    <td><s:property value="#tournament.count"/></td>
                                    <td><s:property value="tournamentName" /></td>
                                    <td><s:property value="tournamentDate" /></td>
                                    <td><s:property value="tournamentPlace" /></td>
                                    <td>
                                    <s:url id="tournamentMatchesListURL" action="torunamentsmatches">
                                            <s:param name="tournamentId" value="%{tournamentId}"></s:param>
                                            </s:url>
                                        <s:a href="%{tournamentMatchesListURL}">Tournament Matches</s:a>
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

