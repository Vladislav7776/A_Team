package space.bunkou.a_team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        val myViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        super.onActivityCreated(savedInstanceState)
        val recycleView: RecyclerView = recycler_container

        val myRefPerson: DatabaseReference = REF_DATABASE_ROOT.child("omon")
        val adapter = PersonAdapter()

        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this.context)
        recycleView.hasFixedSize()
        val mPersonListener: AppValueEventListener = AppValueEventListener { dataSnapshot ->
            mList = dataSnapshot.children.map { it.getPersonModel() }
            adapter.setList(mList)
        }
        myRefPerson.addValueEventListener(mPersonListener)
        Toast.makeText(context, myViewModel.myUser.name.value.toString(), Toast.LENGTH_SHORT).show()
        button_add.setOnClickListener {
            val nav = findNavController()
            if (myViewModel.isAuthorization()) {
                nav.navigate(R.id.authorization4)
            } else {
                nav.navigate(R.id.login4)
            }
        }
    }
}
