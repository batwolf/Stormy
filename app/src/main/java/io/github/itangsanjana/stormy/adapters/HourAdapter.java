package io.github.itangsanjana.stormy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.itangsanjana.stormy.R;
import io.github.itangsanjana.stormy.weather.Hour;

/**
 * Created by estudio on 04/04/16.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;

    public HourAdapter(Hour[] hours) {
        mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_list_item, parent, false);
        HourViewHolder viewHolder = new HourViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewTime;
        public TextView mTextViewSummary;
        public TextView mTextViewTemperature;
        public ImageView mImageViewIcon;

        public HourViewHolder(View itemView) {
            super(itemView);

            mTextViewTime = (TextView) itemView.findViewById(R.id.textViewTime);
            mTextViewSummary = (TextView) itemView.findViewById(R.id.textViewSummary);
            mTextViewTemperature = (TextView) itemView.findViewById(R.id.textViewTemperature);
            mImageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewIcon);
        }

        public void bindHour(Hour hour) {
            mTextViewTime.setText(hour.getHour());
            mTextViewSummary.setText(hour.getSummary());
            mTextViewTemperature.setText(hour.getTemperature() + "");
            mImageViewIcon.setImageResource(hour.getIconId());
        }
    }
}
