// Generated code from Butter Knife. Do not modify!
package com.udacity.md_typograhical_scale;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MainActivityFragment$$ViewInjector<T extends com.udacity.md_typograhical_scale.MainActivityFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427329, "field 'display4View'");
    target.display4View = finder.castView(view, 2131427329, "field 'display4View'");
    view = finder.findRequiredView(source, 2131427330, "field 'headlineView'");
    target.headlineView = finder.castView(view, 2131427330, "field 'headlineView'");
  }

  @Override public void reset(T target) {
    target.display4View = null;
    target.headlineView = null;
  }
}
