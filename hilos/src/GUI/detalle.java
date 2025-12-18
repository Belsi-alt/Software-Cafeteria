
package GUI;

import conectar.hilo;
import conectar.conex;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.sql.PreparedStatement;

public class detalle extends javax.swing.JPanel {
    public static String cad="", cad1="";
    Vector<Integer> vector = new Vector<>();
    ArrayList<Integer> cantidades= new ArrayList<>();
    
    DefaultTableModel dm= new DefaultTableModel();
    
    public detalle() {
        initComponents();
       
          try{
    conex con = new conex("postgres","12345","localhost","5432","cafeteria");
    con.ConexionPostgres();
    
    String query= "SELECT * FROM producto order by nombre_producto ASC";
    ResultSet rs= con.consultar(query);
           
    while(rs.next())
            {
             long id_ingre=(rs.getLong("id_producto"));
             
            boxproducto.addItem(id_ingre+"-"+ rs.getString("nombre_producto"));
            };
 
        } catch (Exception r) {
            r.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }
    }

     private void limpiar (){
    
        txtide.setText("");
        boxproducto.setSelectedItem("");
        txtcant.setText("");
    
    }
    
     
                   
    private void mostrar() {

       
      try {
    DefaultTableModel model = (DefaultTableModel) tablamostrar.getModel();
    model.setRowCount(0);

    conex c = new conex("postgres", "12345", "localhost", "5432", "cafeteria");
    c.ConexionPostgres();

    String query = "SELECT * FROM detalle_venta";
    System.out.println(query);

    ResultSet rs = c.consultar(query);
    while (rs.next()) {
        // Leer array de PostgreSQL
        java.sql.Array arrProductos = rs.getArray("id_producto");
        java.sql.Array arrCantidades = rs.getArray("cantidad");

        // Convertir a Object[]
        Object[] productos = (Object[]) arrProductos.getArray();
        Object[] cantidades = (Object[]) arrCantidades.getArray();

        // Convertir arrays a String para mostrarlos en la tabla
        String productosStr = java.util.Arrays.toString(productos);
        String cantidadesStr = java.util.Arrays.toString(cantidades);

        model.addRow(new Object[]{
            rs.getLong("id_detalle"),
            productosStr,
            cantidadesStr
        });
    }

    c.cerrar();
} catch (SQLException ex) {
    Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
} catch (ClassNotFoundException ex) {
    Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
    Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
    Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablamostrar1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_cliente = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        inclient = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxproducto = new javax.swing.JComboBox<>();
        txtide = new javax.swing.JTextField();
        txtcant = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista1 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablamostrar = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LIS = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        LIS1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(tablamostrar1);

        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Documento de Identidad", "Nombres y Apellidos", "Fecha de Nacimiento", "Genero", "Telefono", "Correo Electronico", "Direccion"
            }
        ));
        jScrollPane4.setViewportView(tabla_cliente);

        jPanel12.setBackground(new java.awt.Color(64, 23, 30));
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("BUSCAR");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("INSERTAR");

        jPanel13.setBackground(new java.awt.Color(64, 23, 30));
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel7.setText("MOSTRAR");

        jPanel9.setBackground(new java.awt.Color(64, 23, 30));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel10.setText("MODIFICAR");

        jLabel11.setText("ELIMINAR");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(64, 23, 30));
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(64, 23, 30));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jSeparator8.setBackground(new java.awt.Color(102, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(154, 98, 98));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        setPreferredSize(new java.awt.Dimension(1024, 750));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 750));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(126, 44, 52));

        inclient.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        inclient.setForeground(new java.awt.Color(255, 255, 255));
        inclient.setText("Detalle Venta");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-agregar-a-carrito-de-compras-50.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inclient)
                .addContainerGap(959, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(inclient)
                .addGap(31, 31, 31))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1210, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Id Detalle Venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Producto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 20));

        boxproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        boxproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxproductoActionPerformed(evt);
            }
        });
        jPanel1.add(boxproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 210, -1));

        txtide.setBorder(null);
        jPanel1.add(txtide, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 230, 30));

        txtcant.setBorder(null);
        jPanel1.add(txtcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 230, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Cantidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, 10));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-aceptar-la-base-de-datos-25.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 40, 40));

        lista1.setColumns(20);
        lista1.setRows(5);
        jScrollPane3.setViewportView(lista1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 280, 130));

        jPanel8.setBackground(new java.awt.Color(234, 234, 234));

        txtbuscar.setBackground(new java.awt.Color(234, 234, 234));
        txtbuscar.setText("ingrese el id del detalle");
        txtbuscar.setBorder(null);
        txtbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtbuscarMousePressed(evt);
            }
        });
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        tablamostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_Detalle", "Producto", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(tablamostrar);

        jPanel4.setBackground(new java.awt.Color(50, 24, 24));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-añadir-usuario-masculino-30.png"))); // NOI18N
        jLabel14.setText("INSERTAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14)
        );

        jPanel2.setBackground(new java.awt.Color(64, 23, 30));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        LIS.setBackground(new java.awt.Color(255, 255, 255));
        LIS.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        LIS.setForeground(new java.awt.Color(255, 255, 255));
        LIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-actualizar-archivo-30.png"))); // NOI18N
        LIS.setText("LISTAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LIS, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LIS))
        );

        jPanel6.setBackground(new java.awt.Color(64, 23, 30));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-editar-propiedad-30.png"))); // NOI18N
        jLabel15.setText("MODIFICAR");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(64, 23, 30));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        LIS1.setBackground(new java.awt.Color(255, 255, 255));
        LIS1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        LIS1.setForeground(new java.awt.Color(255, 255, 255));
        LIS1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-30.png"))); // NOI18N
        LIS1.setText("ELIMINAR");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LIS1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LIS1))
        );

        jPanel5.setBackground(new java.awt.Color(64, 23, 30));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setToolTipText("");
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-buscar-cliente-30.png"))); // NOI18N
        jLabel13.setText("BUSCAR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 540, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

        mostrar();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        int id_det = Integer.parseInt(txtide.getText().trim());

try {
    if (vector.size() == 0 || cantidades.size() == 0) {
        JOptionPane.showMessageDialog(null, "Debes agregar al menos un producto con su cantidad.");
        return;
    }

    if (vector.size() != cantidades.size()) {
        JOptionPane.showMessageDialog(null, "Error: La cantidad de productos no coincide con las cantidades ingresadas.");
        return;
    }

    conex con = new conex("postgres", "12345", "localhost", "5432", "cafeteria");
    con.ConexionPostgres();

    String query = "INSERT INTO detalle_venta (id_detalle, id_producto, cantidad) VALUES (?, ?, ?)";
    PreparedStatement ps = con.getConnection().prepareStatement(query);

    ps.setInt(1, id_det);
    ps.setArray(2, con.getConnection().createArrayOf("integer", vector.toArray()));
    ps.setArray(3, con.getConnection().createArrayOf("integer", cantidades.toArray()));

    ps.executeUpdate();
    con.cerrar();

    JOptionPane.showMessageDialog(null, "Insertado correctamente");

    // Limpiar todo
    txtcant.setText("");
    txtide.setText("");
    boxproducto.setSelectedIndex(0);
    dm.setRowCount(0);
    vector.clear();
    cantidades.clear();
    cad = "";
    cad1 = "";
    lista1.setText("");

} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error al insertar: " + ex.getMessage());
}

    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
dm.setRowCount(0);
String[] ids = {"Id_Detalle", "Producto", "Cantidad", "Precio Unitario", "Valor Total"};
dm.setColumnIdentifiers(ids);
tablamostrar.setModel(dm);

int id_det = Integer.parseInt(txtide.getText());

try {
    conex con = new conex("postgres", "12345", "localhost", "5432", "cafeteria");
    con.ConexionPostgres();

    String query = "SELECT id_producto, cantidad FROM detalle_venta WHERE id_detalle = ?";
    PreparedStatement ps = con.getConnection().prepareStatement(query);
    ps.setInt(1, id_det);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        Integer[] productos = (Integer[]) rs.getArray("id_producto").getArray();
        Integer[] cantidades = (Integer[]) rs.getArray("cantidad").getArray();

        if (productos.length != cantidades.length) {
            JOptionPane.showMessageDialog(null, "Advertencia: cantidad de productos y cantidades no coinciden.");
        }

        int min = Math.min(productos.length, cantidades.length);

        String queryProd = "SELECT nombre_producto, precio_producto FROM producto WHERE id_producto = ?";
        PreparedStatement psProd = con.getConnection().prepareStatement(queryProd);

        for (int i = 0; i < min; i++) {
            int idProd = productos[i];
            int cantidad = cantidades[i];

            psProd.setInt(1, idProd);
            ResultSet rsProd = psProd.executeQuery();

            if (rsProd.next()) {
                String nombre = rsProd.getString("nombre_producto");
                double precio = rsProd.getDouble("precio_producto");
                double total = precio * cantidad;

                dm.addRow(new Object[]{
                    id_det,
                    nombre,
                    cantidad,
                    precio,
                    total
                });
            }
        }
    }

    con.cerrar();
} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error al buscar datos");
}         
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked

        try {
            long ced = Long.parseLong(txtide.getText());
            String pro = (String) boxproducto.getSelectedItem();
            Long cant = Long.parseLong(txtcant.getText());

            conex c = new conex ("postgres", "12345", "localhost", "5432", "cafeteria");
            c.ConexionPostgres();

            String query = "UPDATE detalle_venta SET producto = '" + pro + "', cantidad = " + cant + ", valor =  WHERE id_detalle = " + ced + " ";

            c.actualizar(query);
            JOptionPane.showMessageDialog(null, "modificado");
            mostrar();
            c.cerrar();
            limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        try {
            conex c = new conex ("postgres", "12345", "localhost", "5432", "cafeteria");
            c.ConexionPostgres();

            String query = "DELETE FROM venta WHERE id_venta = ?";

            PreparedStatement p = c.getConnection().prepareStatement(query);
            p.setLong(1, Long.parseLong(txtide.getText()));
            int fila = p.executeUpdate();
            JOptionPane.showMessageDialog(null, fila > 0 ? "cliente eliminado" : "cliente no encontrado");
            p.close();
            mostrar();
            c.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(detalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseClicked

    private void boxproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxproductoActionPerformed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
      String cod_ing = (String) boxproducto.getSelectedItem(); 
StringTokenizer st = new StringTokenizer(cod_ing, "-");

String token = st.nextToken(); 

vector.add(Integer.valueOf(token));

int cantidadIngresada = Integer.parseInt(txtcant.getText().trim());

cantidades.add(cantidadIngresada);

lista1.append(cod_ing + " - Cantidad: " + cantidadIngresada + "\n");

txtcant.setText("");

try {
    conex con = new conex("postgres","12345","localhost","5432","cafeteria");
   con.ConexionPostgres();

    String updateQuery = "UPDATE producto SET existencia_producto = existencia_producto - ? WHERE id_producto = ? AND existencia_producto >= ?";

     PreparedStatement p = con.getConnection().prepareStatement(updateQuery);

    for (int i = 0; i < vector.size(); i++) {
        int idProd = vector.get(i);
        int cantidad = cantidades.get(i);

        p.setInt(1, cantidad);
        p.setInt(2, idProd);
        p.setInt(3, cantidad);
    }
       int affectedRows = p.executeUpdate();
    JOptionPane.showMessageDialog(null, "Existencias actualizadas correctamente.");

    con.cerrar();

} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
    Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Error al actualizar existencias: " + ex.getMessage());
}

     
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked

        mostrar();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked

    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked

    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked

    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked

    }//GEN-LAST:event_jPanel14MouseClicked

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbuscarMousePressed
         if(txtbuscar.getText().equals("Ingrese Id del producto a buscar")){
        txtbuscar.setText("");
      txtbuscar.setForeground(Color.black);
     }
      else{txtbuscar.getText().isEmpty();
      txtbuscar.setText("Ingrese Id del producto a buscar");
     txtbuscar.setForeground(Color.gray);
     }
    }//GEN-LAST:event_txtbuscarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LIS;
    private javax.swing.JLabel LIS1;
    private javax.swing.JComboBox<String> boxproducto;
    private javax.swing.JLabel inclient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextArea lista1;
    private javax.swing.JTable tabla_cliente;
    private javax.swing.JTable tablamostrar;
    private javax.swing.JTable tablamostrar1;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtide;
    // End of variables declaration//GEN-END:variables
}
