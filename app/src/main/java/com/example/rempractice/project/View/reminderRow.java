package com.example.rempractice.project.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rempractice.Domain.reminders;
import com.example.rempractice.R;
import com.example.rempractice.databinding.ReminderrowBinding;
import com.example.rempractice.project.View.adapters.reminderAdapter;
import com.example.rempractice.project.ViewModel.reminderVM;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class reminderRow extends Fragment {
    private reminderVM ARVM;
    private ReminderrowBinding ARB;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ARB = ReminderrowBinding.inflate(getLayoutInflater(), container, false);
        ARB.recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));

        ARB.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_reminderRow_to_addReminder2);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                ARVM.deleteReminder(((reminderAdapter) ARB.recyclerView2.getAdapter()).getReminder().get(pos));
            }
        }).attachToRecyclerView(ARB.recyclerView2);
        return ARB.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ARVM = new ViewModelProvider(this).get(reminderVM.class);
        ARVM.getRems().observe(getViewLifecycleOwner(), (List<reminders> remList) -> {
            ARB.recyclerView2.setAdapter(new reminderAdapter(remList, reminderRow.this));
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ARB = null;
        ARVM = null;
    }
}
