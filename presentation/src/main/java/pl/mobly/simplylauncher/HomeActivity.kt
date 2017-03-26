package pl.mobly.simplylauncher

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import javax.inject.Inject

import pl.mobly.simplylauncher.common.AppBase

class HomeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        AppBase.appComponent.inject(this)
    }
}
