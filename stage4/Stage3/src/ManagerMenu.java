
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author iamth
 */
public class ManagerMenu extends javax.swing.JFrame {
    HashMap<String, StaffDB> employees;
    
    /**
     * Creates new form ManagerMenu
     */
    public ManagerMenu() {
        
    }
    
    public ManagerMenu(HashMap<String, StaffDB> employeesDB){
        employees = employeesDB;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlManager = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPTO = new javax.swing.JTextField();
        txtSick = new javax.swing.JTextField();
        txtUnpaid = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Title", "ID"
            }
        ));
        tblStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStaff);

        jLabel1.setText("Manager Menu");

        jLabel2.setText("Name:");

        jLabel3.setText("ID:");

        jLabel4.setText("Hire Date:");

        jLabel5.setText("Title:");

        jLabel6.setText("Phone:");

        jLabel7.setText("Email:");

        jLabel8.setText("PTO:");

        jLabel9.setText("Unpaid:");

        jLabel10.setText("Sick Time:");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlManagerLayout = new javax.swing.GroupLayout(pnlManager);
        pnlManager.setLayout(pnlManagerLayout);
        pnlManagerLayout.setHorizontalGroup(
            pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManagerLayout.createSequentialGroup()
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(pnlManagerLayout.createSequentialGroup()
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManagerLayout.createSequentialGroup()
                                .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(pnlManagerLayout.createSequentialGroup()
                                .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlManagerLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel6)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlManagerLayout.createSequentialGroup()
                                        .addComponent(txtUnpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtEmail))))
                        .addGap(19, 19, 19))
                    .addGroup(pnlManagerLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(110, 110, 110))
                    .addGroup(pnlManagerLayout.createSequentialGroup()
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlManagerLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8))
                            .addComponent(txtPTO, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSick, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManagerLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(10, 10, 10)))
                        .addGap(9, 9, 9))
                    .addGroup(pnlManagerLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManagerLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnClear)
                .addGap(59, 59, 59)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addGap(30, 30, 30)
                .addComponent(btnDelete)
                .addGap(33, 33, 33))
        );
        pnlManagerLayout.setVerticalGroup(
            pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlManagerLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlManagerLayout.createSequentialGroup()
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(5, 5, 5)
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnpaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(pnlManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnUpdate))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffMouseClicked
        int row = tblStaff.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel)tblStaff.getModel();
        String key = model.getValueAt(row, 0).toString();
        
        txtName.setText(key);
        txtID.setText(employees.get(key).getEmployeeId());
        txtDate.setText(employees.get(key).getHireDate());
        txtTitle.setText(employees.get(key).getTitle());
        txtPhone.setText(employees.get(key).getPhone());
        txtEmail.setText(employees.get(key).getEmail());
        txtPTO.setText(String.valueOf(employees.get(key).getPTO()));
        txtUnpaid.setText(String.valueOf(employees.get(key).getUnpaid()));
        txtSick.setText(String.valueOf(employees.get(key).getsickTime()));
    }//GEN-LAST:event_tblStaffMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            //Gets data from file
            BufferedReader reader = new BufferedReader(new FileReader("employeedata.csv"));
            ArrayList<String> tableInfo = new ArrayList<>();
            String line;
            
            while ((line = reader.readLine()) != null){
                tableInfo.add(line);
            }
            reader.close();
            
            //Put data in table
            DefaultTableModel model = (DefaultTableModel)tblStaff.getModel();
            for(String rowInfo : tableInfo){
                String[] row = rowInfo.split(",");

                StaffDB staff = new StaffDB(row[0], row[1], row[2], row[3], row[4], row[5], 
                        Integer.valueOf(row[6]), Integer.valueOf(row[7]), Integer.valueOf(row[8]));
                employees.put(row[0], staff);
                String[] newRow = new String[] {row[0], row[3], row[1]};
                model.addRow(newRow);
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }//GEN-LAST:event_formWindowOpened

    private void clearFields(){
        txtName.setText("");
        txtID.setText("");
        txtDate.setText("");
        txtTitle.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtPTO.setText("");
        txtUnpaid.setText("");
        txtSick.setText("");
    }
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tblStaff.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(this, "Choose an employee");
        }else{
            DefaultTableModel model = (DefaultTableModel)tblStaff.getModel();
            
            String key = model.getValueAt(row, 0).toString();
            String name = txtName.getText();
            String ID = txtID.getText();
            String date = txtDate.getText();
            String title = txtTitle.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            String pto = txtPTO.getText();
            String unpaid = txtUnpaid.getText();
            String sick = txtSick.getText();
            
            employees.get(key).setName(name);
            employees.get(key).setEmployeeID(ID);
            employees.get(key).setHireDate(date);
            employees.get(name).setEmployeeTitle(title);
            employees.get(key).setEmployeePhone(phone);
            employees.get(key).setEmployeeEmail(email);
            employees.get(key).setPto(Integer.valueOf(pto));
            employees.get(key).setUnpaidTime(Integer.valueOf(unpaid));
            employees.get(key).setSickTime(Integer.valueOf(sick));
            
            employees.put(name, employees.remove(key));
            
            updateTableInfo(model,name, title, ID, row);
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        //Checks if fields have information
        if(txtName.getText().isEmpty() || txtID.getText().isEmpty() || txtDate.getText().isEmpty()
                || txtTitle.getText().isEmpty() || txtPhone.getText().isEmpty() 
                || txtEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter information");
        }else{
            DefaultTableModel model = (DefaultTableModel)tblStaff.getModel();

            String name = txtName.getText();
            String ID = txtID.getText();
            String date = txtDate.getText();
            String title = txtTitle.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            int pto = Integer.valueOf(txtPTO.getText());
            int unpaid = Integer.valueOf(txtUnpaid.getText());
            int sick = Integer.valueOf(txtSick.getText());

            StaffDB newStaff = new StaffDB(name, ID, date, title, email, phone, pto, sick, unpaid);

            employees.put(name, newStaff);

            String[] newRow = new String[]{name, title, ID};
            model.addRow(newRow);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblStaff.getSelectedRow();
        if (row < 0){
            JOptionPane.showMessageDialog(this, "Choose a row");
            
        }else{
            DefaultTableModel model = (DefaultTableModel)tblStaff.getModel();
            String key = model.getValueAt(row, 0).toString();
            employees.remove(key);
            model.removeRow(row);
            clearFields();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ArrayList<String> tableInfo = new ArrayList<>();
        for(String key : employees.keySet()){
            if(!"default".equals(key)){
                String name = employees.get(key).getName();
                String ID = employees.get(key).getEmployeeId();
                String date = employees.get(key).getHireDate();
                String title = employees.get(key).getTitle();
                String phone = employees.get(key).getPhone();
                String email = employees.get(key).getEmail();
                String pto = String.valueOf(employees.get(key).getPTO());
                String unpaid = String.valueOf(employees.get(key).getUnpaid());
                String sick =String.valueOf(employees.get(key).getsickTime());
                String row = name + "," + ID + "," + date + "," + title + "," 
                        + email + "," + phone + "," + pto + "," + sick + "," + unpaid;
                tableInfo.add(row);
            }
            
        }
        
        try{
            PrintWriter writer = new PrintWriter(new FileWriter("employeedata.csv"));
            for(String rowData : tableInfo){
                writer.println(rowData);
            }
            writer.close();
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Data not stored");
        }
    }//GEN-LAST:event_formWindowClosing


    private void updateTableInfo(DefaultTableModel aModel, String aName, String aTitle, String aID, int aRow){
        DefaultTableModel model = aModel;
        model.setValueAt(aName, aRow, 0);
        model.setValueAt(aTitle, aRow, 1);
        model.setValueAt(aID, aRow, 2);
        
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlManager;
    private javax.swing.JTable tblStaff;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPTO;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSick;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtUnpaid;
    // End of variables declaration//GEN-END:variables
}