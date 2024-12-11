import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Justin Hovious
 */
public class CustomerFrame extends javax.swing.JFrame {
        // Private variables and list creation.
    private int option;
    private boolean choice;
    private String name;
    private String phoneNumber;
    private int rewardNumber;
    private short rewardPoint;
    private static LinkedList<Customer> customerDataBase = new LinkedList<>();
    private Customer Customer;

    /**
     * Creates new form NewJFrame
     */
    public CustomerFrame() {
        this.name = name;
        this.option = 9;
        this.choice = true;
        this.phoneNumber = phoneNumber;
        this.rewardNumber = rewardNumber;
        this.rewardPoint = rewardPoint;
        customerDataBase.add(this.Customer); 
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

        viewAllBtn = new javax.swing.JButton();
        findCustomerBtn = new javax.swing.JButton();
        createNewBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewAllBtn.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        viewAllBtn.setText("View All Customers");
        viewAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBtnActionPerformed(evt);
            }
        });
        getContentPane().add(viewAllBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 200, 50));

        findCustomerBtn.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        findCustomerBtn.setText("Find a Customer");
        findCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findCustomerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(findCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 200, 50));

        createNewBtn.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        createNewBtn.setText("Create New Customer");
        createNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewBtnActionPerformed(evt);
            }
        });
        getContentPane().add(createNewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 200, 50));

        updateBtn.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        updateBtn.setText("Update Existing Customer");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 200, 50));

        deleteBtn.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        deleteBtn.setText("Delete Customer");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 200, 50));

        returnBtn.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        returnBtn.setText("Return");
        returnBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });
        getContentPane().add(returnBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 100, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 380, 40));

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        jLabel1.setText("                                 Customer Menu");
        jLabel1.setAlignmentY(0.0F);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 710, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        Customer.viewCustomers();
        ViewAllCustomersFrame viewAllCustomersFrame = new ViewAllCustomersFrame();
        
        viewAllCustomersFrame.setVisible(true);
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void createNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewBtnActionPerformed
        Customer.createCustomer(name, phoneNumber, rewardNumber, rewardPoint);
        CreateCustomerFrame createCustomerFrame = new CreateCustomerFrame();
        
        createCustomerFrame.setVisible(true);
    }//GEN-LAST:event_createNewBtnActionPerformed

    private void findCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findCustomerBtnActionPerformed
        Customer.viewCustomer(rewardNumber);
        FindCustomersFrame findCustomersFrame = new FindCustomersFrame();
        
        findCustomersFrame.setVisible(true);
    }//GEN-LAST:event_findCustomerBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        Customer.updateCustomer(rewardNumber, name, phoneNumber, rewardPoint);
        UpdateCustomerFrame updateCustomerFrame = new UpdateCustomerFrame();
        
        updateCustomerFrame.setVisible(true);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        Customer.deleteCustomer(rewardNumber);
        DeleteCustomerFrame deleteCustomerFrame = new DeleteCustomerFrame();
        
        deleteCustomerFrame.setVisible(true);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        dispose();
    }//GEN-LAST:event_returnBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CustomerFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton findCustomerBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton viewAllBtn;
    // End of variables declaration//GEN-END:variables
}
