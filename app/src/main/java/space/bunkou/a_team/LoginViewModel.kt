package space.bunkou.a_team

import android.widget.EditText
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val myUser = User()

    fun isLogin(login: EditText, password: EditText): Boolean {

        if (login.text.toString() == "user" && password.text.toString() == "user") {
            CoroutineScope(Dispatchers.IO).launch { myUser.addUserData(login, password) }
            return true
        }
        return false
    }

    fun isAuthorization(): Boolean {
        return myUser.name.value == "user" && myUser.password.value == "user"
    }
}