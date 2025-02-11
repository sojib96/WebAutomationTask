package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.experimental.UtilityClass;
import models.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@UtilityClass
public class SettingsTestData {
    private final String RESOURCES_PATH = "src/test/resources/";
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final String TEST_DATA_PATH = RESOURCES_PATH + "testdata/";
    private final String VALID_USER_DATA_PATH = TEST_DATA_PATH + "validUserData.json";
    private final String INVALID_USER_DATA_PATH = TEST_DATA_PATH + "invalidUserData.json";
    private final String LOCKED_USER_DATA_PATH = TEST_DATA_PATH + "lockedUserData.json";
    private final String CHECKOUT_DATA_FILE_PATH = TEST_DATA_PATH + "checkoutData.json";
    private final String ENV_FILE_PATH = RESOURCES_PATH + "env.json";
    private final Gson GSON = new Gson();

    public EnvData getEnvData() {
        String envConfigPath = String.format("%s%s.json", ENVIRONMENT_PATH, getCurrentEnvironment());
        return deserializeJson(envConfigPath, EnvData.class);
    }

    public ValidUserData getValidUserData() {
        return deserializeJson(VALID_USER_DATA_PATH, ValidUserData.class);
    }

    public InvalidUserData getInvalidUserData() {
        return deserializeJson(INVALID_USER_DATA_PATH, InvalidUserData.class);
    }

    public LockedUserData getLockedUserData() {
        return deserializeJson(LOCKED_USER_DATA_PATH, LockedUserData.class);
    }

    public CheckoutData getCheckoutData() {
        return deserializeJson(CHECKOUT_DATA_FILE_PATH, CheckoutData.class);
    }

    private String getCurrentEnvironment() {
        try (FileReader reader = new FileReader(ENV_FILE_PATH)) {
            JsonObject jsonConfig = JsonParser.parseReader(reader).getAsJsonObject();
            return jsonConfig.get("env").getAsString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read configuration file", e);
        }
    }

    private <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
