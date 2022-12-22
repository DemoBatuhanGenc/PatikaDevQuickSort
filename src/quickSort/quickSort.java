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
    // Dizinin s�ralanmas� gerekiyorsa (yani dizinin uzunlu�u 1'den fazla)
    if (array.length > 1) {
      // Pivot eleman�n�n indeksini bul
      int pivotIndex = array.length / 2;
      // Pivot eleman�n�n de�erini belirle
      int pivotValue = array[pivotIndex];

      // Pivot eleman�ndan k���k elemanlar�n tutuldu�u liste
      List<Integer> less = new ArrayList<>();
      // Pivot eleman�na e�it olan elemanlar�n tutuldu�u liste
      List<Integer> equal = new ArrayList<>();
      // Pivot eleman�ndan b�y�k olan elemanlar�n tutuldu�u liste
      List<Integer> greater = new ArrayList<>();

      // Dizi elemanlar�n� pivot de�erine g�re s�n�fland�r
      for (int i : array) {
        if (i < pivotValue) {
          less.add(i);
        } else if (i == pivotValue) {
          equal.add(i);
        } else {
          greater.add(i);
        }
      }

      // Dizinin s�ralanm�� hali, pivot eleman�ndan k���k olan elemanlar�n s�ralanm�� hali, pivot eleman�na e�it olan elemanlar ve pivot eleman�ndan b�y�k olan elemanlar�n s�ralanm�� hali olacak �ekilde birle�tirilir
      int[] sortedArray = concat(sort(toIntArray(less)), toIntArray(equal), sort(toIntArray(greater)));
      return sortedArray;
    } else {
      // Dizinin s�ralanmas� gerekmiyorsa (yani dizinin uzunlu�u 1 veya daha az) dizi d�nd�r�l�r
      return array;
    }
  }
  

  // �ki diziyi birle�tirir
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


