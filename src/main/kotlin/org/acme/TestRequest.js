const xhr = new XMLHttpRequest();
xhr.open("POST", "http://localhost:8080/todos", true);
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onreadystatechange = (ev) => {
    if (xhr.readyState == 4) {
        alert("Miau");
    }
}
xhr.send(JSON.stringify({"descrition":"Munke"}));