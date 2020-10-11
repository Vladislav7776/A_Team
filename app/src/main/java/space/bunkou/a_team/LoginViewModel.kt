package space.bunkou.a_team

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var array = arrayListOf<User>()
    var userData = MutableLiveData(array)
    fun isLogin(login: EditText, password: EditText): Boolean {
        if (login.text.toString() == "user" && password.text.toString() == "user") {
            array?.add(User(login.text.toString(), password.text.toString()))
            userData.value = array
            return true
        }
        return false
    }


    fun isAuthorization(): Boolean {
        if (userData.value?.isNullOrEmpty()!!) return false
        return true
    }
}