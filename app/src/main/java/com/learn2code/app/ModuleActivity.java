package com.learn2code.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.learn2code.app.data.repository.AppRepository;

public class ModuleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.modules);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.moduleListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Module> modules = AppRepository.getInstance(this).getAllModules();
        ModuleAdapter adapter = new ModuleAdapter(modules, module -> {
            Intent intent = new Intent(this, TopicActivity.class);
            intent.putExtra("MODULE_ID", module.getId());
            intent.putExtra("MODULE_NAME", module.getName());

            getPrefsHelper().setModuleId(module.getId());
            getPrefsHelper().setModuleName(module.getName());

            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}