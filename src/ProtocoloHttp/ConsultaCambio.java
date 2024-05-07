package ProtocoloHttp;

import Clases.Moneda;
import Clases.MonedaCambio;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaCambio {
    public double consultaCambio (Moneda monedaSalida, Moneda monedaUsuario){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d91ccf161f7ac49899e18dab/latest/"+monedaSalida.getTipo());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var cuerpoJSON = new Gson()
                    .fromJson(response.body(), MonedaCambio.class);
            Map<String, Double> mapaDeConversiones = cuerpoJSON
                    .conversion_rates();

            return mapaDeConversiones.get(monedaUsuario.getTipo());

        }catch (Exception e){
            throw new RuntimeException("Conversión no realizada error con la solicitud");
        }


    }
}
