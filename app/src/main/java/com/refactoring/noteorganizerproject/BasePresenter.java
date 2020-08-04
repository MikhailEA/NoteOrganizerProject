package com.refactoring.noteorganizerproject;

public interface BasePresenter {
    default void notifyDatasetChanged(int messageId) {};
    default void notifyItemChanged(int position) {}
}
