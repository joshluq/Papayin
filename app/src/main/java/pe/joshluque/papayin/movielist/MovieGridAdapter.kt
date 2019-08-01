package pe.joshluque.papayin.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pe.joshluque.papayin.data.entity.Movie
import pe.joshluque.papayin.databinding.GridMovieItemBinding

class MovieGridAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Movie, MovieGridAdapter.MovieViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }


    class MovieViewHolder(private var binding: GridMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(GridMovieItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
    }

    class OnClickListener(val clickListener: (marsProperty: Movie) -> Unit) {
        fun onClick(marsProperty: Movie) = clickListener(marsProperty)
    }
}


