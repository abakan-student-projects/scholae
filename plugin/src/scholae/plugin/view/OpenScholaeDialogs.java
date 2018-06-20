package scholae.plugin.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenScholaeDialogs extends JFrame {
    public JPanel Gotpanel;
    private JButton button1;
    private JSlider slider1;
    private JSlider slider2;
    private JCheckBox checkBox1;
    private JList list1;

    public OpenScholaeDialogs() {
        setContentPane(Gotpanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Hello");

            }
        });
    }
}
