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
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BookstoreWorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
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
public class BookstoreAnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookstoreAnalysisJPanel
     */
  private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private EcoSystem system;
    /**
     * Creates new form AnalysisDemandAndSupplyJPanel
     */
    public BookstoreAnalysisJPanel(JPanel userProcessContainer,OrganizationDirectory directory, EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.directory=directory;
        this.system=system;
        populateData();
    }
    
    public void populateData(){
        
        
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        
        
        for (Map.Entry entry : getFinalModelList().entrySet())  {
            //System.out.println("Key = " + entry.getKey() + 
            //                 ", Value = " + entry.getValue());
            
            
            dcd.setValue(Double.parseDouble(entry.getValue()+""), entry.getKey()+"", entry.getKey()+"");
            JFreeChart jchart = ChartFactory.createBarChart3D("BOOKSTORE STATISTICS", "BOOK TYPE", "NUMBER OF BOOKS", dcd, PlotOrientation.VERTICAL, true, true, false);

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
        DefaultTableModel dtm = (DefaultTableModel) booksAnalysisTable.getModel();
        dtm.setRowCount(0);
        
        for(Network network:system.getNetworkList()){
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Bookstore))
                    
                {
                    for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                        if(organization instanceof StudentOrganization)
                        {
                            for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList())
                            {
                                
                                for (BookstoreWorkRequest request : ua.getWorkQueue().getBookstoreWorkRequestList()){
                                  
                                    if(request.getStatus().equalsIgnoreCase("Purchased"))
                                    {
                                        Object[] row = new Object[2];
                                        row[0] = request.getBooktype();
                                        row[1] = request.getNoOfBooks();

                                        dtm.addRow(row);
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
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Bookstore))
                    
                {
                    for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                        if(organization instanceof StudentOrganization)
                        {
                            for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList())
                            {
                                
                                for (BookstoreWorkRequest request : ua.getWorkQueue().getBookstoreWorkRequestList()){
                                  
                                    if(request.getStatus().equalsIgnoreCase("Purchased"))
                                    {
                                        double noOfBooks=0;
                                       
                                        if(map.containsKey(request.getBooktype()))
                                        {
                                            noOfBooks= map.get(request.getBooktype());
                                        }
                                        
                                        map.put(request.getBooktype(), request.getNoOfBooks()+noOfBooks);
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

        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        booksAnalysisTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        barchart = new javax.swing.JPanel();

        jLabel4.setText("BookStore Analysis");

        booksAnalysisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Book Type", "Number of books"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(booksAnalysisTable);
        if (booksAnalysisTable.getColumnModel().getColumnCount() > 0) {
            booksAnalysisTable.getColumnModel().getColumn(0).setResizable(false);
            booksAnalysisTable.getColumnModel().getColumn(1).setResizable(false);
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        barchartLayout.setVerticalGroup(
            barchartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(barchart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(barchart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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
    private javax.swing.JTable booksAnalysisTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
