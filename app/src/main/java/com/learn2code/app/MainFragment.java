package com.learn2code.app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;
import com.learn2code.app.data.repository.AppRepository;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialCardView cardModules = view.findViewById(R.id.cardModules);
        MaterialCardView cardCode = view.findViewById(R.id.cardCode);
        MaterialCardView cardSettings = view.findViewById(R.id.cardSettings);
        MaterialCardView cardReports = view.findViewById(R.id.cardReports);
        View btnLogout = view.findViewById(R.id.btnLogout);

        cardModules.setOnClickListener(v -> openModuleActivity());
        cardCode.setOnClickListener(v -> openCodeActivity());
        cardSettings.setOnClickListener(v -> openSettingsActivity());
        cardReports.setOnClickListener(v -> openReportsActivity());
        btnLogout.setOnClickListener(v -> showClearProgressConfirmation());
    }

    private void openReportsActivity() {
        Intent intent = new Intent(getActivity(), ReportsActivity.class);
        startActivity(intent);
    }

    private void openModuleActivity() {
        Intent intent = new Intent(getActivity(), ModuleActivity.class);
        startActivity(intent);
    }

    private void openSettingsActivity() {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        startActivity(intent);
    }

    private void showClearProgressConfirmation() {
        new AlertDialog.Builder(requireActivity())
                .setTitle("Clear Progress")
                .setMessage("All quiz scores will be deleted. Are you sure?")
                .setPositiveButton("Clear", (dialog, which) -> clearProgress())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void clearProgress() {
        AppRepository.getInstance(requireActivity()).clearQuizScores();
    }

    private void openCodeActivity() {
        Intent intent = new Intent(getActivity(), CodingActivity.class);
        startActivity(intent);
    }
}