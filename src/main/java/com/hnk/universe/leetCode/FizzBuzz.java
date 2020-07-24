package com.hnk.universe.leetCode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/28 4:16 PM
 */
class FizzBuzz {
    // Initialize the permit, limit to one.
    private Semaphore sema = new Semaphore(1);

    // The current number.
    private int curNum = 1;

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(;;) {
            // Acquire the permit, try to run the logic exclusively.
            this.sema.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 == 0) && (this.curNum % 5 != 0)) {
                    printFizz.run();
                    this.curNum++;
                }
            } finally {
                // Release the permit anyway.
                this.sema.release(1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(;;) {
            this.sema.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 != 0) && (this.curNum % 5 == 0)) {
                    printBuzz.run();
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(;;) {
            this.sema.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 == 0) && (this.curNum % 5 == 0)) {
                    printFizzBuzz.run();
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(;;) {
            this.sema.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 != 0) && (this.curNum % 5 != 0)) {
                    printNumber.accept(this.curNum);
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }
}
