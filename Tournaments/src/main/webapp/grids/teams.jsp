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
                        <table border='0' width='100%' align='center'>
                            <tr>
                                <th>#</th>
                                <th>Team Name</th>
                                <th>Tournament Date</th>
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

