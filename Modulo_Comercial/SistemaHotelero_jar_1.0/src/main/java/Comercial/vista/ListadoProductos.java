
/*
 * 
 *
 * @author SipaqueRitaMaria
 */
package Comercial.vista;


import Comercial.datos.ProductoDAO;
import Comercial.dominio.Producto;
import java.awt.Color;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListadoProductos extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;

    /** Creates new form clientes */
    
   
        public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID PRODCUTO");
        modelo.addColumn("Nombre PRDUCTO");
        modelo.addColumn("COSTO");

        ProductoDAO proveedorDAO = new ProductoDAO();

        List<Producto> proveedor = proveedorDAO.select();
        tbprodcutos.setModel(modelo);
        String[] dato = new String[3];
        for (int i = 0; i < proveedor.size(); i++) {
            
            dato[0] = Integer.toString(proveedor.get(i).getPKcodigoProducto());
            dato[1] = proveedor.get(i).getNombreProducto();
            dato[2] = proveedor.get(i).getCostoProducto();
            
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
        }
    public ListadoProductos() {
        initComponents();
        llenadoDeTablas();
        
        
    
       
       
        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnenviar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbprodcutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPopupMenu1.setForeground(new java.awt.Color(204, 0, 204));

        mnenviar.setText("Enviar Datos");
        mnenviar.setToolTipText("");
        mnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Listado de Productos");

        tbprodcutos.setComponentPopupMenu(jPopupMenu1);
        tbprodcutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbprodcutos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbprodcutosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                tbprodcutosAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbprodcutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbprodcutosMouseClicked(evt);
            }
        });
        tbprodcutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbprodcutosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbprodcutos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Listado de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void mnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarActionPerformed
// TODO add your handling code here:
    String cod="", nom="", canti="";
    String cod1="", nom1="", canti1="";
    String cod2="", nom2="", canti2="";
    String cod3="", nom3="", canti3="";
    
    int fila = tbprodcutos.getSelectedRow();
    int fila1 = tbprodcutos.getSelectedRow();
     int fila2 = tbprodcutos.getSelectedRow();
     int fila3 = tbprodcutos.getSelectedRow();
    try {
        if(fila==-1)
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");
                  
        }
        else
        {
         cod =  (String)tbprodcutos.getValueAt(fila, 0);
         nom=  (String)tbprodcutos.getValueAt(fila, 1);
         canti= (String)tbprodcutos.getValueAt(fila, 2);
         
        Porceso_FacturaCompras.txt_IdProducto.setDisabledTextColor(Color.blue);
        Porceso_FacturaCompras.txt_IdProducto.setText(cod);
        Porceso_FacturaCompras.txt_NombreProducto.setDisabledTextColor(Color.blue);
        Porceso_FacturaCompras.txt_NombreProducto.setText(nom);
       Porceso_FacturaCompras.txt_Costo.setDisabledTextColor(Color.blue);
         Porceso_FacturaCompras.txt_Costo.setText(canti);
         
         
         
         
         this.dispose();
         
        }
    } catch (Exception e) {
    }
    
    try {
        if(fila1==-1)
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");
                  
        }
        else
        {
         cod1=  (String)tbprodcutos.getValueAt(fila, 0);
         nom1=  (String)tbprodcutos.getValueAt(fila, 1);
         canti1= (String)tbprodcutos.getValueAt(fila, 2);
         
        Proceso_OrdenCompra.txt_IdProducto.setDisabledTextColor(Color.blue);
        Proceso_OrdenCompra.txt_IdProducto.setText(cod1);
        Proceso_OrdenCompra.txt_NombreProducto.setDisabledTextColor(Color.blue);
        Proceso_OrdenCompra.txt_NombreProducto.setText(nom1);
       Proceso_OrdenCompra.txt_Costo.setDisabledTextColor(Color.blue);
         Proceso_OrdenCompra.txt_Costo.setText(canti1);
         
         
         
         
         this.dispose();
         
        }
    } catch (Exception e) {
    }
    
    
    try {
        if(fila2==-1)
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");
                  
        }
        else
        {
         cod2=  (String)tbprodcutos.getValueAt(fila2, 0);
         nom2=  (String)tbprodcutos.getValueAt(fila2, 1);
         canti2= (String)tbprodcutos.getValueAt(fila2, 2);
         
        ProcesoDevolucionCompra.txt_IdProducto.setDisabledTextColor(Color.blue);
        ProcesoDevolucionCompra.txt_IdProducto.setText(cod2);
        ProcesoDevolucionCompra.txt_NombreProducto.setDisabledTextColor(Color.blue);
        ProcesoDevolucionCompra.txt_NombreProducto.setText(nom2);
       ProcesoDevolucionCompra.txt_Costo.setDisabledTextColor(Color.blue);
         ProcesoDevolucionCompra.txt_Costo.setText(canti2);
         
         
         
         
         this.dispose();
         
        }
    } catch (Exception e) {
    }
    
   
    try {
        if(fila3==-1)
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");
                  
        }
        else
        {
         cod3=  (String)tbprodcutos.getValueAt(fila3, 0);
         nom3=  (String)tbprodcutos.getValueAt(fila3, 1);
         canti3= (String)tbprodcutos.getValueAt(fila3, 2);
         
        ProcesoRecepcionCompra.txt_IdProducto.setDisabledTextColor(Color.blue);
        ProcesoRecepcionCompra.txt_IdProducto.setText(cod3);
        ProcesoRecepcionCompra.txt_NombreProducto.setDisabledTextColor(Color.blue);
        ProcesoRecepcionCompra.txt_NombreProducto.setText(nom3);
       ProcesoRecepcionCompra.txt_Costo.setDisabledTextColor(Color.blue);
         ProcesoRecepcionCompra.txt_Costo.setText(canti3);
         
         
         
         
         this.dispose();
         
        }
    } catch (Exception e) {
    }
    
    
    
}//GEN-LAST:event_mnenviarActionPerformed

    private void tbprodcutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprodcutosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbprodcutosMouseClicked

    private void tbprodcutosAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbprodcutosAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tbprodcutosAncestorMoved

    private void tbprodcutosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbprodcutosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbprodcutosAncestorAdded

    private void tbprodcutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodcutosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbprodcutosKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnenviar;
    private javax.swing.JTable tbprodcutos;
    // End of variables declaration//GEN-END:variables
//    conectar cc= new conectar();
//    Connection cn = cc.conexion();
}
