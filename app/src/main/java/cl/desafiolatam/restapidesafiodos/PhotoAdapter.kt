package cl.desafiolatam.restapidesafiodos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.restapidesafiodos.modelo.PhotoPojo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_list_item.view.*

class PhotoAdapter(private val myDataset: List<PhotoPojo>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.photo_list_item, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = myDataset[position]
        holder.titulo.text = photo.title

        Picasso.get()
            .load(photo.thumbnailUrl)
            .into(holder.image)
    }


    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.tvtitle
        val image: ImageView = itemView.idphoto
    }

}