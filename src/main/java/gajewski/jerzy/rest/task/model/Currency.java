package gajewski.jerzy.rest.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Currency {
    private String currencyName;
    private String currencyCode;
    private Double currencyValue;

}
