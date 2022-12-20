package friendly.assertion;

import java.util.function.Consumer;

public class Assertions {

  public static BooleanAssertion assertThat(boolean actual) {
    return new BooleanAssertion(actual);
  }

  public static void asserts(Consumer<Void> consumer) {

  }
}
