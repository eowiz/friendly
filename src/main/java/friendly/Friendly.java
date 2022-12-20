package friendly;

import friendly.assertion.Assertion;
import friendly.exception.ShouldCallOnlyOnce;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.opentest4j.AssertionFailedError;

public class Friendly {

  private boolean assertsCalled;

  private Consumer<Inspector> inspectorConsumer = (inspector) -> {};

  public void asserts(Consumer<Inspector> inspector) {
    if (this.assertsCalled) {
      throw new ShouldCallOnlyOnce("Friendly#asserts should only call once");
    }

    this.assertsCalled = true;

    this.inspectorConsumer = inspector;
  }

  public List<AssertionFailedError> collectAssertionErrors() {
    final var inspector = new Inspector();

    this.inspectorConsumer.accept(inspector);

    return inspector.getAssertions().stream()
        .map(Assertion::getAssertionFailedError)
        .map(Optional::ofNullable)
        .flatMap(Optional::stream)
        .collect(Collectors.toList());
  }
}
