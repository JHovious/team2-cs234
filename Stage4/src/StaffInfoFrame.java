import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Justin Hovious
 */
public class StaffInfoFrame extends javax.swing.JFrame {
    private HashMap<String, StaffDB> employees;
    private DefaultTableModel tableModel;

    /**
     * Creates new form StaffInfoFrame
     */
    public StaffInfoFrame() {
        initComponents();
        this.employees = new HashMap<>();
        loadEmployeesFromCSV("employeedata.csv");
        populateTable();
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) staffTable.getModel();
        
        model.setRowCount(0);
        
        for(StaffDB staff : employees.values()) {
            Object[] rowData = {
                staff.getName(),
                staff.getEmployeeId(),
                staff.getHireDate(),
                staff.getTitle(),
                staff.getEmail(),
                staff.getPhone(),
                staff.getPTO(),
                staff.getsickTime(),
                staff.getUnpaid()
            };
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Staff Info");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "EID", "Hire Date", "Title", "Email", "Phone", "PTO", "Sick Time", "Unpaid Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(staffTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Employee Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(nameField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(372, 372, 372))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton)
                        .addGap(111, 111, 111))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
     String searchName = nameField.getText().trim();
    DefaultTableModel model = (DefaultTableModel) staffTable.getModel();
    model.setRowCount(0); // Clear current table
    
    boolean found = false;
    for (StaffDB staff : employees.values()) {
        if (staff.getName().toLowerCase().contains(searchName.toLowerCase())) {
            Object[] rowData = {
                staff.getName(),
                staff.getEmployeeId(),
                staff.getHireDate(),
                staff.getTitle(),
                staff.getEmail(),
                staff.getPhone(),
                staff.getPTO(),
                staff.getsickTime(),
                staff.getUnpaid()
            };
            model.addRow(rowData);
            found = true;
        }
    }
    
    if (!found) {
        JOptionPane.showMessageDialog(this, 
            "No employees found matching: " + searchName, 
            "Search Results", 
            JOptionPane.INFORMATION_MESSAGE);
        populateTable(); // Restore full table if no results
    }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        populateTable();
    }//GEN-LAST:event_formWindowOpened

    private void displayStaffInfo(StaffDB staff) {
        tableModel.setRowCount(0);
        Object[] rowData = {
            staff.getName(),
            staff.getEmployeeId(),
            staff.getHireDate(),
            staff.getTitle(),
            staff.getEmail(),
            staff.getPhone(),
            staff.getPTO(),
            staff.getsickTime(),
            staff.getUnpaid()
                
        };
        tableModel.addRow(rowData);
    }
    
    private void loadEmployeesFromCSV(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        // Skip header if it exists
        String line = br.readLine(); // Read and discard header
        
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            // Add some basic validation
            if (values.length >= 9) {
                try {
                    String name = values[0];
                    String employeeId = values[1];
                    String hireDate = values[2];
                    String title = values[3];
                    String email = values[4];
                    String phone = values[5];
                    int pto = Integer.parseInt(values[6]);
                    int unpaidTime = Integer.parseInt(values[8]);
                    int sickTime = values.length > 7 ? Integer.parseInt(values[7]) : 0;
                    
                    StaffDB staff = new StaffDB(name, employeeId, hireDate, title, email, phone, pto, sickTime, unpaidTime);
                    employees.put(name, staff);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing numeric values in CSV: " + line);
                }
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, 
            "Error reading CSV file: " + e.getMessage(), 
            "File Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffInfoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable staffTable;
    // End of variables declaration//GEN-END:variables
}
