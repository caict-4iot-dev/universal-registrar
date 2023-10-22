package uniregistrar.request;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import uniregistrar.JsonObject;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

@JsonPropertyOrder({ "decryptedPayload" })
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DecryptionResponse extends JsonObject {

    @JsonProperty
    private String decryptedPayload;

    private DecryptionResponse(String decryptedPayload) {
        super();
        this.decryptedPayload = decryptedPayload;
    }

    private DecryptionResponse() {
        this(null);
    }

    /*
     * Factory methods
     */

    @JsonCreator
    public static DecryptionResponse build(@JsonProperty(value="decryptedPayload") String decryptedPayload) {
        return new DecryptionResponse(decryptedPayload);
    }

    public static DecryptionResponse build() {
        return new DecryptionResponse();
    }

    /*
     * Serialization
     */

    public static DecryptionResponse fromJson(String json) throws JsonParseException, JsonMappingException, IOException {
        return objectMapper.readValue(json, DecryptionResponse.class);
    }

    public static DecryptionResponse fromJson(Reader reader) throws JsonParseException, JsonMappingException, IOException {
        return objectMapper.readValue(reader, DecryptionResponse.class);
    }

    public static DecryptionResponse fromMap(Map<String, Object> map) {
        return objectMapper.convertValue(map, DecryptionResponse.class);
    }

    /*
     * Getters and setters
     */

    @JsonGetter
    public String getDecryptedPayload() {
        return decryptedPayload;
    }

    @JsonSetter
    public void setDecryptedPayload(String decryptedPayload) {
        this.decryptedPayload = decryptedPayload;
    }
}
