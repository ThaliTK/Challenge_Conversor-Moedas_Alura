package MoedaExterna;
import java.util.Map;
    public record MoedaExterna(String base_code, Map<String, Double> conversion_rates) {
    }

