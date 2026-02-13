package com.learn2code.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.learn2code.app.data.repository.AppRepository;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReportsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.reports);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        BarChart barChart = findViewById(R.id.barChart);
        TextView tvNoScores = findViewById(R.id.tvNoScores);

        List<Float> scores = AppRepository.getInstance(this).getQuizScores();

        if (scores.isEmpty()) {
            tvNoScores.setVisibility(View.VISIBLE);
            barChart.setVisibility(View.GONE);
        } else {
            tvNoScores.setVisibility(View.GONE);
            barChart.setVisibility(View.VISIBLE);

            ArrayList<BarEntry> entries = new ArrayList<>();
            for (int i = 0; i < scores.size(); i++) {
                entries.add(new BarEntry(i + 1, scores.get(i)));
            }

            BarDataSet barDataSet = new BarDataSet(entries, "Quiz Scores");
            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            BarData barData = new BarData(barDataSet);
            barData.setBarWidth(0.9f);

            barChart.setData(barData);
            barChart.setFitBars(true);
            barChart.getDescription().setText("Scores by Quiz");
            barChart.animateY(1500);

            XAxis xAxis = barChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setGranularity(1f);
            xAxis.setGranularityEnabled(true);

            barChart.invalidate();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}