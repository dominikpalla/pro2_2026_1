package cz.uhk.spring1.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final String API_KEY = "b1f0f39ebd3e42c981862543263003";
    private final String URL = "http://api.weatherapi.com/v1/current.json?key="
            + API_KEY + "&q=";

    public String getTemp(String city) {
        city = city.trim().replaceAll(" ", "%20");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL + city)
                .build();

        try(Response response = client.newCall(request).execute()){
            String responseBody = response.body().string();
            System.out.println(responseBody);
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONObject current = jsonObject.getJSONObject("current");
            float temp = current.getFloat("temp_c");
            return String.valueOf(temp);
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
