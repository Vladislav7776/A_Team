package space.bunkou.a_team

import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import space.bunkou.a_team.User.Companion.instance

class LoginViewModel : ViewModel() {
    private val myUser = User()

    fun isLogin(login: EditText, password: EditText): Boolean {

        if (login.text.toString() == "user" && password.text.toString() == "user") {
            myUser.addUserData(login, password)
            return true
        }
        return false
    }

    fun isAuthorization(nav: NavController): Boolean {
        if (instance.isNullOrEmpty()) {
            nav.navigate(R.id.login4)
        } else {
            if (instance[0].name == "user" && instance[0].password == "user") return true
        }
        return false
    }
}