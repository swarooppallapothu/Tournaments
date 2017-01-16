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
                        <a href="<%=request.getContextPath()%>/addPlayerView.action">Add Player</a>
                        <table border='0' width='100%' align='center'>
                            <tr>
                                <th>#</th>
                                <th>Player Name</th>
                                <th>Team Name</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>                            
                            <s:iterator value="playersList" status="player">
                                <tr>
                                    <td><s:property value="#player.count"/></td>
                                    <td><s:property value="playerName" /></td>
                                    <td><s:property value="team.teamName" /></td>
                                    <td>
                                        <s:url id="editPlayerURL" action="editPlayerView">
                                            <s:param name="playerId" value="%{playerId}"></s:param>
                                        </s:url>
                                        <s:a href="%{editPlayerURL}">Edit</s:a>
                                        </td>
                                        <td>
                                        <s:url id="deletePlayerURL" action="deletePlayer">
                                            <s:param name="playerId" value="%{playerId}"></s:param>
                                        </s:url>
                                        <s:a href="%{deletePlayerURL}">Delete</s:a>
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

