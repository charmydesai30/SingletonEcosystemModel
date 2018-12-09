/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DemandAndSupplyManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.StudentOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HouseholdWorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Jaynee
 */
public class HouseholdAnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HouseholdAnalysisJPanel
     */
    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private EcoSystem system;
    /**
     * Creates new form AnalysisDemandAndSupplyJPanel
     */
    public HouseholdAnalysisJPanel(JPanel userProcessContainer,OrganizationDirectory directory, EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.directory=directory;
        this.system=system;
        populateData();
    }
    
    
      public void populateData(){
          
         DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        
        
        for (Map.Entry entry : getFinalModelList().entrySet())  {
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue());
            
            dcd.setValue(Double.parseDouble(entry.getValue()+""), entry.getKey()+"", entry.getKey()+"");
            JFreeChart jchart = ChartFactory.createBarChart3D("HOUSEHOLD STATISTICS", "FURNITURE TYPE", "FURNITURE QUANTITY", dcd, PlotOrientation.VERTICAL, true, true, false);

            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);

            ChartPanel chartp = new ChartPanel(jchart, true);
                                        //chartp.setDomainZoomable(true);
            chartp.setVisible(true);
            barchart.removeAll();
            barchart.setLayout(new java.awt.BorderLayout());
            barchart.add(chartp, BorderLayout.CENTER);

            barchart.validate();
        }
        
        //-----------------------Populate Table---------------------
        DefaultTableModel model = (DefaultTableModel) householdAnalysisTable.getModel();
        model.setRowCount(0);
        
         for(Network network:system.getNetworkList()){
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Household))
                    
                {
                    for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                        if(organization instanceof StudentOrganization)
                        {
                            for(UserAccount userAccount1: organization.getUserAccountDirectory().getUserAccountList())
                            {
                            for (HouseholdWorkRequest request: userAccount1.getWorkQueue().getHouseholdWorkRequests()){
                               if(request.getStatus().equalsIgnoreCase("Purchased"))
                                    {
                                        Object[] row = new Object[2];
                                        row[0] = request.getFurnitureType();
                                        row[1] = request.getQuantity();

                                        model.addRow(row);
                                    }
                            }
        
                            }
                        }
                    }
                }
            }
         }
                  
   }
      
    private HashMap<String, Double> getFinalModelList()
    {
        HashMap<String, Double> map = new HashMap<>(); 
        //DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        for(Network network:system.getNetworkList()){
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Household))
                    
                {
                    for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                        if(organization instanceof StudentOrganization)
                        {
                            for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList())
                            {
                                
                                for (HouseholdWorkRequest request : ua.getWorkQueue().getHouseholdWorkRequests()){
                                  
                                    if(request.getStatus().equalsIgnoreCase("Purchased"))
                                    {
                                        double quantity=0;
                                       
                                        if(map.containsKey(request.getFurnitureType()))
                                        {
                                            quantity= map.get(request.getFurnitureType());
                                        }
                                        
                                        map.put(request.getFurnitureType(), request.getQuantity()+quantity);
                                    }
                                }
                            }
                        }
                    }
                }
            }
         }
        return map;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        householdAnalysisTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        barchart = new javax.swing.JPanel();

        jLabel3.setText("Household Analysis");

        householdAnalysisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Furniture Type", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(householdAnalysisTable);
        if (householdAnalysisTable.getColumnModel().getColumnCount() > 0) {
            householdAnalysisTable.getColumnModel().getColumn(0).setResizable(false);
            householdAnalysisTable.getColumnModel().getColumn(1).setResizable(false);
        }

        btnBack.setBackground(new java.awt.Color(102, 102, 102));
        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barchartLayout = new javax.swing.GroupLayout(barchart);
        barchart.setLayout(barchartLayout);
        barchartLayout.setHorizontalGroup(
            barchartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        barchartLayout.setVerticalGroup(
            barchartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barchart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(92, 92, 92)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barchart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barchart;
    private javax.swing.JButton btnBack;
    private javax.swing.JTable householdAnalysisTable;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
