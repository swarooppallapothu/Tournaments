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
                    <td width="80%" valign="top" class="contentBody">
                        <s:form name="editTeamForm" autocomplete="off" class="formWrap">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        <s:hidden name="teamId" value="%{team.teamId}"/>
                                        <s:hidden name="user.userId" value="%{team.user.userId}"/>
                                        <s:textfield name="teamName" value="%{team.teamName}" label="Team Name" />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="button" name="editTeam" value="Edit" onclick="onEditTeamBtnClick()">
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
            function onEditTeamBtnClick(parameters) {
                var teamFormObj = document.forms["editTeamForm"];
                var teamObj = {
                    "teamName": teamFormObj.teamName.value
                };
                var validations = {
                    "userName": {
                        "name": "teamName",
                        "message": "Team Name required."
                    }
                };
                console.log(teamObj);
                var validation = validateForm(teamFormObj, validations, "notEmpty");
                if (validation) {
                    var confObj = {
                        action: "updateTeam",
                        form: "editTeamForm"
                    };
                    overrideSubmit(confObj);
                }
            }
        </script>
    </body>
</html>

