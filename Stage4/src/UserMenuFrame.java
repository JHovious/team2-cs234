/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author iamth
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class UserMenuFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserMenuFrame
     */
    
    //Instance Variables

    private Staff staff;
    private HashMap<String, StaffDB> employees;
    private HashMap<Integer,InventoryDB> items;
    private HashMap<Integer,TicketDB> tickets;
    private Inventory item;
    private TicketsMenu ticket;
    private String userID;
    private boolean manager;
    
    public UserMenuFrame(){
        
        employees = null;
        staff = null;
        items = null;
        item = null;
        tickets = null;
        ticket = null;
        userID = null;
        manager = false;
        initComponents();
    }
    
    public UserMenuFrame(HashMap<String, StaffDB> employeesDB, 
            HashMap<Integer,InventoryDB>itemsDB, Staff staff1,HashMap<Integer,TicketDB> ticketsDB, String id, boolean managerCheck) {
        
        
       
        employees = employeesDB;
        staff = staff1;
        items = itemsDB;
        manager = managerCheck;
        item = new Inventory(employees, items, manager);
        tickets = ticketsDB;
        ticket = new TicketsMenu(tickets, manager);
        userID = id;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        UserMenuPanel = new javax.swing.JPanel();
        hardwareStoreLabel = new javax.swing.JLabel();
        ticketsMenuButton = new javax.swing.JButton();
        inventoryMenuButton = new javax.swing.JButton();
        customerMenuButton = new javax.swing.JButton();
        staffMenuButton = new javax.swing.JButton();
        purchaseMenuButton = new javax.swing.JButton();
        storeInfoButton = new javax.swing.JButton();
        managerMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        hardwareStoreLabel.setText("Hardware Store User Menu");

        ticketsMenuButton.setText("Tickets Menu");
        ticketsMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketsMenuButtonActionPerformed(evt);
            }
        });

        inventoryMenuButton.setText("Inventory Menu");
        inventoryMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryMenuButtonActionPerformed(evt);
            }
        });

        customerMenuButton.setText("Customer Menu");
        customerMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMenuButtonActionPerformed(evt);
            }
        });

        staffMenuButton.setText("Staff Menu");
        staffMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffMenuButtonActionPerformed(evt);
            }
        });

        purchaseMenuButton.setText("Purchase Menu");
        purchaseMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseMenuButtonActionPerformed(evt);
            }
        });

        storeInfoButton.setText("Store Info");
        storeInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeInfoButtonActionPerformed(evt);
            }
        });

        managerMenuButton.setText("Manager Menu");
        managerMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserMenuPanelLayout = new javax.swing.GroupLayout(UserMenuPanel);
        UserMenuPanel.setLayout(UserMenuPanelLayout);
        UserMenuPanelLayout.setHorizontalGroup(
            UserMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserMenuPanelLayout.createSequentialGroup()
                .addGroup(UserMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UserMenuPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(hardwareStoreLabel)
                        .addGap(0, 542, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UserMenuPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(UserMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserMenuPanelLayout.createSequentialGroup()
                                .addComponent(purchaseMenuButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(UserMenuPanelLayout.createSequentialGroup()
                                .addGroup(UserMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(staffMenuButton)
                                    .addComponent(ticketsMenuButton)
                                    .addComponent(inventoryMenuButton)
                                    .addComponent(customerMenuButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(UserMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(storeInfoButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(managerMenuButton, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(44, 44, 44))
        );
        UserMenuPanelLayout.setVerticalGroup(
            UserMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserMenuPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(hardwareStoreLabel)
                .addGap(30, 30, 30)
                .addComponent(ticketsMenuButton)
                .addGap(18, 18, 18)
                .addGroup(UserMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserMenuPanelLayout.createSequentialGroup()
                        .addComponent(inventoryMenuButton)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserMenuPanelLayout.createSequentialGroup()
                        .addComponent(managerMenuButton)
                        .addGap(10, 10, 10)))
                .addComponent(customerMenuButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storeInfoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffMenuButton)
                .addGap(2, 2, 2)
                .addComponent(purchaseMenuButton)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UserMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UserMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 865, 506);
    }// </editor-fold>                        

    private void ticketsMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        new TicketsMenu(tickets, manager).setVisible(true);
    }                                                 

    private void inventoryMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        new Inventory(employees, items, manager).setVisible(true);
    }                                                   

    private void customerMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        new CustomerFrame().setVisible(true);
    }                                                  

    private void staffMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        new StaffFrame(employees).setVisible(true);
    }                                               

    private void storeInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        new UpdateStoreHoursPanel().setVisible(true);
        
    }                                               

    private void purchaseMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        new PurchaseGUI(items).setVisible(true);
    }                                                  

    private void managerMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        if(manager){
            new ManagerMenu(employees).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }                                                 

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
            try{
                //Gets data from file
                BufferedReader reader = new BufferedReader(new FileReader("ticketdata.csv"));
                ArrayList<String> tableInfo = new ArrayList<>();
                String line;

                while ((line = reader.readLine()) != null){
                    tableInfo.add(line);
                }
                reader.close();
                //Put data in table
                for(String rowInfo : tableInfo){
                    String[] row = rowInfo.split(",");

                    TicketDB ticket = new TicketDB(Integer.valueOf(row[0]), row[1], row[2], row[3], row[4]);
                    tickets.put(Integer.valueOf(row[0]), ticket);
            }
            
            }catch(Exception e){
            System.out.println("Error");
            }
            try{
            //Gets data from file
            BufferedReader reader = new BufferedReader(new FileReader("employeedata.csv"));
            ArrayList<String> tableInfo = new ArrayList<>();
            String line;
            
            while ((line = reader.readLine()) != null){
                tableInfo.add(line);
            }
            reader.close();
            
            for(String rowInfo : tableInfo){
                String[] row = rowInfo.split(",");

                StaffDB staff = new StaffDB(row[0], row[1], row[2], row[3], row[4], row[5], 
                        Integer.valueOf(row[6]), Integer.valueOf(row[7]), Integer.valueOf(row[8]));
                employees.put(row[0], staff);

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Staff info not read correctly");
        }
            
        try{
            //Gets data from file
            BufferedReader reader = new BufferedReader(new FileReader("inventorydata.csv"));
            ArrayList<String> tableInfo = new ArrayList<>();
            String line;
            
            while ((line = reader.readLine()) != null){
                tableInfo.add(line);
            }
            reader.close();
            
            //Put data in table
            
            for(String rowInfo : tableInfo){
                String[] row = rowInfo.split(",");

                InventoryDB item = new InventoryDB(Integer.valueOf(row[4]), row[0], row[5], row[1], Integer.valueOf(row[2]), row[3]);
                items.put(Integer.valueOf(row[4]), item);
            }
        }catch(Exception e){
            System.out.println("Error");
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
            java.util.logging.Logger.getLogger(UserMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel UserMenuPanel;
    private javax.swing.JButton customerMenuButton;
    private javax.swing.JLabel hardwareStoreLabel;
    private javax.swing.JButton inventoryMenuButton;
    private javax.swing.JButton managerMenuButton;
    private javax.swing.JButton purchaseMenuButton;
    private javax.swing.JButton staffMenuButton;
    private javax.swing.JButton storeInfoButton;
    private javax.swing.JButton ticketsMenuButton;
    // End of variables declaration                   
}