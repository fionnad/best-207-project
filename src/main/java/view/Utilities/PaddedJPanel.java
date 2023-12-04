package view.Utilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PaddedJPanel {
    public static JPanel createPaddedPanel(JPanel panel, int horizontalPadding, int verticalPadding) {
        panel.setBorder(new EmptyBorder(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));
        return panel;
    }
}