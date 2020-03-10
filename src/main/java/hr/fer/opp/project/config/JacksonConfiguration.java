package hr.fer.opp.project.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;

/**
 * A configuration class for the Jackson JSON processor.
 * This class defines certain properties to be used by
 * Jackson while (de)serializing Java objects.
 */
@Configuration
public class JacksonConfiguration {

	/**
	 * Creates and configures an {@link ObjectMapper} to use only
	 * class fields and to ignore getters and setters while performing
	 * (de)serialization of objects.
	 *
	 * @return an {@link ObjectMapper} which uses only class fields
	 * for accessing objects' attributes
	 */
	@PostConstruct
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(mapper.getSerializationConfig()
				.getDefaultVisibilityChecker()
				.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
				.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withSetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
		);
		return mapper;
	}
}