package space.bunkou.a_team

import com.google.firebase.database.FirebaseDatabase


class Database {
    fun addData() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
    }

    fun outputData(){

    }

}