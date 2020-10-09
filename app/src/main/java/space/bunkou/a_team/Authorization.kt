package space.bunkou.a_team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_authorization.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Authorization : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ButtonAdd.setOnClickListener {
//            if (
//                EditTextFIO.text.isBlank() ||  // проверяем не пустая ли
//                EditTextBirth.text.isBlank() ||
//                EditTextCity.text.isBlank() ||
//                EditTextArea.text.isBlank() ||
//                EditTextHome.text.isBlank() ||
//                EditTextKV.text.isBlank()
//            ) {
                Toast.makeText(context, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

//            }
//            Toast.makeText(context, "Жыве Беларусь!!!", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
    }
}