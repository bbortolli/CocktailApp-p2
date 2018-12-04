package com.example.bruno.cocktailapp

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onLoadList(context: Context){

        view.showLoading()

        val cocktailService = RetrofitInitializer().createCocktailService()
        val call = cocktailService.getAlcoholic()

        call.enqueue(object : Callback<CocktailList> {
            override fun onFailure(call: Call<CocktailList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<CocktailList>, response: Response<CocktailList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.cocktails)
                }else {
                    view.showMessage("Não foi encontrado")
                }
            }
        })

    }

    override fun onGetById(context: Context, id: String){

        view.showLoading()

        val cocktailService = RetrofitInitializer().createCocktailService()
        val call = cocktailService.getById(id)

        call.enqueue(object : Callback<CocktailList> {
            override fun onFailure(call: Call<CocktailList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<CocktailList>, response: Response<CocktailList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.cocktails)
                }else {
                    view.showMessage("Não foi encontrado")
                }
            }
        })

    }


    override fun onGetRand(context: Context){

        view.showLoading()

        val cocktailService = RetrofitInitializer().createCocktailService()
        val call = cocktailService.getRandom()

        call.enqueue(object : Callback<CocktailList> {
            override fun onFailure(call: Call<CocktailList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<CocktailList>, response: Response<CocktailList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.cocktails)
                }else {
                    view.showMessage("Não foi encontrado")
                }
            }
        })

    }

}