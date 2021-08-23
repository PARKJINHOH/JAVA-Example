package me.java.the;


import java.util.Locale;
import java.util.concurrent.*;

public class Foo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(1000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started");

        // get()이 시작되는 순간 기다린다.
        // blocking
        helloFuture.get();

        System.out.println("End");

        executorService.shutdown();


        System.out.println("===============================================");
        // ---------------------- CompletableFuture ------------------- //
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("jinho");

        System.out.println(future.get());

        // 여기까지는 별 다를 께 없다.

        // thenApply(Function): 리턴값을 받아서 다른 값으로 바꾸는 콜백
        // thenAccept(Consumer): 리턴값을 또 다른 작업을 처리하는 콜백 (리턴없이)
        // thenRun(Runnable): 리턴값 받고 다른 작업을 처리하는 콜백
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> { // return
            System.out.println("Hello Accept " + Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        future2.get();


        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello2 " + Thread.currentThread().getName());
            return "hello2";
        });

        CompletableFuture<String> world2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("world2 " + Thread.currentThread().getName());
            return "world2";
        });

        


    }
}
