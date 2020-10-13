package space.bunkou.a_team

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment() : Fragment() {
    private var mList = emptyList<Person>()
    val adapter = PersonAdapter()

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

        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this.context)
        recycleView.hasFixedSize()
        val mPersonListener = AppValueEventListener { dataSnapshot ->
            mList = dataSnapshot.children.map { it.getPersonModel() }
            adapter.setList(mList)
        }
        myRefPerson.addValueEventListener(mPersonListener)

        button_add.setOnClickListener {
            val nav = findNavController()
            if (myViewModel.isAuthorization()) {
                nav.navigate(R.id.authorization4)
            } else {
                nav.navigate(R.id.login4)
            }
        }
        search_view.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                adapter.setList(search_view.text.toString(), mList)
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }
}
