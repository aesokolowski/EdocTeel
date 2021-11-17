class FizzBuzz {
    private int n;
    private int count;

    public FizzBuzz(int n) {
        this.n = n;
        count = 1;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (count <= n) {
            if (count % 3 == 0 && count % 5 != 0) {
                printFizz.run();
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (count <= n) {
            if (count % 3 != 0 && count % 5 == 0) {
                printBuzz.run();
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (count <= n) {
            if (count % 3 == 0 && count % 5 == 0) {
                printFizzBuzz.run();
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            if (count % 3 != 0 && count % 5!= 0) {
                printNumber.accept(count);
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}