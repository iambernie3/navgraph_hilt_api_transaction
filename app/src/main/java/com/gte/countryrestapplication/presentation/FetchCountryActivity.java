package com.gte.countryrestapplication.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.gte.countryrestapplication.R;
import com.gte.countryrestapplication.databinding.ActivityFetchCountryBinding;

import dagger.hilt.EntryPoint;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FetchCountryActivity extends AppCompatActivity {
    private ActivityFetchCountryBinding binding;

    private CountryViewModel countryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFetchCountryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        exitPage();

        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);

        //FETCH COUNTRY IN BACKGROUND
        new Thread(new FetchCountryThread(countryViewModel)).start();

        countryViewModel.getApiState().observe(this,result -> {
            switch (result.getApiStatus()) {
                case ON_PROGRESS:
                    binding.progress.setVisibility(View.VISIBLE);
                    break;
                case SUCCESS:
                    binding.progress.setVisibility(View.GONE);
                    Log.e("Country List","data: "+ result.getData().get(0).getName().getCommon());
                    Log.e("Country List","capital: "+ result.getData().get(0).getCapital().get(0));
                    break;
                case ERROR:
                    binding.progress.setVisibility(View.GONE);
                    Log.e("Country List","error data: "+ result.getErrorMessage());
                    break;
                default:
            }
        });
    }

    @Override
    public boolean onNavigateUp() {
        this.finish();
        return true;
    }

    private void exitPage() {
        binding.btnExit.setOnClickListener( v -> {
            this.finish();
        });
    }

}