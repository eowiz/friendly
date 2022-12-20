package friendly;

import jakarta.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Throwables {

  private static String ORG_FRIENDLY = "friendly";
  private static final String JAVA_LANG_REFLECT_CONSTRUCTOR = "java.lang.reflect.Constructor";

  public static void removeFriendlyRelatedElementsFromStackTrace(@Nullable Throwable throwable) {
    if (throwable == null) return;

    StackTraceElement[] filtered =
        Arrays.stream(throwable.getStackTrace())
            .filter(element -> element.getClassName().contains(ORG_FRIENDLY))
            .toArray(StackTraceElement[]::new);

    throwable.setStackTrace(filtered);
  }

}
