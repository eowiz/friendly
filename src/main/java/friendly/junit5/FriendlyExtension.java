package friendly.junit5;

import friendly.Friendly;
import java.io.FileReader;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class FriendlyExtension implements ParameterResolver, BeforeEachCallback,
    AfterTestExecutionCallback {

  private static final Namespace FRIENDLY_ASSERTIONS_EXTENSION_NAMESPACE = Namespace.create(FriendlyExtension.class);

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.getParameter().getType().isAssignableFrom(Friendly.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return new Friendly();
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {

  }

  @Override
  public void afterTestExecution(ExtensionContext context) throws Exception {
    final var store = context.getStore(FRIENDLY_ASSERTIONS_EXTENSION_NAMESPACE);
    store.getOrComputeIfAbsent(Friendly.class, unused -> new Friendly(), Friendly.class);
  }
}
