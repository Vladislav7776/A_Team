package space.bunkou.a_team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_authorization.*

class Authorization : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ButtonAdd.setOnClickListener {
            if (EditTextFIO.text.isNullOrEmpty()) {
                EditTextFIO.setText("-")
            }
            if (EditTextBirth.text.isNullOrEmpty()) {
                EditTextBirth.setText("-")
            }
            if (EditTextCity.text.isNullOrEmpty()) {
                EditTextCity.setText("-")
            }
            if (EditTextArea.text.isNullOrEmpty()) {
                EditTextArea.setText("-")
            }
            if (EditTextRank.text.isNullOrEmpty()) {
                EditTextRank.setText("-")
            }
            if (EditTextOrganization.text.isNullOrEmpty()) {
                EditTextOrganization.setText("-")
            }
            if (EditTextOrganization2.text.isNullOrEmpty()) {
                EditTextOrganization2.setText("-")
            }

            addData(
                EditTextFIO,
                EditTextBirth,
                EditTextCity,
                EditTextArea,
                EditTextOrganization,
                EditTextRank,
                EditTextOrganization2
            )
            EditTextCity.text?.clear()
            EditTextOrganization2.text?.clear()
            EditTextOrganization.text?.clear()
            EditTextRank.text?.clear()
            EditTextArea.text?.clear()
            EditTextFIO.text?.clear()
            EditTextBirth.text?.clear()

            Toast.makeText(context, "Жыве Беларусь!!!", Toast.LENGTH_SHORT).show()

        }
    }
}