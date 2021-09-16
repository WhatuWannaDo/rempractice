package com.example.rempractice.project.View.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rempractice.Domain.reminders;
import com.example.rempractice.databinding.RemrecyclerBinding;

import java.util.List;

public class reminderAdapter extends RecyclerView.Adapter<reminderAdapter.reminderViewHolder> {
    private List<reminders> rems;

    public reminderAdapter(List<reminders> rems){
        this.rems = rems;
    }

    @NonNull
    @NotNull
    @Override
    public reminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RemrecyclerBinding binding = RemrecyclerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new reminderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull reminderViewHolder holder, int position) {
        holder.binding.textrow.setText(rems.get(position).getTextRem());
        holder.binding.daterow.setText(rems.get(position).getDateRem());
        holder.binding.isdone.setChecked(rems.get(position).isDone());

    }

    @Override
    public int getItemCount() {
        return rems.size();
    }

    public List<reminders> getReminder(){
        return rems;
    }

    class reminderViewHolder extends RecyclerView.ViewHolder{
        RemrecyclerBinding binding;

        public  reminderViewHolder(RemrecyclerBinding binding){
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
