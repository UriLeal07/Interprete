/*********************************************
 * @author Cortes
 ********************************************/

package Vista;

import Controlador.Interprete;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame
{
    private final JFileChooser selectorDeArchivo;
    private File dirActual;
    private long loggerEventID;
    private AboutFrame frmAbout;
    private final Interprete interprete;
    private final Grafo grafo;
    private final Lienzo lienzo;
    
    public MainFrame()
    {
        initComponents();
        
        setLocationRelativeTo(null);
        setTitle("Traductor");
        
        grafo = new Grafo();
        lienzo = new Lienzo(grafo);
        
        lienzo.setBounds(12, lyPane.getY()+20, lyPane.getWidth()-25, lyPane.getHeight()-40);
        grafo.setBounds(lienzo.getBounds());
        
        lyPane.add(lienzo, new Integer(0));
        
        selectorDeArchivo = new JFileChooser();
        selectorDeArchivo.setFileFilter(new FileNameExtensionFilter("Archivos de Texto", "txt"));
        selectorDeArchivo.setMultiSelectionEnabled(false);
        
        dirActual = null;
        
        loggerEventID = 0;
        
        frmAbout = null;
        interprete = new Interprete(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEditor = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        tbPaneActividad = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLogger = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        lyPane = new javax.swing.JLayeredPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        mItemNuevo = new javax.swing.JMenuItem();
        mItemAbrir = new javax.swing.JMenuItem();
        mItemGuardar = new javax.swing.JMenuItem();
        mItGuardarComo = new javax.swing.JMenuItem();
        mEjecutar = new javax.swing.JMenu();
        mItemInterpretar = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        mItemAcerca = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        txtEditor.setColumns(20);
        txtEditor.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        txtEditor.setRows(5);
        panelEditor.setViewportView(txtEditor);

        jScrollPane2.setBorder(null);

        txtErrores.setEditable(false);
        txtErrores.setColumns(20);
        txtErrores.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        txtErrores.setRows(5);
        jScrollPane2.setViewportView(txtErrores);

        tbPaneActividad.addTab(" Errores ", new javax.swing.ImageIcon(getClass().getResource("/Icons/error.png")), jScrollPane2); // NOI18N

        txtLogger.setEditable(false);
        txtLogger.setColumns(20);
        txtLogger.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        txtLogger.setRows(5);
        jScrollPane3.setViewportView(txtLogger);

        tbPaneActividad.addTab(" Logger ", new javax.swing.ImageIcon(getClass().getResource("/Icons/logger.png")), jScrollPane3); // NOI18N

        txtOutput.setEditable(false);
        txtOutput.setColumns(20);
        txtOutput.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        tbPaneActividad.addTab(" Output ", new javax.swing.ImageIcon(getClass().getResource("/Icons/output.png")), jScrollPane1); // NOI18N

        lyPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Interpretación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        javax.swing.GroupLayout lyPaneLayout = new javax.swing.GroupLayout(lyPane);
        lyPane.setLayout(lyPaneLayout);
        lyPaneLayout.setHorizontalGroup(
            lyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        lyPaneLayout.setVerticalGroup(
            lyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mArchivo.setText("Archivo");

        mItemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mItemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/new.png"))); // NOI18N
        mItemNuevo.setText("Nuevo");
        mItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemNuevoActionPerformed(evt);
            }
        });
        mArchivo.add(mItemNuevo);

        mItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mItemAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/open.png"))); // NOI18N
        mItemAbrir.setText("Abrir");
        mItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemAbrirActionPerformed(evt);
            }
        });
        mArchivo.add(mItemAbrir);

        mItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mItemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save.png"))); // NOI18N
        mItemGuardar.setText("Guardar");
        mItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemGuardarActionPerformed(evt);
            }
        });
        mArchivo.add(mItemGuardar);

        mItGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mItGuardarComo.setText("Guardar como...");
        mItGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItGuardarComoActionPerformed(evt);
            }
        });
        mArchivo.add(mItGuardarComo);

        jMenuBar1.add(mArchivo);

        mEjecutar.setText("Ejecutar");

        mItemInterpretar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mItemInterpretar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/interpret.png"))); // NOI18N
        mItemInterpretar.setText("Interpretar");
        mItemInterpretar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemInterpretarActionPerformed(evt);
            }
        });
        mEjecutar.add(mItemInterpretar);

        jMenuBar1.add(mEjecutar);

        mAyuda.setText("Ayuda");

        mItemAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/about.png"))); // NOI18N
        mItemAcerca.setText("Acerca de");
        mItemAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemAcercaActionPerformed(evt);
            }
        });
        mAyuda.add(mItemAcerca);

        jMenuBar1.add(mAyuda);

        mSalir.setText("Salir");
        mSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(mSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbPaneActividad)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lyPane)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(lyPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbPaneActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mSalirMouseClicked

    private void mItemAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemAcercaActionPerformed
        frmAbout = new AboutFrame();
        frmAbout.setResizable(false);
        frmAbout.setLocationRelativeTo(this);
        frmAbout.setVisible(true);
    }//GEN-LAST:event_mItemAcercaActionPerformed

    private void mItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemGuardarActionPerformed

        if(dirActual == null)
        {
            saveAs();
        }
        
        else
        {
            save(dirActual);
        }
        
    }//GEN-LAST:event_mItemGuardarActionPerformed

    private void mItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemAbrirActionPerformed

        selectorDeArchivo.setDialogType(JFileChooser.OPEN_DIALOG);
        int res = selectorDeArchivo.showOpenDialog(MainFrame.this);
        
        if(res == JFileChooser.APPROVE_OPTION)
        {
            File archivo = selectorDeArchivo.getSelectedFile().getAbsoluteFile();
            
            if(archivo.getName().endsWith("txt"))
            {
                try (BufferedReader reader = Files.newBufferedReader(archivo.toPath()))
                {
                    txtEditor.setText("");
                    
                    String line = null;
                    String texto = "";
                    
                    while ((line = reader.readLine()) != null)
                        texto += line+"\n";
                    
                    // Guardamos referencia al archivo cargado en programa
                    dirActual = archivo;
                    // Ponemos el noombre en el marco del editor
                    panelEditor.setBorder(BorderFactory.createTitledBorder("\""+archivo.getName()+"\""));
                    // Limpiamos editores y salida de texto
                    clearWorkspace();
                    // Acomodamos el texto en el editor adecuadamente
                    txtEditor.setText(texto.substring(0, texto.length()-1));
                    txtLogger.append((++loggerEventID)+".- Lectura de archivo \""+archivo.getName()+"\"\n");
                    
                    JOptionPane.showMessageDialog(null,
                                          "Archivo leído exitosamente",
                                          "Lectura de archivo", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (IOException x) { errorArchivo(); }
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,
                                          "Solo se admiten archivos .txt",
                                          "Error de compatibilidad", JOptionPane.ERROR_MESSAGE);
                
                txtLogger.append((++loggerEventID)+".- Error de formato de archivo\n");
            }
        }
        
        if(res == JFileChooser.ERROR_OPTION)
            errorArchivo();
        
    }//GEN-LAST:event_mItemAbrirActionPerformed

    private void mItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemNuevoActionPerformed
        
        panelEditor.setBorder(BorderFactory.createTitledBorder("Editor"));
        dirActual = null;
        grafo.limpiar(lienzo);
        clearWorkspace();
        txtLogger.append((++loggerEventID)+".- Archivo nuevo creado\n");
        
    }//GEN-LAST:event_mItemNuevoActionPerformed

    private void mItGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItGuardarComoActionPerformed
        
        saveAs();
        
    }//GEN-LAST:event_mItGuardarComoActionPerformed

    private void mItemInterpretarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemInterpretarActionPerformed
        
        if(!isEditorEmpty())
        {
            grafo.reset();
            txtErrores.setText("");
            txtOutput.setText("");
            txtLogger.append((++loggerEventID)+".- Interpretando archivo fuente...\n");
            interprete.interpretar(txtEditor.getText());
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                                          "No hay texto a traducir",
                                          "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            
            txtLogger.append((++loggerEventID)+".- Archivo no traducido\n");
        }
    }//GEN-LAST:event_mItemInterpretarActionPerformed

    public void finish(boolean err)
    {
        if(err)
        {
            JOptionPane.showMessageDialog(null,
                        "Traducción terminada sin errores",
                        "Traduccion lista", JOptionPane.INFORMATION_MESSAGE);
            txtLogger.append((++loggerEventID)+".- Traduccion terminada exitosamente\n");
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                        "El código contiene errores",
                        "Error de Traduccion", JOptionPane.ERROR_MESSAGE);
            txtLogger.append((++loggerEventID)+".- Traduccion terminada con errores\n");
        }
    }
    
    private void clearWorkspace()
    {
        txtEditor.setText("");
        txtErrores.setText("");
        txtOutput.setText("");
    }
    
    private void saveAs()
    {
        if(!isEditorEmpty())
        {
            selectorDeArchivo.setDialogType(JFileChooser.SAVE_DIALOG);
            int res = selectorDeArchivo.showSaveDialog(MainFrame.this);
            
            if(res == JFileChooser.APPROVE_OPTION)
            {
                save(selectorDeArchivo.getSelectedFile().getAbsoluteFile());
            }
            
            if(res == JFileChooser.ERROR_OPTION)
                errorArchivo();
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,
                                          "El archivo a guardar está vacio",
                                          "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            txtLogger.append((++loggerEventID)+".- Archivo no guardado\n");
        }
    }
    
    private void errorArchivo()
    {
        txtLogger.append((++loggerEventID)+".- Error de lectura de archivo\n");
        
        JOptionPane.showMessageDialog(null,
                    "Ocurrio un problema al acceder al archivo",
                    "Error de Archivo", JOptionPane.ERROR_MESSAGE);
    }
    
    private boolean isEditorEmpty(){ return txtEditor.getText().trim().isEmpty(); }
    
    private void save(File archivo)
    {
        if(!archivo.getName().endsWith(".txt"))
        {
            txtLogger.append((++loggerEventID)+".- Error al guardar archivo\n");
                    
            JOptionPane.showMessageDialog(null,
                                          "Solo se admiten archivos .txt",
                                          "Error de compatibilidad", JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivo)))
            {
                String[] result = txtEditor.getText().split("\\n");

                for (String result1 : result)
                    pw.println(result1);

                pw.close();
                
                dirActual = archivo;
                
                panelEditor.setBorder(BorderFactory.createTitledBorder("\""+archivo.getName()+"\""));
                txtLogger.append((++loggerEventID)+".- Archivo \""+archivo.getName()+"\" guardado\n");
                
                JOptionPane.showMessageDialog(null,
                                              "Archivo guardado exitosamente",
                                              "Operación de Archivo", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException x) { errorArchivo(); }
        }
    }
    
    public JTextArea getTxtError(){ return txtErrores; }
    public JTextArea getTxtOutput(){ return txtOutput; }
    
    public void refresh(){ lienzo.repaint(); }
    
    public Grafo getGrafo() {return grafo;}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLayeredPane lyPane;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenu mEjecutar;
    private javax.swing.JMenuItem mItGuardarComo;
    private javax.swing.JMenuItem mItemAbrir;
    private javax.swing.JMenuItem mItemAcerca;
    private javax.swing.JMenuItem mItemGuardar;
    private javax.swing.JMenuItem mItemInterpretar;
    private javax.swing.JMenuItem mItemNuevo;
    private javax.swing.JMenu mSalir;
    private javax.swing.JScrollPane panelEditor;
    private javax.swing.JTabbedPane tbPaneActividad;
    private javax.swing.JTextArea txtEditor;
    private javax.swing.JTextArea txtErrores;
    private javax.swing.JTextArea txtLogger;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
}