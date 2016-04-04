package io.github.itangsanjana.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.github.itangsanjana.stormy.R;
import io.github.itangsanjana.stormy.weather.Hour;

/**
 * Created by estudio on 04/04/16.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;
    private Context mContext;

    public HourAdapter(Context context, Hour[] hours) {
        mContext = context;
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

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour) {
            mTextViewTime.setText(hour.getHour());
            mTextViewSummary.setText(hour.getSummary());
            mTextViewTemperature.setText(hour.getTemperature() + "");
            mImageViewIcon.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View v) {
            String stringTime = mTextViewTime.getText().toString();
            String stringTemperature = mTextViewTemperature.getText().toString();
            String stringSummary = mTextViewSummary.getText().toString();
            String stringMessage = String.format("At %s it will be %s and %s", stringTime, stringTemperature, stringSummary);

            Toast.makeText(mContext, stringMessage, Toast.LENGTH_LONG).show();
        }
    }
}
