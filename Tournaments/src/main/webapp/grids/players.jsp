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
                    <td width="80%" valign="top" class="contentBody gridWrap" >
                        <table border='0' width='100%' align='center'>
                            <tr>
                                <th>#</th>
                                <th>Player Name</th>
                                <th>Team Name</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>ABCD</td>
                                <td>HYD</td>
                                <td><button type="button" value="edit">Edit</button></td>
                                <td><button type="button" value="delete">Delete</button></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        <script>
        </script>
    </body>
</html>

