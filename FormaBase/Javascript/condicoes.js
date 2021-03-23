/* 
var idade = prompt("Que idade tem?");

idade < 18 || idade > 130 ? alert("idade inválida.") : window.location = "http://www.formabase.com";

*/

var numeroMes = parseInt(prompt("Insira o mes em que nasceu (1-12)"));

switch (numeroMes) {
    case 1: document.write("Nasceu em Janeiro"); break;
    case 2: document.write("Nasceu em Fevereiro"); break;
    case 3: document.write("Nasceu em Março"); break;
    case 4: document.write("Nasceu em Abril"); break;
    case 5: document.write("Nasceu em Maio"); break;
    case 6: document.write("Nasceu em Junho"); break;
    case 7: document.write("Nasceu em Julho"); break;
    case 8: document.write("Nasceu em Agosto"); break;
    case 9: document.write("Nasceu em Setembro"); break;
    case 10: document.write("Nasceu em Outubro"); break;
    case 11: document.write("Nasceu em Novembro"); break;
    case 12: document.write("Nasceu em Dezembro"); break;
    default: document.write("Mes invalido");
}

switch (numeroMes) {
    case 1:
    case 2:
    case 3: document.write("Nasceu no Inverno"); break;
    case 4:
    case 5:
    case 6: document.write("Nasceu na Primavera"); break;
    case 7:
    case 8:
    case 9: document.write("Nasceu no Verao"); break;
    case 10:
    case 11:
    case 12: document.write("Nasceu no Outuno"); break;
    default: document.write("Mes invalido");
}