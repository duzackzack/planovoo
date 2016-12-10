package br.com.unicsul.planovoo.entity;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsNave implements Serializable{
	private static final long serialVersionUID = 4196775882606636344L;

	private List<Nave>results;
	
	
	@JsonProperty("count")
	private String count;

	  
	 @JsonProperty("next")
	private String next;

	@JsonProperty("previous")
	private String previous;

	public List<Nave> getResults() {
		return results;
	}

	public void setResults(List<Nave> results) {
		this.results = results;
	}

	

 	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}
		
}
