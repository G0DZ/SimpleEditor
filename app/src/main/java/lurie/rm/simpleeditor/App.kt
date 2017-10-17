package lurie.rm.simpleeditor

import android.app.Application
import android.os.SystemClock
import java.util.concurrent.TimeUnit

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Don't do this! This is just so cold launches take some time
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
    }
}