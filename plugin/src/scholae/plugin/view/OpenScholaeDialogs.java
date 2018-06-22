package scholae.plugin.view;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.image.VolatileImage;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenScholaeDialogs extends JFrame {
    public JPanel Gotpanel;
    public JButton button1;
    public JSlider slider1;
    public JSlider slider2;
    public JCheckBox checkBox1;
    public JList list1;
    public String str_slider1;
    public String str_slider2;

    public OpenScholaeDialogs() {
        setContentPane(Gotpanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, str_slider1);
            }
        });

        /*slider1 = new JSlider( 1, 5, 5);
        slider1.setFont(new Font("Dialog", Font.BOLD, 10));
        slider1.setMajorTickSpacing(4);
        slider1.setMajorTickSpacing(2);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setSnapToTicks(true);*/
        // slider1.getValue();
        /*slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // String str = null;
                *//*System.out.println(slider1.getValue());
                if (event.getSource() == slider1) {
                    //Получаем установленное значение;
                    str = (new Integer(slider1.getValue())).toString();

                }*//*

                JSlider source = (JSlider)e.getSource();
                if(!source.getValueIsAdjusting())
                {
                    //textField.setText(String.valueOf(source.getValue()));
                    int gain = source.getValue();
                    System.out.println(gain);
                    //System.out.println("***** GAIN ***** "+gain);
                    // GetGain g = new GetGain(gain);
                } else {
                    System.out.println("wrf");
                }
            }
        });*/
        //getContentPane().add(slider1);
        /*
        Hashtable<Integer, Component> labelTable = new Hashtable<Integer, Component>();
        labelTable.put(1, new JLabel("A"));
        labelTable.put(5, new JLabel("B"));
        slider1.setLabelTable(labelTable);
        //addSlider(slider1, "Custom labels");*/

        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider source = (JSlider) changeEvent.getSource();
                str_slider1 = "" + source.getValue();
            }
        });


        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider source = (JSlider) changeEvent.getSource();
                str_slider2 = "" + source.getValue();
            }
        });
        pack();
        setVisible(true);
    }
}