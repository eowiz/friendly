package friendly.assertion;

import org.opentest4j.AssertionFailedError;

public interface Assertion {

  AssertionFailedError getAssertionFailedError();
}
