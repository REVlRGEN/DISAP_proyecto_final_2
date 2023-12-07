package mx.edu.uthermosillo.manuel.boletotren

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.bottomsheet.BottomSheetDialog

class ListFragment : Fragment() {
    private var tickets : MutableList<Boleto> = mutableListOf()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)

        initData()
        val adapter = TicketAdapter(tickets)
        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.countriesRecycler
            )
        //Variables para el elemento nuevo
        var _id: Int = 0
        var _name: String
        var _estado: String
        var _time: String
        var _flag: String
        var _image: String
        var _salida: String
        var _dinero: String

        fab.setOnClickListener {
            // Show Bottom Sheet Dialog and add a new item
            val bottomSheetFragment = BottomSheetDialog(view.context)
            val parentView: View = layoutInflater.inflate(R.layout.bsd_new_country, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            //elementos del formulario bsd
            val newId = parentView.findViewById<EditText>(R.id.bsd_country_id)
            val newName = parentView.findViewById<EditText>(R.id.bsd_country_name)
            val newestado = parentView.findViewById<EditText>(R.id.bsd_country_status)
            val newFlag = parentView.findViewById<EditText>(R.id.bsd_country_flag)
            val newImage = parentView.findViewById<EditText>(R.id.bsd_country_image)
            val newtime = parentView.findViewById<EditText>(R.id.bsd_country_time)
            val newdinero = parentView.findViewById<EditText>(R.id.bsd_country_costo1)
            val newsalida = parentView.findViewById<EditText>(R.id.bsd_country_salida)

            val button = parentView.findViewById<Button>(R.id.buttonagregar)

            //boton guardar del bsd, asignación de valores y creación del nuevo elemento
            button.setOnClickListener {
                _id = newId.text.toString().toInt()
                _name = newName.text.toString()
                _estado = newestado.text.toString()
                _flag = newFlag.text.toString()
                _image = newImage.text.toString()
                _dinero = newdinero.text.toString()
                _salida = newsalida.text.toString()
                _time = newtime.text.toString()

                val newProductAdd = Boleto(
                    _id,
                    _name,
                    _estado,
                    _salida,
                    _flag,
                    _time,
                    _dinero,
                    _image,
                )

                tickets.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                bottomSheetFragment.dismiss()
            }
        }

        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {
        tickets = mutableListOf(
            Boleto(1, "Hermosillo", "Sonora", "Hora de salida: "," $670", "12:30 pm", "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.playasmexico.com.mx%2Fwp-content%2Fuploads%2F2020%2F12%2F2-8.jpg&f=1&nofb=1&ipt=b70cfa0413dadc5216a4f8d94ec707312ee06203162c421e21e29e983d20e65e&ipo=images"),
            Boleto(2, "Culiacan", "Sinaloa", "Hora de salida: "," $345", "2:15 pm", "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.ta7qGYtUPv6bgpBzr02QggHaDt%26pid%3DApi&f=1&ipt=42eabceed948962450244e3cb158f0079aa88b659484dcf7c2e8d18cf2367cf5&ipo=images"),
            Boleto(3,"Cancun","CDMX","Hora de salida: "," $210","5:40 pm", "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.zSEVV0dYrxiJOHhSNeSeMQHaEv%26pid%3DApi&f=1&ipt=368ad500162dfbbc67ad745b97c83f1a1775bdb6262ca1a6186b9560995fe588&ipo=images"),
            Boleto(4, "Mazatlan", "Sinaloa", "Hora de salida: "," $400", "8:20 pm", "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.erA40Mjito3NnVPvQP_HWgHaEK%26pid%3DApi&f=1&ipt=28f2d9c341c1ca34aa877ffeb278ae670da2495f0645051fbdd526f9b4ef87d1&ipo=images"),
            Boleto(5, "Obregon", "Sonora", "Hora de salida: "," $980", "11:00 pm", "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.wuLKOjeeqDLyU0Du6KE8NgHaEp%26pid%3DApi&f=1&ipt=4f6603abaaea595a448d3d9697e7392b7cbe16083fef0ae4284d17f3b23ddf3e&ipo=images"),
            Boleto(6, "Phoenix", "Arizona", "Hora de salida: "," $1020", "2:00 am", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.4WjOFCuyGuKWNDJw4yyB1AHaEU%26pid%3DApi&f=1&ipt=5357516fbe81237990079680855a0636da965d2943fdd54171aa4208bbfaac3a&ipo=images","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.K6s6_9vUjEaKJlE02rCbpQHaE7%26pid%3DApi&f=1&ipt=ba1ab2534f663645798e309359665f318c8b03d7577b55fb7efac32378da3ada&ipo=images"),
            Boleto(7,"Nogales", "Sonora", "Hora de salida: "," $220", "4:40 am", "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.YPJ6p1HBP6VRjcfWNd0aKwHaE6%26pid%3DApi&f=1&ipt=db987fc54029411ef0a8556c8af9efb2a56c74bf5fd9892fe1edc4093bbf7ed0&ipo=images"),
            Boleto(8, "Nuevo Leon", "Monterrey", "Hora de salida: "," $540", "6:20 am", "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.travelreport.mx%2Fwp-content%2Fuploads%2F2017%2F11%2Fmonterrey-.jpg&f=1&nofb=1&ipt=941f6876aa5203ecc1b9054b361891085eb1660d3ab131fa8981c212872d31dc&ipo=images")
        )
    }
}