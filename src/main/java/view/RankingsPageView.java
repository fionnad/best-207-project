package view;

import interface_adapter.RefreshButton.RefreshController;
import interface_adapter.RefreshButton.RefreshState;
import interface_adapter.RefreshButton.RefreshViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RankingsPageView extends JPanel implements ActionListener, PropertyChangeListener {
    private final RefreshViewModel refreshViewModel;
    private final RefreshController refreshController;
    private final JButton refresh;

    public RankingsPageView(RefreshViewModel refreshViewModel, RefreshController refreshController) {

        this.refreshViewModel = refreshViewModel;
        this.refreshController = refreshController;

        refreshViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(RefreshViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        refresh = new JButton(RefreshViewModel.REFRESH_BUTTON_LABEL);
        buttons.add(refresh);

        refresh.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(refresh)) {
                            RefreshState currentState = refreshViewModel.getState();
                            refreshController.execute();
                            JOptionPane.showMessageDialog(null, currentState.getRefreshSuccess());
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}