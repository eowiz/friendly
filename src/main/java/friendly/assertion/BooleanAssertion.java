package friendly.assertion;

import java.util.Objects;
import org.opentest4j.AssertionFailedError;

public class BooleanAssertion implements Assertion {

  private Boolean expected;

  private AssertionFailedError assertionFailedError;

  public BooleanAssertion(Boolean expected) {
    this.expected = expected;
  }

  public void isTrue() {
    if (Boolean.TRUE.equals(expected)) {
      return;
    }

    this.assertionFailedError = new AssertionFailedError("TODO", expected, false);
  }

  public void isFalse() {
    if (Boolean.FALSE.equals(expected)) {
      return;
    }

    this.assertionFailedError = new AssertionFailedError("TODO", expected, true);
  }

  public <T> void isEqualTo(T actual) {
    if (Objects.equals(this.expected, actual)) {
      return;
    }
  }

  @Override
  public AssertionFailedError getAssertionFailedError() {
    return this.assertionFailedError;
  }
}
