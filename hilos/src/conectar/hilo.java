package conectar;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class hilo implements Runnable
       
{
    Thread hilo;
        conex con;
        
        public hilo() {}
	public void inicio() throws Exception
	{
	   con = new conex("postgres","12345","localhost","5432","cafeteria");
           con.ConexionPostgres();
	    
	    if (hilo==null)
		{
			hilo=new Thread(this);//crea el hilo
		//	hilo=new Thread();//crea el hilo
			hilo.start();// lanzar el hilo
			
		}
	}
	public void stop()
	{
		hilo=null;
	}
    private void pausa(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	@Override
	public void run(){
            Thread hiloactual = Thread.currentThread();
            while (hilo == hiloactual){
                try{
                    ResultSet tm = con.consultar("SELECT id_producto, nombre_producto, stock_producto,existencia_producto FROM producto");
               
                while (tm.next()) {
                    int idProducto = tm.getInt("id_producto");
                    String nombre = tm.getString("nombre_producto");
                    int stock = tm.getInt("stock_producto");
                    int existencia = tm.getInt("existencia_producto");
                 
                    if(existencia<stock){
                    if(!existeNotificacionActiva(nombre)){
                        registrarNotificacion(nombre);
                    }
                    }else{
                        try(PreparedStatement pr = con.getConnection().prepareStatement(
                        "UPDATE notificaciones SET estado= 'Inactivo',"
                                +" fecha_solucion=CURRENT_DATE, hora_solucion= CURRENT_TIME "
                                +"WHERE descripcion LIKE ? AND estado= 'Activo'"))
                                {
                                    pr.setString(1, "%" + nombre+"%");
                                    pr.executeUpdate();
                                }
                }
                }
                      pausa(10000);
		} catch (SQLException ex) {
                Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            }
        
    
        
  private boolean existeNotificacionActiva (String nombreProducto) throws SQLException {
            PreparedStatement stm = con.getConnection().prepareStatement(
"SELECT id FROM notificaciones WHERE descripcion LIKE ? AND estado ='Activo'" );
stm.setString(1, "%" + nombreProducto+"%");
ResultSet rs = stm.executeQuery();
return rs.next () ;
        }
        
private void registrarNotificacion (String nombreProducto) throws SQLException {
PreparedStatement ps =con.getConnection().prepareStatement(
"INSERT INTO notificaciones(id, descripcion, fecha_noti, hora, estado) " + "VALUES(?, ?, ?, ?, ?)");

java.util.Date now = new java.util.Date();
                        java.sql.Date fecha = new java.sql.Date(now.getTime());
                        java.sql.Time hora = new java.sql.Time(now.getTime());
                        
                        
ps.setString(1, "NOTIF-" + System.nanoTime());
                    ps.setString(2, "Existencia baja para : '"+nombreProducto+"'");
                    ps.setDate(3, fecha);
                    ps.setTime(4, hora);
                    ps.setString(5, "Activo");
ps.executeUpdate ();

}
}

               
       



		
	
	

