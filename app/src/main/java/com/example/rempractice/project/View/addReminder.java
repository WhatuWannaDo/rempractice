package com.example.rempractice.project.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.rempractice.databinding.AddremBinding;
import com.example.rempractice.project.ViewModel.addReminderVM;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class addReminder extends Fragment {

    private addReminderVM ARVM;
    private AddremBinding ARB;
    public List<String> list = new ArrayList<>( );

    public static addReminder instance() {
        return new addReminder();
    }

    public static final int GALLERY_REQUEST = 1;

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

        ARB.buttonAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });

        ARB.adress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ARVM.getAddressList(s.toString()).observe(getViewLifecycleOwner(), (List<String> values) -> {
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(
                            getContext(),
                            android.R.layout.simple_dropdown_item_1line,
                            values
                    );
                    adapter.getFilter().filter(null);
                    ARB.adress.setAdapter(adapter);

                });
            }

            @Override
            public void afterTextChanged(Editable s) {
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
                else if(ARB.adress.getText().toString().equals("")){
                    ARB.err.setText("Место не добавлено!");
                }
                else {
                    Bitmap bitmap = ((BitmapDrawable)ARB.addImageRem.getDrawable()).getBitmap();

                    Uri uri = getImageUri(getContext(), bitmap);
                    list.add(uri.toString());

                    ARVM.addReminder(ARB.remText.getText().toString(),
                            ARB.dateFromCalendar.getText().toString(),
                            false,
                            list,
                            ARB.adress.getText().toString());

                    Navigation.findNavController(v).popBackStack();
                }
            }
        });

        return ARB.getRoot();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case GALLERY_REQUEST:
                    Uri selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                        ARB.addImageRem.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        Log.i("TAG", "Exception " + e);
                    }
                    break;
            }
    }

    @Override
    public void onActivityCreated(@NonNull Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ARVM = new ViewModelProvider(this).get(addReminderVM.class);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }





    @Override
    public void onDestroy(){
        super.onDestroy();
        ARVM = null;
        ARB = null;
    }
}
