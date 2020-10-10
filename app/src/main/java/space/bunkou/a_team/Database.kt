package space.bunkou.a_team

import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


lateinit var REF_DATABASE_ROOT: DatabaseReference

//Подключаем базу данных
fun initDatabase() {
  var auth = FirebaseDatabase.getInstance()
    REF_DATABASE_ROOT = auth.getReference("омон")
}

//Функция добавляет данные в базу данных
fun addData(
    person: Person,
    name: TextView,
    yearOfBirth: TextView,
    city: TextView,
    region: TextView,
    organization2: TextView,
    rank: TextView,
    organization: TextView,
) {
    person.user = name.text.toString()
    person.city = city.text.toString()
    person.data_of_birth = yearOfBirth.text.toString()
    person.rank = rank.text.toString()
    person.organization = organization.text.toString()
    person.organization2 = organization2.text.toString()
    person.region = region.text.toString()
    REF_DATABASE_ROOT.push().setValue(person)
}

// Функция преобразовывает полученые данные из Firebase в модель Person
fun DataSnapshot.getPersonModel(): Person =
    this.getValue(Person::class.java) ?: Person()
