<%@taglib uri="/struts-tags" prefix="s"%>
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
                    <td width="80%" valign="top" class="contentBody">
                        <s:form name="editUser">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        <s:textfield name="userName"  label="Username" readonly="true"></s:textfield>  
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:password name="password" label="Password"></s:password>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="center">
                                        <%--<s:submit id="#submit" value="Register" theme="simple"></s:submit>
                                        <s:reset id="#reset" value="Reset"  theme="simple"></s:reset> --%>
                                        <input type="button" name="edit" value="Edit" onclick="onEditBtnClick();">
                                        <input type="reset" name="resetBtn" value="Reset">
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </td>
                </tr>
            </table>
        </div>
        <script>
            var cntxtPath = "<%=request.getContextPath()%>";
//            $("#submit").click(function () {
            function onEditBtnClick(parameters) {
                var userFormObj = document.forms["editUser"];
                var userObj = {
                    "userName": userFormObj.userName.value,
                    "password": userFormObj.password.value
                };

                var validations = {
                    "userName": {
                        "name": "userName",
                        "message": "Username required."
                    },
                    "password": {
                        "name": "password",
                        "message": "Password required."
                    }
                };
                console.log(userObj);
                var validation = validateForm(userFormObj, validations, "notEmpty");
                if (validation) {
                    var confObj = {
                        action: "edituser",
                        form: "editUser"
                    };
                    overrideSubmit(confObj);
                }


            }
//            );
        </script>
    </body>
</html>

<%@taglib uri="/struts-tags" prefix="s"%>
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
                    <td valign="top" class="contentBody" class="formWrap">
                        <s:form name="registerUser">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        <s:textfield name="userName"  label="Username"></s:textfield>  
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:password name="password" label="Password"></s:password>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="center">
                                        <%--<s:submit id="#submit" value="Register" theme="simple"></s:submit>
                                        <s:reset id="#reset" value="Reset"  theme="simple"></s:reset> --%>
                                        <input type="button" name="register" value="Register" onclick="onRegisterBtnClick();">
                                        <input type="reset" name="resetBtn" value="Reset">
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </td>
                </tr>
            </table>
        </div>
        <script>
            var cntxtPath = "<%=request.getContextPath()%>";
//            $("#submit").click(function () {
            function onRegisterBtnClick(parameters) {
                var userFormObj = document.forms["registerUser"];
                var userObj = {
                    "userName": userFormObj.userName.value,
                    "password": userFormObj.password.value
                };

                var validations = {
                    "userName": {
                        "name": "userName",
                        "message": "Username required."
                    },
                    "password": {
                        "name": "password",
                        "message": "Password required."
                    }
                };
                console.log(userObj);
                var validation = validateForm(userFormObj, validations, "notEmpty");
                if (validation) {
                    var confObj = {
                        action: "registeruser",
                        form: "registerUser"
                    };
                    overrideSubmit(confObj);
                }


            }
//            );
        </script>
    </body>
</html>

