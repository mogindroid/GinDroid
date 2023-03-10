// Generated by view binder compiler. Do not edit!
package com.aaronjwood.portauthority.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.aaronjwood.portauthority.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PortRangeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final NumberPicker portRangePickerStart;

  @NonNull
  public final NumberPicker portRangePickerStop;

  @NonNull
  public final TextView portRangeStartLabel;

  @NonNull
  public final TextView portRangeStopLabel;

  @NonNull
  public final Button resetPortRangeScan;

  @NonNull
  public final Button startPortRangeScan;

  private PortRangeBinding(@NonNull LinearLayout rootView,
      @NonNull NumberPicker portRangePickerStart, @NonNull NumberPicker portRangePickerStop,
      @NonNull TextView portRangeStartLabel, @NonNull TextView portRangeStopLabel,
      @NonNull Button resetPortRangeScan, @NonNull Button startPortRangeScan) {
    this.rootView = rootView;
    this.portRangePickerStart = portRangePickerStart;
    this.portRangePickerStop = portRangePickerStop;
    this.portRangeStartLabel = portRangeStartLabel;
    this.portRangeStopLabel = portRangeStopLabel;
    this.resetPortRangeScan = resetPortRangeScan;
    this.startPortRangeScan = startPortRangeScan;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PortRangeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PortRangeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.port_range, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PortRangeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.portRangePickerStart;
      NumberPicker portRangePickerStart = rootView.findViewById(id);
      if (portRangePickerStart == null) {
        break missingId;
      }

      id = R.id.portRangePickerStop;
      NumberPicker portRangePickerStop = rootView.findViewById(id);
      if (portRangePickerStop == null) {
        break missingId;
      }

      id = R.id.portRangeStartLabel;
      TextView portRangeStartLabel = rootView.findViewById(id);
      if (portRangeStartLabel == null) {
        break missingId;
      }

      id = R.id.portRangeStopLabel;
      TextView portRangeStopLabel = rootView.findViewById(id);
      if (portRangeStopLabel == null) {
        break missingId;
      }

      id = R.id.resetPortRangeScan;
      Button resetPortRangeScan = rootView.findViewById(id);
      if (resetPortRangeScan == null) {
        break missingId;
      }

      id = R.id.startPortRangeScan;
      Button startPortRangeScan = rootView.findViewById(id);
      if (startPortRangeScan == null) {
        break missingId;
      }

      return new PortRangeBinding((LinearLayout) rootView, portRangePickerStart,
          portRangePickerStop, portRangeStartLabel, portRangeStopLabel, resetPortRangeScan,
          startPortRangeScan);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
