import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.google.gson.*;

public class ApiTrainService {

    private final String apiKey =System.getenv( "Train_API_Key");

    public ArrayList<Train> searchTrains(String from, String to) throws Exception {

        String url = "https://api.railradar.in/v1/trains/between/"
                + from + "/" + to;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + apiKey)
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        ArrayList<Train> trains = new ArrayList<>();

        JsonObject root =
                JsonParser.parseString(response.body()).getAsJsonObject();

        JsonObject data = root.getAsJsonObject("data");

        JsonArray trainArray = data.getAsJsonArray("trains");

        for (JsonElement element : trainArray) {

            JsonObject item = element.getAsJsonObject();

            JsonObject trainData = item.getAsJsonObject("train");
            JsonObject fromData = item.getAsJsonObject("from");
            JsonObject toData = item.getAsJsonObject("to");

            int trainNumber =
                    Integer.parseInt(trainData.get("number").getAsString());

            String trainName =
                    trainData.get("name").getAsString();

            String source =
                    fromData.get("name").getAsString();

            String destination =
                    toData.get("name").getAsString();

            String date =
                    trainData.get("runDays").toString();

            String time =
                    fromData.get("departure").getAsString();

            Train train = new Train(
                    trainNumber,
                    trainName,
                    source,
                    destination,
                    date,
                    time
            );

            trains.add(train);
        }

        return trains;
    }
}