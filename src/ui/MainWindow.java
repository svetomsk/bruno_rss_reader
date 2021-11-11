package ui;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
    public MainWindow() {
        setSize(new Dimension(600, 600));
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel leftPanel = new JPanel();
        String [] itemList = {"hello", "goo", "dsf"};
        JList list = new JList(itemList);
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    System.out.println(itemList[index]);
                }
            }
        });
        JScrollPane pane = new JScrollPane(list);
        pane.setPreferredSize(new Dimension(250, 500));
        leftPanel.add(pane);
        leftPanel.setPreferredSize(new Dimension(250, 550));
        JButton refreshNews = new JButton("Refresh");
        leftPanel.add(refreshNews);
        add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(250, 500));

        String [] channelsText = {"1", "2", "3"};
        JList channels = new JList(channelsText);
        JScrollPane pane1 = new JScrollPane(channels);
        pane1.setPreferredSize(new Dimension(250, 200));
        rightPanel.add(pane1);
        JButton addChannel = new JButton("+");
        JButton removeChannel = new JButton("-");
        rightPanel.add(addChannel);
        rightPanel.add(removeChannel);

        add(rightPanel);
    }

    public static void main(String[] args) {
        MainWindow win = new MainWindow();
        win.setVisible(true);
    }
}

