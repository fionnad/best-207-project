package view.Utilities;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class CreateTheme {
    public static void setTheme() {
        try {
            // Set Nimbus Look and Feel
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
