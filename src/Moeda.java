        import MoedaExterna.MoedaExterna;
        import com.google.gson.Gson;

        import java.io.IOException;
        import java.net.URI;
        import java.net.http.HttpClient;
        import java.net.http.HttpRequest;
        import java.net.http.HttpResponse;


        public class Moeda {
            public static void main(String[] args) throws IOException, InterruptedException{

                String endereco = "https://v6.exchangerate-api.com/v6/299fa0bebda42ce1e41d0b83/latest/USD";

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());

                Gson gson = new Gson();
                MoedaExterna minhaMoeda = gson.fromJson(response.body(), MoedaExterna.class);

                System.out.println(minhaMoeda);
                System.out.println("Valor em Reais: " + minhaMoeda.conversion_rates().get("BRL"));
    }
}
