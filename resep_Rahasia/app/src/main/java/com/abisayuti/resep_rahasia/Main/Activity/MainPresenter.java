package com.abisayuti.resep_rahasia.Main.Activity;

import com.abisayuti.resep_rahasia.base.BasePresenter;
import com.abisayuti.resep_rahasia.Main.Activity.model.RecipesItem;
import com.abisayuti.resep_rahasia.Main.Activity.model.ResponseGetResep;
import com.abisayuti.resep_rahasia.Network.ConfigRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {

    MainView mainView;
    private String apikey = "9f79b23522bc7438825619575a06f1e1";
    private String query = "chicken breast";
    private int page = 1;

    // TODO 2. Memanggil fungsi getData
    public void getData(){
//        ApiService api = ConfigRetrofit.getInstance();
//        Call<ResponseGetResep> call = api.getResepData();

        call().enqueue(new Callback<ResponseGetResep>() {
            @Override
            public void onResponse(Call<ResponseGetResep> call, Response<ResponseGetResep> response) {
                if(response.isSuccessful()){
                    List<RecipesItem> recipesItems = response.body().getRecipes();
                    //TODO 5. Data Dikembalikan ke View
                    mainView.onSucces(recipesItems);
                }else {
                    mainView.onError("Gagal Mengambil Data");
                }

            }

            @Override
            public void onFailure(Call<ResponseGetResep> call, Throwable t) {

            }
        });

    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDettach() {

    }

    // TODO 3. Get Config network
    // TODO 4. Mengambil model
    public Call<ResponseGetResep> call() {
        return ConfigRetrofit.getInstance().getResepData(apikey,query,page);
    }
}
