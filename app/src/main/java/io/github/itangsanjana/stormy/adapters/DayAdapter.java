package io.github.itangsanjana.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.itangsanjana.stormy.R;
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
        ViewHolder holder;

        if (convertView == null) {
//            Brand new.
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.imageViewIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            holder.textViewTemperature = (TextView) convertView.findViewById(R.id.textViewTemperature);
            holder.textViewDayName = (TextView) convertView.findViewById(R.id.textViewDayName);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];

        holder.imageViewIcon.setImageResource(day.getIconId());
        holder.textViewTemperature.setText(day.getTemperatureMax() + "");
        holder.textViewDayName.setText(day.getDayOfTheWeek());

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageViewIcon;
        TextView textViewTemperature;
        TextView textViewDayName;
    }
}
