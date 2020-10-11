package space.bunkou.a_team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import space.bunkou.a_team.R
import space.bunkou.a_team.Person
import kotlinx.android.synthetic.main.itemperson.view.*

class PersonAdapter() :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private var listPersonCache = emptyList<Person>()

    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val personItem: ConstraintLayout = view.person_item
        val userName: TextView = view.view_fio
        val city: TextView = view.view_city
        val birthday: TextView = view.view_birth
        val region: TextView = view.view_area
        val rank: TextView = view.view_rank
        val organ: TextView = view.view_organization
        val organ2: TextView = view.view_organization2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemperson, parent, false)

        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPersonCache.size
    }


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.personItem.visibility = View.VISIBLE
        holder.userName.text = listPersonCache[position].user
        holder.birthday.text = listPersonCache[position].data_of_birth
        holder.city.text = listPersonCache[position].city
        holder.region.text = listPersonCache[position].region
        holder.rank.text = listPersonCache[position].rank
        holder.organ.text = listPersonCache[position].organization
        holder.organ2.text = listPersonCache[position].organization2
    }

    fun setList(list: List<Person>) {
        listPersonCache = list
        notifyDataSetChanged()
    }
}