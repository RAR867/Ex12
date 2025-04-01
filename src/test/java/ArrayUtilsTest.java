import org.example.ArrayUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    // Test cases for findLast()

    @Test
    public void testFindLastNull() {
        assertThrows(NullPointerException.class, () -> ArrayUtils.findLast(null, 3));
    }

    @Test
    public void testFindLastEmptyArray() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    @Test
    public void testFindLastNoMatch() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2, 4}, 3));
    }

    @Test
    public void testFindLastAtFirstPosition() {
        assertEquals(0, ArrayUtils.findLast(new int[]{3, 1, 2}, 3));
    }

    @Test
    public void testFindLastAtMiddlePosition() {
        assertEquals(2, ArrayUtils.findLast(new int[]{1, 2, 3, 4}, 3));
    }

    @Test
    public void testFindLastAtLastPosition() {
        assertEquals(4, ArrayUtils.findLast(new int[]{1, 2, 3, 4, 3}, 3));
    }

    @Test
    public void testFindLastSingleElementMatch() {
        assertEquals(0, ArrayUtils.findLast(new int[]{3}, 3));
    }

    @Test
    public void testFindLastSingleElementNoMatch() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1}, 3));
    }

    @Test
    public void testFindLastMultipleOccurrences() {
        assertEquals(5, ArrayUtils.findLast(new int[]{3, 1, 3, 2, 3, 3}, 3));
    }

    // Test cases for oddOrPos()

    @Test
    public void testOddOrPosNull() {
        assertThrows(NullPointerException.class, () -> ArrayUtils.oddOrPos(null));
    }

    @Test
    public void testOddOrPosAllPositives() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{1, 2, 3}));
    }

    @Test
    public void testOddOrPosAllNegatives() {
        assertEquals(1, ArrayUtils.oddOrPos(new int[]{-2, -4, -5}));
    }

    @Test
    public void testOddOrPosMixedValues() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

    @Test
    public void testOddOrPosZero() {
        assertEquals(1, ArrayUtils.oddOrPos(new int[]{0}));
    }

    @Test
    public void testOddOrPosSingleNegativeOdd() {
        assertEquals(1, ArrayUtils.oddOrPos(new int[]{-3}));
    }

    @Test
    public void testOddOrPosSingleNegativeEven() {
        assertEquals(0, ArrayUtils.oddOrPos(new int[]{-4}));
    }

    @Test
    public void testOddOrPosSinglePositiveOdd() {
        assertEquals(1, ArrayUtils.oddOrPos(new int[]{3}));
    }

    @Test
    public void testOddOrPosSinglePositiveEven() {
        assertEquals(1, ArrayUtils.oddOrPos(new int[]{4}));
    }
}
