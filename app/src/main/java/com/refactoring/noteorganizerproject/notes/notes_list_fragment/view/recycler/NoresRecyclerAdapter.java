package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view.recycler;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.refactoring.noteorganizerproject.R;
import com.refactoring.noteorganizerproject.notes.model.Note;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter.INotesPresenter;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.NotesViewHolder> {
    private INotesPresenter presenter;

    public NotesRecyclerAdapter(INotesPresenter presenter) {this.presenter = presenter};

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NotesViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        presenter.bindView(holder);

    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {return position};


    public class NotesViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
        private View itemView;
        private INotesPresenter presenter;

        private String CLASS_TAG = "MyViewHolder";

        private TextView title;
        private TextView sublitle;
        private TextView date;

        public NotesViewHolder(View view, INotesPresenter presenter) {
            super(view);
            this.itemView = view;
            this.presenter = presenter;

            init();

        }

        private void init() {
            initItemViewFields();
            initItemViewClickListener();
        }

        private void initItemViewClickListener() {
            itemView.setOnClickListener( v -> presenter.clicked(getPos()) );
            itemView.setOnClickListener( v -> {
                presenter.longClicked(getPos(), itemView);
                return true;
            });
        }

        private void initItemViewFields() {
            title = itemView.findViewById(R.id.note_item_title);
            sublitle = itemView.findViewById(R.id.note_item_subtitle);
            date = itemView.findViewById(R.id.note_item_data);
        }


        @Override
        public void setNote(Note note) {
            if (note.title.equals(""))
                title.setVisibility(View.GONE);
            else {
                title.setVisibility(View.VISIBLE);
                title.setText(note.title);
            }
            sublitle.setText(note.body);
            date.setText(DateUtils.dateToString(note.dataTime).split("")[0]);

        }

        @Override
        public int getPos() {
            return getLayoutPosition();
        }
    }
}


