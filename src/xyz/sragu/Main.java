package xyz.sragu;

import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {
        System.out.printf("result: %s \n", Multiplier.multiply(20, 3));
    }
}

class Multiplier {
    public static long multiply(long one, long two) {
        return new PeasantTable(one, two).createStream().peek(System.out::println)
                .filter(PeasantTable::notExcluded)
                .mapToLong(PeasantTable::value)
                .sum();
    }
}

class PeasantTable implements Iterable<PeasantTable> {
    private final long first, second;
    private final boolean excluded;

    public PeasantTable(long first, long second) {
        this.first = first;
        this.second = second;
        this.excluded = (second % 2 == 0);
    }

    @Override
    public Iterator<PeasantTable> iterator() {
        return new Iterator<PeasantTable>() {
            private PeasantTable seed = new PeasantTable(first, second);
            private PeasantTable next = seed;

            @Override
            public boolean hasNext() {
                return next == seed ? true : next.second > 0;
            }

            @Override
            public PeasantTable next() {
                PeasantTable current = next;
                next = new PeasantTable(next.first * 2, next.second / 2);
                return current;
            }
        };
    }

    Stream<PeasantTable> createStream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    @Override
    public String toString() {
        return String.format("%s, %s (excluded=%s)", first, second, excluded);
    }

    public boolean notExcluded() {
        return !excluded;
    }

    public long value() {
        return first;
    }
}
