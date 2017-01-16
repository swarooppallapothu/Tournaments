function validateForm(formObj, detailsObj, type) {
    if (!formObj) {
        return;
    }

    var isSuccessfullyValidated = true;
    for (var emptyValue in detailsObj) {
        if (type === "notEmpty") {
            if (!formObj[detailsObj[emptyValue].name].value.trim()) {
                alert(detailsObj[emptyValue].message);
                isSuccessfullyValidated = false;
                return;
            }
        }
    }
    return isSuccessfullyValidated;
}

function submitActionConfObj() {
    return {
        url: "",
        type: "",
        data: "",
        contentType: "",
        dataType: "",
        async: "",
        successAction: "",
        cntxtPath: "",
        form: ""
    };
}

function submitAction(detailsObject) {
    $.ajax({
        url: detailsObject.url,
        type: detailsObject.type,
        data: typeof detailsObject.data === "object" ? JSON.stringify(detailsObject.data) : detailsObject.data,
        contentType: detailsObject.contentType,
        dataType: detailsObject.json,
        async: false,
        success: function (response) {
            window.location.href = detailsObject.successAction;

        },
        error: function (xhr) {
            window.location.href = detailsObject.cntxtPath + "/error.action";
        }
    });
}

function overrideSubmit(detailsObj) {
    document.forms[detailsObj.form].action = detailsObj.action + ".action";
    document.forms[detailsObj.form].submit();
}

function getTournaments() {
    var result;
    $.ajax({
        url: cntxtPath + '/getTournaments.action',
        type: "GET",
        data: null,
        dataType: "json",
        async: false,
        success: function (response) {
            result = response;
        },
        error: function (xhr) {
            result = {};
        }
    });
    return result;
}

function getTeams() {
    var result;
    $.ajax({
        url: cntxtPath + '/getTeams.action',
        type: "GET",
        data: null,
        dataType: "json",
        async: false,
        success: function (response) {
            result = response;
        },
        error: function (xhr) {
            result = {};
        }
    });
    return result;
}

function getTournamentResults() {
    return {
        3: "Victory (3 Points)",
        1: "Tie (1 Point)",
        0: "Defeat (0 Point)"
    };
}

function getParameterByName(name, url) {
    if (!url) {
        url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
    if (!results)
        return null;
    if (!results[2])
        return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}