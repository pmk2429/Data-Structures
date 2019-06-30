package queue.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockData {

  private Deque<Stock> stockPrices;
  private Stock min; // represents min price of the day
  private Stock max; // represents max price of the day

  private StockData() {
    stockPrices = new ArrayDeque<>();
    min = new Stock(11222, Integer.MAX_VALUE);
    max = new Stock(33333, Integer.MIN_VALUE);
  }

  public void push(Stock stock) {

    // insert into DS
    stockPrices.offer(stock);

    if (stock.price >= max.price) {
      max = stock;
    }

    if (stock.price <= min.price) {
      min = stock;
    }
  }

  public Stock getMin() {
    return min;
  }

  public Stock getMax() {
    return max;
  }

  public static void main(String[] args) {
    StockData dataEntry = new StockData();
    Stock uber1 = new Stock(111, 40.5);
    Stock uber2 = new Stock(122, 39.9);
    Stock uber3 = new Stock(331, 33.7);
    Stock uber4 = new Stock(145, 47.9);
    Stock uber5 = new Stock(555, 41.2);
    dataEntry.push(uber1);
    dataEntry.push(uber2);
    dataEntry.push(uber3);
    dataEntry.push(uber4);
    dataEntry.push(uber5);

    Stock min = dataEntry.getMin();
    System.out.println(min.price);
    Stock max = dataEntry.getMax();
    System.out.println(max.price);
  }
}

class Stock {
  long timestamp;
  double price;

  Stock(long timestamp, double price) {
    this.timestamp = timestamp;
    this.price = price;
  }
}
