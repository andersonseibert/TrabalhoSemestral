package br.com.trabalhosemestral.service;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RESTUtil {


    public String processRequest(String resource, String method, String payload) {

        String resultado = "";
        try {
            URL url = new URL(resource);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(method);

            if (!payload.isEmpty()) {
                con.setRequestProperty("Content-type", "application/json");

                OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
                writer.write(payload);
                writer.flush();
            }

            BufferedReader br =
                    new BufferedReader(new InputStreamReader
                            (con.getInputStream())
                    );

            String linha = "";
            while ((linha = br.readLine()) != null) {
                resultado += linha;
            }
            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;

    }

}
