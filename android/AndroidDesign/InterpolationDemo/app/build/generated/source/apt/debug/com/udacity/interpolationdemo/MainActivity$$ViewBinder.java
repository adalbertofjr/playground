// Generated code from Butter Knife. Do not modify!
package com.udacity.interpolationdemo;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.udacity.interpolationdemo.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558479, "field 'interpolatorSpinner', method 'onItemSelected', and method 'onNothingSelected'");
    target.interpolatorSpinner = finder.castView(view, 2131558479, "field 'interpolatorSpinner'");
    ((android.widget.AdapterView<?>) view).setOnItemSelectedListener(
      new android.widget.AdapterView.OnItemSelectedListener() {
        @Override public void onItemSelected(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.onItemSelected(finder.<android.widget.Spinner>castParam(p0, "onItemSelected", 0, "onItemSelected", 0), p2);
        }
        @Override public void onNothingSelected(
          android.widget.AdapterView<?> p0
        ) {
          target.onNothingSelected();
        }
      });
    view = finder.findRequiredView(source, 2131558480, "field 'duratorSpinner' and method 'durationSelected'");
    target.duratorSpinner = finder.castView(view, 2131558480, "field 'duratorSpinner'");
    ((android.widget.AdapterView<?>) view).setOnItemSelectedListener(
      new android.widget.AdapterView.OnItemSelectedListener() {
        @Override public void onItemSelected(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.durationSelected(finder.<android.widget.Spinner>castParam(p0, "onItemSelected", 0, "durationSelected", 0), p2);
        }
        @Override public void onNothingSelected(
          android.widget.AdapterView<?> p0
        ) {
          
        }
      });
    view = finder.findRequiredView(source, 2131558481, "field 'textView'");
    target.textView = finder.castView(view, 2131558481, "field 'textView'");
  }

  @Override public void unbind(T target) {
    target.interpolatorSpinner = null;
    target.duratorSpinner = null;
    target.textView = null;
  }
}
