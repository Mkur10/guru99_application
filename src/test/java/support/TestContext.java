package support;

import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Lightweight context shared across step classes (via Cucumber PicoContainer).
 * Use set/get to pass data between steps in the same scenario.
 */
public class TestContext {

    private final Map<String, Object> bag = new ConcurrentHashMap<>();

    public void set(String key, Object value) {
        bag.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) bag.get(key);
    }

    public boolean has(String key) {
        return bag.containsKey(key);
    }

    // Convenience accessors (optional)
    public WebDriver driver() {
        return DriverFactory.getDriver();
    }
}
