package space.bunkou.a_team

val newPerson = arrayListOf<Person>()

data class Person(
    var city: String,
    var organization2: String,
    var organization: String,
    var rank: String,
    var region: String,
    var user: String,
    var data_of_birth: String
)

object personSet {

    fun addPersonToCollection(p: Person) {
        newPerson.add(p)
    }
}