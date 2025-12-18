
package GUI;

import conectar.conex;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Venta extends javax.swing.JPanel {

     DefaultTableModel dp= new DefaultTableModel();
    public Venta() {
        initComponents();
        
        
//         try{
//    conectar con = new conectar("postgres","12345","localhost","5432","cafeteria");
//    con.ConexionPostgres();
//    
//    String query= "SELECT * FROM detalle_venta order by id_detalle ASC";
//    ResultSet rs= con.consultar(query);
//           
//    while(rs.next())
//            {
//             long id_ingre=(rs.getLong("id_detalle"));
//             
//            iddet.addItem(id_ingre+"");
//            };
// 
//        } catch (Exception r) {
//            r.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error al conectar");
//        }
         
         try{
    conex con = new conex("postgres","12345","localhost","5432","cafeteria");
    con.ConexionPostgres();
    
    String query= "SELECT * FROM cliente order by cedula_cliente ASC";
    ResultSet rs= con.consultar(query);
           
    while(rs.next())
            {
             long id_ingre=(rs.getLong("cedula_cliente"));
             
            boxcliente.addItem(id_ingre+"-"+rs.getString("nombre_cliente"));
            };
 
        } catch (Exception r) {
            r.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }
         
         try{
    conex con = new conex("postgres","12345","localhost","5432","cafeteria");
    con.ConexionPostgres();
    
    String query= "SELECT * FROM empleado order by cedula_empleado ASC";
    ResultSet rs= con.consultar(query);
           
    while(rs.next())
            {
             long id_ingre=(rs.getLong("cedula_empleado"));
             
            boxempleado.addItem(id_ingre+"-"+rs.getString("nombre_empleado"));
            };
 
        } catch (Exception r) {
            r.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }
    }

  
    private void limpiar(){
    
        idventa.setText("");
        iddet.setText("");
        boxcliente.setSelectedIndex(-1);
        boxempleado.setSelectedIndex(-1);
        fecha.setDate(null);
        valor.setText("");
        dp.setRowCount(0);
    
    }
    
    private void mostrar() {

        try {
            DefaultTableModel model = (DefaultTableModel) tabla_venta.getModel();
            model.setRowCount(0);

            conex c = new conex("postgres", "12345", "localhost", "5432", "cafeteria");
            c.ConexionPostgres();

            String query = "SELECT * FROM venta";
            System.out.println(query);

            ResultSet rs = c.consultar(query);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getLong("id_venta"),
                    rs.getInt("id_detalle"),
                    rs.getString("id_cliente"),
                    rs.getString("id_empleado"),
                    rs.getDate("fecha_venta"),
                    rs.getDouble("valor")
                });

            }
            c.cerrar();
       

    }    catch (SQLException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        inclient = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idventa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boxempleado = new javax.swing.JComboBox<>();
        boxcliente = new javax.swing.JComboBox<>();
        fecha = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_venta = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listar = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        iddet = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(126, 44, 52));

        inclient.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        inclient.setForeground(new java.awt.Color(255, 255, 255));
        inclient.setText("Ingresar Venta");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-clientes-48.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(inclient)
                .addContainerGap(978, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(14, 14, 14))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(inclient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Fecha Venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, 20));

        idventa.setBorder(null);
        jPanel1.add(idventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 240, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Id Venta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Empleado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        boxempleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        boxempleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(boxempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 170, 30));

        boxcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        boxcliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(boxcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 170, 30));
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 170, 30));

        jPanel2.setBackground(new java.awt.Color(64, 23, 30));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-añadir-usuario-masculino-30.png"))); // NOI18N
        jLabel7.setText("INSERTAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 100, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("ID Detalle");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 240, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Valor total");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        valor.setBackground(new java.awt.Color(0, 0, 102));
        valor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        valor.setForeground(new java.awt.Color(255, 255, 0));
        valor.setBorder(null);
        valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorActionPerformed(evt);
            }
        });
        jPanel1.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 290, 60));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 280, 10));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(null);

        tabla_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_venta", "Id_detalle", "Id_Cliente", "Id_Empleado", "Fecha_venta", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tabla_venta);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(16, 84, 490, 110);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Ventas realizadas");
        jPanel8.add(jLabel13);
        jLabel13.setBounds(20, 10, 260, 15);
        jPanel8.add(jSeparator3);
        jSeparator3.setBounds(20, 30, 260, 10);

        jPanel7.setBackground(new java.awt.Color(64, 23, 30));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ELIMINAR");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jPanel8.add(jPanel7);
        jPanel7.setBounds(390, 10, 85, 28);

        jPanel4.setBackground(new java.awt.Color(64, 23, 30));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MOSTRAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        jPanel8.add(jPanel4);
        jPanel4.setBounds(290, 10, 75, 28);

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 530, 200));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setLayout(null);
        jPanel9.add(jLabel14);
        jLabel14.setBounds(135, 6, 0, 0);

        jLabel15.setText("Productos Agregados");
        jPanel9.add(jLabel15);
        jLabel15.setBounds(30, 30, 150, 16);

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jPanel9.add(jSeparator4);
        jSeparator4.setBounds(30, 60, 373, 10);

        listar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(listar);

        jPanel9.add(jScrollPane2);
        jScrollPane2.setBounds(20, 110, 470, 150);

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 530, 290));

        jPanel5.setBackground(new java.awt.Color(64, 23, 30));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-buscar-cliente-30.png"))); // NOI18N
        jLabel9.setText("BUSCAR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 100, -1));

        iddet.setBorder(null);
        iddet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                iddetKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                iddetKeyTyped(evt);
            }
        });
        jPanel1.add(iddet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 240, 30));

        jPanel10.setBackground(new java.awt.Color(64, 23, 30));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-factura-30.png"))); // NOI18N
        jLabel16.setText("FACTURA");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 100, 40));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 240, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

        try {
            int ide = Integer.parseInt(idventa.getText());
            int idd= Integer.parseInt(iddet.getText());
            String client = (String) boxcliente.getSelectedItem();
            String empl = (String) boxempleado.getSelectedItem();
            Date fechana = fecha.getDate();
            double val=Double.parseDouble(valor.getText().trim());
            
            fechana.toString();

            conex con = new conex("postgres", "12345", "localhost", "5432", "cafeteria");
            con.ConexionPostgres();

            String query = "INSERT INTO venta VALUES("+ide+","+idd+",'"+client+"','"+empl+"','"+fechana+"',"+val+")";
            
            con.actualizar(query);

            JOptionPane.showMessageDialog(null, "Venta insertada");
            con.cerrar();

            limpiar();
        } catch (SQLException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        mostrar();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
try {
    int ven = Integer.parseInt(idventa.getText());

    // Conexión a la base de datos
    conex con = new conex("postgres", "12345", "localhost", "5432", "cafeteria");
    con.ConexionPostgres();

    // Consulta para obtener detalles de la venta
    String query = "SELECT * FROM venta WHERE id_venta = ?";
    PreparedStatement ps = con.getConnection().prepareStatement(query);
    ps.setInt(1, ven);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        iddet.setText(String.valueOf(rs.getInt("id_detalle")));
        boxcliente.setSelectedItem(rs.getString("id_cliente"));
        boxempleado.setSelectedItem(rs.getString("id_empleado"));
        fecha.setDate(rs.getDate("fecha_venta"));
        valor.setText(String.valueOf(rs.getDouble("valor")));
    } else {
        JOptionPane.showMessageDialog(null, "Venta no encontrada");
        return; // Salir temprano si no se encuentra la venta
    }

    int id_det = Integer.parseInt(iddet.getText());

    // Configuración de la tabla
    dp.setRowCount(0);
    String[] ids = {"Id_Detalle", "Producto", "Cantidad", "Precio Unitario", "Valor Total"};
    dp.setColumnIdentifiers(ids);
    listar.setModel(dp);

    // Consulta para obtener productos del detalle de venta
    String querys = "SELECT id_producto, cantidad FROM detalle_venta WHERE id_detalle = ?";
    PreparedStatement psDet = con.getConnection().prepareStatement(querys);
    psDet.setInt(1, id_det);
    ResultSet rss = psDet.executeQuery();

    double totalGeneral = 0.0;

   while (rss.next()) {
        // Obtener los arreglos desde la base de datos
        java.sql.Array productosArray = rss.getArray("id_producto");
        java.sql.Array cantidadesArray = rss.getArray("cantidad");

        Object[] objProductos = (Object[]) productosArray.getArray();
        Object[] objCantidades = (Object[]) cantidadesArray.getArray();

        if (objProductos.length != objCantidades.length) {
            JOptionPane.showMessageDialog(null, "Advertencia: cantidad de productos y cantidades no coinciden.");
            return;
        }

        int min = Math.min(objProductos.length, objCantidades.length);

        // Consulta para obtener detalles del producto
        String queryProd = "SELECT nombre_producto, precio_producto FROM producto WHERE id_producto = ?";
        PreparedStatement psProd = con.getConnection().prepareStatement(queryProd);

        for (int i = 0; i < min; i++) {
            int idProd = Integer.parseInt(objProductos[i].toString());
            int cantidad = Integer.parseInt(objCantidades[i].toString());

            psProd.setInt(1, idProd);
            ResultSet rsProd = psProd.executeQuery();

            if (rsProd.next()) {
                String nombre = rsProd.getString("nombre_producto");
                double precio = rsProd.getDouble("precio_producto");
                double total = precio * cantidad;

                dp.addRow(new Object[]{
                    id_det,
                    nombre,
                    cantidad,
                    precio,
                    total
                });

                totalGeneral += total;
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }

            rsProd.close();
        }

        psProd.close();
    }

    // Actualizar el valor total
    valor.setText(String.valueOf("  "+totalGeneral));

    rss.close();
    psDet.close();



} catch (SQLException ex) {
    Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
}        catch (ClassNotFoundException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
    
}

    }//GEN-LAST:event_jPanel5MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        try {
            conex c = new conex ("postgres", "123", "localhost", "5432", "cafeteria");
            c.ConexionPostgres();

            String query = "DELETE FROM venta WHERE id_venta = ?";

            PreparedStatement p = c.getConnection().prepareStatement(query);
            p.setLong(1, Long.parseLong(idventa.getText()));
            int fila = p.executeUpdate();
            JOptionPane.showMessageDialog(null, fila > 0 ? "cliente eliminado" : "cliente no encontrado");
            p.close();
            mostrar();
            c.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
     try {
            conex c = new conex("postgres", "12345", "localhost", "5432", "cafeteria");
            c.ConexionPostgres();

            String query = "DELETE FROM venta WHERE id_venta = ?";

            PreparedStatement p = c.getConnection().prepareStatement(query);
            p.setInt(1, Integer.parseInt(idventa.getText()));
            int fila = p.executeUpdate();
            JOptionPane.showMessageDialog(null, fila > 0 ? "cliente eliminado" : "cliente no encontrado");
            p.close();
            mostrar();
            c.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jPanel7MouseClicked

    private void valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorActionPerformed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked

 
        try {
            int idd= Integer.parseInt(idventa.getText());
 int d= Integer.parseInt(iddet.getText());
 String clien= (String) boxcliente.getSelectedItem();
 String emp= (String) boxempleado.getSelectedItem();
 Date f= fecha.getDate();
 double v= Double.parseDouble(valor.getText());
            // Formatear la fecha
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formatoFecha.format(f);

            // Crear el archivo
            PrintWriter escritor = new PrintWriter(new FileWriter("Factura.txt"));

            // Encabezado
            escritor.println("Factura de Venta");
            escritor.println("--------------------------------------------------------");

            // Datos de la factura
            escritor.println("ID Venta: " + idd);
            escritor.println("Detalle Venta: " + d);
            escritor.println("Cliente: " + clien);
            escritor.println("Empleado: " + emp);
            escritor.println("Fecha Venta: " + fechaFormateada);
            escritor.println();

            // Datos de la tabla
            escritor.println("Detalles de la Compra:");
            for (int fila = 0; fila < listar.getRowCount(); fila++) {
                for (int columna = 0; columna < listar.getColumnCount(); columna++) {
                    Object valorCelda = listar.getValueAt(fila, columna); // Obtén el valor de la celda
                    escritor.print(valorCelda + "\t"); // Imprime el valor
                }
                escritor.println(); // Salto de línea al final de cada fila
            }

            // Total
            escritor.println("--------------------------------------------------------");
            escritor.println("Valor Final: " + v);
            escritor.println("--------------------------------------------------------");
            escritor.println("Gracias por su compra");

            // Cierra el escritor
            escritor.close();

            // Verificar y abrir el archivo
            File archivoFactura = new File("Factura.txt");
            if (archivoFactura.exists()) {
                Desktop.getDesktop().open(archivoFactura);
                System.out.println("Factura generada correctamente.");
            } else {
                System.out.println("Error: El archivo no se generó correctamente.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    


    }//GEN-LAST:event_jPanel10MouseClicked

    private void iddetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iddetKeyTyped
       
    }//GEN-LAST:event_iddetKeyTyped

    private void iddetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iddetKeyReleased
        dp.setRowCount(0);
String[] ids = {"Id_Detalle", "Producto", "Cantidad", "Precio Unitario", "Valor Total"};
dp.setColumnIdentifiers(ids);
listar.setModel(dp);

int id_det = Integer.parseInt(iddet.getText());

try {
    conex con = new conex("postgres", "12345", "localhost", "5432", "cafeteria");
    con.ConexionPostgres();

    String query = "SELECT id_producto, cantidad FROM detalle_venta WHERE id_detalle = ?";
    PreparedStatement ps = con.getConnection().prepareStatement(query);
    ps.setInt(1, id_det);
    ResultSet rs = ps.executeQuery();

    double totalGeneral = 0.0;

    if (rs.next()) {
        java.sql.Array productosArray = rs.getArray("id_producto");
        java.sql.Array cantidadesArray = rs.getArray("cantidad");

        Object[] objProductos = (Object[]) productosArray.getArray();
        Object[] objCantidades = (Object[]) cantidadesArray.getArray();

        if (objProductos.length != objCantidades.length) {
            JOptionPane.showMessageDialog(null, "Advertencia: cantidad de productos y cantidades no coinciden.");
        }

        int min = Math.min(objProductos.length, objCantidades.length);

        String queryProd = "SELECT nombre_producto, precio_producto FROM producto WHERE id_producto = ?";
        PreparedStatement psProd = con.getConnection().prepareStatement(queryProd);

        for (int i = 0; i < min; i++) {
            int idProd = ((Integer) objProductos[i]).intValue();
            int cantidad = ((Integer) objCantidades[i]).intValue();

            psProd.setInt(1, idProd);
            ResultSet rsProd = psProd.executeQuery();

            if (rsProd.next()) {
                String nombre = rsProd.getString("nombre_producto");
                double precio = rsProd.getDouble("precio_producto");
                double total = precio * cantidad;

                dp.addRow(new Object[]{
                    id_det,
                    nombre,
                    cantidad,
                    precio,
                    total
                });

                totalGeneral += total;
            }
        }
    }

    valor.setText(String.valueOf("  "+totalGeneral));

    con.cerrar();
} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error al buscar datos");
}


    }//GEN-LAST:event_iddetKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxcliente;
    private javax.swing.JComboBox<String> boxempleado;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JTextField iddet;
    private javax.swing.JTextField idventa;
    private javax.swing.JLabel inclient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable listar;
    private javax.swing.JTable tabla_venta;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
