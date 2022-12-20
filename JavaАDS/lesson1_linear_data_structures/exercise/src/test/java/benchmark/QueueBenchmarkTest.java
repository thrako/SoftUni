package benchmark;

import implementations.Queue;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
// Arguments that specify the memory allocation pool
// Xms -> starting memory pool 2GB and Xmx - the maximum memory pool 4GB
// NOTE: When running those tests you may want to adjust those values as well
// as the param value, otherwise -> java.lang.OutOfMemoryError may occur
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx4G"})
@State(Scope.Benchmark)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 2, time = 1)
public class QueueBenchmarkTest {

    @Param({"1000", "10000"/*, "100000000"*/})
    private long n;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QueueBenchmarkTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void testAddInQueue() {
        Queue<Integer> numbers = new Queue<>();
        for (int i = 0; i < n; i++) {
            numbers.offer(i);
        }
    }
}
