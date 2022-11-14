package com.example.myapplication

import android.Manifest
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.location.LocationManager.NETWORK_PROVIDER
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.myapplication.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    var lat=0.00
    var lan=0.00
    lateinit var location:Location
    lateinit var locationManager:LocationManager
    lateinit var listener:LocationListener
    

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        if (checkSelfPermission(ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED && checkSelfPermission(
                ACCESS_FINE_LOCATION) != PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION), 101)
        }
        var locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        if (!locationManager.isProviderEnabled(GPS_PROVIDER)) {
            Toast.makeText(applicationContext, "GPS is not working", Toast.LENGTH_LONG).show()
        } else if (!locationManager.isProviderEnabled(NETWORK_PROVIDER)) {
            Toast.makeText(applicationContext, "Internet is not working", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(applicationContext, "Fetching Location", Toast.LENGTH_LONG).show()
        }
        listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                lat = location.getLatitude()
                lan = location.getLongitude()
            }
        }
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0.0F, listener)
                // locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,);
            }
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)!!
            // locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,);
            if (location != null) {
                lat = location.getLatitude()
                lan = location.getLongitude()
                Toast.makeText(this@MapsActivity, "" + location.getLatitude(), Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }




        /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(22.288919, 70.773588)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Rajkot"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}


