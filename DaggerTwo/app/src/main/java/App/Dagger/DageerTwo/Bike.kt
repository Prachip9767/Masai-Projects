package pg.dagger.DaggerTWo

import android.util.Log
import javax.inject.Inject

class Bike @Inject constructor(wheels: Wheels, engine: Engine, suspension: Suspension){

    fun driveBike(){
        Log.d("Umang", "driveBike: Driving Bike ");
    }

}