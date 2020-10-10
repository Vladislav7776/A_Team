package space.bunkou.a_team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment() : Fragment() {
    var mList = emptyList<Person>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        var recycleView: RecyclerView = recycler_container

        var myRefPerson: DatabaseReference = REF_DATABASE_ROOT.child("omon")
        val adapter = PersonAdapter()


        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this.context)
        recycleView.hasFixedSize()
        val mPersonListener: AppValueEventListener = AppValueEventListener { dataSnapshot ->
            mList = dataSnapshot.children.map { it.getPersonModel() }
            adapter.setList(mList)
        }
        myRefPerson.addValueEventListener(mPersonListener)
        button_add.setOnClickListener {
            val nav = findNavController()
            nav.navigate(R.id.login4)
        }

    }
}
