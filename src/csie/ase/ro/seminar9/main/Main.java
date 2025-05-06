package csie.ase.ro.seminar9.main;

import csie.ase.ro.seminar9.classes.SyncedThread;
import csie.ase.ro.seminar9.classes.UnsyncedThread;

public class Main {
    public static void main(String[] args) {
        UnsyncedThread unsyncedThread1 = new UnsyncedThread();
        // unsyncedThread1.run(); never do this

        // unsyncedThread1.start(); // do this
        System.out.println("Hello from the main thread");

        UnsyncedThread unsyncedThread2 = new UnsyncedThread();
        // unsyncedThread2.start();

        SyncedThread syncedThread1 = new SyncedThread();
        SyncedThread syncedThread2 = new SyncedThread();

        new Thread(syncedThread1).start();
        new Thread(syncedThread2).start();

        // lambda + threads
        Runnable r = () -> System.out.println("Processing starts");
        new Thread(r).start();

        // handling exceptions
//        Runnable r2 = () ->  {
//            int x = 7 / 0;
//            System.out.println("Handling exceptions");
//        };
//
//        try {
//            new Thread(r2).start();
//        } catch (Exception e) {
//            System.out.println("Exception caught");
//        }

        // proper catch
        Runnable r3 = () ->  {
            try {
                int x = 7 / 0;
                System.out.println("Handling exceptions");
            } catch (Exception e) {
                System.out.println("Exception caught!");
            }
        };
        new Thread(r3).start();

    } // end main method
} // end main class
