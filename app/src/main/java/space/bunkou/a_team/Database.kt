package space.bunkou.a_team

import android.provider.ContactsContract
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase


class Database {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("omon")

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
        myRef.push().setValue(person)
    }

    fun outputData() {


    }

}