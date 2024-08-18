package com.example.zoho_gatherly

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class MainActivity: FlutterActivity(){
    @Override
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        flutterEngine
            .platformViewsController
            .registry
            .registerViewFactory("custom-button-view", CustomButtonViewFactory())
    }
}
class CustomButtonViewFactory : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        return CustomButtonPlatformView(context)
    }
}
class CustomButtonView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    init {
        inflate(context, R.layout.custom_button, this)
        findViewById<Button>(R.id.custom_button).setOnClickListener {
            Toast.makeText(context, "Custom Button Pressed", Toast.LENGTH_SHORT).show()
        }
    }
}
class CustomButtonPlatformView(private val context: Context) : PlatformView {

    private val view: CustomButtonView = CustomButtonView(context, null)

    override fun getView(): View {
        return view
    }

    override fun dispose() {}
}