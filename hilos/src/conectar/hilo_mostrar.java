/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectar;
import GUI.notificaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author SENA
 */
public class hilo_mostrar implements Runnable
       
{
    Thread hilo;
        conex con;
        
        private notificaciones formularioNotificaciones;

public hilo_mostrar(notificaciones form) {
    this.formularioNotificaciones = form;
}
        
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
	
               String query = "SELECT  id, descripcion, fecha_noti, hora, estado FROM notificaciones where estado ='Activo'";
               
               Thread hiloactual = Thread.currentThread();
               
              
               while (hilo == hiloactual){
              try {
        ResultSet tm = con.consultar(query);
        SwingUtilities.invokeLater(() -> {
            formularioNotificaciones.limpiarTabla();
        });
                   
                while (tm.next()) {
                    Object [] fila ={
                    tm.getString("id"),
                    tm.getString("descripcion"),
                    tm.getDate("fecha_noti"),
                    tm.getTime("hora"),
                    tm.getString("estado")
                    };
                     SwingUtilities.invokeLater(() -> {
                formularioNotificaciones.agregarFilaATabla(fila);
            });
                }
                     tm.close();
                      pausa(10000);
		} catch (SQLException ex) {
                Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
            } 
            }
        }          
    }



