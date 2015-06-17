package com.github.petropavel13.zoomablefrescoexample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.samples.zoomable.ZoomableDraweeView;


public class MainActivity extends Activity {

    private ZoomableDraweeView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(this);

        setContentView(R.layout.activity_main);

        imageView = (ZoomableDraweeView)findViewById(R.id.entry_image_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("https://assets-cdn.github.com/images/modules/open_graph/github-octocat.png"))
                .setOldController(imageView.getController())
                .build();

        imageView.setController(controller);
    }
}
