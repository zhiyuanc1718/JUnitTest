import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class myTest {

  @Test
  public void test1() {
    assertEquals(15, Main.sum(new int[]{1,2,3,4,5}));
  }

}