function validateForm(formObj, notEmptyValues) {
    if (!formObj) {
        return;
    }

    for (var emptyValue in notEmptyValues) {
        console.log(notEmptyValues[emptyValue].name + "   " + formObj[notEmptyValues[emptyValue].name].value + "   " + notEmptyValues[emptyValue].message);
    }
    return true;
}