/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import numbers.Prime;
import rsa.Key;
import rsa.RSA;
import socket.Client;

/**
 *
 * @author ANHMATTROI
 */
public class ClientGui extends javax.swing.JFrame 
{
    private int i;
    private RSA rsa;
    private int p, q;
    private Key private_key;
    private Key public_key;
    private Client client;
    /**
     * Creates new form MainWindow
     */
    public ClientGui()
    {
        initComponents();
        i = 888;
        p = 0;
        q = 0;
        rsa = new RSA();
        LoadListPrimes();
        private_key = new Key();
        public_key = new Key();
        tb_send.requestFocus(true);
        client = new Client();
    }
    
    private void LoadListPrimes()
    {
        final Prime prime = new Prime();
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                String[] list_prime = prime.ListPrime(257, 65535).getItems();
                cbb_p.setModel(new DefaultComboBoxModel(list_prime));
                cbb_q.setModel(new DefaultComboBoxModel(list_prime));
                cbb_p.setSelectedIndex(0);
                cbb_q.setSelectedIndex(1);
            }
        });
        thread.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_root = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_send = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_receive = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbb_p = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbb_q = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        lb_publickey = new javax.swing.JLabel();
        bt_open_publickey = new javax.swing.JButton();
        bt_save_publickey = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lb_privatekey = new javax.swing.JLabel();
        bt_open_privatekey = new javax.swing.JButton();
        bt_save_privatekey = new javax.swing.JButton();
        bt_decrypt = new javax.swing.JButton();
        bt_save_ciphertext = new javax.swing.JButton();
        bt_delete_ciphertext = new javax.swing.JButton();
        bt_encrypt = new javax.swing.JButton();
        bt_send = new javax.swing.JButton();
        bt_delete_plaintext = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bt_createkey = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tb_address = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tb_port = new javax.swing.JTextField();
        bt_connect = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mn_openfile = new javax.swing.JMenuItem();
        mn_save = new javax.swing.JMenuItem();
        mn_exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mn_copy_publickey = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENT - RSA");
        setBackground(new java.awt.Color(250, 250, 250));
        setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(316, 594));
        setResizable(false);

        pn_root.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tb_send.setColumns(10);
        tb_send.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_send.setLineWrap(true);
        tb_send.setRows(5);
        tb_send.setTabSize(4);
        tb_send.setWrapStyleWord(true);
        tb_send.setSelectionColor(new java.awt.Color(0, 0, 255));
        tb_send.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tb_sendFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tb_send);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tb_receive.setColumns(10);
        tb_receive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_receive.setLineWrap(true);
        tb_receive.setRows(5);
        tb_receive.setTabSize(4);
        tb_receive.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tb_receive.setSelectionColor(new java.awt.Color(0, 0, 255));
        jScrollPane2.setViewportView(tb_receive);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Dữ liệu nhận được");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nhập dữ liệu cần gửi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Chọn số nguyên tố p");

        cbb_p.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbb_p.setBorder(null);
        cbb_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_pActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Chọn số nguyên tố q");

        cbb_q.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbb_q.setBorder(null);
        cbb_q.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbb_q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_qActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Khóa công khai");

        lb_publickey.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_publickey.setForeground(new java.awt.Color(0, 51, 255));
        lb_publickey.setText("khóa");

        bt_open_publickey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/open.png"))); // NOI18N
        bt_open_publickey.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        bt_open_publickey.setContentAreaFilled(false);
        bt_open_publickey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_open_publickey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_open_publickeyActionPerformed(evt);
            }
        });

        bt_save_publickey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        bt_save_publickey.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        bt_save_publickey.setContentAreaFilled(false);
        bt_save_publickey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_save_publickey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_save_publickeyActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Khóa bí mật");

        lb_privatekey.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_privatekey.setForeground(new java.awt.Color(0, 51, 255));
        lb_privatekey.setText("khóa");

        bt_open_privatekey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/open.png"))); // NOI18N
        bt_open_privatekey.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        bt_open_privatekey.setContentAreaFilled(false);
        bt_open_privatekey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_open_privatekey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_open_privatekeyActionPerformed(evt);
            }
        });

        bt_save_privatekey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        bt_save_privatekey.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        bt_save_privatekey.setContentAreaFilled(false);
        bt_save_privatekey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_save_privatekey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_save_privatekeyActionPerformed(evt);
            }
        });

        bt_decrypt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_decrypt.setText("Giải mã");
        bt_decrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bt_decrypt.setContentAreaFilled(false);
        bt_decrypt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_decryptActionPerformed(evt);
            }
        });

        bt_save_ciphertext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_save_ciphertext.setText("Lưu");
        bt_save_ciphertext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bt_save_ciphertext.setContentAreaFilled(false);
        bt_save_ciphertext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_save_ciphertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_save_ciphertextActionPerformed(evt);
            }
        });

        bt_delete_ciphertext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_delete_ciphertext.setText("Xóa");
        bt_delete_ciphertext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bt_delete_ciphertext.setContentAreaFilled(false);
        bt_delete_ciphertext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_delete_ciphertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_delete_ciphertextActionPerformed(evt);
            }
        });

        bt_encrypt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_encrypt.setText("Mã hóa");
        bt_encrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bt_encrypt.setContentAreaFilled(false);
        bt_encrypt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_encryptActionPerformed(evt);
            }
        });

        bt_send.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_send.setText("Gửi");
        bt_send.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bt_send.setContentAreaFilled(false);
        bt_send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sendActionPerformed(evt);
            }
        });

        bt_delete_plaintext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_delete_plaintext.setText("Xóa");
        bt_delete_plaintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bt_delete_plaintext.setContentAreaFilled(false);
        bt_delete_plaintext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_delete_plaintext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_delete_plaintextActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Bên nhận");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Bên gửi");

        bt_createkey.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_createkey.setText("Tạo khóa");
        bt_createkey.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bt_createkey.setContentAreaFilled(false);
        bt_createkey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_createkey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_createkeyActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Địa chỉ máy chủ");

        tb_address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Cổng");

        tb_port.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        bt_connect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_connect.setText("Kết nối");
        bt_connect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bt_connect.setContentAreaFilled(false);
        bt_connect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_connectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_rootLayout = new javax.swing.GroupLayout(pn_root);
        pn_root.setLayout(pn_rootLayout);
        pn_rootLayout.setHorizontalGroup(
            pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_rootLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(26, 26, 26)
                .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_rootLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_rootLayout.createSequentialGroup()
                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt_connect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbb_q, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pn_rootLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bt_createkey, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbb_p, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pn_rootLayout.createSequentialGroup()
                                .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(bt_decrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_save_ciphertext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_delete_ciphertext, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(bt_encrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bt_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_delete_plaintext, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_rootLayout.createSequentialGroup()
                                .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_rootLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lb_privatekey)
                                            .addComponent(lb_publickey)
                                            .addGroup(pn_rootLayout.createSequentialGroup()
                                                .addComponent(bt_open_publickey, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bt_save_publickey, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pn_rootLayout.createSequentialGroup()
                                                .addComponent(bt_open_privatekey, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bt_save_privatekey, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_rootLayout.createSequentialGroup()
                                        .addComponent(tb_address, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tb_port, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(13, 13, 13))))
        );
        pn_rootLayout.setVerticalGroup(
            pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_rootLayout.createSequentialGroup()
                .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_rootLayout.createSequentialGroup()
                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_rootLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbb_q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbb_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bt_createkey, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_publickey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_open_publickey)
                            .addComponent(bt_save_publickey))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_privatekey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_open_privatekey)
                            .addComponent(bt_save_privatekey))
                        .addGap(40, 40, 40)
                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pn_rootLayout.createSequentialGroup()
                                .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bt_encrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(bt_send, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_delete_plaintext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pn_rootLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(bt_save_ciphertext, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_delete_ciphertext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tb_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tb_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_rootLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jMenu1.setText("Tệp");

        mn_openfile.setText("Mở file");
        mn_openfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_openfileActionPerformed(evt);
            }
        });
        jMenu1.add(mn_openfile);

        mn_save.setText("Lưu");
        mn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_saveActionPerformed(evt);
            }
        });
        jMenu1.add(mn_save);

        mn_exit.setText("Thoát");
        mn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_exitActionPerformed(evt);
            }
        });
        jMenu1.add(mn_exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sửa");

        mn_copy_publickey.setText("Chép khóa công khai");
        mn_copy_publickey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_copy_publickeyActionPerformed(evt);
            }
        });
        jMenu2.add(mn_copy_publickey);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Trợ giúp");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mn_openfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_openfileActionPerformed
        // TODO add your handling code here:
        JFileChooser file_open = new JFileChooser();
        file_open.setCurrentDirectory(new File(System.getProperty("user.home")));
        file_open.setFileSelectionMode(0);
        file_open.setDialogTitle("Open file");
        //file_open.setFileFilter(new FileFilter());
        int result = file_open.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            FileReader reader = null; 
            try 
            {
                File file = file_open.getSelectedFile();
                reader = new FileReader(file.getPath());
                String str = "";
                int k;
                //reader.read();
                k = reader.read();
                while(k != -1)
                {
                    str += (char) k;
                    k = reader.read();
                }
                tb_send.setText(str);
            } 
            catch (FileNotFoundException ex) 
            {
                System.out.println(ex.toString());
            } 
            catch (IOException ex) 
            {
                System.out.println(ex.toString());
            } 
            finally 
            {
                try 
                {
                    if(reader != null) reader.close();
                } 
                catch (IOException ex) 
                {
                    System.out.println(ex.toString());
                }
            }
            
        }
        file_open.removeAll();
    }//GEN-LAST:event_mn_openfileActionPerformed

    private void mn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mn_exitActionPerformed

    private void tb_sendFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_sendFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_sendFocusGained

    private void bt_open_publickeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_open_publickeyActionPerformed
        // TODO add your handling code here:
        JFileChooser open_file = new JFileChooser();
        open_file.setCurrentDirectory(new File(System.getProperty("user.home")));
        open_file.setFileSelectionMode(0);
        open_file.setDialogTitle("Mở khóa công khai");
        int result = open_file.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = open_file.getSelectedFile();
            FileInputStream input = null;
            try
            {
                input = new FileInputStream(file.getPath());
                String str = "";
                int c;
                c = input.read();
                while(c != -1)
                {
                    str += String.valueOf((char)c);
                    c = input.read();
                }
                input.close();
                try
                {
                    String[] plk;
                    plk = str.split(";");
                    if(plk.length == 2)
                    {
                        int e, n;
                        e = Integer.parseInt(plk[0].trim());
                        n = Integer.parseInt(plk[1].trim());
                        if(e < 3 || n < 3 || e == n)
                        {
                            JOptionPane.showMessageDialog(null, "Khóa công khai không đúng");
                            return;
                        }
                        public_key.setM(e);
                        public_key.setN(n);
                        lb_publickey.setText(String.valueOf(e) + ", " + String.valueOf(n));
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                    JOptionPane.showMessageDialog(null, "Khóa công khai không đúng");
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bt_open_publickeyActionPerformed

    private void bt_save_publickeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_save_publickeyActionPerformed
        // TODO add your handling code here:
        if(public_key.getM() < 3 || public_key.getN() < 3 || public_key.getM() == public_key.getN())
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa tạo khóa công khai");
            return;
        }
        JFileChooser save_file = new JFileChooser();
        save_file.setCurrentDirectory(new File(System.getProperty("user.home")));
        save_file.setDialogTitle("Lưu khóa công khai");
        int result = save_file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = save_file.getSelectedFile();
            FileOutputStream output = null;
            try
            {
                output = new FileOutputStream(file.getPath());
                byte[] ba;
                String str = String.valueOf(public_key.getM()) + ";" + String.valueOf(public_key.getN());
                ba = str.getBytes();
                output.write(ba);
                output.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bt_save_publickeyActionPerformed

    private void bt_open_privatekeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_open_privatekeyActionPerformed
        // TODO add your handling code here:
        JFileChooser open_file = new JFileChooser();
        open_file.setCurrentDirectory(new File(System.getProperty("user.home")));
        open_file.setFileSelectionMode(0);
        open_file.setDialogTitle("Mở khóa bí mật");
        int result = open_file.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = open_file.getSelectedFile();
            FileInputStream input = null;
            try
            {
                input = new FileInputStream(file.getPath());
                String str = "";
                int c;
                c = input.read();
                while(c != -1)
                {
                    str += String.valueOf((char)c);
                    c = input.read();
                }
                input.close();
                try
                {
                    String[] plk;
                    plk = str.split(";");
                    if(plk.length == 2)
                    {
                        int d, n;
                        d = Integer.parseInt(plk[0].trim());
                        n = Integer.parseInt(plk[1].trim());
                        if(d < 3 || n < 3 || d == n)
                        {
                            JOptionPane.showMessageDialog(null, "Khóa bí mật không đúng");
                            return;
                        }
                        private_key.setM(d);
                        private_key.setN(n);
                        lb_privatekey.setText(String.valueOf(d) + ", " + String.valueOf(n));
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                    JOptionPane.showMessageDialog(null, "Khóa bí mật không đúng");
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_bt_open_privatekeyActionPerformed

    private void bt_save_privatekeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_save_privatekeyActionPerformed
        // TODO add your handling code here:
        if(private_key.getM() < 3 || private_key.getN() < 3 || private_key.getM() == private_key.getN())
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa tạo khóa bí mật");
            return;
        }
        JFileChooser save_file = new JFileChooser();
        save_file.setCurrentDirectory(new File(System.getProperty("user.home")));
        save_file.setDialogTitle("Lưu khóa bí mật");
        int result = save_file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = save_file.getSelectedFile();
            FileOutputStream output = null;
            try
            {
                output = new FileOutputStream(file.getPath());
                byte[] ba;
                String str = String.valueOf(private_key.getM()) + ";" + String.valueOf(private_key.getN());
                ba = str.getBytes();
                output.write(ba);
                output.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bt_save_privatekeyActionPerformed

    private void bt_decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_decryptActionPerformed
        // TODO add your handling code here:
        if(private_key.getM() == 0 || private_key.getN() == 0)
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa tạo khóa");
            return;
        }
        tb_receive.setText(rsa.Decrypt(tb_receive.getText(), private_key));
        //tb_receive.setText(String.valueOf(private_key.getM())+ ", " + String.valueOf(private_key.getN()));
    }//GEN-LAST:event_bt_decryptActionPerformed

    private void bt_encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_encryptActionPerformed
        // TODO add your handling code here:
        if(public_key.getM() == 0 || public_key.getN() == 0)
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa tạo khóa");
            return;
        }
        tb_send.setText(rsa.Encrypt(tb_send.getText(), public_key));
        //tb_send.setText(String.valueOf(public_key.getM())+ ", " + String.valueOf(public_key.getN()));
    }//GEN-LAST:event_bt_encryptActionPerformed

    private void bt_save_ciphertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_save_ciphertextActionPerformed
        // TODO add your handling code here:
        JFileChooser save_file = new JFileChooser();
        save_file.setCurrentDirectory(new File(System.getProperty("user.home")));
        save_file.setDialogTitle("Lưu");
        int result = save_file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = save_file.getSelectedFile();
            FileOutputStream output = null;
            try
            {
                output = new FileOutputStream(file.getPath());
                byte[] ba;
                String str = tb_receive.getText();
                ba = str.getBytes();
                output.write(ba);
                output.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_bt_save_ciphertextActionPerformed

    private void bt_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sendActionPerformed
        // TODO add your handling code here:
        if(client.getState())
        {
            client.SendData(tb_send.getText());
            tb_send.setText("");
        }
        else
            JOptionPane.showMessageDialog(null, "Không có kết nối nào");
    }//GEN-LAST:event_bt_sendActionPerformed

    private void bt_delete_ciphertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_delete_ciphertextActionPerformed
        // TODO add your handling code here:
        tb_receive.setText("");
    }//GEN-LAST:event_bt_delete_ciphertextActionPerformed

    private void bt_delete_plaintextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_delete_plaintextActionPerformed
        // TODO add your handling code here:
        tb_send.setText("");
    }//GEN-LAST:event_bt_delete_plaintextActionPerformed

    private void bt_createkeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_createkeyActionPerformed
        // TODO add your handling code here:
        if(p == q)
        {
            JOptionPane.showMessageDialog(null, "Hai số nguyên tố p và q phải khác nhau");
            return;
        }
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                ClientGui.this.bt_createkey.setEnabled(false);
                ClientGui.this.setTitle("Đang tạo khóa............");
                rsa.CreateKey(p, q);
                private_key = rsa.GetPrivateKey();
                public_key = rsa.GetPublicKey();
                lb_publickey.setText("(" + String.valueOf(public_key.getM()) + ", " + String.valueOf(public_key.getN()) + ")");
                lb_privatekey.setText("(" + String.valueOf(private_key.getM()) + ", " + String.valueOf(private_key.getN()) + ")");
                ClientGui.this.bt_createkey.setEnabled(true);
                ClientGui.this.setTitle("CLIENT - RSA");
            }
        });
        thread.start();
    }//GEN-LAST:event_bt_createkeyActionPerformed

    private void cbb_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_pActionPerformed
        // TODO add your handling code here:
         p = Integer.parseInt(cbb_p.getSelectedItem().toString());
        if(p == q)
        {
            JOptionPane.showMessageDialog(null, "Hai số nguyên tố p và q phải khác nhau");
            return;
        }
    }//GEN-LAST:event_cbb_pActionPerformed

    private void cbb_qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_qActionPerformed
        // TODO add your handling code here:
        q = Integer.parseInt(cbb_q.getSelectedItem().toString());
        if(p == q)
        {
            JOptionPane.showMessageDialog(null, "Hai số nguyên tố q và p phải khác nhau");
            return;
        }
    }//GEN-LAST:event_cbb_qActionPerformed

    public void setReceivedData(String message)
    {
        tb_receive.setText(message);
    }
    
    private void bt_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_connectActionPerformed
        // TODO add your handling code here:
        if(tb_port.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập số cổng đẻ kết nối");
            return;
        }
        if(client.getState())
        {
            client.Finish();
            bt_connect.setText("Kết nối");
            return;
        }
        client.setClientGui(this);
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                String address;
                int port;
                try
                {
                    bt_connect.setEnabled(false);
                    address = tb_address.getText();
                    port = Integer.parseInt(tb_port.getText());
                    if(port >= 0xffff)
                    {
                        JOptionPane.showMessageDialog(null, "Số cổng không hợp lệ");
                        bt_connect.setEnabled(true);
                        return;
                    }
                    if(client.ConnectToServer(address, port))
                    {
                        bt_connect.setText("Đóng kết nối");
                        client.ReceiveData();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Lỗi kết nối");
                        bt_connect.setText("Kết nối");
                    }
                    bt_connect.setEnabled(true);
                }
                catch(Exception ex)
                {
                    bt_connect.setEnabled(true);
                    System.out.println(ex.toString());
                    JOptionPane.showMessageDialog(null, "Số cổng không hợp lệ");
                }
            }
        });
        thread.start();
    }//GEN-LAST:event_bt_connectActionPerformed

    private void mn_copy_publickeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_copy_publickeyActionPerformed
        // TODO add your handling code here:
        if(public_key.getM() < 3 || public_key.getN() < 3 || public_key.getM() == public_key.getN())
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa tạo khóa công khai");
            return;
        }
        String str = String.valueOf(public_key.getM()) + "; " + String.valueOf(public_key.getN());
        tb_send.setText(str);
    }//GEN-LAST:event_mn_copy_publickeyActionPerformed

    private void mn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_saveActionPerformed
        // TODO add your handling code here:
        if(tb_send.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu");
            tb_send.requestFocus();
            return;
        }
        JFileChooser save_file = new JFileChooser();
        save_file.setCurrentDirectory(new File(System.getProperty("user.home")));
        save_file.setDialogTitle("Lưu");
        int result = save_file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = save_file.getSelectedFile();
            FileOutputStream output = null;
            try
            {
                output = new FileOutputStream(file.getPath());
                byte[] ba;
                String str = tb_send.getText();
                ba = str.getBytes();
                output.write(ba);
                output.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_mn_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_connect;
    private javax.swing.JButton bt_createkey;
    private javax.swing.JButton bt_decrypt;
    private javax.swing.JButton bt_delete_ciphertext;
    private javax.swing.JButton bt_delete_plaintext;
    private javax.swing.JButton bt_encrypt;
    private javax.swing.JButton bt_open_privatekey;
    private javax.swing.JButton bt_open_publickey;
    private javax.swing.JButton bt_save_ciphertext;
    private javax.swing.JButton bt_save_privatekey;
    private javax.swing.JButton bt_save_publickey;
    private javax.swing.JButton bt_send;
    private javax.swing.JComboBox cbb_p;
    private javax.swing.JComboBox cbb_q;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_privatekey;
    private javax.swing.JLabel lb_publickey;
    private javax.swing.JMenuItem mn_copy_publickey;
    private javax.swing.JMenuItem mn_exit;
    private javax.swing.JMenuItem mn_openfile;
    private javax.swing.JMenuItem mn_save;
    private javax.swing.JPanel pn_root;
    private javax.swing.JTextField tb_address;
    private javax.swing.JTextField tb_port;
    private javax.swing.JTextArea tb_receive;
    private javax.swing.JTextArea tb_send;
    // End of variables declaration//GEN-END:variables
}
