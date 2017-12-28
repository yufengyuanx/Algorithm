package advancedII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {
  public int[] merge(int[][] arrayOfArrays) {
    // Assumptions: arrayOfArray is not null, none of the array is null either.
    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
    int length = 0;
    for (int i = 0; i < arrayOfArrays.length; i++) {
      int[] array = arrayOfArrays[i];
      length += array.length;
      if (array.length != 0) {
        // We use two index to record the position of each element:
        // the index of the array in the arrayOfArrays,
        // the index of the element in the array.
        minHeap.offer(new Entry(i, 0, array[0]));
      }
    }
    int[] result = new int[length];
    int cur = 0;
    while (!minHeap.isEmpty()) {
      Entry temp = minHeap.poll();
      result[cur++] = temp.value;
      if (temp.y + 1 < arrayOfArrays[temp.x].length) {
        temp.y++;
        temp.value = arrayOfArrays[temp.x][temp.y];
        minHeap.offer(temp);
      }
    }
    return result;
  }

  static class MyComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
      if (e1.value == e2.value) {
        return 0;
      }
      return e1.value < e2.value ? -1 : 1;
    }
  }

  static class Entry {
    // The row number
    int x;
    // the column number.
    int y;
    // The corresponding value.
    int value;

    Entry(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
}
