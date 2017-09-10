// Generated code from Butter Knife. Do not modify!
package com.udacity.immersiveimages;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MainActivity$$ViewInjector<T extends com.udacity.immersiveimages.MainActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492967, "field 'imageView'");
    target.imageView = finder.castView(view, 2131492967, "field 'imageView'");
    view = finder.findRequiredView(source, 2131492970, "field 'noneBtn' and method 'clickRadioButton'");
    target.noneBtn = finder.castView(view, 2131492970, "field 'noneBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
    view = finder.findRequiredView(source, 2131492971, "field 'centerBtn' and method 'clickRadioButton'");
    target.centerBtn = finder.castView(view, 2131492971, "field 'centerBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
    view = finder.findRequiredView(source, 2131492972, "field 'centerCropBtn' and method 'clickRadioButton'");
    target.centerCropBtn = finder.castView(view, 2131492972, "field 'centerCropBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
    view = finder.findRequiredView(source, 2131492973, "field 'centerInsideBtn' and method 'clickRadioButton'");
    target.centerInsideBtn = finder.castView(view, 2131492973, "field 'centerInsideBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
    view = finder.findRequiredView(source, 2131492974, "field 'fitCenterBtn' and method 'clickRadioButton'");
    target.fitCenterBtn = finder.castView(view, 2131492974, "field 'fitCenterBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
    view = finder.findRequiredView(source, 2131492975, "field 'fitEndBtn' and method 'clickRadioButton'");
    target.fitEndBtn = finder.castView(view, 2131492975, "field 'fitEndBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
    view = finder.findRequiredView(source, 2131492976, "field 'fitStartBtn' and method 'clickRadioButton'");
    target.fitStartBtn = finder.castView(view, 2131492976, "field 'fitStartBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
    view = finder.findRequiredView(source, 2131492977, "field 'fitXYBtn' and method 'clickRadioButton'");
    target.fitXYBtn = finder.castView(view, 2131492977, "field 'fitXYBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
    view = finder.findRequiredView(source, 2131492978, "field 'matrixBtn' and method 'clickRadioButton'");
    target.matrixBtn = finder.castView(view, 2131492978, "field 'matrixBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickRadioButton(finder.<android.widget.RadioButton>castParam(p0, "doClick", 0, "clickRadioButton", 0));
        }
      });
  }

  @Override public void reset(T target) {
    target.imageView = null;
    target.noneBtn = null;
    target.centerBtn = null;
    target.centerCropBtn = null;
    target.centerInsideBtn = null;
    target.fitCenterBtn = null;
    target.fitEndBtn = null;
    target.fitStartBtn = null;
    target.fitXYBtn = null;
    target.matrixBtn = null;
  }
}
