package xyz.sragu;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {
        System.out.printf("result: %s \n", Multiplier.multiply(20, 3));
    }
}

class Multiplier {
    public static long multiply(long one, long two) {
        final PeasantTable peasantTable = new PeasantTable(one, two);

        return createStreamFrom(peasantTable)
                .peek(System.out::println)
                .mapToLong(PeasantTable::resultValue)
                .sum();

    }

    private static Stream<PeasantTable> createStreamFrom(Iterable<PeasantTable> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}

/**
 * Using custom iterator (old school for generator) to generate peasant tables
 */
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
                next = new PeasantTable(current.first * 2, current.second / 2);
                return current;
            }
        };
    }

    @Override
    public String toString() {
        return String.format("%s, %s (excluded=%s)", first, second, excluded);
    }

    public long resultValue() {
        return excluded ? 0 : first;
    }
}
