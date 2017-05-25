package br.ufrn.imd.ppgsw.ed.sorter;

public class RadixSort extends Sorter {

    public RadixSort() {
        this.nome = new String("RADIX_SORT");
    }
    
    public void radixSort(int[] array, int from, int to) {
        for (int i = 0; i < 3; i++) {
            int power = (int) Math.pow(10, i + 1);

            int z[][] = new int[array.length][10];
            int n[] = new int[10];

            for (int j = 0; j < array.length; j++) {
                int num = array[j];
                z[n[(num % power) / (power / 10)]][(num % power) / (power / 10)] = num;
                n[(num % power) / (power / 10)]++;

            }
            int c = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < array.length; k++) {
                    if (k < n[j]) {
                        array[c] = z[k][j];
                        c++;
                    } else {
                        break;
                    }
                }
            }

        }
    }

    @Override
    public int[] sort(int[] dataToSort) {
        int[] numeros = dataToSort;
        radixSort(numeros, 0, dataToSort.length - 1);
        return numeros;
    }

}
