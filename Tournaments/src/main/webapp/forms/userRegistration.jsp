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
                    <td valign="top" class="contentBody">
                        <form name="registerUser" autocomplete="off" class="formWrap">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        Username
                                    </td>
                                    <td>
                                        <input type="text" name="userName" >
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Password
                                    </td>
                                    <td>
                                        <input type="password" name="password" >
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="button" name="register" value="Register">
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
            function onRegisterBtnClick(parameters) {

            }
        </script>
    </body>
</html>

