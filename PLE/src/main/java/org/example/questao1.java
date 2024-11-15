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
