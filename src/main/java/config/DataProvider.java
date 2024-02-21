package config;

import org.aeonbits.owner.ConfigCache;

public class DataProvider {
    public static TestDataAndProperties get() {
        return ConfigCache.getOrCreate(TestDataAndProperties.class);
    }
}