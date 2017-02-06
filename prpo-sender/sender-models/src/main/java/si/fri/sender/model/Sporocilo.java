package si.fri.sender.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "naslov", "vsebina", "timestamp" })
public class Sporocilo {

	@JsonProperty("naslov")
	private String naslov;
	@JsonProperty("vsebina")
	private String vsebina;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("naslov")
	public String getNaslov() {
		return naslov;
	}

	@JsonProperty("naslov")
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	@JsonProperty("vsebina")
	public String getVsebina() {
		return vsebina;
	}

	@JsonProperty("vsebina")
	public void setVsebina(String vsebina) {
		this.vsebina = vsebina;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}