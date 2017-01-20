package br.com.armgen.uta.sdk.element.object;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pedro on 20/01/2017.
 */
@Data
public class Tr {
    List<Td> tds = new LinkedList<>();
}
