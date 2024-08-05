package zjubiomedit.mafld_backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "appinfo")
@Data
public class AppInfoConfig {
    private String appId;
    private String appSecret;
}

