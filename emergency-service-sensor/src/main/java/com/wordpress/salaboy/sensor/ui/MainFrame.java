/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on May 10, 2011, 4:39:39 PM
 */
package com.wordpress.salaboy.sensor.ui;

import com.wordpress.salaboy.messaging.MessageConsumerWorker;
import com.wordpress.salaboy.messaging.MessageConsumerWorkerHandler;
import com.wordpress.salaboy.model.messages.IncomingCallMessage;
import com.wordpress.salaboy.model.messages.VehicleDispatchedMessage;
import com.wordpress.salaboy.sensor.EmergencyInformationDataSource;
import com.wordpress.salaboy.sensor.SensorMessageProducer;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author esteban
 */
public class MainFrame extends javax.swing.JFrame implements EmergencyInformationDataSource {

    private SensorMessageProducer sensorMessageProducer;
    private MessageConsumerWorker phoneCallsWorker;
    private MessageConsumerWorker vehicleDispatchedWorker;
    
    private WiiConfigPanel wiiConfigPanel;
    private UDPServerPanel uDPServerPanel;

    /** Creates new form MainFrame */
    public MainFrame() {
        sensorMessageProducer = new SensorMessageProducer(this);
        initComponents();
        
        wiiConfigPanel = new WiiConfigPanel(sensorMessageProducer, true);
        uDPServerPanel= new UDPServerPanel(sensorMessageProducer, true);
                
        this.tpnlMain.add(wiiConfigPanel);
        this.tpnlMain.add(uDPServerPanel);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                stopWorkers();
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chkConnectToCore = new javax.swing.JCheckBox();
        pnlConnectionStatus = new javax.swing.JPanel();
        tpnlMain = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboCallId = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cboVehicleId = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sensor Manager");

        chkConnectToCore.setText("Connect To Core");
        chkConnectToCore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkConnectToCoreActionPerformed(evt);
            }
        });

        pnlConnectionStatus.setBackground(new java.awt.Color(255, 0, 0));
        pnlConnectionStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlConnectionStatusLayout = new javax.swing.GroupLayout(pnlConnectionStatus);
        pnlConnectionStatus.setLayout(pnlConnectionStatusLayout);
        pnlConnectionStatusLayout.setHorizontalGroup(
            pnlConnectionStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        pnlConnectionStatusLayout.setVerticalGroup(
            pnlConnectionStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkConnectToCore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlConnectionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlConnectionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkConnectToCore))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel1.setText("Call");

        jLabel2.setText("Vehicle");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(cboCallId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboVehicleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboCallId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboVehicleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tpnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkConnectToCoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkConnectToCoreActionPerformed
        
        pnlConnectionStatus.setBackground(Color.YELLOW);
        if (chkConnectToCore.isSelected()){
            this.stopWorkers();
            this.initWorkers();
            
            this.uDPServerPanel.setOfflineMode(false);
            this.wiiConfigPanel.setOfflineMode(false);
            
            pnlConnectionStatus.setBackground(Color.GREEN);
        }else{
            this.stopWorkers();
            
            this.uDPServerPanel.setOfflineMode(true);
            this.wiiConfigPanel.setOfflineMode(true);
            
            pnlConnectionStatus.setBackground(Color.RED);
        }
        
    }//GEN-LAST:event_chkConnectToCoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCallId;
    private javax.swing.JComboBox cboVehicleId;
    private javax.swing.JCheckBox chkConnectToCore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlConnectionStatus;
    private javax.swing.JTabbedPane tpnlMain;
    // End of variables declaration//GEN-END:variables

    private void initWorkers() {
        //Phone Calls Worker
        phoneCallsWorker = new MessageConsumerWorker("Sensor-IncomingCall", new MessageConsumerWorkerHandler<IncomingCallMessage>() {

            @Override
            public void handleMessage(IncomingCallMessage incomingCallMessage) {
                Long callId = incomingCallMessage.getCallId();
                cboCallId.addItem(callId);
                cboCallId.setSelectedItem(callId);
            }
        });

        //Vehicle Dispatched
        vehicleDispatchedWorker = new MessageConsumerWorker("Sensor-VehicleDispatched", new MessageConsumerWorkerHandler<VehicleDispatchedMessage>() {

            @Override
            public void handleMessage(VehicleDispatchedMessage vehicleDispatchedMessage) {
                Long vehicleId = vehicleDispatchedMessage.getVehicleId();
                cboVehicleId.addItem(vehicleId);
                cboVehicleId.setSelectedItem(vehicleId);
            }
        });

        phoneCallsWorker.start();
        vehicleDispatchedWorker.start();
    }
    
    private void stopWorkers() {
        if(phoneCallsWorker != null ){
            phoneCallsWorker.stopWorker();
            phoneCallsWorker = null;
        }
        if(vehicleDispatchedWorker != null ){
            vehicleDispatchedWorker.stopWorker();
            vehicleDispatchedWorker = null;
        }
    }

    @Override
    public Long getCallId() {
        if (this.cboCallId.getSelectedIndex() == -1) {
            return null;
        }

        return (Long) this.cboCallId.getSelectedItem();
    }

    @Override
    public Long getVehicleId() {
        if (this.cboVehicleId.getSelectedIndex() == -1) {
            return null;
        }

        return (Long) this.cboVehicleId.getSelectedItem();
    }
    
    
}
