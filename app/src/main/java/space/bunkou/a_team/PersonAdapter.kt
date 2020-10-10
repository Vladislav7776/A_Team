package space.bunkou.a_team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.bunkou.a_team.R
import space.bunkou.a_team.Person
import kotlinx.android.synthetic.main.itemperson.view.*

class PersonAdapter() :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    private var listPerson = emptyList<Person>()

    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemperson, parent, false)

        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        holder.itemView.view_fio.text = listPerson[position].user
        holder.itemView.view_birth.text = listPerson[position].data_of_birth
        holder.itemView.view_city.text = listPerson[position].city
        holder.itemView.view_area.text = listPerson[position].region
        holder.itemView.view_rank.text = listPerson[position].rank
        holder.itemView.view_organization2.text = listPerson[position].organization2
        holder.itemView.view_organization.text = listPerson[position].organization

    }

    fun setList(list: List<Person>) {
        listPerson = list
    }
}