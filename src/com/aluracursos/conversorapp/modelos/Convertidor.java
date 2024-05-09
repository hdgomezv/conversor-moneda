package com.aluracursos.conversorapp.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Convertidor {

    private static final String API_ENDPOINT = "https://v6.exchangerate-api.com/v6/dbe7c5601aea34fce8047990/latest/USD";

    public static double convertidorUnidades(double monto, String monedaOrigen, String monedaAConvertir) {

        try {
            URI apiDireccion = URI.create("https://v6.exchangerate-api.com/v6/dbe7c5601aea34fce8047990/latest/USD");
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(API_ENDPOINT))
                    .GET()
                    .build();

            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            if (response.statusCode() == 200) {
                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
                MedidasConversion medidasConversion = gson.fromJson(response.body(), MedidasConversion.class);
                double monedaInicial = getMedidasConversion(medidasConversion, monedaOrigen);
                double monedaFinal = getMedidasConversion(medidasConversion, monedaAConvertir);

                return monto * monedaFinal / monedaInicial;
            } else {
                System.out.println("Error al obtener la tasa de conversión. Código de respuesta: " + response.statusCode());

            }

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return -1; // Si hay un error, devuelve -1 como indicador de error
    }

    private static double getMedidasConversion(MedidasConversion medidasConversion, String moneda) {

        if (medidasConversion == null || medidasConversion.medidasConversion == null) {
            System.out.println("Los datos de conversión no están disponibles.");
            return 0.0;
        }
        Map<String, Double> rates = medidasConversion.medidasConversion.rates;
        if (rates.containsKey(moneda)) {
            return rates.get(moneda);

        } else {
            System.out.println("No se encontró la tasa de conversión para la moneda especificada: " + moneda);
            return 0.0; // Devuelve 0 si no se encuentra la moneda
        }
    }
}






