package mx.edu.uthermosillo.manuel.boletotren

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val button = view.findViewById<Button>(R.id.back)
        val button2 = view.findViewById<Button>(R.id.agregar)

        button.setOnClickListener {

            val controller : NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_secondFragment_to_thirdFragment)
        }

        button2.setOnClickListener {
            val controller : NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_secondFragment_to_firstFragment)


        }


        return view
    }
}