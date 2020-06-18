package com.example.android.roomwordssample;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;
import android.widget.Button;




public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {


        private final TextView wordItemView;
        private final Button editButton;//Para implementar clickListener


        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
            editButton = itemView.findViewById(R.id.button_edit);
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords = Collections.emptyList();

    WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(
                R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Word current = mWords.get(position);
        holder.wordItemView.setText(current.getWord());
    }

    void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }
    public Word getWordAtPosition (int position) {
        return mWords.get(position);
    }
    public Word getWordAt(int position){
        return mWords.get(position);
    }
}


