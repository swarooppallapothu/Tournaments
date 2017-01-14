function validateForm(formObj, detailsObj, type) {
    if (!formObj) {
        return;
    }

    var isSuccessfullyValidated = true;
    for (var emptyValue in detailsObj) {
        if (type === "notEmpty") {
            if (!formObj[detailsObj[emptyValue].name].value) {
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