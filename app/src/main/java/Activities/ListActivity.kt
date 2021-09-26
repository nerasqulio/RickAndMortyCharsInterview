package Activities

import Networking.Model
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.iterator
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortychars.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*
import java.io.Serializable

import kotlin.collections.mutableListOf as mutableListOf

class ListActivity : AppCompatActivity() {

    val viewModel : Model by lazy{
        ViewModelProvider(this).get(Model::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        var intent : Intent
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val numbers = IntArray(20) {(it + 1)}

        viewModel.updateCharPage(""+numbers.contentToString())
        viewModel.charByPageLive.observe(this)
        { response ->
            if (response == null) {

                Toast.makeText(
                    this@ListActivity, "Network Error!! Check your internet connection!",
                    Toast.LENGTH_SHORT
                ).show()

                return@observe
            }


            val group: ViewGroup = findViewById<ConstraintLayout>(R.id.layout)
            var count: Int = 0
            var check : Boolean = false

            val list: MutableList<View> = mutableListOf()
            for (i in group)
            {
                if (i is AppCompatImageView) Picasso.get().load(response[count].image).into(i).also { check = true }.also{list.add(i)}
                if (i is AppCompatTextView) i.setText(response[count].name).also { if(check)  count++}.also{ check = false }
            }
            for(i in list.withIndex())
            {

                i.value.setOnClickListener()
                    {
                    intent = Intent(this, MainActivity::class.java).apply {
                        putExtra("ID", "" + (i.index+1))
                        putExtra("object",response[(i.index)] as Serializable)
                    }
                        startActivity(intent)
                    }

            }
        }
    }

}
