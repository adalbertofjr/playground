// Generated code from Butter Knife. Do not modify!
package com.example.android.unsplash;

import android.content.res.Resources;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.example.android.unsplash.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296262, "field 'grid'");
    target.grid = finder.castView(view, 2131296262, "field 'grid'");
    view = finder.findRequiredView(source, 16908292, "field 'empty'");
    target.empty = finder.castView(view, 16908292, "field 'empty'");
    Resources res = finder.getContext(source).getResources();
    target.gridSpacing = res.getDimensionPixelSize(2131230723);
    target.columns = res.getInteger(2131361793);
  }

  @Override public void unbind(T target) {
    target.grid = null;
    target.empty = null;
  }
}
