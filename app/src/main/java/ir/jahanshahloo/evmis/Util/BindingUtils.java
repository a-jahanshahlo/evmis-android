package ir.jahanshahloo.evmis.Util;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ir.jahanshahloo.evmis.model.BaseModel;

/**
 * Created by Adminstrator on 10/9/2016.
 */
public class BindingUtils
{
    @BindingAdapter(value = {"selection", "selectionAttrChanged", "adapter"}, requireAll = false)
    public static void setAdapter(AppCompatSpinner view, Integer newSelection, final InverseBindingListener bindingListener, ArrayAdapter adapter) {
       // view.setAdapter(adapter);
        view.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bindingListener.onChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing
            }
        });
        if (newSelection != null) {
      /*      int pos = ((ArrayAdapter<BaseModel>) view.getAdapter()).getPosition(newSelection);
             view.setSelection(pos);*/
        }
    }
    @InverseBindingAdapter(attribute = "selection", event = "selectionAttrChanged")
    public static Integer getSelectedValue(AdapterView view) {

        Integer id = ((BaseModel) view.getSelectedItem()).getId();
        Log.i("ali", "getSelectedValue: "+id);
        return id;
    }

    @BindingAdapter(value={"textDouble","textDoubleAttrChanged"},requireAll = false)
    public static void bindDoubleInText(AppCompatEditText tv, final Double value, final InverseBindingListener bindingListener)
    {
        tv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                    bindingListener.onChange();

            }
        });
        tv.setText(String.valueOf(value));

    }
    @InverseBindingAdapter(attribute = "textDouble", event = "textDoubleAttrChanged")
    public static Double getDoubleFromBinding(AppCompatEditText view)
    {
        String string = view.getText().toString();
        return string.isEmpty() ? 0d : Double.parseDouble(string);
    }

    @BindingAdapter(value={"textInt","textIntAttrChanged"},requireAll = false)
    public static void bindIntInText(AppCompatEditText tv, final Integer value, final InverseBindingListener bindingListener)
    {
        tv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                bindingListener.onChange();

            }
        });
        tv.setText(String.valueOf(value));

    }
    @InverseBindingAdapter(attribute = "textInt", event = "textIntAttrChanged")
    public static Integer getIntFromBinding(AppCompatEditText view)
    {
        String string = view.getText().toString();
        return string.isEmpty() ? 0 : Integer.parseInt(string);
    }

}