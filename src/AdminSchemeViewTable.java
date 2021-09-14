
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import municiplesupport.AdminPersonDetailsTable;
import municiplesupport.SchemeAdminDetailsTable;

public class AdminSchemeViewTable extends JFrame{

    public AdminSchemeViewTable() {
        super("View Person");
        setLayout(new BorderLayout());
        setSize(700, 900);
        SchemeAdminDetailsTable model = new SchemeAdminDetailsTable();
        

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        table.getColumn("Person").setCellRenderer(buttonRenderer);
        table.getColumn("Remove").setCellRenderer(buttonRenderer);
        table.addMouseListener(new JTableButtonMouseListener(table));
        resizeColumnWidth(table);

        setVisible(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }


class JTableButtonMouseListener extends MouseAdapter {

    private final JTable table;

    public JTableButtonMouseListener(JTable table) {
        this.table = table;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Fired");
        int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
        int row = e.getY() / table.getRowHeight(); //get the row of the button

        /*Checking the row or column is valid or not*/
        if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
            Object value = table.getValueAt(row, column);
            if (value instanceof JButton) {
                /*perform a click event*/
                ((JButton) value).doClick();
            }
        }
    }
}

class JTableButtonRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JButton button = (JButton) value;
        return button;
    }
}
}
