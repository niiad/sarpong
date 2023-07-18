package main.structures;

import main.models.Product;

public class SNS {

    // selection sort using comparable product object
    public static void selectionSort(Product[] productArray) {
        for (int i = 0; i < productArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < productArray.length; j++) {
                if (productArray[minIndex].compareTo(productArray[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Product temp = productArray[i];
                productArray[i] = productArray[minIndex];
                productArray[minIndex] = temp;
            }
        }
    }

    // binary search with sorted array and prodName
    public static int binarySearch(Product[] productArray, String prodName) {
        int low = 0;
        int high = productArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (productArray[mid].getName().equals(prodName)) {
                return mid;
            } else if (productArray[mid].getName().compareTo(prodName) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
