package friendly;

import friendly.assertion.Assertion;
import friendly.assertion.BooleanAssertion;
import java.util.ArrayList;
import java.util.List;

public class Inspector {

  private List<Assertion> assertions = new ArrayList<>();

  public BooleanAssertion expect(boolean actual) {
    final var assertion = new BooleanAssertion(actual);
    assertions.add(assertion);

    return assertion;
  }

  public List<Assertion> getAssertions() {
    return assertions;
  }
}
