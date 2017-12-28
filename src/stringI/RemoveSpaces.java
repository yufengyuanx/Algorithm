package stringI;

public class RemoveSpaces {
  // Assumption: input is not null.
  public String removeSpaces(String input) {
    if (input.isEmpty()) {
      return input;
    }
    char[] array = input.toCharArray();
    int end = 0;
    for (int i = 0; i < array.length; i++) {
      // when we would ignore the current space character:
      // 1. we ignore all the space characters followed by
      // another space characters, only the first one will be remained.
      // 2. we ignore also the space character if it is the
      // first character of the input string.
      if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
        continue;
      }
      array[end++] = array[i];
    }
    // Post-processing: it is possible we still have one trailing
    // space character at the end.
    if (end > 0 && array[end - 1] == ' ') {
      end--;
    }
    return new String(array, 0, end);
  }
}
