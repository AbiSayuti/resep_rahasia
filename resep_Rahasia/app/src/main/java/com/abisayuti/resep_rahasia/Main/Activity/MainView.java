package com.abisayuti.resep_rahasia.Main.Activity;

import com.abisayuti.resep_rahasia.base.BaseView;
import com.abisayuti.resep_rahasia.Main.Activity.model.RecipesItem;

import java.util.List;

public interface MainView extends BaseView {
    void onError(String msg);
    void onSucces(List<RecipesItem> data);
}
