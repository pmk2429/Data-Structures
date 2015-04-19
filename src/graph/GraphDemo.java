package graph;

import java.util.*;

public class GraphDemo {
	// Alternatively, use a Multimap:
	// http://google-collections.googlecode.com/svn/trunk/javadoc/com/google/common/collect/Multimap.html
	private Map<String, List<String>> edges = new HashMap<String, List<String>>();

	public void addEdge(String src, String dest) {
		List<String> srcNeighbors = this.edges.get(src);
		if (srcNeighbors == null) {
			this.edges.put(src, srcNeighbors = new ArrayList<String>());
		}
		srcNeighbors.add(dest);
	}

	public Iterable<String> getNeighbors(String vertex) {
		List<String> neighbors = this.edges.get(vertex);
		if (neighbors == null) {
			return Collections.emptyList();
		} else {
			return Collections.unmodifiableList(neighbors);
		}
	}
}

class BreadthFirstIterator implements Iterator<String> {
	private Set<String> visited = new HashSet<String>();
	private Queue<String> queue = new LinkedList<String>();
	private GraphDemo graph;

	public BreadthFirstIterator(GraphDemo g, String startingVertex) {
		this.graph = g;
		this.queue.add(startingVertex);
		this.visited.add(startingVertex);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasNext() {
		return !this.queue.isEmpty();
	}

	@Override
	public String next() {
		// removes from front of queue
		String next = queue.remove();
		for (String neighbor : this.graph.getNeighbors(next)) {
			if (!this.visited.contains(neighbor)) {
				this.queue.add(neighbor);
				this.visited.add(neighbor);
			}
		}
		return next;
	}
}

class PreOrderDFSIterator implements Iterator<String> {
	private Set<String> visited = new HashSet<String>();
	private Deque<Iterator<String>> stack = new LinkedList<Iterator<String>>();
	private GraphDemo graph;
	private String next;

	public PreOrderDFSIterator(GraphDemo g, String startingVertex) {
		this.stack.push(g.getNeighbors(startingVertex).iterator());
		this.graph = g;
		this.next = startingVertex;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	@Override
	public String next() {
		if (this.next == null) {
			throw new NoSuchElementException();
		}
		try {
			this.visited.add(this.next);
			return this.next;
		} finally {
			this.advance();
		}
	}

	private void advance() {
		Iterator<String> neighbors = this.stack.peek();
		do {
			while (!neighbors.hasNext()) { // No more nodes -> back out a level
				this.stack.pop();
				if (this.stack.isEmpty()) { // All done!
					this.next = null;
					return;
				}
				neighbors = this.stack.peek();
			}

			this.next = neighbors.next();
		} while (this.visited.contains(this.next));
		this.stack.push(this.graph.getNeighbors(this.next).iterator());
	}
}

