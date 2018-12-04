package com.example.bruno.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity(), MainContract.View {


    companion object {
        public const val COCKTAIL: String = "Cocktail" //para putExtra entre activities
    }

    var cocktail: Cocktail? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        cocktail = intent.getSerializableExtra(COCKTAIL) as Cocktail?
        val presenter: MainContract.Presenter = MainPresenter(this)

        if (cocktail != null) {
            presenter.onGetById(this, cocktail!!.idDrink)
        }
        else{
            presenter.onGetRand(this)
        }

    }

    override fun showList(cocktails: List<Cocktail>) {
        det_tv_ingText.setText("INGREDIENTS")
        det_tv_strDrink.setText(cocktails[0].strDrink)
        det_tv_strCategory.setText("Category: " + cocktails[0].strCategory)
        det_tv_strGlass.setText("Glass: " + cocktails[0].strGlass)
        det_tv_strIng1.setText(cocktails[0].strIngredient1)
        det_tv_strIng2.setText(cocktails[0].strIngredient2)
        det_tv_strIng3.setText(cocktails[0].strIngredient3)
        det_tv_strIng4.setText(cocktails[0].strIngredient4)
        det_tv_strIng5.setText(cocktails[0].strIngredient5)

        GlideApp.with(this)
                .load(cocktails[0].strDrinkThumb)
                .placeholder(R.drawable.no_image)
                .into(det_imgDrinks)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        barraPro.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        barraPro.visibility = ProgressBar.INVISIBLE
    }
}