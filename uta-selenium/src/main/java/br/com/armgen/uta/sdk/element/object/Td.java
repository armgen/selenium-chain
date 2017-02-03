package br.com.armgen.uta.sdk.element.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Pedro on 20/01/2017.
 */
@Data
public class Td implements Serializable{

    @JsonProperty("value")
    private String text;

    public Td(String text){
        this.text = text;
    }
}
