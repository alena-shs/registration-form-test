package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    @Tag("many_properties")
    void simpleProperty5Test() {
        String browserName = System.getProperty("browser", "mozilla");
        String browserVersion = System.getProperty("browser_version", "99.0");
        System.out.println(browserName);
        System.out.println(browserVersion);

        // gradle clean many_properties_test
        // mozilla
        // 99.0

        // gradle clean many_properties_test -Dbrowser=safari -Dbrowser_version="100.0"
        // safari
        // 100.0
    }
}
