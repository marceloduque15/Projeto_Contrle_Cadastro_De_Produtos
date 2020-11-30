/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestoque.telas;

import br.com.projetoestoque.dal.ModuloConexao;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Desenvolvedor
 */
public class TelaProdutos extends javax.swing.JInternalFrame {
Connection conexao = null;
PreparedStatement pst = null;
ResultSet rs = null;
    /**
     * Creates new form TelaProdutos
     */
    public TelaProdutos() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    private void consultarProd(){
        String sql ="select * from tbproduto where idprod=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtProId.getText());
            rs = pst.executeQuery();
            
            if (rs.next()) {
                txtPrpNome.setText(rs.getString(2));
                txtProDescri.setText(rs.getString(3));
                txtProValor.setText(rs.getString(4));
                txtProQuant.setText(rs.getString(5));
                // a linha abaixo mostra o perfil
                //CboUsoPerfil.setSelectedItem(rs.getString(2));
                
            } else {
                JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
                txtProDescri.setText(null);
                txtProId.setText(null);
                txtProQuant.setText(null);
                txtProValor.setText(null);
                txtPrpNome.setText(null);
            }
                            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void adcionar(){
        String sql ="insert into tbproduto(idprod,nomeprod,descriprod,preco,quantidade) values(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtProId.getText());
            pst.setString(2,txtPrpNome.getText());
            pst.setString(3,txtProDescri.getText());
            pst.setString(4,txtProValor.getText());
            pst.setString(5,txtProQuant.getText());
            
            if((((txtProId.getText().isEmpty())||(txtPrpNome.getText().isEmpty())||txtProValor.getText().isEmpty())||txtProQuant.getText().isEmpty())){
                JOptionPane.showInternalMessageDialog(this, "Preencher todos os campos obrigatórios!");
            }else{
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            pst.executeUpdate();
            txtProDescri.setText(null);
            txtProId.setText(null);
            txtProQuant.setText(null);
            txtProValor.setText(null);
            txtPrpNome.setText(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProId = new javax.swing.JTextField();
        txtProDescri = new javax.swing.JTextField();
        txtPrpNome = new javax.swing.JTextField();
        btn_adc = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtProValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtProQuant = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Produtos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setText("* Id");

        jLabel2.setText("* Nome");

        jLabel4.setText(" Descrição");

        btn_adc.setText("Confirmar");
        btn_adc.setToolTipText("Adicionar");
        btn_adc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_adc.setPreferredSize(new java.awt.Dimension(40, 40));
        btn_adc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adcActionPerformed(evt);
            }
        });

        jLabel3.setText("* Valor");

        jLabel5.setText("* Quantidade");

        jLabel6.setText("* Campo obrigatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProDescri)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPrpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProValor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtProId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(btn_adc, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtProQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtProValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtPrpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProDescri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btn_adc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_adcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adcActionPerformed
       adcionar();
    }//GEN-LAST:event_btn_adcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtProDescri;
    private javax.swing.JTextField txtProId;
    private javax.swing.JTextField txtProQuant;
    private javax.swing.JTextField txtProValor;
    private javax.swing.JTextField txtPrpNome;
    // End of variables declaration//GEN-END:variables
}