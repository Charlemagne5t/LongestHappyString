import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int a = 1;
        int b = 1;
        int c = 7;
        String expected = "ccaccbcc";
        String actual = new Solution().longestDiverseString(a, b, c);

        Assert.assertEquals(expected, actual);
    }
}
