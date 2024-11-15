import java.util.Arrays;

public class questao2 {
    static class Item {
        int valor, peso;

        Item(int valor, int peso) {
            this.valor = valor;
            this.peso = peso;
        }
    }

    public static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n+1][W+1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }

    public static double knapSackGuloso(int W, int[] val, int[] wt) {
        int n = val.length;
        Item[] itens = new Item[n];

        for (int i = 0; i < n; i++) {
            itens[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(itens, (a, b) -> Double.compare((double) b.valor / b.peso, (double) a.valor / a.peso));

        double valorTotal = 0.0;
        int capacidadeRestante = W;

        for (Item item : itens) {
            if (capacidadeRestante == 0) break;

            if (item.peso <= capacidadeRestante) {
                capacidadeRestante -= item.peso;
                valorTotal += item.valor;
            } else {
                valorTotal += (double) item.valor * capacidadeRestante / item.peso;
                capacidadeRestante = 0;
            }
        }

        return valorTotal;
    }
}
