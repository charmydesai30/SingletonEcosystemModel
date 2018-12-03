/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ManagerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AccomodationAssisstantManagerWorkRequest;
import Business.WorkQueue.AccomodationWorkRequest;
import Business.WorkQueue.BookstoreAssisstantManagerWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.AssistantManagerRole.AssistantAccomodationManagerWorkAreaJPanel;

/**
 *
 * @author Ami Gandhi
 */
public class AccomodationManagerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ManagerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    /**
     * Creates new form ManagerWorkAreaJPanel
     */
    public AccomodationManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ManagerOrganization organization, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        valueLabel.setText(enterprise.getName());
        populateRequestTable();
    }
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        //BookstoreAssisstantManagerWorkRequest request1= new BookstoreAssisstantManagerWorkRequest();
        model.setRowCount(0);
        for (AccomodationWorkRequest request : organization.getWorkQueue().getAccomodationWorkRequestList()){
            Object[] row = new Object[10];
            row[0]=((AccomodationAssisstantManagerWorkRequest) request)==null?"waiting":((AccomodationAssisstantManagerWorkRequest) request);
            row[1] = request.getfName();
            row[2] = request.getlName();
            row[3] = request.getApptSize();
            row[4]=request.getNoOfBathrooms();
            row[5]=request.getRent();
            row[6]=request.getNoOfTenants();
            row[7] =request.getGroceries();
            row[8]=request.getMattress();
            row[9]=request.getStatus();
           
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestReportJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Result", "First Name", "Last Name", "Appt Size", "No Of Bathrooms", "Rent", "No of Tenants", "Groceries Included", "Mattress Included", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(4).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(5).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(6).setResizable(false);
        }

        requestReportJButton.setText("Pass Req. to Assistant");
        requestReportJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestReportJButtonActionPerformed(evt);
            }
        });

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setText("<value>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshTestJButton)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(requestReportJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(refreshTestJButton)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(requestReportJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestReportJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestReportJButtonActionPerformed
         
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        
        AccomodationAssisstantManagerWorkRequest request = (AccomodationAssisstantManagerWorkRequest)workRequestJTable.getValueAt(selectedRow,0);
      
        String currentState=request.getStatus();
        
        
        switch(currentState.toUpperCase())
        {
            case "PENDING":
                 request.setStatus("Processing");
                 CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                 userProcessContainer.add("SendToAccomodationAssistantQueueJPanel", new SendToAccomodationAssistantQueueJPanel(userProcessContainer, userAccount, enterprise));
                 layout.next(userProcessContainer);
                break;
            case "PROCESSING":
                JOptionPane.showMessageDialog(null, "Request is already in Processing state.");
                break;
            case "COMPLETED":
                JOptionPane.showMessageDialog(null, "Request is  already processed by you and completed by Assistant manager.");
                break;
            case "ADDED TO CART":
                JOptionPane.showMessageDialog(null, "Request is  already processed by you and completed by Assistant manager.");
                break;
            case "PURCHASED":
                JOptionPane.showMessageDialog(null, "Request is  already processed by you and completed by Assistant manager.");
                break;
                
        }
              
        
        
        populateRequestTable();
        
        
       
        
    }//GEN-LAST:event_requestReportJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();
        
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestReportJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
