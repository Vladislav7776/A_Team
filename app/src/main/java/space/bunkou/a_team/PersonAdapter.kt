package space.bunkou.a_team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.bunkou.a_team.R
import space.bunkou.a_team.Person
import kotlinx.android.synthetic.main.fragment_main.view.*

class PersonAdapter(private val personSet: ArrayList<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_main, parent, false)

        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personSet.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        holder.itemView.view_fio.text = personSet[position].user
        holder.itemView.view_birth.text = personSet[position].data_of_birth
        holder.itemView.view_city.text = personSet[position].city
        holder.itemView.view_area.text = personSet[position].region
        holder.itemView.view_rank.text = personSet[position].rank
        holder.itemView.view_organization2.text = personSet[position].organization2
        holder.itemView.view_organization.text = personSet[position].organization

    }
}