// Generated code from Butter Knife. Do not modify!
package com.udacity.pickpalette;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PickerFragment$$ViewInjector<T extends com.udacity.pickpalette.PickerFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492973, "field 'pickImage' and method 'pickImage'");
    target.pickImage = finder.castView(view, 2131492973, "field 'pickImage'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.pickImage(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492974, "field 'takeImage' and method 'takeImage'");
    target.takeImage = finder.castView(view, 2131492974, "field 'takeImage'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.takeImage(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.pickImage = null;
    target.takeImage = null;
  }
}
