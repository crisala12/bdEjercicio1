
package bdejercicio1;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class ventanaper extends javax.swing.JFrame {
private Inventario inv; 
private boolean invBoolean;
private Utilidades utilidades = new Utilidades();
private persnoa p;
private Colocartabla t;
private personabd persona= new personabd();   
private DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
private Proveedoresbd proveedor= new Proveedoresbd();
private Controlador_Inventario inventario=new Controlador_Inventario();
private DefaultComboBoxModel modeloComboProveedor = new DefaultComboBoxModel();
private  ArrayList<Proveedores> per = new ArrayList<Proveedores>();
    public ventanaper() {
        t= new Colocartabla(persona.mostrarPersonasV());
        initComponents();
        mostrarTabla();
        limpiarCampos();
        llenarcombo();
        inventario.soloIngresarnumeros(textcodigo);
        colocarComboBoxProveedor();
        
    }
  
  void colocarComboBoxProveedor() {
        modeloComboProveedor.addElement("RUC");
        modeloComboProveedor.addElement("Social");
        modeloComboProveedor.addElement("Actividad");
        modeloComboProveedor.addElement("Nombre");
        modeloComboProveedor.addElement("Apellido");
        modeloComboProveedor.addElement("Teléfono");
        modeloComboProveedor.addElement("Correo");
    }  
 public void limpiarCampos() {
        TEXCEDU.setText("");
        textnom.setText("");
        texapelli.setText("");
        texdire.setText("");
        texcorre.setText("");
        textele.setText("");
    }
    private boolean datospersona(){
     if (TEXCEDU.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "En campo de cédula está vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
                    TEXCEDU.requestFocus();
                    return false;
                }

                if (!utilidades.validadorDeCedula(TEXCEDU.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "la cédula ingresada no es valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (textnom.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "El campo nombres no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    textnom.requestFocus();
                    return false;
                }
                if (texapelli.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "El campo apellidos no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    texapelli.requestFocus();
                    return false;
                }
                if (texdire.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "El campo dirección no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    texdire.requestFocus();
                    return false;
                }
                if (textele.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "El campo telefono no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    textele.requestFocus();
                    return false;
                }
                if (!utilidades.validarNumeros(textele.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Los datos ingresados en el telefono no son validos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    textele.requestFocus();
                    return false;
                }
                if (texcorre.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "El campo correo no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    texcorre.requestFocus();
                    return false;
                }

                if (!utilidades.validarCorreo(texcorre.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Los datos del correo son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    texcorre.requestFocus();
                    return false;
                }
          return true;  
          
}
    public void llenarcombo(){
    modeloCombo.addElement("Cédula");
    modeloCombo.addElement("Nombre");
    modeloCombo.addElement("Apellido");
    modeloCombo.addElement("Dirección");
    modeloCombo.addElement("Correo");
    modeloCombo.addElement("Teléfono");
}
  public void buscarPersona(String buscar){
      if (jcombo.getSelectedIndex() == 0) {
            tablaj.setModel(persona.mostrarPersonasPorDato("cedula", buscar));
        } else if (jcombo.getSelectedIndex() == 1) {
            tablaj.setModel(persona.mostrarPersonasPorDato("nombres", buscar));
        } else if (jcombo.getSelectedIndex() == 2) {
            tablaj.setModel(persona.mostrarPersonasPorDato("apellido", buscar));
        } else if (jcombo.getSelectedIndex() == 3) {
            tablaj.setModel(persona.mostrarPersonasPorDato("direccion", buscar));
        } else if (jcombo.getSelectedIndex() == 4) {
            tablaj.setModel(persona.mostrarPersonasPorDato("correo", buscar));
        } else if (jcombo.getSelectedIndex() == 5) {
            tablaj.setModel(persona.mostrarPersonasPorDato("telefono", buscar));
        }
      
  }
  void buscarInventario(String buscar) {
        if (combollenar.getSelectedIndex() == 0) {
            tablainventario.setModel(inventario.mostrarInventariopordato("codigo_Pro", buscar));
        } else if (combollenar.getSelectedIndex() == 1) {
            tablainventario.setModel(inventario.mostrarInventariopordato("descripcion", buscar));
        } 
    }
  void buscarProveedor(String buscar) {
        if (comboedi.getSelectedIndex() == 0) {
            tabla.setModel(proveedor.mostrarProveedorespordato("Ruc", buscar));
        } else if (comboedi.getSelectedIndex() == 1) {
            tabla.setModel(proveedor.mostrarProveedorespordato("razon_social", buscar));
        } else if (comboedi.getSelectedIndex() == 2) {
            tabla.setModel(proveedor.mostrarProveedorespordato("tipo_actividad", buscar));
        } else if (comboedi.getSelectedIndex() == 3) {
            tabla.setModel(proveedor.mostrarProveedorespordato("nombre_representante_legal", buscar));
        } else if (comboedi.getSelectedIndex() == 4) {
            tabla.setModel(proveedor.mostrarProveedorespordato("apellido_representante_legal", buscar));
        } else if (comboedi.getSelectedIndex() == 5) {
            tabla.setModel(proveedor.mostrarProveedorespordato("telefono", buscar));
        } else if (comboedi.getSelectedIndex() == 6) {
            tabla.setModel(proveedor.mostrarProveedorespordato("correo", buscar));
        }
    }
void mostrarTabla() {
        tabla.setModel(proveedor.mostrarProveedorespordato("idproveedores", ""));
        tablainventario.setModel(inventario.mostrarInventariopordato("idinventario",""));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TEXCEDU = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textnom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        texapelli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        texdire = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        texcorre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textele = new javax.swing.JTextField();
        jbguardar = new javax.swing.JButton();
        jbeli = new javax.swing.JButton();
        jbedi = new javax.swing.JButton();
        jbtra = new javax.swing.JButton();
        jcombo = new javax.swing.JComboBox<>();
        jtexto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaj = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        textruc = new javax.swing.JTextField();
        textrazon = new javax.swing.JTextField();
        texttipo = new javax.swing.JTextField();
        textnomre = new javax.swing.JTextField();
        textapellido = new javax.swing.JTextField();
        textcore = new javax.swing.JTextField();
        texttele = new javax.swing.JTextField();
        jbotonguardar = new javax.swing.JButton();
        jbotoneditar = new javax.swing.JButton();
        jbotoneliminar = new javax.swing.JButton();
        jbotontraer = new javax.swing.JButton();
        comboedi = new javax.swing.JComboBox<>();
        jbllenar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jbotonbuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        textcodigo = new javax.swing.JTextField();
        textpre = new javax.swing.JTextField();
        textventa = new javax.swing.JTextField();
        textdescr = new javax.swing.JTextField();
        textcantpr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        botonguardarin = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        botoneliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablainventario = new javax.swing.JTable();
        combollenar = new javax.swing.JComboBox<>();
        campol = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText(" REGISTRO DE PERSONAS");

        jBuscar.setText("BUSCAR");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("CEDULA:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("NOMBRE:");

        textnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textnomActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 255));
        jLabel4.setText("APELLIDO");

        jLabel5.setForeground(new java.awt.Color(0, 255, 153));
        jLabel5.setText("DIRECCION:");

        texdire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texdireActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("CORREO:");

        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("TELÉFONO:");

        jbguardar.setText("GUARDAR");
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });

        jbeli.setText("ELIMINAR");
        jbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeliActionPerformed(evt);
            }
        });

        jbedi.setText("EDITAR");
        jbedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbediActionPerformed(evt);
            }
        });

        jbtra.setText("TRAER");

        jcombo.setModel(modeloCombo);
        jcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboActionPerformed(evt);
            }
        });

        jtexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextoActionPerformed(evt);
            }
        });
        jtexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextoKeyReleased(evt);
            }
        });

        tablaj.setModel(t);
        jScrollPane1.setViewportView(tablaj);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addComponent(jBuscar)
                .addGap(219, 219, 219))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textele, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texcorre, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texdire, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TEXCEDU, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textnom, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texapelli, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jtexto, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jbguardar)
                                        .addGap(45, 45, 45)
                                        .addComponent(jbeli)
                                        .addGap(83, 83, 83)
                                        .addComponent(jbedi)
                                        .addGap(111, 111, 111)
                                        .addComponent(jbtra))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBuscar)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TEXCEDU, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(textnom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(texdire, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(texapelli, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textele, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbedi)
                            .addComponent(jbtra)
                            .addComponent(jbeli)
                            .addComponent(jbguardar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(texcorre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Personas", jPanel2);

        jLabel8.setText("REGISTRAR PROVEEDOR");

        jLabel9.setText("RUC:");

        jLabel10.setText("Razon Social:");

        jLabel11.setText("Tipo de Actividad:");

        jLabel12.setText("Nombre de Representante:");

        jLabel13.setText("Apellido de Representante:");

        jLabel14.setText("Telefono:");

        jLabel15.setText("Correo:");

        textruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textrucActionPerformed(evt);
            }
        });

        jbotonguardar.setText("Guardar");
        jbotonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotonguardarActionPerformed(evt);
            }
        });

        jbotoneditar.setText("Editar");

        jbotoneliminar.setText("Eliminar");

        jbotontraer.setText("Traer");

        comboedi.setModel(modeloComboProveedor);

        jbllenar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jbllenarKeyReleased(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabla);

        jbotonbuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbotonguardar))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textruc)
                        .addComponent(textrazon)
                        .addComponent(texttipo)
                        .addComponent(textnomre)
                        .addComponent(textapellido)
                        .addComponent(textcore)
                        .addComponent(texttele)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jbotoneditar)
                            .addGap(95, 95, 95)
                            .addComponent(jbotoneliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                            .addComponent(jbotontraer)
                            .addGap(47, 47, 47)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbllenar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbotonbuscar)
                .addGap(78, 78, 78))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textruc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbotonbuscar))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textrazon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(texttipo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textnomre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(texttele, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel15))
                    .addComponent(textcore, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbotonguardar)
                    .addComponent(jbotoneditar)
                    .addComponent(jbotoneliminar)
                    .addComponent(jbotontraer))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbllenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedores", jPanel3);

        jLabel16.setText("REGISTRAR INVENTARIO");

        jLabel17.setText("Codigo Producto");

        jLabel18.setText("Descripcion:");

        jLabel19.setText("Precios Compra:");

        jLabel20.setText("Precios Venta:");

        jLabel21.setText("Cantidad Productos");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonguardarin.setText("Guardar");
        botonguardarin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarinActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        botoneliminar.setText("Eliminar");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });

        tablainventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tablainventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablainventarioMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablainventario);

        combollenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo pro", "descripcion" }));
        combollenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combollenarActionPerformed(evt);
            }
        });

        campol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campolKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel20))
                                    .addComponent(botonguardarin)
                                    .addComponent(combollenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textdescr)
                                            .addComponent(textcantpr)
                                            .addComponent(textpre)
                                            .addComponent(textventa)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(174, 174, 174)
                                        .addComponent(editar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botoneliminar))))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(campol, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textdescr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel19))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(textpre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(textventa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(textcantpr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonguardarin)
                    .addComponent(editar)
                    .addComponent(botoneliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combollenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventarios", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed


        persnoa ps= new persnoa(TEXCEDU.getText(), textnom.getText(), texapelli.getText(), texdire.getText(), texcorre.getText(), textele.getText());
        persona.crearPersona(ps);
        limpiarCampos();
        
    }//GEN-LAST:event_jbguardarActionPerformed

    private void textnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textnomActionPerformed

    private void texdireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texdireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texdireActionPerformed

    private void jbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeliActionPerformed
     persona.eliminarPersona(TEXCEDU.getText());
            
        
    }//GEN-LAST:event_jbeliActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        if (textnom.getText().isEmpty()) {
            System.out.println("No hay ningún dato a buscar");
        } else if (persona.obtenerPersona(textnom.getText()) != null){
            p = new persnoa();
            p = persona.obtenerPersona(textnom.getText());
            TEXCEDU.setText(p.getCedula());
            textnom.setText(p.getNombre());
            texapelli.setText(p.getApellido());
            texdire.setText(p.getDireccion());
            texcorre.setText(p.getCorreo());
            textele.setText(p.getTelefono());
        } else {
            System.out.println("La persona buscada no se encuentra en la base de datos");
        }
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jbediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbediActionPerformed
        if (datospersona()){
            p = new persnoa(p.getIdPersona(),TEXCEDU.getText(), textnom.getText(), texapelli.getText(), texdire.getText(), textele.getText(),texcorre.getText() );
            persona.actualizarPersona(p);
          
        }

    }//GEN-LAST:event_jbediActionPerformed

    private void jcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboActionPerformed

    private void jtextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextoActionPerformed

    private void jtextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextoKeyReleased
        buscarPersona(jtexto.getText());
    }//GEN-LAST:event_jtextoKeyReleased

    private void textrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textrucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textrucActionPerformed

    private void jbotonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotonguardarActionPerformed
         Proveedores p= new Proveedores(textruc.getText(), textrazon.getText(), texttipo.getText(), textnomre.getText(), textapellido.getText(), texttele.getText(), textcore.getText());
         proveedor.ingresarproveedor(p);
         limpiarCampos();
         mostrarTabla();
    }//GEN-LAST:event_jbotonguardarActionPerformed

    private void jbllenarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbllenarKeyReleased
        buscarProveedor(jbllenar.getText());
    }//GEN-LAST:event_jbllenarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combollenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combollenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combollenarActionPerformed

    private void botonguardarinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarinActionPerformed
     Inventario p= new Inventario(textcodigo.getText(), textdescr.getText(), textpre.getText(), textventa.getText(), textcantpr.getText());
         inventario.ingresarinventario(p);
         limpiarCampos();
         mostrarTabla();        
    }//GEN-LAST:event_botonguardarinActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
      int fila = tablainventario.getSelectedRow();
        if (fila >= 0) {
            inventario.eliminarinventario(inv.getIdinventario());
            mostrarTabla();
        }  
    }//GEN-LAST:event_botoneliminarActionPerformed

    private void tablainventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablainventarioMouseClicked
        int fila = tablainventario.getSelectedRow();
        if (fila >= 0) {
            String id = tablainventario.getValueAt(fila, 0).toString();
            String codigo = tablainventario.getValueAt(fila, 1).toString();
            String descri = tablainventario.getValueAt(fila, 2).toString();
            String compra = tablainventario.getValueAt(fila, 3).toString();
            String venta = tablainventario.getValueAt(fila, 4).toString();
            String producto = tablainventario.getValueAt(fila, 5).toString();
            textcodigo.setText(codigo);
            textdescr.setText(descri);
            textpre.setText(compra);
            textventa.setText(venta);
            textcantpr.setText(producto);
            inv = new Inventario(Integer.parseInt(id), codigo, descri, compra, venta, producto);
            invBoolean = true;
        }
    }//GEN-LAST:event_tablainventarioMouseClicked

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
     if (invBoolean == true) {
            Inventario in = new Inventario(inv.getIdinventario(), textcodigo.getText(), textdescr.getText(), textpre.getText(), textventa.getText(), textcantpr.getText());
            inventario.actualizarInventario(in);
            mostrarTabla();
        }
    }//GEN-LAST:event_editarActionPerformed

    private void campolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campolKeyReleased
       buscarInventario(campol.getText()); 
    }//GEN-LAST:event_campolKeyReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TEXCEDU;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JButton botonguardarin;
    private javax.swing.JTextField campol;
    private javax.swing.JComboBox<String> comboedi;
    private javax.swing.JComboBox<String> combollenar;
    private javax.swing.JButton editar;
    private javax.swing.JButton jBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbedi;
    private javax.swing.JButton jbeli;
    private javax.swing.JButton jbguardar;
    private javax.swing.JTextField jbllenar;
    private javax.swing.JButton jbotonbuscar;
    private javax.swing.JButton jbotoneditar;
    private javax.swing.JButton jbotoneliminar;
    private javax.swing.JButton jbotonguardar;
    private javax.swing.JButton jbotontraer;
    private javax.swing.JButton jbtra;
    private javax.swing.JComboBox<String> jcombo;
    private javax.swing.JTextField jtexto;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablainventario;
    private javax.swing.JTable tablaj;
    private javax.swing.JTextField texapelli;
    private javax.swing.JTextField texcorre;
    private javax.swing.JTextField texdire;
    private javax.swing.JTextField textapellido;
    private javax.swing.JTextField textcantpr;
    private javax.swing.JTextField textcodigo;
    private javax.swing.JTextField textcore;
    private javax.swing.JTextField textdescr;
    private javax.swing.JTextField textele;
    private javax.swing.JTextField textnom;
    private javax.swing.JTextField textnomre;
    private javax.swing.JTextField textpre;
    private javax.swing.JTextField textrazon;
    private javax.swing.JTextField textruc;
    private javax.swing.JTextField texttele;
    private javax.swing.JTextField texttipo;
    private javax.swing.JTextField textventa;
    // End of variables declaration//GEN-END:variables
}
