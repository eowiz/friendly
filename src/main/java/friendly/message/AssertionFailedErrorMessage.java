package friendly.message;

public class AssertionFailedErrorMessage<EXPECTED, ACTUAL> {

  private EXPECTED expected;

  private ACTUAL actual;

  public AssertionFailedErrorMessage(EXPECTED expected, ACTUAL actual) {
    this.expected = expected;
    this.actual = actual;
  }

  public String failedMessage() {
    var builder = new StringBuilder();

    builder.append("Condition not satisfied:\n");
    builder.append("\n");
    builder.append("  actual: ");
    builder.append("expected: ");

    return builder.toString();
  }
}
