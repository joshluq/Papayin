package pe.joshluque.papayin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import pe.joshluque.papayin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        // first find the nav controller
        val navController = findNavController(R.id.nav_host_fragment)

        setSupportActionBar(binding.toolbar)

        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->
            when (destination.id) {
                R.id.movieListFragment -> {
                    binding.ivToolbar.visibility = View.VISIBLE
                    binding.tvTitleToolbar.visibility = View.GONE
                }
                else -> {
                    binding.ivToolbar.visibility = View.GONE
                    binding.tvTitleToolbar.visibility = View.VISIBLE
                    binding.tvTitleToolbar.text = getString(R.string.my_movie)

                }
            }
        }
    }
}
