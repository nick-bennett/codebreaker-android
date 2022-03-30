package edu.cnm.deepdive.codebreaker.controller;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;
import edu.cnm.deepdive.codebreaker.R;
import edu.cnm.deepdive.codebreaker.viewmodel.UserViewModel;

public class SettingsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);
  }

  public static class SettingsFragment extends PreferenceFragmentCompat {

    private UserViewModel viewModel;

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
      setPreferencesFromResource(R.xml.settings, rootKey);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      viewModel = new ViewModelProvider(this).get(UserViewModel.class);
      viewModel
          .getUser()
          .observe(getViewLifecycleOwner(), (user) -> {
            EditTextPreference displayName = findPreference(getString(R.string.display_name_pref_key));
            displayName.setText(user.getDisplayName());
            SwitchPreference incognito = findPreference(getString(R.string.incognito_pref_key));
            incognito.setChecked(user.isIncognito());
          });
    }

  }

}