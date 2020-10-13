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
    person.year_of_birth = yearOfBirth.text.toString()
    person.rank = rank.text.toString()
    person.organization = organization.text.toString()
    person.institution = organization2.text.toString()
    person.region = region.text.toString()
    REF_DATABASE_ROOT.child("omon").push().setValue(person)
}

// Функция преобразовывает полученые данные из Firebase в модель Person
fun DataSnapshot.getPersonModel(): Person =
    this.getValue(Person::class.java) ?: Person()


