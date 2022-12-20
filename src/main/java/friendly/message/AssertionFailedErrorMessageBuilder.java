package friendly.message;

public class AssertionFailedErrorMessageBuilder {

  private Object actual;

  private Object expected;

  public AssertionFailedErrorMessageBuilder(Object actual, Object expected) {
    this.actual = actual;
    this.expected = expected;
  }

  public String message() {
    var builder = new StringBuilder();

    // format:off
    builder.append("Condition not satisfied:\n");
    builder.append("\n");
    builder.append("  actual: ").append(actual).append("\n");
    builder.append("expected: ").append(expected);
    // format:on

    return builder.toString();
  }

  public Object getActual() {
    return this.actual;
  }

  public Object getExpected() {
    return this.expected;
  }
}
