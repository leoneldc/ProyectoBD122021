package vista;

import dominio.ProcesosRepetidos;
import dominio.ConsultaYRevisionLimpieza;
import dominio.Habitacion;
import datos.ConsultaYRevisionLimpiezaDAO;
import datos.GuardarBitacora;
import datos.HabitacionDAO;
import java.awt.Color;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;

/**
 *
 * @author Jefferson Dávila
 */
public class Prcs_SupervisionLimpieza extends javax.swing.JInternalFrame {

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    ConsultaYRevisionLimpieza consultaSupervision = new ConsultaYRevisionLimpieza();
    ConsultaYRevisionLimpiezaDAO cbxPiso = new ConsultaYRevisionLimpiezaDAO();
    ButtonGroup grupoDeRadios;
    GuardarBitacora bitacora = new GuardarBitacora();
    
    void habilitarAcciones() {

        var codigoAplicacion = 2211;
        var usuario = Login_LD.usuario;

        Btn_modificar.setVisible(false);
        Btn_buscar.setVisible(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[5];

        for (int i = 0; i < 5; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[1].equals("1")) {
            Btn_buscar.setVisible(true);
        }
        if (permisosApp[2].equals("1")) {
            Btn_modificar.setVisible(true);
        }
    }

    public Prcs_SupervisionLimpieza() {
        initComponents();
        diseño();
        grupoDeRadios = new ButtonGroup();
        grupoDeRadios.add(Rdb_Activo);
        grupoDeRadios.add(Rdb_Inactivo);
        grupoDeRadios.add(Rdb_Limpiar2);
        Rdb_Limpiar2.setVisible(false);
        habilitarAcciones();
    }

    public void diseño() {
        this.setTitle("Supervisión de Limpieza");
        Txt_buscar.setBorder(null);
        Txt_habitacion.setBorder(null);
        prcs_repetidos.Cursor(Btn_buscar);
        ImageIcon icono = new ImageIcon("src/main/java/assets/pisos.png");
        this.setFrameIcon(icono);
    }

    public void actualizarTabla(String codigo) {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        ConsultaYRevisionLimpiezaDAO.codigoAuxiliar = codigo;
        String columnas[] = {"NO. PISO", "NO. HABIRACION", "ESTADO LIMPIEZA", "ID HORARIO"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {50, 50, 50, 50};
        ConsultaYRevisionLimpiezaDAO gobernantadao = new ConsultaYRevisionLimpiezaDAO();
        List<ConsultaYRevisionLimpieza> gobernanta = gobernantadao.selectAsignacionesGobernanta();
        for (ConsultaYRevisionLimpieza listaServicio : gobernanta) {
            datos[0] = String.valueOf(listaServicio.getPisoAsigGob());
            datos[1] = String.valueOf(listaServicio.getHabitacionAsigGob());
            if (String.valueOf(listaServicio.getLimpiezaAsigGob()).equals("1")) {
                datos[2] = "Limpia";
            } else if (String.valueOf(listaServicio.getLimpiezaAsigGob()).equals("2")) {
                datos[2] = "Sucia";
            }
            datos[3] = String.valueOf(listaServicio.getHorarioAsigGob());

            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Datos);
        }
    }

    public void actualizarTabla2(String codigo) {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        ConsultaYRevisionLimpiezaDAO.codigoAuxiliar = codigo;
        String columnas[] = {"NO. HABITACION", "ESTADO HABITACION", "ESTADO LIMPIEZA", "TIPO"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Datos2);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {50, 50, 50, 50};
        ConsultaYRevisionLimpiezaDAO gobernantadao = new ConsultaYRevisionLimpiezaDAO();
        List<ConsultaYRevisionLimpieza> gobernanta = gobernantadao.selectHabitacionesGobernanta();
        for (ConsultaYRevisionLimpieza listaServicio : gobernanta) {
            datos[0] = String.valueOf(listaServicio.getHabitacionHabGob());
            if (String.valueOf(listaServicio.getEstadoHabGob()).equals("1")) {
                datos[1] = "Activa";
            } else if (String.valueOf(listaServicio.getEstadoHabGob()).equals("0")) {
                datos[1] = "Inactiva";
            }
            if (String.valueOf(listaServicio.getLimpiezaHabGob()).equals("1")) {
                datos[2] = "Limpia";
            } else if (String.valueOf(listaServicio.getLimpiezaHabGob()).equals("2")) {
                datos[2] = "Sucia";
            }
            if (String.valueOf(listaServicio.getTipoHabGob()).equals("1")) {
                datos[3] = "Familiar";
            } else if (String.valueOf(listaServicio.getTipoHabGob()).equals("2")) {
                datos[3] = "Individual";
            }
            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Datos2);
        }
    }

    public void Limpiar() {
        prcs_repetidos.Limpiar(Txt_buscar);
        prcs_repetidos.Limpiar(Txt_habitacion);
        Rdb_Limpiar2.setSelected(true);
    }
    
    public void Limpiar2() {
        prcs_repetidos.Limpiar(Txt_habitacion);
        Rdb_Limpiar2.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGp_tipo = new javax.swing.ButtonGroup();
        BtnGp_estado = new javax.swing.ButtonGroup();
        Pnl_datos = new javax.swing.JPanel();
        Lbl_codigoNombre = new javax.swing.JLabel();
        Txt_buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Datos = new javax.swing.JTable();
        Btn_fondo_buscar = new javax.swing.JPanel();
        Btn_buscar = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_Datos2 = new javax.swing.JTable();
        Lbl_codigoNombre1 = new javax.swing.JLabel();
        Lbl_codigoNombre2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Rdb_Activo = new javax.swing.JRadioButton();
        Rdb_Limpiar2 = new javax.swing.JRadioButton();
        Rdb_Inactivo = new javax.swing.JRadioButton();
        Txt_habitacion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Btn_fondo_modificar = new javax.swing.JPanel();
        Btn_modificar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(36, 47, 65));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        Pnl_datos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_codigoNombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_codigoNombre.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_codigoNombre.setText("ID Gobernanta:");

        Txt_buscar.setBackground(new java.awt.Color(36, 47, 65));
        Txt_buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt_buscar.setForeground(new java.awt.Color(255, 255, 255));
        Txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_DatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tbl_Datos);

        Btn_fondo_buscar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_buscar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_buscar.setText("Verificar");
        Btn_buscar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_buscar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_buscarLayout = new javax.swing.GroupLayout(Btn_fondo_buscar);
        Btn_fondo_buscar.setLayout(Btn_fondo_buscarLayout);
        Btn_fondo_buscarLayout.setHorizontalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        Btn_fondo_buscarLayout.setVerticalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        Tbl_Datos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tbl_Datos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_Datos2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Tbl_Datos2);

        Lbl_codigoNombre1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_codigoNombre1.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_codigoNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_codigoNombre1.setText("Datos de la Habitaciones");

        Lbl_codigoNombre2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_codigoNombre2.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_codigoNombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_codigoNombre2.setText("Asignaciones de la Gobernanta");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Habitación:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Limpieza:");

        Rdb_Activo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_Activo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_Activo.setText("Limpia");
        Rdb_Activo.setEnabled(false);

        Rdb_Limpiar2.setEnabled(false);

        Rdb_Inactivo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_Inactivo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_Inactivo.setText("Sucia");
        Rdb_Inactivo.setEnabled(false);

        Txt_habitacion.setBackground(new java.awt.Color(36, 47, 65));
        Txt_habitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt_habitacion.setForeground(new java.awt.Color(255, 255, 255));
        Txt_habitacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_habitacion.setEnabled(false);

        Btn_fondo_modificar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_modificar.setText("Confirmar");
        Btn_modificar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_modificar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_modificarLayout = new javax.swing.GroupLayout(Btn_fondo_modificar);
        Btn_fondo_modificar.setLayout(Btn_fondo_modificarLayout);
        Btn_fondo_modificarLayout.setHorizontalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Btn_fondo_modificarLayout.setVerticalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_datosLayout = new javax.swing.GroupLayout(Pnl_datos);
        Pnl_datos.setLayout(Pnl_datosLayout);
        Pnl_datosLayout.setHorizontalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_datosLayout.createSequentialGroup()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Pnl_datosLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_datosLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Lbl_codigoNombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(24, 24, 24)))
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Lbl_codigoNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator7)
                            .addComponent(Txt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_datosLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_datosLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)))
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Pnl_datosLayout.createSequentialGroup()
                                .addComponent(Rdb_Activo)
                                .addGap(18, 18, 18)
                                .addComponent(Rdb_Limpiar2)
                                .addGap(18, 18, 18)
                                .addComponent(Rdb_Inactivo))
                            .addComponent(Txt_habitacion)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Lbl_codigoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Pnl_datosLayout.setVerticalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_codigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_datosLayout.createSequentialGroup()
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Pnl_datosLayout.createSequentialGroup()
                                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2))
                                    .addComponent(Txt_habitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(Rdb_Activo))
                            .addComponent(Rdb_Limpiar2)
                            .addComponent(Rdb_Inactivo))
                        .addGap(34, 34, 34)))
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_codigoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_codigoNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondo_buscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondo_buscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void Tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_DatosMouseClicked
        if (evt.getClickCount() == 2) {
            Txt_habitacion.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 1).toString());
            if (Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 2).toString().equals("Limpia")) {
                Rdb_Activo.setSelected(true);
            } else {
                Rdb_Inactivo.setSelected(true);
            }
        }
    }//GEN-LAST:event_Tbl_DatosMouseClicked

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
        actualizarTabla(Txt_buscar.getText());
        actualizarTabla2(Txt_buscar.getText());
        Rdb_Activo.setEnabled(true);
        Rdb_Inactivo.setEnabled(true);
        bitacora.GuardarEnBitacora("Buscar", "2211");
        
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Tbl_Datos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_Datos2MouseClicked

    }//GEN-LAST:event_Tbl_Datos2MouseClicked

    private void Btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseClicked
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        Habitacion habitacion = new Habitacion();

        habitacion.setId(Txt_habitacion.getText());
        if (Rdb_Activo.isSelected()) {
            habitacion.setLimpieza("1");
        } else if (Rdb_Inactivo.isSelected()) {
            habitacion.setLimpieza("2");
        }
        habitacionDAO.update2(habitacion);
        actualizarTabla(Txt_buscar.getText());
        actualizarTabla2(Txt_buscar.getText());
        prcs_repetidos.AlertaMensaje("confirmada", "Supervisión", "exitosamente");
        Limpiar2();
        bitacora.GuardarEnBitacora("Guardar", "2211");
    }//GEN-LAST:event_Btn_modificarMouseClicked

    private void Btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseEntered
        Btn_fondo_modificar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_modificarMouseEntered

    private void Btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseExited
        Btn_fondo_modificar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_modificarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGp_estado;
    private javax.swing.ButtonGroup BtnGp_tipo;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JPanel Btn_fondo_buscar;
    private javax.swing.JPanel Btn_fondo_modificar;
    private javax.swing.JLabel Btn_modificar;
    private javax.swing.JLabel Lbl_codigoNombre;
    private javax.swing.JLabel Lbl_codigoNombre1;
    private javax.swing.JLabel Lbl_codigoNombre2;
    private javax.swing.JPanel Pnl_datos;
    private javax.swing.JRadioButton Rdb_Activo;
    private javax.swing.JRadioButton Rdb_Inactivo;
    private javax.swing.JRadioButton Rdb_Limpiar2;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTable Tbl_Datos2;
    private javax.swing.JTextField Txt_buscar;
    private javax.swing.JTextField Txt_habitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
