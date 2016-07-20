package xyz.sragu;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {

        final Stream<PeasantTable> table = StreamSupport.stream(new PeasantTable(20, 3).spliterator(), false);
        final long result = table.filter(t -> !t.excluded).mapToLong(t -> t.first).sum();

        System.out.println(result);
    }
}

class PeasantTable implements Iterable<PeasantTable> {
    final long first, second;
    final boolean excluded;

    public PeasantTable(long first, long second) {
        this.first = first;
        this.second = second;
        this.excluded = (second % 2 == 0);
    }

    @Override
    public Iterator<PeasantTable> iterator() {
        return new Iterator<PeasantTable>() {
            private PeasantTable current = new PeasantTable(first / 2, second * 2);

            @Override
            public boolean hasNext() {
                return current.second >= 1;
            }

            @Override
            public PeasantTable next() {
                current = new PeasantTable(current.first * 2, current.second / 2);
                return current;
            }
        };
    }
}
