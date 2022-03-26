package com.example.a1l8.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1l8.databinding.ItemTextBinding;
import com.example.a1l8.models.TextModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FirstFragmentAdapter extends RecyclerView.Adapter<FirstFragmentAdapter.TextViewHolder> {
    private ArrayList<TextModel> textModels = new ArrayList<>();


    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextViewHolder(ItemTextBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        holder.onBind(textModels.get(position));
    }

    @Override
    public int getItemCount() {

        return textModels.size();
    }

    public void addItem(TextModel textModel){
        textModels.add(0, textModel);
        notifyDataSetChanged();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        private ItemTextBinding binding;

        public TextViewHolder(@NonNull ItemTextBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

        public void onBind(TextModel textModel) {
            binding.tvText.setText(textModel.getText());

        }
    }
}
