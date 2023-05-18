package okhttptests;

import com.google.gson.Gson;
import dto.ContactDTO;
import dto.GetALLContactsDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHTTPGetALLContactsTest {

    String token="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoidjc2MjkwMDgxOUBnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY4NDg1Nzc0NCwiaWF0IjoxNjg0MjU3NzQ0fQ.DxPaAAaHWrbYm5LoF-TJ6NNvkgWQllBi1C2SalyZoUA";

    Gson gson=new Gson();
    OkHttpClient client=new OkHttpClient();

    @Test
    public void GetALLContacts() throws IOException {

        Request request=new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
                .addHeader("Authorization",token)
                .build();
        Response response =client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());

        GetALLContactsDTO contacts=gson.fromJson(response.body().string(),GetALLContactsDTO.class);
        for (ContactDTO contact:contacts.getContacts()){
            System.out.println(contact.getId());
            System.out.println(contact.getEmail());
            System.out.println("*****************************");
        }

    }
}
