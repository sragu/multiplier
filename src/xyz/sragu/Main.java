package xyz.sragu;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {

        final Stream<PeasantTable> table = StreamSupport.stream(new PeasantTable(20, 20).spliterator(), false);
        final long result = table.peek(log()).filter(t -> !t.excluded).mapToLong(t -> t.first).sum();

        System.out.printf("result: %s \n", result);
    }

    private static Consumer<PeasantTable> log() {
        return t -> System.out.printf("%s, %s \n", t.first, t.second);
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
}
