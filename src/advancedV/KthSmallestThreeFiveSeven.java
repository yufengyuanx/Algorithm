package advancedV;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
// TODO
public class KthSmallestThreeFiveSeven {
    
    static class Node implements Comparable<Node>{
      int x;
      int y;
      int z;
      int value;
      
      public Node(int x, int y, int z, int value) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
      }
      
      @Override
      public int compareTo(Node other) {
        if (this.value == other.value) {
          return 0;
        }
        return this.value < other.value ? -1 : 1;
      }
      
      public List<Node> getNextThree() {
        List<Node> list = new ArrayList<>();
        list.add(new Node(this.x + 1, this.y, this.z, this.value * 3));
        list.add(new Node(this.x, this.y + 1, this.z, this.value * 5));
        list.add(new Node(this.x, this.y, this.z + 1, this.value * 7));
        return list;
      }
    }
    
    public long kth(int k) {
      // Write your solution here.
      Set<Node> visited = new HashSet<>();
      Set<Integer> visitedValue = new HashSet<>();
      PriorityQueue<Node> pq = new PriorityQueue<>();
      pq.offer(new Node(1,1,1, 105));
      visited.add(pq.peek());
//      visitedValue.add(pq.peek().value);
      int i = 0;
      Node res = null;
      while (i < k) {
        // poll() k - 1 times
        Node node = pq.poll();
        System.out.println(i + " " + node.value);
        for (Node nod: node.getNextThree()) {
          if (!visited.contains(nod)) {
            pq.offer(nod);
            visited.add(nod);
          }
        }
        
        if (visitedValue.contains(node.value)) {
          System.out.println("aaaa");
          i--;
        }
        if (i == k - 1) {
          res = node;
        }
        visitedValue.add(node.value);
        i++;
      }
      
      
      return res.value;
    }
    
    
    public static void main(String[] args) {
      KthSmallestThreeFiveSeven test = new KthSmallestThreeFiveSeven();
//      for (int i = 1; i < 10; i++) {
//        System.out.println(test.kth(i));
//      }
      System.out.println(test.kth(7));
    }
  }
