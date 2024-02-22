package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:env", "system:properties", "classpath:app.properties"})
public interface TestDataAndProperties extends Config {

    @Key("webdriver.browser")
    String browser();

    @Key("window.browser.chrome.runHeadless")
    @DefaultValue("false")
    boolean runHeadless();

    @Key("webdriver.window.width")
    int windowWidth();

    @Key("webdriver.window.height")
    int windowHeight();

    @Key("webdriver.waits.implicitlyWait")
    @DefaultValue("3")
    int implicitlyWait();

    @Key("webdriver.waits.waitTimeout")
    @DefaultValue("3")
    int waitTimeout();

    @Key("webdriver.waits.pageLoadTimeout")
    @DefaultValue("5")
    int pageLoadTimeout();

    @Key("aut.baseUrl")
    String baseUrl();

    @Key("user.dir")
    String workingDir();
}
