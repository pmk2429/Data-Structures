package graph.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

  private static boolean canFinish(int numCourses, int[][] prerequisites) {
    List[] graph = new List[numCourses];

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new LinkedList();
    }

    // init an in-degree array.
    int[] inDeg = new int[numCourses];

    // init queue
    Queue<Integer> Q = new LinkedList<>();

    for (int i = 0; i < prerequisites.length; i++) {
      // get the edge (u,v)
      int u = prerequisites[i][1];
      int v = prerequisites[i][0];

      inDeg[v]++;

      // add to the graph.
      graph[u].add(v);
    }

    // before we start the process of sorting, find all nodes
    //that have 0 inDegree and put them in the Q.
    for (int i = 0; i < inDeg.length; i++) {
      if (inDeg[i] == 0) {
        Q.add(i);
      }
    }

    // start topo sorting.
    //note: we only check for legal DAG.
    //we want to see that in did 'numCourses' nodes got dequeued from the Q.
    //if its not the case-  we a a cycle wich meens th eanswer to our quastion is false.
    int counter = 0;

    while (!Q.isEmpty()) {
      //poll a node with indegree 0;
      int nodeId = Q.poll();

      //remove its edges and update the indegree array.
      // if of one of the children got an in degree 0 - add it to the Q.
      Iterator<Integer> iter = graph[nodeId].iterator();
      while (iter.hasNext()) {
        int childId = iter.next();
        inDeg[childId]--;

        if (inDeg[childId] == 0) {
          Q.add(childId);
        }
      }
      counter++;
    }

    return (counter == numCourses);
  }
}
