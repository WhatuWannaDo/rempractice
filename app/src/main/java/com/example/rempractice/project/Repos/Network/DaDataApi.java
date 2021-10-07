package com.example.rempractice.project.Repos.Network;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.Call;

public interface DaDataApi {
    @POST("api/4_1/rs/suggest/address")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Call<AddressAnalysis.AddressResponse> listAddresses(@Body AddressAnalysis.AddressRequest request, @Header("Authorization") String token);
}
