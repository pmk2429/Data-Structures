package stack;

public class MultipleStacksDemo {
  public static void main(String[] args) {
    MultipleStacks stacks = new MultipleStacks(10, 3);
    stacks.push(2, 15);
    stacks.push(2, 24);
    stacks.push(1, 12);
    stacks.push(1, 88);
    stacks.push(1, 74);
    stacks.push(0, 2429);
    stacks.push(0, 98);

  }
}
