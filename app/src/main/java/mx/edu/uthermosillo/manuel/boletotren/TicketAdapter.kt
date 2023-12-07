package mx.edu.uthermosillo.manuel.boletotren

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TicketAdapter(private var tickets: MutableList<Boleto>): RecyclerView.Adapter<TicketAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflador = LayoutInflater.from(parent.context)
        val view = inflador.inflate(R.layout.itemcountry, parent, false)
        return CountryViewHolder(view)
    }
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = tickets[position]
        holder.render(country)
        //aquí se aplica la lógica. ej: onClickListener
    }
    override fun getItemCount(): Int {
        return tickets.size
    }

    fun addNewItem(item: Boleto) {
        tickets.add(item)
        notifyItemInserted(tickets.size - 1)
    }


    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.country_name)
        val Estado: TextView = view.findViewById(R.id.country_estado)
        val time: TextView = view.findViewById(R.id.country_time)
        val flag: ImageView = view.findViewById(R.id.country_flag)
        val image: ImageView = view.findViewById(R.id.country_image)
        val salida: TextView = view.findViewById(R.id.country_salida)
        val dinero: TextView = view.findViewById(R.id.country_costo)

        fun render(boleto: Boleto) {
            name.text = boleto.name + ", "
            Estado.text = boleto.Estado
            time.text = boleto.time
            salida.text = boleto.salida
            dinero.text = boleto.dinero
            Picasso.get().load(boleto.flag).into(flag)
            Picasso.get().load(boleto.image).into(image)
        }
    }
}
