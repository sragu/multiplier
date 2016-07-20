package xyz.sragu;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {
        System.out.printf("result: %s \n", Multiplier.multiply(20, 30));
    }
}

class Multiplier {
    public static long multiply(long one, long two) {

        return PeasantTables.stream(PeasantTables.generate(one, two))
                .peek(System.out::println)
                .mapToLong(PeasantTables.PeasantTable::resultValue)
                .sum();
    }
}

class PeasantTables {
    static Iterable<PeasantTable> generate(final long first, final long second) {
        return () -> new PeasantTableIterator(new PeasantTable(first, second));
    }

    static Stream<PeasantTable> stream(Iterable<PeasantTable> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    static class PeasantTableIterator implements Iterator<PeasantTable> {
        private PeasantTable next;

        PeasantTableIterator(PeasantTable seed) {
            this.next = seed;
        }

        @Override
        public boolean hasNext() {
            return next.second > 0;
        }

        @Override
        public PeasantTable next() {
            PeasantTable current = next;
            next = new PeasantTable(current.first * 2, current.second / 2);
            return current;
        }
    }

    static class PeasantTable {
        private final long first, second;
        private final boolean excluded;

        public PeasantTable(long first, long second) {
            this.first = first;
            this.second = second;
            this.excluded = (second % 2 == 0);
        }

        @Override
        public String toString() {
            return String.format("%s, %s (excluded=%s)", first, second, excluded);
        }

        public long resultValue() {
            return excluded ? 0 : first;
        }
    }
}
