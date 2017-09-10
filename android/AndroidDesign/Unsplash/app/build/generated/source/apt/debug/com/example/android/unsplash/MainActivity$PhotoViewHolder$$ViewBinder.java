// Generated code from Butter Knife. Do not modify!
package com.example.android.unsplash;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$PhotoViewHolder$$ViewBinder<T extends com.example.android.unsplash.MainActivity.PhotoViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296258, "field 'imageView'");
    target.imageView = finder.castView(view, 2131296258, "field 'imageView'");
  }

  @Override public void unbind(T target) {
    target.imageView = null;
  }
}
