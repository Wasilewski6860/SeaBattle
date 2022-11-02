import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AspectRatio {
    public static void main(String[] args) {
        final JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.YELLOW);

        final JPanel container = new JPanel(new GridBagLayout());
        container.add(innerPanel);
        container.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizePreview(innerPanel, container);
            }
        });
        final JFrame frame = new JFrame("AspectRatio");
        frame.getContentPane().add(container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private static void resizePreview(JPanel innerPanel, JPanel container) {
        int w = container.getWidth();
        int h = container.getHeight();
        int size =  Math.min(w, h);
        innerPanel.setPreferredSize(new Dimension(size, size));
        container.revalidate();
    }
}
