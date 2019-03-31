package graph.sample;

public class Vertex implements Comparable<Vertex> {
  /**
   * label for Vertex
   */
  public String name;
  /**
   * length of shortest path from source
   */
  public int distance;
  /**
   * previous vertex on path from sourxe
   */
  public Vertex predecessor; // previous vertex

  /**
   * a measure of the structural importance of a vertex. The value should initially be set to zero. A higher
   * centrality score should mean a Vertex is more central.
   */
  public double centrality;
  /**
   * Infinite distance indicates that there is no path
   * from the source to this vertex
   */
  public static final int INFINITY = Integer.MAX_VALUE;

  public Vertex(String v) {
    name = v;
    distance = INFINITY; // start as infinity away
    predecessor = null;
    centrality = 0.0;
  }

  /**
   * The name of the Vertex is assumed to be unique, so it is used as a HashCode
   *
   * @see java.lang.Object#hashCode()
   */
  public int hashCode() {
    return name.hashCode();
  }

  public String toString() {
    return name;
  }

  /**
   * Compare on the basis of distance from source first and
   * then lexicographically
   */
  public int compareTo(Vertex other) {
    int diff = distance - other.distance;
    if (diff != 0) {
      return diff;
    } else {
      return name.compareTo(other.name);
    }
  }
}