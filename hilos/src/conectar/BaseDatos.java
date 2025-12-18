package conectar;

public class BaseDatos extends java.awt.Frame
{
            private java.awt.TextArea txt;
            
            public BaseDatos()
            {
                        inicializar();
            }
            
            private void inicializar()
            {
                        txt=new java.awt.TextArea();
                        setLayout(new java.awt.BorderLayout(50,50));
                        addWindowListener(new java.awt.event.WindowAdapter()
                        {
                                   public void windowClosing(java.awt.event.WindowEvent e)
                                   {
                                               salir(e);
                                   }
                        });
                        rellenarRegistros();
                        
                        add(txt, java.awt.BorderLayout.CENTER);
                        pack();
            }
            
            private void rellenarRegistros()
            {
                        String url="jdbc:odbc:base";
                        String driver="sun.jdbc.odbc.JdbcOdbcDriver";
                        java.sql.Connection con=null;
                        try
                        {
                                   Class.forName(driver).newInstance();
                        }catch (Exception e)
                        {
                        }
                        
                        try
                        {
                                   con=java.sql.DriverManager.getConnection(url,"","");
                                   java.sql.Statement select= con.createStatement();
                                   java.sql.ResultSet rs=select.executeQuery("Select * from tabla");
                                   txt.setText("\t Ejemplo de Base de Datos:JDBC/ODBC \n");
                                   txt.setText(txt.getText() + "Codigo \t Nombre \t clave \n");
                                  
								   while (rs.next())
                                   {
                                               int clave;
                                               String nombre;
                                               String valor;
                                               
                                               clave=rs.getInt(1);
                                              
                                               nombre=rs.getString(2);
                                              
                                               valor=rs.getString(3);
                                               
                                               txt.setText(txt.getText() + clave + "\t" + nombre + "\t" + valor + "\n");
                                   }                                 
                        }          catch (java.sql.SQLException e)
                        {
                        }finally
                        {
                                   if (con!=null)
                                   {
                                               try
                                               {
                                                           con.close();
                                               }catch (java.sql.SQLException e)
                                               {
                                               }
                                   }
                        }
            }
            
            
            private void salir(java.awt.event.WindowEvent e)
            {
                        System.exit(0);
            }
            

            public static void main(String args[])
                     
            {
             BaseDatos  b =new BaseDatos();
             b.show();
             
            }
}
