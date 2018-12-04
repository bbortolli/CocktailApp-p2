package com.example.bruno.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList(this)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showList(cocktails: List<Cocktail>) {
        val adapter = CocktailAdapter(this, cocktails)
        adapter.setOnItemClickListener { index ->
            val details = Intent(this, DetailsActivity::class.java)
            details.putExtra(DetailsActivity.COCKTAIL, cocktails[index])
            startActivity(details)
        }

        rvCocktails.adapter = adapter
        rvCocktails.layoutManager = LinearLayoutManager(this)

        btnRandom.setOnClickListener(){

            val novaIntent = Intent(this, DetailsActivity::class.java)
            startActivity(novaIntent)

        }
    }

    override fun showLoading() {
        barra.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        barra.visibility = ProgressBar.INVISIBLE
    }

}
