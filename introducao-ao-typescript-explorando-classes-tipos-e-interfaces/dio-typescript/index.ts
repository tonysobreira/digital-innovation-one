//function
function soma(a: number, b: number) {
    return a + b;
}

//problem
//soma('a', 'b');
soma(2,2);

//interfaces - contratos
interface IAnimal {
    nome: string;
    tipo: 'terrestre' | 'aquático';
    domestico: boolean;
    //executarRugido(alturaEmDecibeis: number): void;
}

interface IFelino extends IAnimal {
    visaoNoturna: boolean;
}

interface ICanino extends IAnimal {
    porte: 'pequeno' | 'médio' | 'grande';
}

//types - junções
type IDomestico = IFelino | ICanino;

const animal: IDomestico = {
    domestico: true,
    nome: 'cachorro',
    porte: 'médio',
    tipo: 'terrestre',
    visaoNoturna: true
}

//error
/*
type IDomestico2 = IFelino & ICanino;
const animal2: IDomestico2 = {
    domestico: true,
    nome: 'cachorro',
    porte: 'médio',
    tipo: 'terrestre'
}
*/

//error
//animal.executarRugido('s');
/*
const felino: IFelino = {
    nome: 'Leão',
    tipo: 'terrestre',
    visaoNoturna: true,
    executarRugido: (alturaEmDecibeis) => (`${alturaEmDecibeis}`)
}
*/

//types
type Animal = {
    nome: string;
    tipo: 'terrestre' | 'aquático';
    executarRugido(alturaEmDecibeis: number): void;
}

//input element
const input = document.getElementById('input') as HTMLInputElement;

input.addEventListener('input', (event) => {
    const i = event.currentTarget as HTMLInputElement;
    console.log(i.value);
});



//generic types
function adicionaApendiceALista<T>(array: T[], valor: T) {
    return array.map(() => valor);
}

adicionaApendiceALista([1, 2, 3], 1);

adicionaApendiceALista(['A', 'B', 'C'], 'D');

//
/*
interface IUsuario {
    id: string;
    email: string;
}

interface IAdmin extends IUsuario {
    cargo: 'gerente' | 'coordenador' | 'supervisor';
}

function redireciona(usuario: IUsuario | IAdmin) {
    if ('cargo' in usuario) {
        //redirecionar para a área de administração
    }

    //redirecionar para a área de usuário
}
*/

//variáveis opcionais
interface IUsuario {
    id: string;
    email: string;
    cargo?: 'gerente' | 'coordenador' | 'supervisor' | 'funcionario';
}

function redireciona(usuario: IUsuario) {
    if (usuario.cargo) {
        //redirecionar(usuario.cargo);
    }

    //redirecionar para a área do usuário
}

//readonly e private

interface Cachorro {
    readonly nome: string;
    readonly idade: number;
    readonly parqueFavorito?: string;
}

//remove opcionais: -?
type CachorroSomenteLeitura = {
    +readonly [K in keyof Cachorro]-?: Cachorro[K];
}

const meuCachorro: Cachorro = {
    nome: 'Apolo',
    idade: 14,
}

class MeuCachorro implements CachorroSomenteLeitura {
    //private idade;
    //private nome;

    idade;
    nome;
    parqueFavorito;

    constructor(nome, idade) {
        this.idade = idade;
        this.nome = nome;
    }
}

const cao = new MeuCachorro('Apolo', 14);

cao.idade = 81;

console.log(cao);


// importar
import $ from 'jquery';

$.fn.extend({
    novaFuncao() {
        console.log('Chamou nova funcao');
    }
})

$('body').novaFuncao();

// exportar
export const numero = 2;


// Omit

interface Pessoa {
    nome: string;
    idade: number;
    nacionalidade: string;
}

interface Brasileiro extends Omit<Pessoa, 'nacionalidade'> {

}

const brasileiro: Brasileiro = {
    nome: 'aaa',
    idade: 18,
}

