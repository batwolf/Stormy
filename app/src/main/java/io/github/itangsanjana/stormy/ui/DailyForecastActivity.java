package io.github.itangsanjana.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.itangsanjana.stormy.R;
import io.github.itangsanjana.stormy.adapters.DayAdapter;
import io.github.itangsanjana.stormy.weather.Day;

public class DailyForecastActivity extends AppCompatActivity {

    private Day[] mDays;

    @Bind(android.R.id.list) ListView mListView;
    @Bind(android.R.id.empty) TextView mTextViewEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter adapter = new DayAdapter(this, mDays);
        mListView.setAdapter(adapter);
        mListView.setEmptyView(mTextViewEmpty);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dayOfTheWeek = mDays[position].getDayOfTheWeek();
                String summary = mDays[position].getSummary();
                String temperatureMax = mDays[position].getTemperatureMax() + "";
                String message = String.format("On %s the high will be %s and it will be %s", dayOfTheWeek, temperatureMax, summary);

                Toast.makeText(DailyForecastActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
