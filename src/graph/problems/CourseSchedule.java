package graph.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * ----------
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * ----------
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * <p>
 * Note:
 * -----
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented(https://www.khanacademy
 * .org/computing/computer-science/algorithms/graph-representation/a/representing-graphs)
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {

  private static boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = new LinkedList[numCourses];

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new LinkedList<>();
    }

    // init an in-degree array.
    int[] inDegree = new int[numCourses];

    // init queue
    Queue<Integer> gQ = new LinkedList<>();

    for (int i = 0; i < prerequisites.length; i++) {
      // get the edge (u,v)
      int u = prerequisites[i][1];
      int v = prerequisites[i][0];

      inDegree[v]++;

      // add to the graph.
      graph[u].add(v);
    }

    // before we start the process of sorting, find all nodes
    // that have 0 inDegree and put them in the Q.
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        gQ.add(i);
      }
    }

    // start topo sorting.
    // note: we only check for legal DAG.
    // we want to see that in did 'numCourses' nodes got dequeued from the Q.
    // if its not the case - we a a cycle which means the answer to our question is false.
    int counter = 0;

    while (!gQ.isEmpty()) {
      // poll a node with inDegree 0
      int nodeId = gQ.poll();

      // remove its edges and update the inDegree array.
      // if of one of the children got an in degree 0 - add it to the Q and perform BFS
      for (int childId : graph[nodeId]) {
        inDegree[childId]--;

        if (inDegree[childId] == 0) {
          gQ.add(childId);
        }
      }
      counter++;
    }

    return (counter == numCourses);
  }

  public static void main(String[] args) {
    int numOfCourses = 2;
    int[][] preReqs = {{1, 0}, {0, 1}};
    System.out.println(canFinish(numOfCourses, preReqs));
  }
}
