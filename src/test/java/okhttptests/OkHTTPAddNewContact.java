package okhttptests;

import com.google.gson.Gson;
import dto.*;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;
/*
  "id": "string",
  "name": "string",
  "lastName": "string",
  "email": "string",
  "phone": "6880343141",
  "address": "string",
  "description": "string"



 */

public class OkHTTPAddNewContact {
    public static final MediaType JSON=MediaType.get("application/json;charset=utf-8");

    String token="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoidjc2MjkwMDgxOUBnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY4NDg1Nzc0NCwiaWF0IjoxNjg0MjU3NzQ0fQ.DxPaAAaHWrbYm5LoF-TJ6NNvkgWQllBi1C2SalyZoUA";

    Gson gson=new Gson();
    OkHttpClient client=new OkHttpClient();

    @Test
    public void addNewContact() throws IOException {
        int i=new Random().nextInt(1000)+1000;

        ContactDTO contactDTO= ContactDTO.builder()
                .name("Till")
                .lastName("Lindemann")
                .email("Rammstein_"+i+"@gmail.com")
                .phone("45678534"+i)
                .address("Germany")
                .description("My favorite musician")
                .build();

        RequestBody requestBody=RequestBody.create(gson.toJson(contactDTO),JSON);
        Request request=new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
                .addHeader("Authorization",token)
                .post(requestBody)
                .build();

        Response response=client.newCall(request).execute();
        ResponseMessageDto responseMessageDto=gson.fromJson(response.body().string(), ResponseMessageDto.class);
        String message=responseMessageDto.getMessage();
        System.out.println(message);
       Assert.assertTrue(response.isSuccessful());
     Assert.assertTrue(message.contains("Contact was added!"));


    }
}
