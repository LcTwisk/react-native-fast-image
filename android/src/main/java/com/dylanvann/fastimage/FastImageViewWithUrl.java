package com.dylanvann.fastimage;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.model.GlideUrl;

import javax.annotation.Nullable;

class FastImageViewWithUrl extends AppCompatImageView {
    public GlideUrl glideUrl;

    public void playAnimation() {
        if (this.getDrawable() instanceof WebpDrawable) {
            WebpDrawable drawable = (WebpDrawable) this.getDrawable();
            if (!drawable.isRunning()) {
                drawable.startFromFirstFrame();
            }
        }
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable)
    {
        super.setImageDrawable(drawable);
        if (drawable instanceof WebpDrawable) {
            WebpDrawable webpDrawable = (WebpDrawable) drawable;
            webpDrawable.setLoopCount(1);
            webpDrawable.stop();
        }
    }

    public FastImageViewWithUrl(Context context) {
        super(context);
    }
}
