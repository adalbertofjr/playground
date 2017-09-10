// Generated code from Butter Knife. Do not modify!
package com.example.android.unsplash;

import android.content.res.Resources;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DetailActivity$$ViewBinder<T extends com.example.android.unsplash.DetailActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296259, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131296259, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131296258, "field 'imageView'");
    target.imageView = finder.castView(view, 2131296258, "field 'imageView'");
    view = finder.findRequiredView(source, 2131296261, "field 'author'");
    target.author = finder.castView(view, 2131296261, "field 'author'");
    Resources res = finder.getContext(source).getResources();
    target.slideDuration = res.getInteger(2131361792);
  }

  @Override public void unbind(T target) {
    target.toolbar = null;
    target.imageView = null;
    target.author = null;
  }
}
