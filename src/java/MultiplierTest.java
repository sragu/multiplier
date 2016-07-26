import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class MultiplierTest {
    @Test
    public void shouldMultiplyNumbers() {

        assertThat(Multiplier.multiply(3, 4), is(12L));
        assertThat(Multiplier.multiply(0, 0), is(0L));
        assertThat(Multiplier.multiply(3, 0), is(0L));
        assertThat(Multiplier.multiply(0, 5), is(0L));
    }

    @Test
    public void shouldGeneratePeasantTable() {

        List<PeasantTables.PeasantTable> items = new ArrayList<>();
        PeasantTables.generate(4, 5).forEach(items::add);

        assertThat(items.size(), is(3));
        assertThat(items.get(0).resultValue(), is(4L));
        assertThat(items.get(1).resultValue(), is(0L));
        assertThat(items.get(2).resultValue(), is(16L));
    }

    @Test
    public void shouldGenerateEmptyPeasantTable_WhenOneOfTheMultiplierIsZero() {

        List<PeasantTables.PeasantTable> items = new ArrayList<>();
        PeasantTables.generate(43, 0).forEach(items::add);

        assertThat(items.size(), is(0));
    }

    @Test
    public void shouldGenerateSinglePeasantTable_WhenOneOfTheMultiplierIsOne() {

        List<PeasantTables.PeasantTable> items = new ArrayList<>();
        PeasantTables.generate(43, 1).forEach(items::add);

        assertThat(items.size(), is(1));
        assertThat(items.get(0).resultValue(), is(43L));
    }

    @Test
    public void shouldGetResultValue_WhenSecondItemIsOdd() {

        final PeasantTables.PeasantTable peasantTable = new PeasantTables.PeasantTable(43, 5);

        assertThat(peasantTable.resultValue(), is(43L));
    }

    @Test
    public void shouldExcludeResultValue_WhenSecondItemIsEven() {

        final PeasantTables.PeasantTable peasantTable = new PeasantTables.PeasantTable(43, 4);

        assertThat(peasantTable.resultValue(), is(0L));
    }
}
