package co.javimay.weatherapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.javimay.weatherapp.R
import co.javimay.weatherapp.presentation.city.model.City


class ReciclerViewAdapter(
    private val cityList: MutableList<City>,
                          context: Context?,
    private val itemClickListener: (position: Int)-> Unit) :
    RecyclerView.Adapter<ReciclerViewAdapter.MyViewHolder>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(context)

    init {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = mInflater.inflate(R.layout.recicler_view_city_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.initBindHolder(cityList[position], position)
    }

    override fun getItemCount() = cityList.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun initBindHolder(city: City, position: Int) {
            val tvCityName = itemView.findViewById<TextView>(R.id.tv_city_name)
            tvCityName.text = city.name
            val ibDeleteCity = itemView.findViewById<ImageButton>(R.id.ib_delete_city)
            ibDeleteCity.setOnClickListener {
                cityList.remove(cityList[position])
                itemClickListener(position)
            }
        }
    }
}