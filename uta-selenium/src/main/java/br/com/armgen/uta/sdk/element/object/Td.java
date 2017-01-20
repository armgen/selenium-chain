package br.com.armgen.uta.sdk.element.object;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Pedro on 20/01/2017.
 */
@Data
public class Td {

    private String text;

    public Td(String text){
        this.text = text;
    }
}
