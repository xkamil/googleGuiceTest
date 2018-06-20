package com.view;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public interface OnTextChangedListener extends DocumentListener {
    void textChanged();

    @Override
    default void insertUpdate(DocumentEvent e) {
        textChanged();
    }

    @Override
    default void removeUpdate(DocumentEvent e) {
        textChanged();
    }

    @Override
    default void changedUpdate(DocumentEvent e) {
        textChanged();
    }
}
