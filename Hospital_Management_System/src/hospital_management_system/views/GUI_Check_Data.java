package hospital_management_system.views;

import hospital_management_system.MysqlConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GUI_Check_Data extends javax.swing.JFrame {

    private JButton saveButton;
    private JButton deleteButton;
    private String tableName;
    private Map<Integer, Object[]> originalData = new HashMap<>();
    private DefaultTableModel tableModel;

    public GUI_Check_Data(String tableName) {
        this.tableName = tableName;
        initComponents();
        loadTableData(tableName);  // 加载数据到表格
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        data_table = new javax.swing.JTable();
        saveButton = new JButton("Save Changes");
        deleteButton = new JButton("Delete");

        // 设置初始窗口大小，例如宽度为800，高度为600
        setSize(800, 600);

        // 将窗口居中显示
        setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(this.tableName + " Table"));
        jPanel1.setLayout(new BorderLayout());

        data_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[]{
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        // 将JTable和窗口大小同步调整
        jScrollPane1.setViewportView(data_table);
        jScrollPane1.setPreferredSize(new Dimension(getWidth(), getHeight() - 100));

        jPanel1.add(jScrollPane1, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);

        jPanel1.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        // 添加窗口大小调整监听器
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                resizeTable();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveChanges();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRow();
            }
        });
    }

    private void resizeTable() {
        jScrollPane1.setPreferredSize(new Dimension(getWidth(), getHeight() - 100));
        jScrollPane1.revalidate();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Check_Data("Admin").setVisible(true);
            }
        });
    }

    private void loadTableData(String tableName) {
        MysqlConnect db = new MysqlConnect();
        String[] columnNames = db.getTableColumns(tableName);
        if (columnNames == null) {
            System.err.println("Failed to fetch column names!");
            return;
        }

        ResultSet rs = db.executeQuery("SELECT * FROM " + tableName);

        this.tableModel = new DefaultTableModel(columnNames, 0);
        originalData.clear(); // 清除之前的数据
        try {
            int rowIndex = 0;
            while (rs.next()) {
                Object[] rowData = new Object[columnNames.length];
                for (int i = 0; i < columnNames.length; i++) {
                    rowData[i] = rs.getObject(columnNames[i]);
                }
                originalData.put(rowIndex, rowData);
                tableModel.addRow(rowData);
                rowIndex++;
            }
        } catch (SQLException e) {
            System.err.println("Failed to fetch data from result set!");
            e.printStackTrace();
        }

        setupTable(data_table, tableModel, jScrollPane1);
    }

    private void setupTable(JTable table, DefaultTableModel model, JScrollPane scrollPane) {
        table.setModel(model);
        table.setIntercellSpacing(new Dimension(1, 1));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setCellSelectionEnabled(false);
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        // 自动调整列宽以适应内容
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                // 这里设置一个最大宽度，以防止列太宽
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }

        // 确保表头可见
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value != null) {
                setToolTipText(value.toString());
            }
            return c;
        }
    }

    private void saveChanges() throws SQLException {
        MysqlConnect db = new MysqlConnect();
    
        String primaryKeyColumn = getPrimaryKeyColumn();
        if (primaryKeyColumn == null) {
            JOptionPane.showMessageDialog(this, "Unable to determine primary key column.");
            return;
        }
    
        boolean hasChanges = false;
        StringBuilder errorMessages = new StringBuilder();
    
        for (int row = 0; row < this.tableModel.getRowCount(); row++) {
            StringBuilder updateQuery = new StringBuilder("UPDATE " + tableName + " SET ");
            boolean modified = false;
    
            Object[] originalRowData = originalData.get(row);
            for (int col = 0; col < this.tableModel.getColumnCount(); col++) {
                Object originalValue = originalRowData[col];
                Object currentValue = data_table.getValueAt(row, col);
                if ((originalValue != null && !originalValue.equals(currentValue)) || (originalValue == null && currentValue != null)) {
                    updateQuery.append(this.tableModel.getColumnName(col)).append(" = '").append(currentValue).append("', ");
                    modified = true;
                }
            }
    
            if (modified) {
                updateQuery.delete(updateQuery.length() - 2, updateQuery.length());
                updateQuery.append(" WHERE ").append(primaryKeyColumn).append(" = '")
                           .append(this.tableModel.getValueAt(row, getColumnIndex(primaryKeyColumn))).append("'");
    
                db.executeUpdate(updateQuery.toString());
                hasChanges = true;
            }
        }
    
        if (errorMessages.length() > 0) {
            JOptionPane.showMessageDialog(this, "There were errors during the save:\n" + errorMessages.toString(), "Save Errors", JOptionPane.ERROR_MESSAGE);
        } else if (hasChanges) {
            JOptionPane.showMessageDialog(this, "All changes saved successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "No changes detected.");
        }
    }
    
    
    private void deleteSelectedRow() {
        int selectedRow = data_table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this row?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        DefaultTableModel model = (DefaultTableModel) data_table.getModel();
        String id = model.getValueAt(selectedRow, getColumnIndex(getPrimaryKeyColumn())).toString();

        MysqlConnect db = new MysqlConnect();
        // 使用主键列名来构建删除条件
        String condition = getPrimaryKeyColumn() + " = '" + id + "'";
        boolean deleteSuccess = db.deleteData(this.tableName, condition);

        if (deleteSuccess) {
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Row deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete row.");
        }
    }

    private String getPrimaryKeyColumn() {
        MysqlConnect db = new MysqlConnect();
        return db.getPrimaryKeyColumn(this.tableName);
    }

    private int getColumnIndex(String columnName) {
        for (int i = 0; i < this.tableModel.getColumnCount(); i++) {
            if (this.tableModel.getColumnName(i).equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        return -1;
    }

    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable data_table;
}
