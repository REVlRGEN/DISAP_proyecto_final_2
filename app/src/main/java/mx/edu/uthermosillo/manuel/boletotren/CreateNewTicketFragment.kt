package mx.edu.uthermosillo.manuel.boletotren

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateNewTicketFragment : BottomSheetDialogFragment() {

    interface OnItemAddedListener {
        fun onItemAddedListener(newItem: Boleto)
    }

    private var itemAddedListener: OnItemAddedListener? = null

    fun setOnItemAddedListener(listener: Boleto) {
        itemAddedListener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bsd_new_country, container, false)

        val button = view.findViewById<Button>(R.id.buttonagregar)

        button.setOnClickListener {
            val boleto = Boleto(
                9,
                "China",
                "SINALOA",
                "12:30",
                "200",
                "12:30",
                "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg",
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.playasmexico.com.mx%2Fwp-content%2Fuploads%2F2020%2F12%2F2-8.jpg&f=1&nofb=1&ipt=b70cfa0413dadc5216a4f8d94ec707312ee06203162c421e21e29e983d20e65e&ipo=images",
                )
            itemAddedListener?.onItemAddedListener(boleto)
            dismiss()
        }

        return view
    }
}