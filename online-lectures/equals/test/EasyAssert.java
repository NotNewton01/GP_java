import org.junit.Assert;
import java.io.PrintStream;

public class EasyAssert {
    public static void setOutput(PrintStream out) {
    }

    public static void fail(String message) {
        Assert.fail(message);
    }

    public static void assertEquals(String message, String expected, String actual) {
        Assert.assertEquals(message, expected, actual);
    }

    public static void assertEquals(String message, int expected, int actual) {
        Assert.assertEquals(message, expected, actual);
    }

    public static void assertEquals(String message, double expected, double actual) {
        Assert.assertEquals(expected, actual, 0.001);
    }

    public static void assertTrue(String message, boolean value) {
        Assert.assertTrue(message, value);
    }
}