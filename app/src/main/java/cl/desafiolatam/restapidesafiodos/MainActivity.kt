package cl.desafiolatam.restapidesafiodos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.restapidesafiodos.modelo.PhotoPojo
import cl.desafiolatam.restapidesafiodos.modelo.RetrofitClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private val photoPojo = ArrayList<PhotoPojo>()
    private lateinit var imgAdapter: RecyclerView.Adapter<*>
    /*val​picasso = Picasso.Builder(applicationContext)
    .indicatorsEnabled(​true​)
    .loggingEnabled(​true​)
    .build()
    Picasso.setSingletonInstance(picasso)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgAdapter = PhotoAdapter(photoPojo)

        listRecyclerView.adapter = imgAdapter

        loadApiData()

    }

    private fun loadApiData() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getLista()
        call.enqueue(object : retrofit2.Callback<List<PhotoPojo>> {
            override fun onResponse(
                call: Call<List<PhotoPojo>>,
                response: Response<List<PhotoPojo>>
            ) {
                response.body()?.map { photoPojo.add(it) }
                imgAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<PhotoPojo>>, t: Throwable) {
                Log.d("Main", "Error: " + t)
                Toast.makeText(
                    applicationContext, "Error : no pudimos recuperar los posts desde la Api",
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }
}