            import MoedaExterna.MoedaExterna;
            import com.google.gson.Gson;
            import java.util.Scanner;

            import java.io.IOException;
            import java.net.URI;
            import java.net.http.HttpClient;
            import java.net.http.HttpRequest;
            import java.net.http.HttpResponse;


            public class Moeda {
                public static void main(String[] args) throws IOException, InterruptedException {

                    String endereco = "https://v6.exchangerate-api.com/v6/299fa0bebda42ce1e41d0b83/latest/USD";

                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(endereco))
                            .build();
                    HttpClient client = HttpClient.newHttpClient();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    System.out.println(response.body());

                    Gson gson = new Gson();
                    MoedaExterna minhaMoeda = gson.fromJson(response.body(), MoedaExterna.class);

                    Scanner leitura = new Scanner(System.in);
                    int opcao = 0;

                    while (opcao != 7) {
                        System.out.println("*******MENU CONVERSOR DE MOEDAS*******");

                        System.out.println("1) [Dólar] convertido para => [Peso argentino]");
                        System.out.println("2) [Peso argentino] convertido para => [Dólar]  ");
                        System.out.println("3) [Real] convertido para => [Dolar]");
                        System.out.println("4) [Dólar] convertido para => [Real]");
                        System.out.println("5) [Dólar] convertido para => [Peso colombiano]");
                        System.out.println("6)  [Peso colombiano] convertido para => [Dólar]");

                        System.out.println("7) SAIR DO MENU ");

                        opcao = leitura.nextInt();

                        if (opcao == 7) {
                            System.out.println("Saindo da aplicação...");
                        } else {
                            System.out.println("Você escolheu a opção " + opcao);

                            System.out.println("Digite o valor que deseja converter:");
                            double valor = leitura.nextDouble();

                            if (opcao == 1) {
                                double taxa = minhaMoeda.conversion_rates().get("ARS");
                                double valorConvertido = valor * taxa;
                                System.out.println("Valor " + valor + " [USD] corresponde ao valor de =>>> " + valorConvertido + " [ARS]");
                            }

                            if (opcao == 2) {
                                double taxa = minhaMoeda.conversion_rates().get("ARS");
                                double valorConvertido = valor / taxa;
                                System.out.println("Valor " + valor + " [ARS] corresponde ao valor de =>>> " + valorConvertido + " [USD]");
                            }


                            if (opcao == 3) {
                                double taxa = minhaMoeda.conversion_rates().get("BRL");
                                double valorConvertido = valor / taxa;
                                System.out.println("Valor " + valor + " [BRL] corresponde ao valor de =>>> " + valorConvertido + " [USD]");


                            }
                            if (opcao == 4) {
                                double taxa = minhaMoeda.conversion_rates().get("BRL");
                                double valorConvertido = valor * taxa;
                                System.out.println("Valor " + valor + " [USD] corresponde ao valor de =>>> " + valorConvertido + " [BRL]");
                            }

                            if (opcao == 5) {
                                double taxa = minhaMoeda.conversion_rates().get("COP");
                                double valorConvertido = valor * taxa;
                                System.out.println("Valor " + valor + " [USD] corresponde ao valor de =>>> " + valorConvertido + " [COP]");
                            }

                            if (opcao == 6) {
                                double taxa = minhaMoeda.conversion_rates().get("COP");
                                double valorConvertido = valor / taxa;
                                System.out.println("Valor " + valor + " [COP] corresponde ao valor de =>>> " + valorConvertido + " [USD]");
                            }

                        }
                    }
                }
            }