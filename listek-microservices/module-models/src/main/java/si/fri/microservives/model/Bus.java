package si.fri.microservives.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "direction", "number", "arrivals" })
public class Bus {

	@JsonProperty("direction")
	private String direction;
	@JsonProperty("number")
	private String number;
	@JsonProperty("arrivals")
	private List<Integer> arrivals = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("direction")
	public String getDirection() {
		return direction;
	}

	@JsonProperty("direction")
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(String number) {
		this.number = number;
	}

	@JsonProperty("arrivals")
	public List<Integer> getArrivals() {
		return arrivals;
	}

	@JsonProperty("arrivals")
	public void setArrivals(List<Integer> arrivals) {
		this.arrivals = arrivals;
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
