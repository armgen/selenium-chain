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
public class Tr implements Serializable{

    @JsonProperty("columns")
    List<Td> tds = new LinkedList<>();
}
