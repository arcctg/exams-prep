package org.arcctg;

import org.arcctg.implement.Schedule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    @Test
    void testScheduleWith3Executions() throws InterruptedException {
        List<Integer> results = new ArrayList<>();
        Schedule.schedule(results::add, 3, 10);
        assertEquals(List.of(0, 1, 2), results);
    }

    @Test
    void testScheduleWithZeroExecutions() throws InterruptedException {
        List<Integer> results = new ArrayList<>();
        Schedule.schedule(results::add, 0, 10);
        assertTrue(results.isEmpty(), "No executions should occur when n = 0");
    }

    @Test
    void testScheduleWith2ExecutionsAndZeroInterval() throws InterruptedException {
        List<Integer> results = new ArrayList<>();
        Schedule.schedule(results::add, 2, 0);
        assertEquals(List.of(0, 1), results);
    }

    @Test
    void testScheduleWithNegativeInterval() throws InterruptedException {
        List<Integer> results = new ArrayList<>();
        Schedule.schedule(results::add, 3, -10);
        assertTrue(results.isEmpty(), "No executions should occur when interval is negative");
    }

    @Test
    void testScheduleWithNegativeExecutions() throws InterruptedException {
        List<Integer> results = new ArrayList<>();
        Schedule.schedule(results::add, -1, 10);
        assertTrue(results.isEmpty(), "No executions should occur when n is negative");
    }
}