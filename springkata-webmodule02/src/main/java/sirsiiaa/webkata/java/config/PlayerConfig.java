package sirsiiaa.webkata.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PlayerConfigImportSelector.class)
public class PlayerConfig {
}
