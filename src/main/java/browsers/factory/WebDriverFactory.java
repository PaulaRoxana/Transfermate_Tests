package browsers.factory;

import browsers.properties.converters.SupportedBrowserConverter;
import browsers.properties.holder.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
        return SupportedBrowserConverter.valueOfWebBrowser(
                        new PropertyHolder().readProperty("browser"))
                .getWebDriver();
    }
}
