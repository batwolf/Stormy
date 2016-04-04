package io.github.itangsanjana.stormy.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import io.github.itangsanjana.stormy.weather.Day;

/**
 * Created by itangsanjana on 04/04/16.
 */
public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; // Not used.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
