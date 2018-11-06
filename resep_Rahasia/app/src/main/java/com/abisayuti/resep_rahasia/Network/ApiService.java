package com.abisayuti.resep_rahasia.Network;

import com.abisayuti.resep_rahasia.Main.Activity.model.ResponseGetResep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface   ApiService {

    //    @GET("search?key=9f79b23522bc7438825619575a06f1e1&q=chicken%20breast&page=2")

    @GET("search?")
    Call<ResponseGetResep> getResepData(
            @Query("key") String key,
            @Query("q") String query,
            @Query("page") int page
    );
}
