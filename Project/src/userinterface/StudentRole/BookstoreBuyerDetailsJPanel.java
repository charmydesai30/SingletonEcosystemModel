/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StudentRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.StudentOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BookstoreAssisstantManagerWorkRequest;
import Business.WorkQueue.BookstoreWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.AssistantManagerRole.AssistantAccomodationManagerWorkAreaJPanel;

/**
 *
 * @author Ami Gandhi
 */
public class BookstoreBuyerDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookstoreBuyerDetailsJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount userAccount;
    Organization studentOrganization;
    EcoSystem system;
    public BookstoreBuyerDetailsJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount userAccount,Organization organization,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.userAccount=userAccount;
        this.studentOrganization=(StudentOrganization)organization;
        this.system=system;
        userNameTxt.setText("Hello  "+userAccount.getUsername() +"!!");
        populateData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buyButton = new javax.swing.JButton();
        buyRelatedItemsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        buyButton.setText("BUY");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        buyRelatedItemsButton.setText("BUY BOOKS");
        buyRelatedItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyRelatedItemsButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Your Order Summary:");

        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Book Name", "Book Price", "Book Author", "Book Type", "#Books", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestJTable);

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("BOOK BUYING WORK AREA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnBack)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(buyRelatedItemsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(337, 337, 337))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyRelatedItemsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void populateData(){
       
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        
        for(UserAccount userAccount1: studentOrganization.getUserAccountDirectory().getUserAccountList())
        {
        for (BookstoreWorkRequest request : userAccount1.getWorkQueue().getBookstoreWorkRequestList()){
             if(! request.getStatus().equalsIgnoreCase("Purchased"))
             {
                Object[] row = new Object[7];
                row[0] = request.getBookName();
                row[1] = request.getBookPrice();
                row[2] = request.getBookAuthor();
                row[3] = request.getBooktype();
                row[4] = request.getNoOfBooks();
                row[5] = request.getStatus();
                row[6] = request;
            
                model.addRow(row);
            }
        }
        
        }
   }
    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!");
        }
        
        BookstoreAssisstantManagerWorkRequest request = (BookstoreAssisstantManagerWorkRequest)workRequestJTable.getValueAt(selectedRow,6);
        if(! request.getStatus().equalsIgnoreCase("Purchased"))
        {
             for(UserAccount userAccount1: studentOrganization.getUserAccountDirectory().getUserAccountList())
                {
                    for (BookstoreWorkRequest request1 : userAccount1.getWorkQueue().getBookstoreWorkRequestList())
                         request1.setStatus("Purchased");
                 }
        
        request.setBuyerName(userAccount.getUsername());
        JOptionPane.showMessageDialog(null, "You purchased this book successfully!!");
        populateData();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "The book is not available!!");
        }

    }//GEN-LAST:event_buyButtonActionPerformed

    private void buyRelatedItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyRelatedItemsButtonActionPerformed
        BookstoreHouseholdJPanel ent = new BookstoreHouseholdJPanel(userProcessContainer,enterprise,userAccount,studentOrganization,system);
        userProcessContainer.add("ent", ent);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_buyRelatedItemsButtonActionPerformed

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTxtActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        //userProcessContainer.remove(this);
        //CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        //layout.previous(userProcessContainer);
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        BuyBooksJPanel bbjp = (BuyBooksJPanel) component;
        bbjp.populateData();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton buyButton;
    private javax.swing.JButton buyRelatedItemsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField userNameTxt;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}