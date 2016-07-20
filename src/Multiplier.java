import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

interface PeasantTables {
    static Iterable<PeasantTable> generate(final long first, final long second) {
        return () -> new PeasantTableIterator(new PeasantTable(first, second));
    }

    /**
     * using iterators (old school generators) to build the peasant table.
     */
    class PeasantTableIterator implements Iterator<PeasantTable> {
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

    class PeasantTable {
        private final long first, second;
        private final boolean excluded;

        public PeasantTable(long first, long second) {
            this.first = first;
            this.second = second;
            this.excluded = (second % 2 == 0);
        }

        public long resultValue() {
            return excluded ? 0 : first;
        }

        @Override
        public String toString() {
            return String.format("%s, %s (excluded=%s)", first, second, excluded);
        }
    }
}

public class Multiplier {
    static long multiply(long one, long two) {

        return stream(PeasantTables.generate(one, two))
                .peek(System.out::println)
                .mapToLong(PeasantTables.PeasantTable::resultValue)
                .sum();
    }

    private static Stream<PeasantTables.PeasantTable> stream(Iterable<PeasantTables.PeasantTable> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
