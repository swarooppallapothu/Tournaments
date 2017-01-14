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
                        <s:form name="editTournamentForm" autocomplete="off" class="formWrap">
                            <table border='0' width='480px' align='center'>
                                <tr>
                                    <td>
                                        <s:hidden name="tournamentId" value="%{tournamentId}"/>
                                        <s:hidden name="userId" value="%{tournament.user.userId}"/>
                                        <s:textfield name="tournamentName" label="Tournament Name" value="%{tournament.tournamentName}"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield name="tournamentDate" label="Tournament Date" value="%{tournament.tournamentDate}"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield name="tournamentPlace" label="Tournament Place" value="%{tournament.tournamentPlace}"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="center">
                                            <input type="button" name="editTournament" value="Update" onclick="onEditTournamentBtnClick()">
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
            function onEditTournamentBtnClick(parameters) {
                var tournamentFormObj = document.forms["editTournamentForm"];
                var validations = {
                    "tournamentName": {
                        "name": "tournamentName",
                        "message": "Tournament Name required."
                    },
                    "tournamentDate": {
                        "name": "tournamentDate",
                        "message": "Tournament Date required."
                    },
                    "tournamentPlace": {
                        "name": "tournamentPlace",
                        "message": "Tournament Place required."
                    }
                };
                var validation = validateForm(tournamentFormObj, validations, "notEmpty");
                if (validation) {
                    var confObj = {
                        action: "updatetournament",
                        form: "editTournamentForm"
                    };
                    overrideSubmit(confObj);
                }

            }
        </script>
    </body>
</html>

