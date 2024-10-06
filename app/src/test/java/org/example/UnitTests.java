/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests {
    @Test
    public void test_clock() {
        Timer timer = new Timer();
        timer.start();
        System.out.println("start" + timer.time);
        try {
            Thread.sleep(2000);
        }

        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        timer.stop();
        System.out.println("end" + timer.time);
        assertEquals(2, timer.time);
    }

    public void test_clock_2() {
        Timer timer = new Timer();
        timer.start();
        System.out.println("start" + timer.time);
        try {
            Thread.sleep(2000);
        }

        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long timeElapsed = timer.elapsedTime();
        System.out.println("end" + timer.time);
        assertEquals(2, timeElapsed);
    }

}