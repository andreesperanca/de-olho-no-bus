package com.andreesperanca.deolhonobus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.deolhonobus.R
import com.andreesperanca.deolhonobus.adapters.BusStopForecastAdapter.BusStopForecastViewHolder
import com.andreesperanca.deolhonobus.databinding.RvBusStopForescastItemBinding
import com.andreesperanca.deolhonobus.models.BusStopPrediction
import com.andreesperanca.deolhonobus.models.ForecastVehicleView
import com.andreesperanca.deolhonobus.models.ListOfVehiclesLocated
import com.andreesperanca.deolhonobus.util.CustomDialog

class BusStopForecastAdapter(
    private val supportFragmentManager: FragmentManager
) : RecyclerView.Adapter<BusStopForecastViewHolder>() {

    private var busStopForecastList: List<ForecastVehicleView> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusStopForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvBusStopForescastItemBinding.inflate(inflater, parent, false)
        return BusStopForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusStopForecastViewHolder, position: Int) {
        holder.bind(busStopForecastList[position])
    }

    override fun getItemCount(): Int = busStopForecastList.size

    fun updateList(data: List<ForecastVehicleView>?) {
        data?.let {
            busStopForecastList = data
        }
        notifyItemChanged(busStopForecastList.size)
    }

    inner class BusStopForecastViewHolder(private val binding: RvBusStopForescastItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(forecastVehicleView: ForecastVehicleView) {

            binding.tvNumberLine.text = binding.root.context.getString(R.string.busNumber, forecastVehicleView.sign)
            binding.tvOrigin.text = binding.root.context.getString(R.string.origin, forecastVehicleView.origin)
            binding.tvDestination.text = binding.root.context.getString(R.string.destination, forecastVehicleView.destination)

            binding.tvDetails.setOnClickListener {
                val customDialog = CustomDialog(forecastVehicleView.vehicleList)
                customDialog.show(supportFragmentManager,null)
            }
        }
    }
}