package mx.edu.uthermosillo.manuel.boletotren

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialog


class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val button = view.findViewById<Button>(R.id.agregar)
        val name = view.findViewById<EditText>(R.id.editTextText)

        button.setOnClickListener {


            if (name.text.isNotEmpty()){
                val controller : NavController = Navigation.findNavController(view)
                controller.navigate(R.id.action_thirdFragment_to_secondFragment)
            }
            else{
                val bsdError= BottomSheetDialog(view.context)
                val layout: View =
                    layoutInflater.inflate(R.layout.bsd_error, null)
                bsdError.setContentView(layout)
                bsdError.show()
            }
        }
        return view
    }
}