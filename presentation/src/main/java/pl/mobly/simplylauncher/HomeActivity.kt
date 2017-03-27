package pl.mobly.simplylauncher

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscription
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.domain.interactors.SystemInfoInteractorImpl

import javax.inject.Inject

import pl.mobly.simplylauncher.common.AppBase

class HomeActivity : Activity() {

    lateinit var disposable:Disposable

    @Inject
    lateinit var systemInfoInteractorImpl:SystemInfoInteractorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        AppBase.appComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
    }
}
