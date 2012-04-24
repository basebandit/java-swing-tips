package example;
//-*- mode:java; encoding:utf8n; coding:utf-8 -*-
// vim:set fileencoding=utf-8:
//@homepage@
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.Position;

public class MainPanel extends JPanel{
    private static final JCheckBox check = new JCheckBox("<html>The alphanumeric keys are pressed:<br />&nbsp;&nbsp;&nbsp;&nbsp;Nothing to select");
    public MainPanel() {
        super(new BorderLayout(5, 5));

        add(new JScrollPane(makeList()));
        add(check, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setPreferredSize(new Dimension(320, 240));
    }
    @SuppressWarnings("unchecked")
    private static JList makeList() {
        DefaultListModel model = new DefaultListModel();
        model.addElement("aaaaaaaaaaaa");
        model.addElement("abbbbbbbbbbbbbbbbbb");
        model.addElement("accccccccccc");
        model.addElement("bbbbbb");
        model.addElement("cccbbb");
        model.addElement("dddddddddddd");
        model.addElement("eeeeeeeeeeeeeeeeeee");
        model.addElement("fffffffffffffffffffffff");

        JList list = new JList(model) {
            @Override public int getNextMatch(String prefix, int startIndex, Position.Bias bias) {
                return check.isSelected()?-1:super.getNextMatch(prefix, startIndex, bias);
            }
        };
        return list;
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("@title@");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
