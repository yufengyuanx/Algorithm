package bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Assumptions: 1. matrix is not null, N * M where N > 0 and M > 0 2. k > 0 and
 * k <= N * M
 */
public class KthSmallestInSortedMatrix {
  static class Cell {
    int row;
    int col;
    int value;

    Cell(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    // Best First Search, need a minHeap on the value of each cells.
    PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.value == c2.value) {
          return 0;
        }
        return c1.value < c2.value ? -1 : 1;
      }
    });
    // all the generated cells will be marked true,
    // to avoid being generated more than once.
    boolean[][] visited = new boolean[rows][cols];
    minHeap.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;
    // iterate k - 1 rounds, the Best First Search the smallest k - 1 cells
    for (int i = 0; i < k; i++) {
      Cell cur = minHeap.poll();
      // the neighbor cell will be inserted back to the minHeap only if
      // 1. It is not out of boundary.
      // 2. it has not been generated before.
      // Because for each cell it could be generated twice.
      if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
        minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        visited[cur.row + 1][cur.col] = true;
      }
      if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
        minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        visited[cur.row][cur.col + 1] = true;
      }
    }
    return minHeap.peek().value;
  }
}
