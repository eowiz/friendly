package friendly.exception;

public final class ShouldCallOnlyOnce extends RuntimeException {

  public ShouldCallOnlyOnce() {
  }

  public ShouldCallOnlyOnce(String message) {
    super(message);
  }

  public ShouldCallOnlyOnce(String message, Throwable cause) {
    super(message, cause);
  }

  public ShouldCallOnlyOnce(Throwable cause) {
    super(cause);
  }

  public ShouldCallOnlyOnce(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
