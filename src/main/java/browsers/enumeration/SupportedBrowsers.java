package browsers.enumeration;

import invoker.WebDriverInvoker;
import invoker.implementation.LocalChromeInvoker;
import invoker.implementation.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    LOCAL_CHROME(new LocalChromeInvoker()),
    LOCAL_FIREFOX(new LocalFirefoxInvoker());

    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver(){
        return webDriverInvoker.invokeWebDriver();
    }
}
