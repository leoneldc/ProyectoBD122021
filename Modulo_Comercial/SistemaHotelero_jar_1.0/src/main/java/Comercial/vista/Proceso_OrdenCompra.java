package Comercial.vista;

import Comercial.dominio.Mantenimiento_FormaPago;
import Comercial.datos.OrdenCompraDAO;
import Comercial.dominio.OrdenCompra;
import Comercial.datos.OrdenCompraDetalleDAO;
import Comercial.dominio.OrdenCompraDetalle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Comercial.datos.BalanceSaldosProveedoresDAO;
import Comercial.dominio.BalanceSaldosProveedores1;

import com.toedter.calendar.JDateChooser;
import java.net.UnknownHostException;
import seguridad.vista.Mantenimiento_Perfil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import seguridad.vista.Aplicacion_Perfil;
import java.net.UnknownHostException;
import java.util.Calendar;

/**
 *
 * /**
 *
 * @author SipaqueRitaMaria
 */
public class Proceso_OrdenCompra extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Porceso_FacturaCompras
     */
    OrdenCompra fecha2 = new OrdenCompra();
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaemision = null;

    OrdenCompra fecha3 = new OrdenCompra();
    SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
    Date fechavencimiento = null;

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("No.Factura");
        modelo.addColumn("ID BODEGA");
        modelo.addColumn("ID PROVEEDOR");
        modelo.addColumn("FECHA EMISION");
        modelo.addColumn("FECHA VENCIMIENTO");
        modelo.addColumn("FORMA PAGO");
        modelo.addColumn("Estado");
        OrdenCompraDAO proveedorDAO = new OrdenCompraDAO();

        List<OrdenCompra> proveedor = proveedorDAO.select();
        TablaFacturaEncabezado.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < proveedor.size(); i++) {
            dato[0] = Integer.toString(proveedor.get(i).getPK_codigo_ordencompra());
            dato[1] = proveedor.get(i).getPK_codigo_bodega();
            dato[2] = proveedor.get(i).getCodigo_proveedor();
            dato[3] = proveedor.get(i).getFecha_emision();
            dato[4] = proveedor.get(i).getFecha_vencimiento();
            dato[5] = proveedor.get(i).getCodigo_pago();
            dato[6] = proveedor.get(i).getEstatus_ordecompra();
            modelo.addRow(dato);
        }

    }
     
    public void uno() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CORRELATIVO");
        modelo.addColumn("NO.ORDEN");
        modelo.addColumn("ID PRODUCTO ");
        modelo.addColumn("ID BODEGA");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Costo");
        modelo.addColumn("Total");

        OrdenCompraDetalleDAO proveedorDAO = new OrdenCompraDetalleDAO();

        List<OrdenCompraDetalle> proveedor = proveedorDAO.select();
        TablaFacturaDetalle.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < proveedor.size(); i++) {
            dato[0] = Integer.toString(proveedor.get(i).getCorrelativo());
            dato[1] = Integer.toString(proveedor.get(i).getPK_Codigo_Ordencompra());
            dato[2] = proveedor.get(i).getPK_codigo_producto();
            dato[3] = proveedor.get(i).getPK_codigo_bodega();
            dato[4] = proveedor.get(i).getCantidad_detalle();
            dato[5] = proveedor.get(i).getCosto_detalle();
           dato[6] =  Integer.toString(proveedor.get(i).getTotal_detalle());;

            modelo.addRow(dato);
        }
   
    }

    public void limpiar() {
//        txt_IdProveedor.setText("");
//        txt_FechaEmision.setDateFormatString("");
        txt_CodigoPago.setText("");
        txt_Estatus.setText("");
//        txt_FechaVencimiento.setDateFormatString("");

    }

    public void limpiar1() {
        LbNofactura.setText("");
        txt_FechaEmision.setDateFormatString("");
        txt_CodigoPago.setText("");
        txt_IdBodega.setText("");
        txt_IdProducto.setText("");
        txt_NombreProducto.setText("");
        txt_Costo.setText("");
        txt_Cantidad.setText("");
        txtTotal.setText("");

    }

    public void limpiartotal() {
        LbNofactura.setText("");
        txt_FechaEmision.setDateFormatString("");
        txt_CodigoPago.setText("");
        txt_IdBodega.setText("");
        txt_IdProducto.setText("");
        txt_NombreProducto.setText("");
        txt_Costo.setText("");
        txt_Cantidad.setText("");
        txtTotal.setText("");
        txt_IdProveedor.setText("");
        txt_FechaEmision.setDateFormatString("");
        txt_CodigoPago.setText("");
        txt_Estatus.setText("");
        txt_FechaVencimiento.setDateFormatString("");
        Lbfecha.setText("");
       txtTotal1.setText("");
    }
    
    

    public void calculardias(JDateChooser fechainicio,JDateChooser fechatermino){
    if(fechainicio.getDate()!=null&&fechatermino.getDate()!=null){
        Calendar inicio=fechainicio.getCalendar();
        Calendar termino=fechatermino.getCalendar();
        int dias=-1;
        
        while (inicio.before(termino)|| inicio.equals(termino)){
        dias++;
        inicio.add(Calendar.DATE,1);
    }
        Lbfecha.setText(""+dias);
    }else{
        
    }
}
    
    
    
    public Proceso_OrdenCompra() {
        initComponents();
//        uno();
//        llenadoDeTablas();

    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbTITULO = new javax.swing.JLabel();
        LbNIT = new javax.swing.JLabel();
        Lbtitulo = new javax.swing.JLabel();
        LbNofactura = new javax.swing.JTextField();
        PanelFacturaDatos = new javax.swing.JPanel();
        LbIdProveedor = new javax.swing.JLabel();
        txt_IdProveedor = new javax.swing.JTextField();
        btnAgregarProveedor = new javax.swing.JButton();
        LbFechaEmision = new javax.swing.JLabel();
        txt_FechaEmision = new com.toedter.calendar.JDateChooser();
        LbNombreProducto = new javax.swing.JLabel();
        txt_IdProducto = new javax.swing.JTextField();
        LbIdProducto = new javax.swing.JLabel();
        btnAgregarProductos = new javax.swing.JButton();
        txt_NombreProducto = new javax.swing.JTextField();
        LbCostoProducto = new javax.swing.JLabel();
        txt_Costo = new javax.swing.JTextField();
        LbCantidadProducto = new javax.swing.JLabel();
        txt_Cantidad = new javax.swing.JTextField();
        LbFormaPago = new javax.swing.JLabel();
        LbFechaVencimiento = new javax.swing.JLabel();
        txt_FechaVencimiento = new com.toedter.calendar.JDateChooser();
        LbEstatus = new javax.swing.JLabel();
        txt_Estatus = new javax.swing.JTextField();
        LbIdBodega = new javax.swing.JLabel();
        txt_IdBodega = new javax.swing.JTextField();
        btnAgregarBodega = new javax.swing.JButton();
        txt_CodigoPago = new javax.swing.JTextField();
        btnAgregarPago = new javax.swing.JButton();
        Lbfacturadetalle = new javax.swing.JLabel();
        Lbfecha = new javax.swing.JLabel();
        PanleFacturaDetalles = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaFacturaDetalle = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaFacturaEncabezado = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        LbSubtotal = new javax.swing.JLabel();
        btnEliminar1 = new javax.swing.JButton();
        LbCorrelativo = new javax.swing.JLabel();
        btnModificar1 = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        Lbfacturadetalle1 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        LbTITULO.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTITULO.setText("Orden De Compra Hotel San Carlos");

        LbNIT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LbNIT.setText("Nit 67890000023-4");

        Lbtitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Lbtitulo.setText("No. Orden: ");

        LbNofactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PanelFacturaDatos.setBackground(new java.awt.Color(255, 255, 255));
        PanelFacturaDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden Compra Datos"));

        LbIdProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbIdProveedor.setText("Id Proveedor : ");

        txt_IdProveedor.setEditable(false);
        txt_IdProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_IdProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_IdProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_IdProveedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IdProveedorKeyTyped(evt);
            }
        });

        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        LbFechaEmision.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbFechaEmision.setText("Fecha Emisión :");

        txt_FechaEmision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt_FechaEmision.setForeground(new java.awt.Color(255, 255, 255));
        txt_FechaEmision.setDateFormatString("dd/MM/yyyy");
        txt_FechaEmision.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        LbNombreProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbNombreProducto.setText("Nombre Productos: ");

        txt_IdProducto.setEditable(false);
        txt_IdProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_IdProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_IdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_IdProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IdProductoKeyTyped(evt);
            }
        });

        LbIdProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbIdProducto.setText("Id Producto: ");

        btnAgregarProductos.setText("Agregar");
        btnAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductosActionPerformed(evt);
            }
        });

        txt_NombreProducto.setEditable(false);
        txt_NombreProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_NombreProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_NombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_NombreProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreProductoKeyTyped(evt);
            }
        });

        LbCostoProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbCostoProducto.setText("Costo Producto: ");

        txt_Costo.setEditable(false);
        txt_Costo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_Costo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_Costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CostoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CostoKeyTyped(evt);
            }
        });

        LbCantidadProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbCantidadProducto.setText("Cantidad: ");

        txt_Cantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_Cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CantidadKeyTyped(evt);
            }
        });

        LbFormaPago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbFormaPago.setText("Codigo Pago:");

        LbFechaVencimiento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbFechaVencimiento.setText("Fecha Vencimiento :");

        txt_FechaVencimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_FechaVencimiento.setDateFormatString("dd/MM/yyyyy");

        LbEstatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbEstatus.setText("Estatus Orden:");

        txt_Estatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_Estatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_Estatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_EstatusKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_EstatusKeyTyped(evt);
            }
        });

        LbIdBodega.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbIdBodega.setText("Bodega Productos: ");

        txt_IdBodega.setEditable(false);
        txt_IdBodega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_IdBodega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_IdBodega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_IdBodegaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IdBodegaKeyTyped(evt);
            }
        });

        btnAgregarBodega.setText("Agregar");
        btnAgregarBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBodegaActionPerformed(evt);
            }
        });

        txt_CodigoPago.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_CodigoPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_CodigoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CodigoPagoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CodigoPagoKeyTyped(evt);
            }
        });

        btnAgregarPago.setText("Agregar");
        btnAgregarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPagoActionPerformed(evt);
            }
        });

        Lbfacturadetalle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lbfacturadetalle.setForeground(new java.awt.Color(0, 0, 153));
        Lbfacturadetalle.setText("Orden Compra Detalle");

        Lbfecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout PanelFacturaDatosLayout = new javax.swing.GroupLayout(PanelFacturaDatos);
        PanelFacturaDatos.setLayout(PanelFacturaDatosLayout);
        PanelFacturaDatosLayout.setHorizontalGroup(
            PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFacturaDatosLayout.createSequentialGroup()
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbfacturadetalle)
                    .addComponent(Lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelFacturaDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelFacturaDatosLayout.createSequentialGroup()
                        .addComponent(LbIdProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_IdProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarProveedor))
                    .addGroup(PanelFacturaDatosLayout.createSequentialGroup()
                        .addComponent(LbIdBodega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_IdBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarBodega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelFacturaDatosLayout.createSequentialGroup()
                        .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbFechaVencimiento)
                            .addComponent(LbEstatus))
                        .addGap(20, 20, 20)
                        .addComponent(txt_Estatus))
                    .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_FechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFacturaDatosLayout.createSequentialGroup()
                            .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LbFechaEmision)
                                .addComponent(LbFormaPago))
                            .addGap(18, 18, 18)
                            .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_FechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelFacturaDatosLayout.createSequentialGroup()
                                    .addComponent(txt_CodigoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAgregarPago)))))
                    .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFacturaDatosLayout.createSequentialGroup()
                            .addComponent(LbIdProducto)
                            .addGap(29, 29, 29)
                            .addComponent(txt_IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAgregarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFacturaDatosLayout.createSequentialGroup()
                            .addComponent(LbCostoProducto)
                            .addGap(18, 18, 18)
                            .addComponent(txt_Costo))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFacturaDatosLayout.createSequentialGroup()
                            .addComponent(LbCantidadProducto)
                            .addGap(18, 18, 18)
                            .addComponent(txt_Cantidad))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFacturaDatosLayout.createSequentialGroup()
                            .addComponent(LbNombreProducto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_NombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        PanelFacturaDatosLayout.setVerticalGroup(
            PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFacturaDatosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbIdProveedor)
                    .addComponent(txt_IdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProveedor))
                .addGap(24, 24, 24)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbIdBodega)
                    .addComponent(txt_IdBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarBodega))
                .addGap(18, 18, 18)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbFechaEmision)
                    .addComponent(txt_FechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbFormaPago)
                    .addComponent(txt_CodigoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPago))
                .addGap(18, 18, 18)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbFechaVencimiento)
                    .addComponent(txt_FechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbEstatus)
                    .addComponent(txt_Estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbfacturadetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbIdProducto)
                    .addComponent(txt_IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbNombreProducto)
                    .addComponent(txt_NombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCostoProducto)
                    .addComponent(txt_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFacturaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCantidadProducto)
                    .addComponent(txt_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(Lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanleFacturaDetalles.setBackground(new java.awt.Color(255, 255, 255));
        PanleFacturaDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden Compra Enzabezado"));
        PanleFacturaDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TablaFacturaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaFacturaDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaFacturaDetalleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaFacturaDetalle);

        TablaFacturaEncabezado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaFacturaEncabezado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaFacturaEncabezadoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaFacturaEncabezado);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalKeyTyped(evt);
            }
        });

        LbSubtotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LbSubtotal.setText("SUB TOTAL:");

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        LbCorrelativo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        btnModificar1.setText("Modificar");
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        Lbfacturadetalle1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lbfacturadetalle1.setText("Orden Compra Detalle");

        txtTotal1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTotal1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTotal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotal1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotal1KeyTyped(evt);
            }
        });

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanleFacturaDetallesLayout = new javax.swing.GroupLayout(PanleFacturaDetalles);
        PanleFacturaDetalles.setLayout(PanleFacturaDetallesLayout);
        PanleFacturaDetallesLayout.setHorizontalGroup(
            PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanleFacturaDetallesLayout.createSequentialGroup()
                .addGroup(PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanleFacturaDetallesLayout.createSequentialGroup()
                        .addGroup(PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanleFacturaDetallesLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnGuardar1))
                            .addGroup(PanleFacturaDetallesLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)))
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar))
                    .addGroup(PanleFacturaDetallesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanleFacturaDetallesLayout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(LbCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(Lbfacturadetalle1)
                            .addGroup(PanleFacturaDetallesLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(btnModificar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar1)
                                .addGap(44, 44, 44)
                                .addComponent(LbSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanleFacturaDetallesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        PanleFacturaDetallesLayout.setVerticalGroup(
            PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanleFacturaDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbfacturadetalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar1)
                    .addComponent(btnModificar1)
                    .addComponent(btnGuardar1)
                    .addComponent(LbSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanleFacturaDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LbTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PanelFacturaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanleFacturaDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Lbtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LbNofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LbNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(388, 388, 388))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LbTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbNofactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanleFacturaDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelFacturaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IdProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdProveedorKeyPressed

    }//GEN-LAST:event_txt_IdProveedorKeyPressed

    private void txt_IdProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdProveedorKeyTyped

    }//GEN-LAST:event_txt_IdProveedorKeyTyped

    private void txt_IdProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdProductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdProductoKeyPressed

    private void txt_IdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdProductoKeyTyped

    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
        // TODO add your handling code here:
        ListadoProductos pro = new ListadoProductos();
        MDIComercial.jdpescritorio.add(pro);
        pro.toFront();
        pro.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductosActionPerformed

    private void txt_NombreProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreProductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreProductoKeyPressed

    private void txt_NombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreProductoKeyTyped

    private void txt_CostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CostoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CostoKeyPressed

    private void txt_CostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CostoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CostoKeyTyped

    private void txt_CantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CantidadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CantidadKeyPressed

    private void txt_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CantidadKeyTyped

    private void txt_EstatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EstatusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EstatusKeyPressed

    private void txt_EstatusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EstatusKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EstatusKeyTyped

    private void txt_IdBodegaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdBodegaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdBodegaKeyPressed

    private void txt_IdBodegaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdBodegaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdBodegaKeyTyped

    private void btnAgregarBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBodegaActionPerformed
        // TODO add your handling code here:
        ListadoBodegas cli = new ListadoBodegas();
        MDIComercial.jdpescritorio.add(cli);
        cli.toFront();
        cli.setVisible(true);
    }//GEN-LAST:event_btnAgregarBodegaActionPerformed

    private void TablaFacturaDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaFacturaDetalleMouseClicked
        // TODO add your handling code here:
        int seleccionar = this.TablaFacturaDetalle.getSelectedRow();
        this.LbCorrelativo.setText(TablaFacturaDetalle.getValueAt(seleccionar, 0).toString());

        this.LbNofactura.setText(TablaFacturaDetalle.getValueAt(seleccionar, 1).toString());
        this.txt_IdProducto.setText(TablaFacturaDetalle.getValueAt(seleccionar, 2).toString());
        this.txt_IdBodega.setText(TablaFacturaDetalle.getValueAt(seleccionar, 3).toString());
        this.txt_Cantidad.setText(TablaFacturaDetalle.getValueAt(seleccionar, 4).toString());
        this.txt_Costo.setText(TablaFacturaDetalle.getValueAt(seleccionar, 5).toString());
        this.txtTotal.setText(TablaFacturaDetalle.getValueAt(seleccionar, 6).toString());
    }//GEN-LAST:event_TablaFacturaDetalleMouseClicked

    private void TablaFacturaEncabezadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaFacturaEncabezadoMouseClicked
        // TODO add your handling code here:
        int seleccionar = this.TablaFacturaEncabezado.getSelectedRow();
        this.LbNofactura.setText(TablaFacturaEncabezado.getValueAt(seleccionar, 0).toString());
        this.txt_IdBodega.setText(TablaFacturaEncabezado.getValueAt(seleccionar, 1).toString());
        this.txt_IdProveedor.setText(TablaFacturaEncabezado.getValueAt(seleccionar, 2).toString());

        try {
            fechaemision = formato.parse(TablaFacturaEncabezado.getValueAt(TablaFacturaEncabezado.getSelectedRow(), 3).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Proceso_OrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_FechaEmision.setDate(fechaemision);

        try {
            fechavencimiento = formato1.parse(TablaFacturaEncabezado.getValueAt(TablaFacturaEncabezado.getSelectedRow(), 4).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Proceso_OrdenCompra.class.getName()).log(Level.SEVERE, null, ex);

        }
        txt_FechaVencimiento.setDate(fechavencimiento);
        this.txt_CodigoPago.setText(TablaFacturaEncabezado.getValueAt(seleccionar, 5).toString());

        this.txt_Estatus.setText(TablaFacturaEncabezado.getValueAt(seleccionar, 6).toString());
    }//GEN-LAST:event_TablaFacturaEncabezadoMouseClicked
    private double redondear(double num) {
        return Math.rint(num * 100) / 100;
    }

    private void calTot() {
        double S = 0, tot;
        for (int i = 0; i < TablaFacturaDetalle.getRowCount(); i++) {
            S = S + Integer.parseInt(model.getValueAt(i, 6).toString());

        }
        S = redondear(S);
        //txt_subtotal.setText(String.valueOf(S));

        tot = S;
        tot = (int) redondear(tot);

//        txtTotall.setText(String.valueOf(tot));
    }

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        int numero1, numero2;
        int total2 = 0, total = 0;
        numero1 = Integer.parseInt(txt_Cantidad.getText());
        numero2 = Integer.parseInt(txt_Costo.getText());
        total = numero1 * numero2;
        txtTotal.setText(String.valueOf(total));

        OrdenCompraDetalleDAO emisionchequeDAO = new OrdenCompraDetalleDAO();
        OrdenCompraDetalle insertar = new OrdenCompraDetalle();

        insertar.setPK_Codigo_Ordencompra((int) Integer.parseInt(LbNofactura.getText()));
        insertar.setPK_codigo_producto(txt_IdProducto.getText());
        insertar.setPK_codigo_bodega(txt_IdBodega.getText());
        insertar.setCantidad_detalle(txt_Cantidad.getText());
        insertar.setCosto_detalle(txt_Costo.getText());
        insertar.setTotal_detalle((int) Integer.parseInt(txtTotal.getText()));
        
        emisionchequeDAO.insert(insertar);

        

     

        uno();

    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        OrdenCompraDAO proveedorDAO = new OrdenCompraDAO();
        OrdenCompra proveedorAEliminar = new OrdenCompra();
        proveedorAEliminar.setPK_codigo_ordencompra(Integer.parseInt(LbNofactura.getText()));
        proveedorDAO.delete(proveedorAEliminar);
        JOptionPane.showMessageDialog(null, "Registro Eliminado.");
        llenadoDeTablas();
        limpiar();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
         OrdenCompraDAO proveedorDAO = new  OrdenCompraDAO();
         OrdenCompra proveedorAActualizar = new  OrdenCompra();
        proveedorAActualizar.setPK_codigo_ordencompra(Integer.parseInt(LbNofactura.getText()));
        proveedorAActualizar.setPK_codigo_bodega(txt_IdBodega.getText());
        proveedorAActualizar.setCodigo_proveedor(txt_IdProveedor.getText());
        String Inicio = new SimpleDateFormat("yyyy/MM/dd").format(txt_FechaEmision.getDate());
        String Inicio1 = new SimpleDateFormat("yyyy/MM/dd").format(txt_FechaVencimiento.getDate());

        proveedorAActualizar.setFecha_emision(Inicio);
        proveedorAActualizar.setFecha_vencimiento(Inicio1);
        proveedorAActualizar.setCodigo_pago(txt_CodigoPago.getText());

        proveedorAActualizar.setEstatus_ordecompra(txt_Estatus.getText());

        proveedorDAO.update(proveedorAActualizar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");

        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        OrdenCompraDAO emisionchequeDAO = new OrdenCompraDAO();
        OrdenCompra insertar = new OrdenCompra();

        String Inicio = new SimpleDateFormat("yyyy/MM/dd").format(txt_FechaEmision.getDate());
        String Inicio1 = new SimpleDateFormat("yyyy/MM/dd").format(txt_FechaVencimiento.getDate());

        insertar.setPK_codigo_ordencompra((int) Integer.parseInt(LbNofactura.getText()));
        insertar.setPK_codigo_bodega(txt_IdBodega.getText());
        insertar.setCodigo_proveedor(txt_IdProveedor.getText());
        insertar.setFecha_emision(Inicio);
        insertar.setFecha_vencimiento(Inicio1);
        insertar.setCodigo_pago(txt_CodigoPago.getText());
        insertar.setEstatus_ordecompra(txt_Estatus.getText());

        emisionchequeDAO.insert(insertar);

        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyTyped

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
        OrdenCompraDetalleDAO proveedorDAO = new OrdenCompraDetalleDAO();
        OrdenCompraDetalle proveedorAEliminar = new OrdenCompraDetalle();
        proveedorAEliminar.setCorrelativo(Integer.parseInt(LbCorrelativo.getText()));
        proveedorDAO.delete(proveedorAEliminar);
        JOptionPane.showMessageDialog(null, "Registro Eliminado.");
        uno();
        limpiar1();
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        // TODO add your handling code here:
       OrdenCompraDetalleDAO proveedorDAO = new OrdenCompraDetalleDAO();
        OrdenCompraDetalle proveedorAActualizar = new OrdenCompraDetalle();
        proveedorAActualizar.setCorrelativo(Integer.parseInt(LbCorrelativo.getText()));
        proveedorAActualizar.setPK_Codigo_Ordencompra(Integer.parseInt(LbNofactura.getText()));
        proveedorAActualizar.setPK_codigo_producto(txt_IdProducto.getText());
        proveedorAActualizar.setPK_codigo_bodega(txt_IdBodega.getText());
        proveedorAActualizar.setCantidad_detalle(txt_Cantidad.getText());
        proveedorAActualizar.setCosto_detalle(txt_Costo.getText());
        proveedorAActualizar.setTotal_detalle(Integer.parseInt(txtTotal.getText()));

        proveedorDAO.update(proveedorAActualizar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");
        uno();
        limpiar1();
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void txt_CodigoPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodigoPagoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CodigoPagoKeyPressed

    private void txt_CodigoPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodigoPagoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CodigoPagoKeyTyped

    private void btnAgregarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPagoActionPerformed
        // TODO add your handling code here:
        MantenimientoFormaPago cli = new MantenimientoFormaPago();
        MDIComercial.jdpescritorio.add(cli);
        cli.toFront();
        cli.setVisible(true);
    }//GEN-LAST:event_btnAgregarPagoActionPerformed

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        // TODO add your handling code here:
        ListadoProveedor pro = new ListadoProveedor();
        MDIComercial.jdpescritorio.add(pro);
        pro.toFront();
        pro.setVisible(true);
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void txtTotal1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1KeyPressed

    private void txtTotal1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1KeyTyped

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtTotal1.setText("0");
        int ta=TablaFacturaDetalle.getRowCount();
        int c=0;
        do 
            try {
                int f=c++;
                int n1=Integer.parseInt(TablaFacturaDetalle.getValueAt(f,6).toString());
                String nu=txtTotal1.getText();
                int nu2=Integer.parseInt(nu);
                long re=n1+nu2;
                txtTotal1.setText(String.valueOf(re));
            }catch(Exception e){
            }
             while(c<ta);      
        
         BalanceSaldosProveedoresDAO BitacoraDAO = new BalanceSaldosProveedoresDAO();

        BalanceSaldosProveedores1 Insertar = new BalanceSaldosProveedores1();
        Insertar.setPK_codigo_proveedor((int) Integer.parseInt(LbNofactura.getText()));
        Insertar.setCodigo_documento(txt_IdProveedor.getText());
        Insertar.setTransaccion("OrdenCompra");
        String Inicio = new SimpleDateFormat("yyyy/MM/dd").format(txt_FechaEmision.getDate());
        String Inicio1 = new SimpleDateFormat("yyyy/MM/dd").format(txt_FechaVencimiento.getDate());
        Insertar.setFecha_emision(Inicio);
        Insertar.setFecha_atraso(Inicio1);
         calculardias(txt_FechaEmision,txt_FechaVencimiento);
        Insertar.setDiasvencidos(Lbfecha.getText());
        Insertar.setTotal_detalle(txtTotal1.getText());
      
        
        BitacoraDAO.insert(Insertar);
       
        
        limpiartotal();
    }//GEN-LAST:event_jButton1ActionPerformed
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbCantidadProducto;
    private javax.swing.JLabel LbCorrelativo;
    private javax.swing.JLabel LbCostoProducto;
    private javax.swing.JLabel LbEstatus;
    private javax.swing.JLabel LbFechaEmision;
    private javax.swing.JLabel LbFechaVencimiento;
    private javax.swing.JLabel LbFormaPago;
    private javax.swing.JLabel LbIdBodega;
    private javax.swing.JLabel LbIdProducto;
    private javax.swing.JLabel LbIdProveedor;
    private javax.swing.JLabel LbNIT;
    private javax.swing.JTextField LbNofactura;
    private javax.swing.JLabel LbNombreProducto;
    private javax.swing.JLabel LbSubtotal;
    private javax.swing.JLabel LbTITULO;
    private javax.swing.JLabel Lbfacturadetalle;
    private javax.swing.JLabel Lbfacturadetalle1;
    private javax.swing.JLabel Lbfecha;
    private javax.swing.JLabel Lbtitulo;
    private javax.swing.JPanel PanelFacturaDatos;
    private javax.swing.JPanel PanleFacturaDetalles;
    private javax.swing.JTable TablaFacturaDetalle;
    private javax.swing.JTable TablaFacturaEncabezado;
    private javax.swing.JButton btnAgregarBodega;
    private javax.swing.JButton btnAgregarPago;
    private javax.swing.JButton btnAgregarProductos;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtTotal1;
    public static javax.swing.JTextField txt_Cantidad;
    public static javax.swing.JTextField txt_CodigoPago;
    public static javax.swing.JTextField txt_Costo;
    public static javax.swing.JTextField txt_Estatus;
    private com.toedter.calendar.JDateChooser txt_FechaEmision;
    private com.toedter.calendar.JDateChooser txt_FechaVencimiento;
    public static javax.swing.JTextField txt_IdBodega;
    public static javax.swing.JTextField txt_IdProducto;
    public static javax.swing.JTextField txt_IdProveedor;
    public static javax.swing.JTextField txt_NombreProducto;
    // End of variables declaration//GEN-END:variables
}
