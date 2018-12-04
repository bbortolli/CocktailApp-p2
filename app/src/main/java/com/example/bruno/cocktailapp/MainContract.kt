package com.example.bruno.cocktailapp

import android.content.Context

interface MainContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(cocktails: List<Cocktail>)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun onLoadList(context: Context)
        fun onGetById(context: Context, id: String)
        fun onGetRand(context: Context)
    }

}