package eu.deic.multithreading;

class HelloThread extends Thread {

    public HelloThread(String name) {
        super(name);
    }
    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println("Hello - Th1" + name);
    }
}

class HelloRunnable extends /* OtherClass */ Object implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Hello - Th2" + name);
    }
}

public class TestMultiThreading {
    public static void main(String[] args) {

    }
}

