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
import Business.WorkQueue.AccomodationWorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashMap;
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
public class AccomodationAnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccomodationAnalysisJPanel
     */
   private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private EcoSystem system;
    int count1bhk = 0;
    int count2bhk = 0;
    int count3bhk = 0;
     HashMap<String, Float> hashMapApt= new HashMap<>();
    /**
     * Creates new form AnalysisDemandAndSupplyJPanel
     */
    public AccomodationAnalysisJPanel(JPanel userProcessContainer,OrganizationDirectory directory, EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.directory=directory;
        this.system=system;
        populateData();
    }
    
    public void populateData()
    {
        
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        
        
        for (Map.Entry entry : getFinalModelList().entrySet())  {
            //System.out.println("Key = " + entry.getKey() + 
            //                 ", Value = " + entry.getValue());
           
            String hashApt=entry.getKey()+"";
            float aptRent=Float.parseFloat(entry.getValue()+"");
            
            if (hashApt.equalsIgnoreCase("1 BHK"))
            {
                hashMapApt.put(entry.getKey()+"",Float.parseFloat((aptRent/count1bhk)+""));      
            }
            else if(hashApt.equalsIgnoreCase("2 BHK"))
            {
                hashMapApt.put(entry.getKey()+"",Float.parseFloat((aptRent/count2bhk)+""));     
            }
            else if(hashApt.equalsIgnoreCase("3 BHK"))
            {
                hashMapApt.put(entry.getKey()+"",Float.parseFloat((aptRent/count3bhk)+""));     
            }
        }                  
        for (Map.Entry entry : hashMapApt.entrySet())  {
            dcd.setValue(Double.parseDouble(entry.getValue()+""), entry.getKey()+"", entry.getKey()+"");
            JFreeChart jchart = ChartFactory.createBarChart3D("ACCOMODATION STATISTICS", "APARTMENT SIZE", "RENT", dcd, PlotOrientation.VERTICAL, true, true, false);

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
        
        //------------------ populate table-------------------------------------
        DefaultTableModel model = (DefaultTableModel) accomodationTable.getModel();
        model.setRowCount(0);
        
        for(Network network:system.getNetworkList())
        {
        for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
        {
           if(enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Accomodation);
              {
                  for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                   {
                      if(organization instanceof StudentOrganization)
                          {
                            for(UserAccount userAccount1: organization.getUserAccountDirectory().getUserAccountList())
                            {
                                for (AccomodationWorkRequest request : userAccount1.getWorkQueue().getAccomodationWorkRequestList())
                                {
                                    if(request.getStatus().equalsIgnoreCase("Purchased"))
                                    {
                                        Object[] row = new Object[2];
                                        row[0] = request.getApptSize();
                                        row[1]=request.getRent();                         
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
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Accomodation))
                    
                {
                    for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                        if(organization instanceof StudentOrganization)
                        {
                            for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList())
                            {
                                 double rent = 0;
                                       
                                for (AccomodationWorkRequest request : ua.getWorkQueue().getAccomodationWorkRequestList()){
                                  
                                    if(request.getStatus().equalsIgnoreCase("Purchased"))
                                    {
                                       
                                      
                                         if (request.getApptSize().equalsIgnoreCase("1 BHK"))
                                        {
                                            count1bhk++;       
                                        }
                                        else if(request.getApptSize().equalsIgnoreCase("2 BHK"))
                                        {
                                            count2bhk++;
                                        }
                                        else if(request.getApptSize().equalsIgnoreCase("3 BHK"))
                                        {
                                            count3bhk++;
                                        }
                                        if(map.containsKey(request.getApptSize()))
                                        {
                                            rent= map.get(request.getApptSize());
                                        }
                                        map.put(request.getApptSize(), (request.getRent()+rent));
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

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accomodationTable = new javax.swing.JTable();
        barchart = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        btnBack.setBackground(new java.awt.Color(102, 102, 102));
        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        accomodationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Apartment size", "Rent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(accomodationTable);
        if (accomodationTable.getColumnModel().getColumnCount() > 0) {
            accomodationTable.getColumnModel().getColumn(0).setResizable(false);
            accomodationTable.getColumnModel().getColumn(1).setResizable(false);
        }

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("ACCOMMODATION ANALYSIS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barchart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barchart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accomodationTable;
    private javax.swing.JPanel barchart;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
