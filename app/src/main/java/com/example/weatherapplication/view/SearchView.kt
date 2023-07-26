package com.example.weatherapplication.view

import com.example.weatherapplication.presenter.CustomAdapter
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.ActivitySearchBinding
import com.example.weatherapplication.di.DependencyInjectorImpl
import com.example.weatherapplication.model.SampleWeather
import com.example.weatherapplication.model.SearchData
import com.example.weatherapplication.presenter.SearchContract
import com.example.weatherapplication.presenter.SearchPresenter
import com.example.weatherapplication.repo.WeatherState
import java.util.Locale

class SearchView : AppCompatActivity(), SearchContract.View{

    //initializing presenter
    private lateinit var presenter: SearchContract.presenter

    //Initializing components globally
    private lateinit var switpeRefresh: SwipeRefreshLayout
    private lateinit var location_result: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var progressBar: ProgressBar
    private lateinit var no_data: TextView

    //temporary data of Array<String> later to be change into Array<Created_Model>
    /*val locations = __init__()*/
    private lateinit var locations: List<SearchData.location>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_search)*/
        val binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary)

        //assigning references of components to globally declared variables
        switpeRefresh = binding.SwioRefresh
        location_result = binding.searchResults
        searchView = binding.searchView
        progressBar = binding.progressBar
        no_data = binding.noData

        setPresenter(SearchPresenter(this, DependencyInjectorImpl()))
        /*presenter.onViewCreated()*/

        //setting up searchViewListener
        searchViewListener()
    }

    override fun setPresenter(presenter: SearchContract.presenter) {
        this.presenter = presenter
    }

    override fun displayWeatherState(sampleWeather: SampleWeather) {
        Log.d("this", sampleWeather.icon.toString())
    }

    override fun Make_recycler(locations: List<SearchData.location>?) {
        Log.d("this", locations.toString())
        this.locations = locations!!
        recycleViewBuilder()
    }

    //a function that initializes the recycler view
    fun recycleViewBuilder(){
        Log.d("this","then last im here")
        //making an instance of the custom adapter then assigning it to the recyclerView reference
        val adapter = CustomAdapter(locations)
        location_result.adapter = adapter

        //Listening to the orientation change and assigning proper columns for each orientation.
        val col = if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 2 else 1

        //asinging the layout manager for the recyclerView reference
        location_result.layoutManager = GridLayoutManager(this, col)

        if(locations.size > 0){
            showdata()
        }else{
            nodata()
        }
        //calling function to set up onload and onrefresh Animation.
        setAnimation()
    }

    fun searchViewListener(){
        //creating a searchViewListener for searching instances
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            //calls everytime the text changes.
            override fun onQueryTextChange(newText: String): Boolean {
                //calls a filter function that filters the current dataset
                /*filter(newText)*/
                return false
            }

            //calls everytime the
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("this", "text was submitted")
                Log.d("this", "query = $query")
                loading()
                presenter.onViewCreated(query!!)
                return false
            }
        })
    }

    fun filter(text: String){
        //temporary variable
        val  temp = mutableListOf<SearchData.location>()

        //looping through every item inside locations arraylist
        for(data in locations){
            val loc = data.name
            if(loc.lowercase().contains(text.lowercase(Locale.getDefault()))){
                temp.add(data)
            }
        }

        //swapping recycler view adaptors
        //did this in one line for now. will make readable later. (1)
        location_result.swapAdapter(CustomAdapter(temp), false)
    }

    fun setAnimation(){
        //getting the reference of an animation resource
        val animation = AnimationUtils.loadAnimation(this, R.anim.onload_anim)

        //assigning animation to an animation controller
        val controller = LayoutAnimationController(animation)

        //Applying the animation controller to recycler view. this will animate the recycler view items on load
        location_result.layoutAnimation = controller

        //creating a listener for refresh instances
        switpeRefresh.setOnRefreshListener{
            //rebuilding the recyclerView. will be problematic once more features comes in. will change later in development.
            /*recycleViewBuilder()*/

            //disables the loading animation of SwipeRefreshLayout
            switpeRefresh.isRefreshing = false
        }
    }

    //function that returns an arraylist of temp strings.
    fun __init__():List<SearchData.location>{
        val names = arrayListOf(
            "Cebu",
            "Cebu cityy",
            "Wahington, that place, United States of America, This place. Yes that place",
            "Bohol",
            "Dumagetme",
            "Argao",
            "DD",
            "Dionn",
            "Panpan",
            "Mingky",
            "Caturay",
            "Josephine",
            "Another placeholder for a location that has a long name",
            "The United Guild of Something",
            "Robert",
            "Miranda",
            "Jhoana",
            "Johanes",
            "France",
            "Rudeus-kun",
            "Kazuma sato",
            "Lilith",
            "Shima"
        )

        val data = mutableListOf<SearchData.location>()

        for(name in names){
            data.add(
                SearchData.location(
                    id = 0,
                    name = name,
                    region = "unkown",
                    country = "unkown",
                    lat = 0.0,
                    lon = 0.0,
                    url = "unkown"
                ))
        }
        return data
    }

    fun loading(){
        progressBar.visibility = View.VISIBLE
        switpeRefresh.visibility = View.GONE
        no_data.visibility = View.GONE
    }

    fun showdata(){
        progressBar.visibility = View.GONE
        switpeRefresh.visibility = View.VISIBLE
        no_data.visibility = View.GONE
    }

    fun nodata(){
        progressBar.visibility = View.GONE
        switpeRefresh.visibility = View.GONE
        no_data.visibility = View.VISIBLE
    }

}