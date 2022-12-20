package friendly;

import friendly.junit5.FriendlyExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(FriendlyExtension.class)
public class SampleTest {

  @Test
  public void test(Friendly friendly) {
    friendly.asserts(inspector -> {
      inspector.expect(true).isFalse();
      inspector.expect(false).isTrue();
    });

    friendly.collectAssertionErrors()
        .forEach(System.out::println);
  }
}
