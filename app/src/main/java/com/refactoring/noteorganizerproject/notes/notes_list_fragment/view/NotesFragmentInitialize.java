package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.refactoring.noteorganizerproject.R;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter.INotesPresenter;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter.NotesPresenter;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.view.recycler.NotesRecyclerAdapter;
import com.refactoring.noteorganizerproject.utils.ScreenUtil;


public class NotesFragmentInitialize extends Fragment {
    View root;
    RecyclerView recyclerView;
    private FloatingActionButton writeNewNote;
    MaterialButton sortNotes;
    TextInputEditText searchNoteTv;

    INotesPresenter presenter;

    LinearLayoutCompat sortLayout;
    ConstraintLayout extraOptionsLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_notes, container, false);

        initUI();
        initRecyclerView();

        return root;
    }

    private void initUI() {
        initWriteNoteFab();
        initSortLayoutAndGroup();
        initSearchNoteLayout();
        initExtraOptionsLayout();
    }

    private void initWriteNoteFab() {
        writeNewNote = root.findViewById(R.id.notes_write_fab);
        writeNewNote.setOnClickListener(v -> presenter.createNewNotes());
    }

    private void initSortLayoutAndGroup() {
        sortLayout = root.findViewById(R.id.sort_layout);
        sortNotes = root.findViewById(R.id.sort_notes_button);
        sortNotes.setOnClickListener(v -> interactWithSortLayout());
        ChipGroup sortGroup = root.findViewById(R.id.sort_group);
        sortGroup.setOnCheckedChangeListener(presenter.getOnCheckedChangeListener());
    }

    private void initSearchNoteLayout() {
        MaterialButton clearSearch = root.findViewById(R.id.clear_search);
        clearSearch.setOnClickListener(v -> presenter.clearSearch());
        clearSearch.setVisibility(View.GONE);

        searchNoteTv = root.findViewById(R.id.search_text_view);
        searchNoteTv.addTextChangedListener(presenter.getTextChangeListener(clearSearch));
    }

    private void initExtraOptionsLayout() {
        extraOptionsLayout = root.findViewById(R.id.extra_options_group);
        ImageButton closeBtn = root.findViewById(R.id.close_button);
        closeBtn.setOnClickListener(v -> presenter.disableMultiSelection());

        ImageButton deleteBtn = root.findViewById(R.id.delete_button);
        deleteBtn.setOnClickListener(v -> showConfirmation());

    }

    private void interactWithSortLayout() {
        if (sortNotes.isChecked())
            presenter.enableSort();
        else
            presenter.disableSort();
    }

    private void setDescriptions(View... views) {
        for (View view : views) {
            view.setOnLongClickListener(v -> {
                showHint(v.getContentDescription().toString());
                return true;
            });
        }
    }

    private void showHint(String hintText) {
        Toast.makeText(getContext(), hintText, Toast.LENGTH_SHORT).show();
    }

    private void initRecyclerView() {
        recyclerView = root.findViewById(R.id.notes_rv);
        int spanCount = ScreenUtil.getDisplayColumns(getActivity());
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new NotesRecyclerAdapter(presenter));
        recyclerView.addOnScrollListener(presenter.getRecyclerScrollListener(writeNewNote));

        presenter.getNotes();

    }

    private void initPresenter(NotesFragment fragment) {
        presenter = new NotesPresenter(fragment);
    }

    private void showConfirmation() {
        AlertDialog.Builder db = new AlertDialog.Builder(getContext());
        db.setTitle("Sure to delete item?");
        db.setPositiveButton(R.string.positive, (dialog, which) -> presenter.deleteNotes());
        db.setNegativeButton(R.string.negative, (dialog, which) -> dialog.dismiss());
        db.show();
    }
}
