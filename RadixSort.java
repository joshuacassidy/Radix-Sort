public class RadixSort {

    public int[] sort(int[] arr, int radix, int amountOfPlaces) {
        for(int i= 0; i < amountOfPlaces; i++) {
            arr = sortHelper(arr, i, radix);
        }
        return arr;
    }

    public int[] sortHelper(int[] arr, int position, int radix) {
        int[] countArray = new int[radix];

        for (int i: arr) {
            countArray[getDigit(position,i,radix)]++;
        }

        for (int i  = 1; i < radix; i++) {
            countArray[i] += countArray[i-1];
        }

        int[] sortedArray = new int[arr.length];

        for (int i = arr.length-1; i >= 0; i--) {
            sortedArray[--countArray[getDigit(position,arr[i], radix)]] = arr[i];

        }

        return sortedArray;

    }

    public int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }

    public void traverse (int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}