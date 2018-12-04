package com.example.bruno.cocktailapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.cocktail_list_item.view.*

class CocktailAdapter(val context: Context, val cocktails: List<Cocktail>)
    : RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    //salva a função do clique no item
    var clickListener: ((index: Int) -> Unit)? = null

    //configuração a função de clique nos itens
    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.clickListener = clique
    }

    //método responsável por inflar as views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cocktail_list_item, parent, false)
        return ViewHolder(view)
    }

    //retorna a quantidade de itens na lista
    override fun getItemCount(): Int {
        return cocktails.size
    }

    //popula o ViewHolder com as informações do cocktail
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, cocktails[position], clickListener)
    }

    //referência para a view de cada item da lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context:Context,
                     cocktail: Cocktail,
                     clickListener: ((index: Int) -> Unit)?) {
            itemView.tvCocktail.text = cocktail.strDrink

            GlideApp.with(context)
                    .load(cocktail.strDrinkThumb)
                    .placeholder(R.mipmap.ic_defaultimg)
                    .centerCrop()
                    .apply(RequestOptions().circleCrop())
                    .into(itemView.imgCocktail)

            if(clickListener != null) {
                itemView.setOnClickListener {
                    clickListener.invoke(adapterPosition)
                }
            }


        }

    }
}