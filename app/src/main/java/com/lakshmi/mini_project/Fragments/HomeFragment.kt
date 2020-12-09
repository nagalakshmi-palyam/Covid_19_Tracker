package com.lakshmi.mini_project.Fragments

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.mini_project.Adapter.CountryAdapter
import com.lakshmi.mini_project.Adapter.StateAdapter
import com.lakshmi.mini_project.Listeners.RecyclerviewItemClickListener
import com.lakshmi.mini_project.Model.CountryItem
import com.lakshmi.mini_project.Model.ResponseStates
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.SealedClass.UserUI
import com.lakshmi.mini_project.ViewModel.StateViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),View.OnClickListener,RecyclerviewItemClickListener {
    private lateinit var stateViewModel: StateViewModel
    private lateinit var stateAdapter:StateAdapter
    private var stateModellist= emptyList<ResponseStates>()
    lateinit var phonenumber:String
    val requestcode=1;
    val sendrequestcode=2
    private lateinit var countrylist:ArrayList<CountryItem>
    private lateinit var madapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviews(view)

    }
   fun initviews(view: View){
       ivcallnow.setOnClickListener(this)
       tvhelpline1.setOnClickListener(this)
       tvhelpline4.setOnClickListener(this)
       tvhelpline2.setOnClickListener(this)
       tvhelpline3.setOnClickListener(this)
       tvhelpline1send.setOnClickListener(this)
       tvhelpline2send.setOnClickListener(this)
       tvhelpline3send.setOnClickListener(this)
       tvhelpline4send.setOnClickListener(this)
       ivsendmessage.setOnClickListener(this)
       stateViewModel = ViewModelProvider(this).get(StateViewModel::class.java)
       initList()
       madapter= CountryAdapter(context, countrylist)
       spinnerCountries.adapter=madapter

       spinnerCountries.onItemSelectedListener = object : OnItemSelectedListener {
           override fun onItemSelected(
               parent: AdapterView<*>,
               view: View,
               position: Int,
               id: Long

           ) {
               val clickedItem = parent.getItemAtPosition(position) as CountryItem
               val clickedCountryName: String = clickedItem.mcountryname
               Toast.makeText(context, "$clickedCountryName selected", Toast.LENGTH_SHORT)
                   .show()
               setadapterandLayout()
               observeLiveData()
               stateViewModel.getAPI()
           }

           override fun onNothingSelected(parent: AdapterView<*>?) {}
       }
     
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivcallnow -> {
                llayout.visibility = View.VISIBLE
            }
            R.id.tvhelpline1 -> {
                llayout.visibility = View.GONE
                phonenumber = tvhelpline1.text.toString()
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.CALL_PHONE
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        requestcode
                    )
                } else {
                    startcall()
                }
            }
            R.id.tvhelpline2 -> {
                llayout.visibility = View.GONE
                phonenumber = tvhelpline2.text.toString()
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.CALL_PHONE
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        requestcode
                    )
                } else {
                    startcall()
                }
            }
            R.id.tvhelpline3 -> {
                llayout.visibility = View.GONE
                phonenumber = tvhelpline3.text.toString()
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.CALL_PHONE
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        requestcode
                    )
                } else {
                    startcall()
                }

            }
            R.id.tvhelpline4 -> {
                llayout.visibility = View.GONE
                phonenumber = tvhelpline4.text.toString()
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.CALL_PHONE
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        requestcode
                    )
                } else {
                    startcall()
                }

            }

            R.id.ivsendmessage -> {
                llayoutsend.visibility = View.VISIBLE

            }
            R.id.tvhelpline3send -> {
                llayout.visibility = View.GONE
                phonenumber = tvhelpline3send.text.toString()
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.SEND_SMS
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.SEND_SMS),
                        sendrequestcode
                    )
                } else {
                    sendMessage()
                }
            }
            R.id.tvhelpline2send -> {
                llayout.visibility = View.GONE
                phonenumber = tvhelpline2send.text.toString()
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.SEND_SMS
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.SEND_SMS),
                        sendrequestcode
                    )
                } else {
                    sendMessage()
                }
            }
            R.id.tvhelpline1send -> {
                llayout.visibility = View.GONE
                phonenumber = tvhelpline1send.text.toString()
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.SEND_SMS
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.SEND_SMS),
                        sendrequestcode
                    )
                } else {
                    sendMessage()
                }
            }
            R.id.tvhelpline4send -> {
                llayout.visibility = View.GONE
                phonenumber = tvhelpline4send.text.toString()
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.SEND_SMS
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.SEND_SMS),
                        sendrequestcode
                    )
                } else {
                    sendMessage()
                }
            }




        }
    }
        fun startcall() {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.setData(Uri.parse("tel:" + phonenumber))
            if (context?.let { ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.CALL_PHONE
                ) } != PackageManager.PERMISSION_GRANTED) {
                return
            }
            startActivity(callIntent)
        }
    fun sendMessage(){
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.setData(Uri.parse("send :" + phonenumber))
        if (context?.let { ActivityCompat.checkSelfPermission(it, Manifest.permission.SEND_SMS) } != PackageManager.PERMISSION_GRANTED) {
            return
        }
        startActivity(sendIntent)
    }

    private fun observeLiveData() {
        stateViewModel.liveData.observe(this, {
            when (it) {
                is UserUI.Success -> {
                    stateAdapter.updateStateList(it.stateslist)
                }

                is UserUI.Failure -> {
                    Toast.makeText(
                        requireActivity(),
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
    fun setadapterandLayout(){
        val linearlayoutmanager= LinearLayoutManager(context)
        stateAdapter= StateAdapter(stateModellist,this)
        recyclerview.apply {
            this.layoutManager= linearlayoutmanager
            this.adapter=stateAdapter
        }
    }
    private fun initList() {
        countrylist=ArrayList<CountryItem>()
        countrylist.add(CountryItem("USA", R.drawable.american))
        countrylist.add(CountryItem("India", R.drawable.american))
    }

    override fun onItemClicked(responseStates: ResponseStates, position: Int) {
        stateViewModel.states.value=responseStates.state
    }


}