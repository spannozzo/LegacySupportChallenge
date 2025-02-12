package com.fime;

import java.util.*;


/**
 * A small Java project with three challenges: Debugging, Refactoring, and Performance Optimization.
 */
public class LegacySupportChallenge {

    public static void main(String[] args) {
        System.out.println("Starting Legacy Support Challenge...");

        debugChallenge();
        refactorChallenge();
        performanceChallenge();
    }


    private static void debugChallenge() {
        System.out.println("\n--- Debugging Challenge ---");
        Set<Order> orders = new HashSet<>();
        orders.add(new Order(101, "SUCCESS"));
        orders.add(new Order(102, "FAILED"));
        orders.add(new Order(103, "SUCCESS"));
        orders.add(new Order(101, "SUCCESS"));  // Duplicate?

        System.out.println("Orders in Set:");
        orders.forEach(System.out::println);

        System.out.println("Expected: Only 3 unique orders.");
        System.out.println("Actual: " + orders.size() + " orders.");
    }

    // 2. Refactoring Challenge: Improve structure & readability
    private static void refactorChallenge() {
        System.out.println("\n--- Refactoring Challenge ---");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, 500.0, true),
                new Transaction(2, -100.0, false),
                new Transaction(3, 200.0, true),
                new Transaction(4, 0.0, false),
                new Transaction(5, 150.0, true));

        List<Transaction> validTransactions = getValidTransactions(transactions);
        validTransactions.forEach(t -> System.out.println("Valid Transaction: " + t.id + " Amount: " + t.amount));
    }

    public static List<Transaction> getValidTransactions(List<Transaction> transactions) {
        //TODO: refactor this code using java 8
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.valid && t.amount > 0) {
                result.add(t);
            }
        }
        return result;
    }

    // 3. Performance Challenge: Optimize batch processing with concurrency
    private static void performanceChallenge() {
        System.out.println("\n--- Performance Optimization Challenge ---");
        List<MyCustomData> dataset = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            dataset.add(new MyCustomData(i));
        }

        long startTime = System.nanoTime();
        processDatasetSequentially(dataset);
        long endTime = System.nanoTime();
        System.out.println("Sequential Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        processDatasetParallel(dataset);
        endTime = System.nanoTime();
        System.out.println("Parallel Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void processDatasetSequentially(List<MyCustomData> dataset) {
        for (MyCustomData data: dataset) {
            compute(data);
        }
    }

    public static void processDatasetParallel(List<MyCustomData> dataset) {
        //TODO: implement this method executing compute(MyCustomData value)
    }

    public static void compute(MyCustomData value) {
        try {
            value.compute();
            Thread.sleep(10);  // Simulating expensive computation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}

class MyCustomData {
    private Integer value;

    public MyCustomData(Integer value) {
        this.value = value;
    }

    void compute() {
        value = value * 2;
    }

    public Integer getValue(){
        return value;
    }
}

// Order Class for Debugging Challenge
class Order {
    private int id;
    private String status;

    public Order(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}

// Transaction Class for Refactoring Challenge
class Transaction {
    int id;
    double amount;
    boolean valid;

    public Transaction(int id, double amount, boolean valid) {
        this.id = id;
        this.amount = amount;
        this.valid = valid;
    }
}
