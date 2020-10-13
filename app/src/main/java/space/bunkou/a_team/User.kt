package space.bunkou.a_team

import android.widget.EditText

data class User(
    var name: String = "",
    var password: String = ""
) {
    companion object {
        val instance = ArrayList<User>()
    }

    fun addUserData(login: EditText, password: EditText) {
        instance.add(User(login.text.toString(), password.text.toString()))
    }
}
