package space.bunkou.a_team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        button_login.setOnClickListener {
            if (myViewModel.isLogin(materialEditText, materialPassword)) {
                val nav = findNavController()
                nav.navigate(R.id.authorization4)
            } else {
                Toast.makeText(context, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}