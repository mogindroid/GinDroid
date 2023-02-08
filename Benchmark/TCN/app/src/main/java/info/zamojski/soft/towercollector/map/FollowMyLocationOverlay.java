/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.map;

import android.graphics.Bitmap;
import android.view.MotionEvent;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class FollowMyLocationOverlay extends MyLocationNewOverlay {

    private FollowMyLocationChangeListener followMyLocationChangeListener;

    public FollowMyLocationOverlay(MapView mapView) {
        super(mapView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event, MapView mapView) {
        boolean wasFollowing = isFollowLocationEnabled();
        boolean result = super.onTouchEvent(event, mapView);
        boolean isFollowing = isFollowLocationEnabled();
        if (wasFollowing != isFollowing && followMyLocationChangeListener != null) {
            followMyLocationChangeListener.onFollowMyLocationChanged(isFollowing);
        }
        return result;
    }

    public void setFollowMyLocationChangeListener(FollowMyLocationChangeListener listener) {
        this.followMyLocationChangeListener = listener;
    }

    public interface FollowMyLocationChangeListener {
        void onFollowMyLocationChanged(boolean enabled);
    }

    // re-implemented for custom shapes
    public void setDirectionArrow(final Bitmap personBitmap, final Bitmap directionArrowBitmap) {
        this.mPersonBitmap = personBitmap;
        this.mDirectionArrowBitmap = directionArrowBitmap;

        mDirectionArrowCenterX = mDirectionArrowBitmap.getWidth() / 3.0f;
        mDirectionArrowCenterY = mDirectionArrowBitmap.getHeight() / 2.5f; // visual center of gravity is here

        if (mPersonHotspot != null) {
            float personCenterX = mPersonBitmap.getWidth() / 3.0f;
            float personCenterY = mPersonBitmap.getHeight() / 3.0f;

            mPersonHotspot.set(personCenterX, personCenterY);
        }
    }
}
