function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username === "mariella" && password === "140200") {
        // dirige a la página de inicio
        window.location.href = "inicio.html";
    } else {
        alert("Credenciales incorrectas. Intenta de nuevo.");
    }
}

function logout() {
    document.getElementById("menu-container").style.display = "none";
    document.getElementById("login-container").style.display = "block";
}
