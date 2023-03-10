// Generated by view binder compiler. Do not edit!
package com.aaronjwood.portauthority.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.aaronjwood.portauthority.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class WakeOnLanBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText wolIp;

  @NonNull
  public final EditText wolMac;

  @NonNull
  public final Button wolWake;

  private WakeOnLanBinding(@NonNull LinearLayout rootView, @NonNull EditText wolIp,
      @NonNull EditText wolMac, @NonNull Button wolWake) {
    this.rootView = rootView;
    this.wolIp = wolIp;
    this.wolMac = wolMac;
    this.wolWake = wolWake;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static WakeOnLanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static WakeOnLanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.wake_on_lan, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static WakeOnLanBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.wolIp;
      EditText wolIp = rootView.findViewById(id);
      if (wolIp == null) {
        break missingId;
      }

      id = R.id.wolMac;
      EditText wolMac = rootView.findViewById(id);
      if (wolMac == null) {
        break missingId;
      }

      id = R.id.wolWake;
      Button wolWake = rootView.findViewById(id);
      if (wolWake == null) {
        break missingId;
      }

      return new WakeOnLanBinding((LinearLayout) rootView, wolIp, wolMac, wolWake);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
