package benchmark;

import implementations.ArrayList;
import implementations.Queue;
import implementations.SinglyLinkedList;
import implementations.Stack;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
// Arguments that specify the memory allocation pool
// Xms -> starting memory pool 2GB and Xmx - the maximum memory pool 4GB
// NOTE: When running those tests you may want to adjust those values as well
// as the param value, otherwise -> java.lang.OutOfMemoryError may occur
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx4G"})
@State(Scope.Benchmark)
public class BenchmarkTests {

    @Param({"1000", "10000"/*, "100000000"*/})
    private long n;

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();
    private Queue<Integer> queue = new Queue<>();
    private SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    private void fillArrayListWithRandomValues(ArrayList<Integer> list) {
        new Random()
                .ints()
                .limit(n)
                .forEach(list::add);
    }

    private void fillStackWithRandomValues(Stack<Integer> stack) {
        new Random()
                .ints()
                .limit(n)
                .forEach(stack::push);
    }

    private void fillQueueWithRandomValues(Queue<Integer> queue) {
        new Random()
                .ints()
                .limit(n)
                .forEach(queue::offer);
    }

    private void fillSinglyLinkedListWithRandomValues(SinglyLinkedList<Integer> singlyLinkedList) {
        // In the SinglyLinkedList we can use a pointer to the end of the structure
        // then it wont matter if we call addLast() or addFirst()
        // but that we will implement later so for now we will call addFirst()
        new Random()
                .ints()
                .limit(n)
                .forEach(singlyLinkedList::addFirst);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTests.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void testAddInArrayList(Blackhole blackhole) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
    }

    @Benchmark
    public void testAddInStack(Blackhole blackhole) {
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < n; i++) {
            numbers.push(i);
        }
    }

    @Benchmark
    public void testAddInQueue(Blackhole blackhole) {
        Queue<Integer> numbers = new Queue<>();
        for (int i = 0; i < n; i++) {
            numbers.offer(i);
        }
    }

    @Benchmark
    public void testAddInSinglyLinkedListAddFirst() {
        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();
        for (int i = 0; i < n; i++) {
            numbers.addFirst(i);
        }
    }

    @Benchmark
    public void testAddInSinglyLinkedListAddLast() {
        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();
        for (int i = 0; i < n; i++) {
            numbers.addLast(i);
        }
    }

    @Benchmark
    public void testRemoveAtFrontArrayList() {
        fillArrayListWithRandomValues(arrayList);
        while (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
    }

    @Benchmark
    public void testStackPop() {
        fillStackWithRandomValues(stack);
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    @Benchmark
    public void testQueuePoll() {
        fillQueueWithRandomValues(queue);
        while (!queue.isEmpty()) {
            queue.poll();
        }
    }

    @Benchmark
    public void testSinglyLinkedListRemoveFirst() {
        fillSinglyLinkedListWithRandomValues(singlyLinkedList);
        while (!singlyLinkedList.isEmpty()) {
            singlyLinkedList.removeFirst();
        }
    }

    @Benchmark
    public void testSinglyLinkedListRemoveLast() {
        fillSinglyLinkedListWithRandomValues(singlyLinkedList);
        while (!singlyLinkedList.isEmpty()) {
            singlyLinkedList.removeLast();
        }
    }
}
