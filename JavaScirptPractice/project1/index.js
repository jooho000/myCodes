console.log("hello");
console.log("I like pizza");

//window.alert(`This is an alert!`);

document.getElementById("myH1").textContent = `Hello`;

let age = 21;
let price = 10.99;
let firstName = window.prompt("What is your first name?");
let online = true;
console.log(`${firstName} is ${age} years old, whith a price of ${price}.`);
console.log(typeof price);
console.log(typeof firstName);
console.log(typeof online);

console.log(`${firstName} is online: ${online}`);

document.getElementById("p1").textContent = `Your name is ${firstName}`;
document.getElementById("p2").textContent = `${firstName} is online: ${online}`;
document.getElementById("p3").textContent = `type what you want so Header becomes "Hello (input)"`;

let input;
document.getElementById("mySubmit").onclick = function() {
    input = document.getElementById("myText").value;
    document.getElementById("myH1").textContent = `Hello ${input}`;
}

let length;
let width;
document.getElementById("areaHeader").textContent = `Area of square finder`;
document.getElementById("areaSubmit").onclick = function() {
    length = document.getElementById("length").value;
    width = document.getElementById("width").value;
    let total = length * width;
    document.getElementById("area").textContent = `area: ${total}`;
}


