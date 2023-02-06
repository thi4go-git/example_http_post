package com.mycompany;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Http_post {

    //private static final String URL_BASE = "http://wlcontabilidade.sytes.net:8080";
    private static HttpURLConnection conexaoGeral;
    //
    private static String session;

    //
    private static final String URL_BASE = "https://api.openai.com/v1/completions";
    private static final String TOKEN = "Bearer meu tokan";
    private final String USER_AGENT = "Mozilla/5.0";
    private static HttpURLConnection conexao;

    public static void main(String[] args) throws IOException {
        chatGpt();
    }

    public static void logar() throws IOException {
        CookieHandler.setDefault(new CookieManager());
        //
        URL loginUrl = new URL(URL_BASE + "/wlgestao/login.jsf");
        conexaoGeral = (HttpURLConnection) loginUrl.openConnection();
        conexaoGeral.setRequestMethod("POST");
        conexaoGeral.setDoOutput(true);
        conexaoGeral.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conexaoGeral.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
        conexaoGeral.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/109.0");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("j_idt11", "j_idt11");
        parameters.put("j_username", "anilson-asj");
        parameters.put("j_password", "115200");
        parameters.put("javax.faces.ViewState", "H4sIAAAAAAAAAMVWX2gcRRif7OWS5k/T/KkxoaQtEiOC3SPVlEgQc5qLOb2mRy8Gax/Oubvxbi57O9OZ2bu9gsH6UB+KIKiIkKIPPvShfbFPfVGkFKHQgIIIiqDiq+KDIuiLM7t7e3vJHmkfLg7cd7O738x8v9/3+2bm+m8gSjkDI2VYhbolsKGvQF46DWm09/svb4+/9nUEaMug3yCwsAzzgrAk6BMlhniJGAWbPrsIVJuoHZD2uPwdEiBazuLCSYuBsfMpZ1oDmkX9TK6M8mLh3e1XPh7mjxsaADaV/pp1AWyCiOz1UNn8p95NBnQ12tZfh3nE9TypUGIiU+gvJ59v9KfTjFDERP0lVOfAa6NyagaGmksnTKsS/EgF6IdCMJyzBOIS/VgTfZwxWE9hLuxL30x99BW8GgFdSdDN8UXkxButdSsrB82ER5cRUKAVSQ5iGVhF7Nzdm8+8t3XvtAa0FOjLG5DzVVhBAow65MRUhLGMDMYsLqRAP5djCs4cAoy7HpjEMohhaOCLMGegBZvSqqIJcGUPSjTdppzRfxryg5Fxce6/7zVwjkFW91/0U4YryAFgS7rnHozuNMNVGWaQWDXxAQEON8ldK0ERZyiDhLPqgHSMOAxGvCgcJAPeg7Jjgf7D9qb66xVgkCFTMorYWp1KZo4FQ5ViJBbLI0l93ZDCRHKxhqKd/D9HiIGgee84e/PbrX9+10DXqyBahYalUqoW0Kin2id9/bXVper0+WAacmjGPBKCRYDh8gULsXrM/dPLPIgy0J90ODzShixlj7XlStlHBDgSzk2eYSqUy4wyjzUQz4YgjrYgjkhpnGgnjXWMamcJaV+IniR6pO5FstCal6QpUBGx0V8++fTvS2/Pa6rSvLwwyZjvt2pVcohdvv7B1MD7P11p7BwyLwJMOoFlncCyBslDgYmZXUnEl+4vf7v5HfFzdlQC1bllerCVNaS09Hg6nUomljw/CWmujSOuUENfkgVmGWLZfTkdp9Sor5ENZP517YlzW4vlxUGFpzYOBmMGKWJTt0uiYgDQdXns56s37B160Jx4tTZ6eMHVQJWB7irBBdBsNvVTH/cyf6pTWp9o0foJalgSFu+g5pU55eNLq61OARQnw8UtT6bD50OOpokv/s38uvHD3YbAupqjJaPTwRJAVSX/NOEiXiisEVUFCfXqjyu37nw3fPOW5hxBM7uH+Ftpps4FqjiDPi/O/7m+vT7kDpraPSjg++jGh7fxj5Pbru9DzXPL+eoCSb3TtzpReeOag2Nv5QiQ2HvjD4tbnZLIRCxegFQg1mSrMe9sa124W/gGFrpSeDYHOc57+9JZb3enkuij7aI5YwlqiRZR20qvnp6f6pSee/OEoX2TL2/gmesUnoOB+8F+oXpLXTfKWSpvPzXCCj6EbjeBbr3OPh1er6qbay1I1cF7a1uZyk5hKkMdL+bpp8dZPnz1IOHR+z08nM040H/xAbfxZlDz+0KJ2HmGhdeqf7/y6zXIosyvxRFTd9Gd+XWxhFXo/05w2DHYGc19FmDL/g/nVF3HeQ0AAA==");
        parameters.put("j_idt15", "j_idt15");

        try ( OutputStream os = conexaoGeral.getOutputStream()) {
            os.write(getPostDataString(parameters).getBytes());
            os.flush();
        }

        int responseCode = conexaoGeral.getResponseCode();
        System.out.println("Response Code LOGin : " + responseCode);
        System.out.println("Cód: " + conexaoGeral.getResponseMessage());
        //  
        //Guardar cookie:

        System.out.println(conexaoGeral.getHeaderFields().toString());

        Map<String, List<String>> headerFields = conexaoGeral.getHeaderFields();
        List<String> cookiesHeader = headerFields.get("Set-Cookie");
        if (cookiesHeader != null) {
            for (String cookie : cookiesHeader) {
                System.out.println("cookie " + cookie);
            }
        }

        String URL_REDI = conexaoGeral.getURL().getPath();
        session = URL_REDI.substring(URL_REDI.indexOf(";"), URL_REDI.length());
        //  imprimeHtml(conexaoGeral);
    }
    //

    private static void sanear() throws IOException {
        URL resourceUrl = new URL(URL_BASE + "/wlgestao/paginas/saneamento/commom/produtossaneamento.jsf" + session);
        HttpURLConnection resourceConnection = (HttpURLConnection) resourceUrl.openConnection();
        resourceConnection.setRequestMethod("GET");
        // configure o cookie na requisição
        //resourceConnection.setRequestProperty("Cookie", "your_cookie");
        int resourceResponseCode = resourceConnection.getResponseCode();
        System.out.println("Response Code : " + resourceResponseCode);
        //
        imprimeHtml(resourceConnection);
    }

    private static String getPostDataString(Map<String, String> parameters) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return result.toString();
    }

    public static void imprimeHtml(HttpURLConnection conexao) {

        try (
                 BufferedReader in = new BufferedReader(new InputStreamReader(
                        conexao.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException ex) {
            Logger.getLogger(Http_post.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void chatGpt() {
        try {

            URL loginUrl = new URL(URL_BASE);
            conexao = (HttpURLConnection) loginUrl.openConnection();
            //
            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setRequestProperty("Authorization", "Bearer TOKEN aqui");
            // Send post request

            String jsonInputString = """
                                     {
                                         "model": "text-davinci-003",
                                         "prompt": "Ricardo",
                                         "temperature": 0,
                                         "max_tokens": 1000
                                     }""";

            conexao.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conexao.getOutputStream());
            wr.writeBytes(jsonInputString);
            wr.flush();
            wr.close();
            //
            int responseCode = conexao.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + URL_BASE);
            System.out.println("Post parameters : " + jsonInputString);
            System.out.println("Response Code : " + responseCode);
            System.out.println("Message: " + conexao.getResponseMessage());
            //
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conexao.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
