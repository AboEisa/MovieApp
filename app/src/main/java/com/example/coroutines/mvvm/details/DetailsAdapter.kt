import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coroutines.Constant
import com.example.coroutines.Constant.Companion.IMAGES
import com.example.coroutines.mvvm.details.MovieDetailsModel
import com.example.coroutines.databinding.ItemDetailsBinding

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.Holder>() {

    var movieDetails: MovieDetailsModel? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        movieDetails?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return if (movieDetails == null) 0 else 1
    }

    inner class Holder(val binding: ItemDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieDetails: MovieDetailsModel) {
            binding.apply {
                detailsContainer.visibility = View.VISIBLE
                movieTitle.text = movieDetails.title
                releaseDate.text = movieDetails.release_date
                movieDescription.text = movieDetails.overview
                Glide.with(binding.root)
                    .load(IMAGES+movieDetails.poster_path)
                    .into(moviePoster)
            }
        }
    }
}
