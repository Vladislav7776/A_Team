package space.bunkou.a_team

import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var AUTH: FirebaseAuth
lateinit var REF_DATABASE_ROOT: DatabaseReference

//Подключаем базу данных
fun initDatabase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
}

//Функция добавляет данные в базу данных
fun addData(

    name: TextView,
    yearOfBirth: TextView,
    city: TextView,
    region: TextView,
    organization2: TextView,
    rank: TextView,
    organization: TextView,
) {
    val person = Person()
    person.user = name.text.toString()
    person.city = city.text.toString()
    person.data_of_birth = yearOfBirth.text.toString()
    person.rank = rank.text.toString()
    person.organization = organization.text.toString()
    person.organization2 = organization2.text.toString()
    person.region = region.text.toString()
    REF_DATABASE_ROOT.child("omon").push().setValue(person)
}

fun addDataUser(login: EditText, password: EditText) {
    val user = User()
    user.name = login.text.toString()
    user.password = password.text.toString()
    user.isAuthorization = true
    REF_DATABASE_ROOT.child("user").setValue(user)
}

// Функция преобразовывает полученые данные из Firebase в модель Person
fun DataSnapshot.getPersonModel(): Person =
    this.getValue(Person::class.java) ?: Person()

fun DataSnapshot.getUserModel(): User =
    this.getValue(User::class.java) ?: User()

fun getUserData(user: User) {
    var mList = emptyList<User>()
    val mUserListener: AppValueEventListener = AppValueEventListener { dataSnapshot ->
        mList = dataSnapshot.children.map {
            it.getUserModel()
        }
    }
    if (mList.isNotEmpty()) {
        for (k in mList) {
            user.name = k.name
            user.password = k.password
            user.isAuthorization = k.isAuthorization
        }
    }
    REF_DATABASE_ROOT.child("user").addValueEventListener(mUserListener)
}

