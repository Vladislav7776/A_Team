package space.bunkou.a_team

import android.widget.EditText
import androidx.lifecycle.MutableLiveData

data class User(
    var name: MutableLiveData<String> = MutableLiveData<String>(),
    var password: MutableLiveData<String> = MutableLiveData<String>()
) {
    fun addUserData(name: EditText, password: EditText) {
        this.name.postValue(name.text.toString())
        this.password.postValue(password.text.toString())
    }
}