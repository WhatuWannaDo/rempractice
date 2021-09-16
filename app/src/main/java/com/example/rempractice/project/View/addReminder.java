package com.example.rempractice.project.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.rempractice.MainActivity;
import com.example.rempractice.databinding.AddremBinding;
import com.example.rempractice.project.ViewModel.addReminderVM;

import java.util.Calendar;

public class addReminder extends Fragment {

    private addReminderVM ARVM;
    private AddremBinding ARB;

    public static addReminder instance() {
        return new addReminder();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ARB = AddremBinding.inflate(getLayoutInflater(), container, false);


        ARB.calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month += 1;
                ARB.dateFromCalendar.setText(dayOfMonth + "." + month + "." + year);
            }
        });

        ARB.contRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ARB.remText.getText().toString().equals("")){
                    ARB.err.setText("Напоминание не написано!");
                }
                else if(ARB.dateFromCalendar.getText().toString().equals("")){
                    ARB.err.setText("Дата не выбрана!");
                }
                else {
                    ARVM.addReminder(ARB.remText.getText().toString(),
                            ARB.dateFromCalendar.getText().toString(), false);
                    Navigation.findNavController(v).popBackStack();
                }
            }
        });
        return ARB.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ARVM = new ViewModelProvider(this).get(addReminderVM.class);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        ARVM = null;
        ARB = null;
    }
}
