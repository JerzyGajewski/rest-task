package gajewski.jerzy.rest.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gajewski.jerzy.rest.task.model.Currency;
import gajewski.jerzy.rest.task.model.CurrencyValue;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    public CurrencyValue getCurrencyValue(String currency) throws JsonProcessingException {
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/A?";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Currency> currencyWrapperList = new ArrayList<>();
        JsonNode root = objectMapper.readTree(result);
        for (JsonNode node : root.path(0).path("rates")){
            Currency currencyObj = new Currency(node.path("currency").asText(),node.path("code").asText(), node.path("mid").asDouble());
            currencyWrapperList.add(currencyObj);
        }
        CurrencyValue currencyValue = new CurrencyValue();
        int count = 0;
        for (Currency curr: currencyWrapperList) {
            if(curr.getCurrencyCode().equalsIgnoreCase(currency)){
                currencyValue.setValue(curr.getCurrencyValue().toString());
                count = 1;
            }
        }
        if (count == 0){
            currencyValue.setValue("No Currency Code");
        }

        return currencyValue;
    }
}
