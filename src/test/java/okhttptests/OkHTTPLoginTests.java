package okhttptests;

import com.google.gson.Gson;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHTTPLoginTests {

    public static final MediaType JSON=MediaType.get("application/json;charset=utf-8");
/*

eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoidjc2MjkwMDgxOUBnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY4NDg1Nzc0NCwiaWF0IjoxNjg0MjU3NzQ0fQ.DxPaAAaHWrbYm5LoF-TJ6NNvkgWQllBi1C2SalyZoUA

 */
    @Test
    public void loginTest() throws IOException {

        AuthRequestDTO requestDTO=AuthRequestDTO.builder()
                .username("v762900819@gmail.com")
                .password("Vova1234$")
                .build();
        Gson gson=new Gson();
        OkHttpClient client=new OkHttpClient();

        RequestBody requestBody=RequestBody.create(gson.toJson(requestDTO),JSON);

        Request request=new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();
        Response response=client.newCall(request).execute();

        if(response.isSuccessful()){
        String responseJson=response.body().string();
            AuthResponseDTO responseDTO=gson.fromJson(responseJson,AuthResponseDTO.class);
            System.out.println(responseDTO.getToken());
            System.out.println(response.code());
            Assert.assertTrue(response.isSuccessful());
        }else {
            System.out.println("Response code is"+response.code());
            ErrorDTO errorDTO=gson.fromJson(response.body().string(),ErrorDTO.class);
            System.out.println(errorDTO.getStatus()+" ==== "+errorDTO.getMessage()+"======="+errorDTO.getError());
            Assert.assertFalse(response.isSuccessful());


        }


        }
    }

