package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {

    private String mTeamperature, micon, mcity, mWeathertype;
    private int mCondition;

    public static WeatherData fromjson(JSONObject jsonObject){

        try {

            WeatherData weatherD = new WeatherData();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeathertype=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon=updateWeatherIcon(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTeamperature=Integer.toString(roundedValue);
            return weatherD;

        }




         catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    private static String updateWeatherIcon(int condition){

        if (condition>=0 && condition<=300){

            return "thunderstorm";

        }

        else if (condition>=300 && condition<=500){

            return "lightrain";

        }

        else if (condition>=500 && condition<=600){

            return "shower";

        }

        else if (condition>=600 && condition<=700){

            return "snow2";

        }

        else if (condition>=701 && condition<=771){

            return "fog";

        }

        else if (condition>=772 && condition<=800){

            return "overcast";

        }

        else if (condition==800){

            return "sunny";

        }

        else if (condition>=801 && condition<=804){

            return "cloudy";

        }

        else if (condition>=900 && condition<=902){

            return "thunderstorm";

        }

        else if (condition==903){

            return "snow";

        }

        else if (condition==904){

            return "sunny";

        }

        if (condition>=905 && condition<=1000){

            return "thunderstorm";

        }

        return "dunno";


    }

    public String getmTeamperature() {
        return mTeamperature+"°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getmWeathertype() {
        return mWeathertype;
    }
}
