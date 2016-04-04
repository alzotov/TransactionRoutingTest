package com.iconnect360.iterview.azotov.controller.route.impl;

import com.iconnect360.iterview.azotov.controller.provider.Processor;
import com.iconnect360.iterview.azotov.controller.route.CreditDebitRule;
import com.iconnect360.iterview.azotov.model.CardTransactionRz;
import com.iconnect360.iterview.azotov.model.CardType;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.iconnect360.iterview.azotov.model.CardType.valueOf;

/**
 * Created by alexey.zotov on 3/31/2016.
 * This rule is based on BIN range being looked up on web-service avaialable on the internet
 */
public class BINRule extends CreditDebitRule {

    public Processor select(CardTransactionRz trx) throws Exception {

        CardType type = checkBINalt(trx.getTransaction().getCard().getCardNumber());
        trx.setCardType(type);
        switch (type) {
            case DEBIT:
                return debitCardProcessor;
            case CREDIT:
                return creditCardProcessor;
        }
        return null;
    }

    //java native api based web call implementation, surprisingly doesn't support autocloasable interface
    private CardType checkBIN(String bin) throws Exception {

        URL url = new URL("https://binlist.net/json/"+bin.substring(0,6));
        HttpURLConnection connection = null;
        JsonReader jsonReader = null;
        JsonObject object = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("Content-Type", "application/json");

            InputStream is = connection.getInputStream();
            jsonReader = Json.createReader(is);
            object = jsonReader.readObject();

            int code = connection.getResponseCode();
        }finally {
            if(jsonReader!=null) jsonReader.close();
            if(connection!=null) connection.disconnect();
        }
        CardType cardType = valueOf(object.getString("card_type"));
        return cardType;
    }

    //apachee based implementation, bit easier with exceptions
    private CardType checkBINalt(String bin) throws Exception {
        String url = "https://binlist.net/json/"+bin.substring(0,6);

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        JsonReader jsonReader = Json.createReader(
                new InputStreamReader(response.getEntity().getContent()));

        JsonObject object = jsonReader.readObject();

        CardType cardType = valueOf(object.getString("card_type"));
        return cardType;
    }
}
