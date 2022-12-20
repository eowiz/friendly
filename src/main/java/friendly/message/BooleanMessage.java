package friendly.message;

public class BooleanMessage {

  public String getMessage(boolean actual, boolean expected) {
    var builder = new StringBuilder();

    builder.append("Condition not satisfied: \n");
    builder.append("\n");
    builder.append("  actual: ").append(actual).append("\n");
    builder.append("           |");
    builder.append("expected: ").append(expected);

    return builder.toString();
  }

  public String getMessage(Boolean actual, Boolean expected) {
    return "";
  }
}
