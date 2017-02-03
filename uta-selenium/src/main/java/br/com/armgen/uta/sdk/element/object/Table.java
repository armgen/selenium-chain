package br.com.armgen.uta.sdk.element.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pedro on 20/01/2017.
 */
@Data
public class Table implements Serializable{

    @JsonProperty("lines")
    private List<Tr> trs = new LinkedList<>();
}
