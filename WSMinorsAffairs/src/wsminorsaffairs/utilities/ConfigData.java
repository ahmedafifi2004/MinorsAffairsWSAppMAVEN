package wsminorsaffairs.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class ConfigData {
    public ConfigData() {
        super();
    }
    
    private static Properties config;

    public static void setConfig(Properties config) {
        ConfigData.config = config;
    }

    public static Properties getConfig() {
        return config;
    }

    public static void loadData() throws IOException {
        config = new Properties();
        String propFileName="config.properties";
        InputStream inputStream = new ConfigData().getClass().getClassLoader().getResourceAsStream(propFileName);
        
        if (inputStream != null){
            config.load(inputStream);
        }
        else{
            throw new FileNotFoundException(" File Not Found");
        }

    }
}
