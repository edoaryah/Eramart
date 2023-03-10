/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import java.sql.*;
import koneksi.Database;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author G512
 */
public class PilihBarang extends javax.swing.JFrame {

    /**
     * Creates new form PilihBarang
     */
    DefaultTableModel table = new DefaultTableModel();
    
    public PilihBarang() {
        initComponents();
        
        Database.getKoneksi();
        
        jTable_pilihbarang.setModel(table);
        table.addColumn("ID");
        table.addColumn("NAMA");
        table.addColumn("HARGA");
        table.addColumn("STOK");
        
        tampilData();
    }

    private void tampilData(){
        int row = jTable_pilihbarang.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM barang ";
        
        try{
            Connection connect = Database.getKoneksi(); //memanggil koneksi
            Statement sttmnt = connect.createStatement(); //membuat statement
            ResultSet rslt = sttmnt.executeQuery(query); //menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                String kode = rslt.getString("idbarang");
                String nama = rslt.getString("namabarang");
                String harga = rslt.getString("harga");
                String stok = rslt.getString("stok");
                    
                //memasukkan semua data kedalam array
                String[] data = {kode,nama,harga,stok};
                //menambahakan baris sesuai dengan data yang tersimpan di array
                table.addRow(data);
            }
            //mengeset nilai yang ditampung agar muncul di tabel
            jTable_pilihbarang.setModel(table);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void cari(){
        int row = jTable_pilihbarang.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String cari = jTextField_cari.getText();
        String query = "SELECT * FROM barang WHERE idbarang LIKE '%"+cari+"%' OR namabarang LIKE '%"+cari+"%' ";
        
        try{
            Connection connect = Database.getKoneksi(); //memanggil koneksi
            Statement sttmnt = connect.createStatement(); //membuat statement
            ResultSet rslt = sttmnt.executeQuery(query); //menjalanakn query
           
            while (rslt.next()){
                //menampung data sementara
                String id = rslt.getString("idbarang");
                String nama = rslt.getString("namabarang");
                String harga = rslt.getString("harga");
                String stok = rslt.getString("stok");
                    
                //memasukkan semua data kedalam array
                String[] data = {id,nama,harga,stok};
                //menambahakan baris sesuai dengan data yang tersimpan di array
                table.addRow(data);
            }
            //mengeset nilai yang ditampung agar muncul di table
            jTable_pilihbarang.setModel(table);
        }catch(Exception e){
            System.out.println(e);
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
        jTextField_cari = new javax.swing.JTextField();
        jButton_cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_pilihbarang = new javax.swing.JTable();
        jButton_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setText("PILIH BARANG");

        jTextField_cari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton_cari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_cari.setText("CARI");
        jButton_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cariActionPerformed(evt);
            }
        });

        jTable_pilihbarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable_pilihbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_pilihbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_pilihbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_pilihbarang);

        jButton_back.setText("BACK");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton_back))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_back)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        // TODO add your handling code here:
        new Transaksi().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

    private void jButton_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton_cariActionPerformed

    private void jTable_pilihbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_pilihbarangMouseClicked
        // TODO add your handling code here:
        
        int row = jTable_pilihbarang.getSelectedRow();
        Transaksi menu = new Transaksi();
        
        
        String id = table.getValueAt(row, 0).toString();
        menu.jTextField_idbarang.setText(id);
        
        String nama = table.getValueAt(row, 1).toString();
        menu.jTextField_namabarang.setText(nama);
        
        String harga = table.getValueAt(row, 2).toString();
        menu.jTextField_harga.setText(harga);
        
        menu.setVisible(true);
        menu.pack();
        menu.setDefaultCloseOperation(Transaksi.DISPOSE_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jTable_pilihbarangMouseClicked

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
            java.util.logging.Logger.getLogger(PilihBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PilihBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PilihBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PilihBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PilihBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable_pilihbarang;
    private javax.swing.JTextField jTextField_cari;
    // End of variables declaration//GEN-END:variables
}
