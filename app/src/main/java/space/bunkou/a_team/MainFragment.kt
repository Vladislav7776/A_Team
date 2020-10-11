package space.bunkou.a_team

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment() : Fragment() {
    lateinit var interstitialAd : InterstitialAd  // Реклама

//    // Реклама - начало
//    MobileAds.initialize(this, "ca-app-pub-4393452075947293~6502531964")
//    interstitialAd = InterstitialAd(this)
//    interstitialAd.setAdUnitId("ca-app-pub-4393452075947293/4582945634")
//    var adRequest = AdRequest.Builder().build()
//    interstitialAd.loadAd(adRequest)
//    // Реклама - конец
//
//
//    // Закрытие рекламы на крестик - начало
//    interstitialAd.setAdListener(
//     object : AdListener() {
//        override fun onAdClosed() {
//            try {
//                val transition = null
//                when (transition) {
//                    0 -> {
//                    }
//                    1 -> {
//                        val intent = Intent(this, Login::class.java)
//                        startActivity(intent)
//                    }
//                    2 -> {
//                        val intent1 = Intent(this, Authorization::class.java)
//                        startActivity(intent1)
//                    }
//                    else -> {
//                    }
//                }
//            } catch (e: Exception) {
//                // пусто
//            }
//        }
//    }
//    // Закрытие рекламы на крестик - конец


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
