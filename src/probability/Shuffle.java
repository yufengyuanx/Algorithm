package probability;

public class Shuffle {
  public void shuffle(int[] array) {
    // Assumption: array is not null.
    if (array.length <= 1) {
      return;
    }

    // from right to left
    // for index i - 1, randomly pick one of the first i elements.
    for (int i = array.length; i >= 1; i--) {
      int idx = (int) (Math.random() * i);
      swap(array, i - 1, idx);
    }
  }

  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

}
