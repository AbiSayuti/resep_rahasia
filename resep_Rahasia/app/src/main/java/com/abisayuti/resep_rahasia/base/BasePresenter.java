package com.abisayuti.resep_rahasia.base;

public interface BasePresenter  <T extends BaseView>{

    void onAttach(T v);

    void onDettach();
}
