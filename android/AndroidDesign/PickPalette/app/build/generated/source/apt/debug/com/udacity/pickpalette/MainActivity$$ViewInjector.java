// Generated code from Butter Knife. Do not modify!
package com.udacity.pickpalette;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MainActivity$$ViewInjector<T extends com.udacity.pickpalette.MainActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492972, "field 'fab' and method 'click'");
    target.fab = finder.castView(view, 2131492972, "field 'fab'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.click(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492971, "field 'gridView' and method 'onItemClick'");
    target.gridView = finder.castView(view, 2131492971, "field 'gridView'");
    ((android.widget.AdapterView<?>) view).setOnItemClickListener(
      new android.widget.AdapterView.OnItemClickListener() {
        @Override public void onItemClick(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.onItemClick(p2);
        }
      });
    view = finder.findRequiredView(source, 2131492967, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131492967, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131492969, "field 'imageView'");
    target.imageView = finder.castView(view, 2131492969, "field 'imageView'");
  }

  @Override public void reset(T target) {
    target.fab = null;
    target.gridView = null;
    target.toolbar = null;
    target.imageView = null;
  }
}
