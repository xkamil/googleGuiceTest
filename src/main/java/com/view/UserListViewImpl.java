package com.view;

import com.controller.ControllerProvider;
import com.google.inject.Inject;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;


public class UserListViewImpl extends JFrame implements UserListView {
    private JTextArea textArea;
    private ControllerProvider controllerProvider;

    @Inject
    public UserListViewImpl(ControllerProvider controllerProvider) {
        this.controllerProvider = controllerProvider;
    }


    public void displayUsers(List<String> users) {
        StringBuilder sb = new StringBuilder();

        users.forEach(u -> sb.append(u).append("\n"));
        textArea.setText(sb.toString());
    }

    @Override
    public void initView() {
        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel bottomPane = new JPanel(new BorderLayout());

        System.out.println(controllerProvider.getMainController());

        JTextField filterField = new JTextField();

        OnTextChangedListener listener = () -> {
            controllerProvider.getMainController().setFilter(filterField.getText());
            controllerProvider.getMainController().updateUserList();
        };
        filterField.getDocument().addDocumentListener(listener);

        JButton button1 = new JButton("Fetch users");
        button1.addActionListener(e -> controllerProvider.getMainController().fetchUsers());

        textArea = new JTextArea();

        bottomPane.add(button1, BorderLayout.CENTER);
        contentPane.add(bottomPane, BorderLayout.SOUTH);

        contentPane.add(filterField, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);

        setContentPane(contentPane);
        setPreferredSize(new Dimension(400, 400));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

}
