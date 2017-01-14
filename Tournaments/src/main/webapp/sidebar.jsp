<table align="center" style="width: 100%">
    <tr id="tournamentsSidebar">
        <td>
            <a href="<%=request.getContextPath()%>/tournaments.action">Tournaments</a> 
        </td>
    </tr>

    <tr id="teamSidebar">
        <td>
            <a href="<%=request.getContextPath()%>/teams.action">Teams</a><br>
        </td>
    </tr>
    <tr id="playerSidebar">
        <td>
            <a href="<%=request.getContextPath()%>/players.action">Players</a><br>
        </td>
    </tr>
    <tr id="tournamentDetailsSidebar">
        <td>
            <a href="<%=request.getContextPath()%>/tournamentDetails.action">Tournament Details</a><br>
        </td>
    </tr>                 

    <tr id="usersSidebar">
        <td>
            <a href="<%=request.getContextPath()%>/users.action">Users</a><br>
        </td>
    </tr>                            

</table>

<script>
    var cntxtPath = "<%=request.getContextPath()%>";
    var userClearance = "${sessionScope.userObject.clearance}";
    if (parseInt(userClearance) === 0) {
        userRole = "admin";

    } else {
        $("#tournamentsSidebar").hide();
        $("#usersSidebar").hide();
        userRole = "user";
    }
</script>
