package quickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class quickSort {

  public static void main(String[] args) {
    int[] array = {5, 3, 8, 1, 2, 9, 4, 7, 6};
    int[] sortedArray = sort(array);
    System.out.println(Arrays.toString(sortedArray));
  }

  public static int[] sort(int[] array) {
    // Dizinin sýralanmasý gerekiyorsa (yani dizinin uzunluðu 1'den fazla)
    if (array.length > 1) {
      // Pivot elemanýnýn indeksini bul
      int pivotIndex = array.length / 2;
      // Pivot elemanýnýn deðerini belirle
      int pivotValue = array[pivotIndex];

      // Pivot elemanýndan küçük elemanlarýn tutulduðu liste
      List<Integer> less = new ArrayList<>();
      // Pivot elemanýna eþit olan elemanlarýn tutulduðu liste
      List<Integer> equal = new ArrayList<>();
      // Pivot elemanýndan büyük olan elemanlarýn tutulduðu liste
      List<Integer> greater = new ArrayList<>();

      // Dizi elemanlarýný pivot deðerine göre sýnýflandýr
      for (int i : array) {
        if (i < pivotValue) {
          less.add(i);
        } else if (i == pivotValue) {
          equal.add(i);
        } else {
          greater.add(i);
        }
      }

      // Dizinin sýralanmýþ hali, pivot elemanýndan küçük olan elemanlarýn sýralanmýþ hali, pivot elemanýna eþit olan elemanlar ve pivot elemanýndan büyük olan elemanlarýn sýralanmýþ hali olacak þekilde birleþtirilir
      int[] sortedArray = concat(sort(toIntArray(less)), toIntArray(equal), sort(toIntArray(greater)));
      return sortedArray;
    } else {
      // Dizinin sýralanmasý gerekmiyorsa (yani dizinin uzunluðu 1 veya daha az) dizi döndürülür
      return array;
    }
  }
  

  // Ýki diziyi birleþtirir
  public static int[] concat(int[] a, int[] b, int[] c) {
    int[] result = new int[a.length + b.length + c.length];
    int i = 0;
    for (int x : a) {
      result[i] = x;
      i++;
    }
    for (int x : b) {
      result[i] = x;
      i++;
    }
    for (int x : c) {
      result[i] = x;
      i++;
    }
    return result;
  }
  	public static int[] toIntArray(List<Integer> list) {
	    int[] array = new int[list.size()];
	    for (int i = 0; i < array.length; i++) {
	      array[i] = list.get(i);
	    }
	    return array;
	  }
	}


