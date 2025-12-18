package conectar;

import java.awt.*;


public class Imprimir extends Frame
{
            public static TextArea txt;
            
            public Imprimir()
            {
                        inicializar();
            }
            
            private void inicializar()
            {
                        txt=new TextArea();
                        setLayout(new BorderLayout(50,50));
                        addWindowListener(new java.awt.event.WindowAdapter()
                        {
                                   public void windowClosing(java.awt.event.WindowEvent e)
                                   {
                                               salir(e);
                                   }
                        });
                        
                       
                        txt.setText(txt.getText() + "Notificación");
                                  
                        //rellenarRegistros();
                        
                        add(txt, java.awt.BorderLayout.CENTER);
                        pack();
            }
            
            public static void colocar(String mensaje)
            { 
               txt.setText(txt.getText() +mensaje+ "\n");
            }
            
            
            private void salir(java.awt.event.WindowEvent e)
            {
                        System.exit(0);
            }
            
}
