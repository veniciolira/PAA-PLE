package org.example;

public class questao1 {

    public static int buscaSequencial(int[] lista, int valor) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public static int buscaBinaria(int[] lista, int valor) {
        int inicio = 0;
        int fim = lista.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (lista[meio] == valor) {
                return meio;
            } else if (lista[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] listaOrdenada = {2, 4, 6, 8, 10};
        int[] listaDesordenada = {5, 2, 8, 1, 10};

        int valorBuscado = 8;

        int indiceSequencial = buscaSequencial(listaDesordenada, valorBuscado);
        System.out.println("Busca Sequencial: Indice do valor " + valorBuscado + " = " + indiceSequencial);

        int indiceBinaria = buscaBinaria(listaOrdenada, valorBuscado);
        System.out.println("Busca Binária: Indice do valor " + valorBuscado + " = " + indiceBinaria);
    }
}
