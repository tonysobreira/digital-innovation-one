/*
var nome = "Admin";
var idade = 59;
var frase = "Japão é o melhor time do mundo"
alert("Bem vindo " + nome + " idade " + idade);
console.log(nome);
console.log(frase.replace("Japão", "Brasil"));
console.log(frase.toUpperCase());
console.log(frase.toLowerCase());
*/

/*
var lista = ["maçã", "pêra", "laranja"];
lista.push("uva");
lista.pop();
console.log(lista);
console.log(lista.length);

console.log(lista.reverse());
console.log(lista.toString());

console.log(lista[0]);
console.log(lista.toString()[0]);

console.log(lista.join(" - "));
*/

/*
var fruta = {nome:"maçã", cor:"vermelha"}
console.log(fruta);
console.log(fruta.nome);
*/

/*
var frutas = [
    {nome:"maçã", cor:"vermelha"}, 
    {nome:"uva", cor:"roxa"}
]
console.log(frutas[1].nome);
console.log(frutas);
*/

/*
var idade = prompt("Qual sua idade ?");

if (idade >= 18) {
    alert("maior de idade");
} else {
    alert("menor de idade");
}
*/

/*
var count = 0;
while (count <= 5) {
    console.log(count);
    count++;
}
*/

/*
var count;
for (count = 0; count <= 5; count++) {
    console.log(count);
}
*/

/*
var d = new Date();
console.log(d.getMonth() + 1);
console.log(d.getMinutes());
console.log(d.getDay());
console.log(d.getHours());
console.log(d.toLocaleDateString());
console.log(d.getDate());
*/

/*
var list = ["a", "b", "c"];
list.pop();
console.log(list);

list.forEach(x => {
    console.log(x);
})
*/

/*
function soma(n1, n2) {
    return n1 + n2;
}

//alert(soma(5, 10));

function setReplace(frase, nome, novo_nome) {
    return frase.replace(nome, novo_nome);
}

//alert(setReplace("Vai Japão", "Japão", "Brasil"));

var validar = 0;

function validaIdade(idade) {
    if (idade >= 18) {
        validar = true;
    } else {
        validar = false;
    }
    return validar;
}

var idade = prompt("Qual sua idade?");
console.log(validaIdade(idade));
*/

function clicou() {
    document.getElementById("agradecimento").innerHTML = "<b>Obrigado por clicar</b>";

    //document.getElementById("agradecimento");
    //console.log(document.getElementById("agradecimento"))
}

function redirecionar() {
    window.open("https://www.google.com/");
    //window.location.href = "https://www.google.com/";
}

function trocar(elemento) {
    elemento.innerHTML = "Obrigado por passar o mouse";
    //alert("trocar texto");
}

function voltar(elemento) {
    elemento.innerHTML = "Passe o mouse aqui";
}

function load() {
    alert("Página carregada");
}

function funcaoChange(elemento) {
    console.log(elemento.value);
}

function somar() {
    var num1 = document.getElementById("input1").value;
    var num2 = document.getElementById("input2").value;
    var soma = parseInt(num1) + parseInt(num2);
    document.getElementById("resultado").innerHTML = soma;
}