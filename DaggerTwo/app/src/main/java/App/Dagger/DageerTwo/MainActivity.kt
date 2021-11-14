package pg.dagger.DaggerTWo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var bike: Bike

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        bike = DaggerCarCompo.create().getBike()
        bike.driveBike()

    }
}

