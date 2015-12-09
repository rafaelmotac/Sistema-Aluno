function validar() {
    var texto = document.getElementsByClassName("nota").value;

    var RegExp = /^[\d]{1,2}([.|,][\d]{2})?$/;

    if (RegExp.test(texto) == true) {
        if (texto > 10 || texto < 0) {
            alert("O valor deve estar entre 0 e 10!");
        } else {
            alert("Formato v�lido!");
        }
    } else {
        alert("Formato inv�lido!");
    }

}