package queue;

public class LoadBalancer {
//  public static void main(String[] args) {
//
//    int m = Integer.parseInt(args[0]);
//    int n = Integer.parseInt(args[1]);
//    int s = Integer.parseInt(args[2]);
//
//    // Create server queues.
//    RandomQueue<Queue<Integer>> servers = new RandomQueue<>();
//
//    for (int i = 0; i < m; i++) {
//      servers.enqueue(new Queue<Integer>());
//    }
//
//    // Assign an item to a server
//    for (int j = 0; j < n; j++) {
//      // Pick a random server, update if new min.
//      Queue<Integer> min = servers.sample();
//      for (int k = 1; k < s; k++) {
//        Queue<Integer> queue = servers.sample();
//        if (queue.length() < min.length()) min = queue;
//      }
//
//      // min is the shortest server queue
//      min.enqueue(j);
//    }
//  }
}
