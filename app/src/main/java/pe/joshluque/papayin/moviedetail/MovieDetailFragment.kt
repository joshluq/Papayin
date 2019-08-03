package pe.joshluque.papayin.moviedetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import pe.joshluque.papayin.R
import pe.joshluque.papayin.data.entity.Gender
import pe.joshluque.papayin.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {

    private val viewModel: MovieDetailViewModel by lazy {
        ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMovieDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        viewModel.setMovie(MovieDetailFragmentArgs.fromBundle(arguments!!).movieSelected)
        binding.viewModel = viewModel
        return binding.root
    }


}
