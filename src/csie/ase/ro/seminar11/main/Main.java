package csie.ase.ro.seminar11.main;

import csie.ase.ro.seminar11.classes.MathModule;
import csie.ase.ro.seminar11.threads.MathModuleCallable;
import csie.ase.ro.seminar11.threads.MathModuleThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[MathModule.NO_ELEMENTS];
        MathModule mathModule = new MathModule(array);

        mathModule.populateArray();

        long startTime = System.currentTimeMillis();
        long sum = mathModule.computeSum(array);
        long stopTime = System.currentTimeMillis();
        System.out.println(String.format("The sum computed on the main thread is %d computed in %dms.", sum, stopTime-startTime));


        final int NO_THREADS = 6;

        sum = 0;

        startTime = System.currentTimeMillis();
        MathModuleThread[] threads = new MathModuleThread[NO_THREADS];
        for (int i = 0; i < NO_THREADS; i++) {
            threads[i] = new MathModuleThread(i * (MathModule.NO_ELEMENTS / NO_THREADS), (i + 1) * (MathModule.NO_ELEMENTS / NO_THREADS) , array);
            threads[i].start();
        }

        for (int i = 0; i < NO_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < NO_THREADS; i++) {
            sum += threads[i].getSum();
        }
        stopTime = System.currentTimeMillis();
        System.out.println(String.format("The sum computed on the other threads is %d computed in %dms.", sum, stopTime-startTime));

        // thread pool
        sum = 0;
        startTime = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(NO_THREADS);
        MathModuleThread[] threadPoolArray= new MathModuleThread[NO_THREADS];
        for (int i = 0; i < NO_THREADS; i++) {
            threadPoolArray[i] = new MathModuleThread(i * (MathModule.NO_ELEMENTS / NO_THREADS), (i + 1) * (MathModule.NO_ELEMENTS / NO_THREADS) , array);
            threadPool.execute(threadPoolArray[i]); // sau metoda submit
        }
        threadPool.shutdown(); // incepe executarea threadurilor; le porneste pe toate in acelasi timp
        try {
            threadPool.awaitTermination(1, TimeUnit.MINUTES); // dupa 1 minut trece la alt thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < NO_THREADS; i++) {
            sum += threadPoolArray[i].getSum();
        }
        stopTime = System.currentTimeMillis();
        System.out.println(String.format("The sum computed on the other threads(threadpool) is %d computed in %dms.", sum, stopTime-startTime));

        // callable
        sum = 0;
        startTime = System.currentTimeMillis();
        ExecutorService callablePool = Executors.newFixedThreadPool(NO_THREADS);
        List<Future<Long>> results = new ArrayList<Future<Long>>();
        for (int i = 0; i < NO_THREADS; i++) {
            MathModuleCallable callable = new MathModuleCallable(i * (MathModule.NO_ELEMENTS / NO_THREADS), (i + 1) * (MathModule.NO_ELEMENTS / NO_THREADS) , array);
            Future<Long> promise = callablePool.submit(callable);
            results.add(promise);
        }

        for (Future<Long> f : results) {
            try {
                sum += f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        stopTime = System.currentTimeMillis();
        System.out.println(String.format("The sum computed on the other threads (callable) is %d computed in %dms.", sum, stopTime-startTime));
    }
}
