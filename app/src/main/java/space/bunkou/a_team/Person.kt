package space.bunkou.a_team

val newPerson = arrayListOf<Person>()

data class Person(
    val city: String,
    val organization2: String,
    val organization: String,
    val rank: String,
    val region: String,
    val user: String,
    val data_of_birth: String
)

object personSet {

    fun addPersonToCollection(p: Person) {
        newPerson.add(p)
    }
}