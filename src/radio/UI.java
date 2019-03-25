/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;
import static java.lang.Thread.sleep;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrixito
 */
public class UI extends javax.swing.JFrame {
    
    Banda bandaAM;
    Banda bandaFM;
    Radio radio;

    /**
     * Creates new form NewJFrame
     */
    public UI() {
        initComponents();
        
        //1
        crearBandaAM();
        System.out.println("");
        //2
        crearBandaFM();
        System.out.println("");
        
        //3        
        MemoriaExterna memoriaSD = new MemoriaExterna(TipoMemoria.SD, null);
        System.out.println("Memoria SD creada:");
        System.out.println(memoriaSD.toString());
        System.out.println("");
        
        //4
        MemoriaExterna memoriaUSB = new MemoriaExterna(TipoMemoria.USB, null);
        System.out.println("Memoria USB creada:");
        System.out.println(memoriaUSB.toString());
        System.out.println("");
        
        //5
        Dispositivo cualquiera = new Dispositivo();
        System.out.println("Dispositivo creado:");
        System.out.println(cualquiera.toString());
        System.out.println("");
        
        //6
        radio = new Radio();
        System.out.println("Radio creado:");
        System.out.println(radio.toString());
        System.out.println("");
        
        //7
        List<MemoriaExterna> listaMemorias = new ArrayList<>();
        listaMemorias.add(memoriaUSB);
        listaMemorias.add(memoriaSD);
        radio.setMemoriasExternas(listaMemorias);
        System.out.println("Memorias incorporadas al radio:");
        System.out.println(radio.getMemoriasExternas().toString());
        System.out.println("");
        
        //8
        List<Dispositivo> listaDispositivos = new ArrayList<>();
        listaDispositivos.add(cualquiera);
        Bluetooth bluetooth = new Bluetooth();
        bluetooth.setDisVinculados(listaDispositivos);
        System.out.println("Bluetooth creado:");
        System.out.println(bluetooth.toString());
        System.out.println("Dispositivo vinculado al bluetooth:");
        System.out.println(bluetooth.getDisVinculados().toString());
        System.out.println("");
        
        //9
        System.out.println("Bluetooth incorporado al radio:");
        radio.setElBluetooth(bluetooth);
        System.out.println(radio.getElBluetooth().toString());
        System.out.println("");
        
        //10
        //Desde UI
        
        //11
        //Desde UI
        
        //12
        //Desde UI
        
        //13
        //Desde UI
        
        //14
        //Desde UI
        
        //15
        System.out.println("Dispositivos vinculados:");
        System.out.println(radio.getElBluetooth().getDisVinculados().toString());
        System.out.println("");
        
        //16
        //Desde UI
        
        //17
        System.out.println("Acceso a memoria SD habilitado");
        radio.setMemExtSeleccionada(memoriaSD);
        System.out.println("");
        
        //18
        System.out.println("Contenido de la memoria:");
        System.out.println(radio.getMemExtSeleccionada().getContenido());
        System.out.println("");
        
        //19
        //Desde UI
        
        radioPrint(radio.getEmisoraActual().toString());
        toggleRadio.setSelected(true);
        toggleBluetooth.setSelected(false);
        toggleFM.setSelected(true);
              
                
    }
    
    public void scanFM()
    {
        
            Thread hilo = new Thread() {
                public void run() {
                    try {
                        while(!radio.isDetenerse())
                        {
                        if(radio.getBandaActual() == TipoBanda.AM)
                        {
                            siguienteAM();
                        }
                        else
                        {
                            siguienteFM();
                        }

                        Thread.sleep(1500);
                        
                        }
                        
                    } catch (InterruptedException v) {
                        System.out.println(v);
                    }
                }
            };

            hilo.start();
        
    }
    
    public void siguienteFM()
    {
        Emisora tempEmisora = radio.getEmisoraActual();
        float tempFloat = tempEmisora.getFrecuencia();
        if(Float.compare(tempFloat, 107.9f) == 1)
        {
            radio.setEmisoraActual(new Emisora(88.1f, ""));
            radioPrint(radio.getEmisoraActual().toString());
        }
        else
        {
            
            radio.setEmisoraActual(new Emisora(tempFloat + 0.2f, ""));
            radioPrint(radio.getEmisoraActual().toString());
        }
    }
    
    public void siguienteAM()
    {
        Emisora tempEmisora = radio.getEmisoraActual();
        float tempFloat = tempEmisora.getFrecuencia();
        if(Float.compare(tempFloat, 1630f) == 1)
        {
            radio.setEmisoraActual(new Emisora(540f, ""));
            radioPrint(radio.getEmisoraActual().toString());
        }
        else
        {
            
            radio.setEmisoraActual(new Emisora(tempFloat + 10f, ""));
            radioPrint(radio.getEmisoraActual().toString());
        }
    }
    
    public void anteriorFM()
    {
        Emisora tempEmisora = radio.getEmisoraActual();
        float tempFloat = tempEmisora.getFrecuencia();
        if(Float.compare(tempFloat, 88.1f) != 1)
        {
            radio.setEmisoraActual(new Emisora(108.1f, ""));
            radioPrint(radio.getEmisoraActual().toString());
        }
        else
        {
            ;
            radio.setEmisoraActual(new Emisora(tempFloat - 0.2f, ""));
            radioPrint(radio.getEmisoraActual().toString());
        }
    }
    
    public void anteriorAM()
    {
        Emisora tempEmisora = radio.getEmisoraActual();
        float tempFloat = tempEmisora.getFrecuencia();
        if(Float.compare(tempFloat, 550f) != 1)
        {
            radio.setEmisoraActual(new Emisora(1640f, ""));
            radioPrint(radio.getEmisoraActual().toString());
        }
        else
        {
            ;
            radio.setEmisoraActual(new Emisora(tempFloat - 10f, ""));
            radioPrint(radio.getEmisoraActual().toString());
        }
    }
    
    public void crearBandaAM()
    {
        // 540 to 1600 kHz
        List<Emisora> listaFrecuencia = new ArrayList<>();
        float frecuencia = 540;
        while(frecuencia != 1610)
        {
            Emisora tempEmisora = new Emisora(frecuencia, "");
            listaFrecuencia.add(tempEmisora);
            frecuencia = frecuencia + 10;
        }
        bandaAM = new Banda(TipoBanda.AM, listaFrecuencia); 
        System.out.println(bandaAM);
    }
    
    public void crearBandaFM()
    {
        List<Emisora> listaFrecuencia = new ArrayList<>();
        float frecuencia = 88.1f;
        while(Float.compare(frecuencia, 108.3f) != 1)
        {
            Emisora tempEmisora = new Emisora(frecuencia, "");
            listaFrecuencia.add(tempEmisora);
            frecuencia = frecuencia + 0.2f;
        }
        bandaFM = new Banda(TipoBanda.FM, listaFrecuencia);
        System.out.println(bandaFM);
    }
    
    public void radioPrint(String print)
    {
        radioText.setText(print);
    }
    
    public void textBoxPrint(String print)
    {
        radioTextBox.setText(print);
    }
    
    public void deseleccionarFavoritos()
    {
        fav1.setSelected(false);
        fav2.setSelected(false);
        fav3.setSelected(false);
        fav4.setSelected(false);
        fav5.setSelected(false);
        fav6.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        bAtras = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        radioText = new javax.swing.JTextArea();
        jSlider1 = new javax.swing.JSlider();
        jButton5 = new javax.swing.JButton();
        toggleAM = new javax.swing.JToggleButton();
        toggleFM = new javax.swing.JToggleButton();
        toggleRadio = new javax.swing.JToggleButton();
        toggleUSB = new javax.swing.JToggleButton();
        toggleBluetooth = new javax.swing.JToggleButton();
        radioTextBox = new javax.swing.JTextField();
        bPair = new javax.swing.JButton();
        bEncendido = new javax.swing.JButton();
        fav1 = new javax.swing.JToggleButton();
        fav2 = new javax.swing.JToggleButton();
        fav4 = new javax.swing.JToggleButton();
        fav3 = new javax.swing.JToggleButton();
        fav6 = new javax.swing.JToggleButton();
        fav5 = new javax.swing.JToggleButton();
        favSiguiente = new javax.swing.JButton();
        favAtras = new javax.swing.JButton();
        bScan = new javax.swing.JButton();
        bFavorite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Radio"); // NOI18N
        setPreferredSize(new java.awt.Dimension(640, 360));
        setResizable(false);

        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radio/media/previous.png"))); // NOI18N
        bAtras.setPreferredSize(new java.awt.Dimension(50, 50));
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        bSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radio/media/next.png"))); // NOI18N
        bSiguiente.setToolTipText("");
        bSiguiente.setPreferredSize(new java.awt.Dimension(50, 50));
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        radioText.setColumns(20);
        radioText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        radioText.setRows(1);
        radioText.setText("test");
        jScrollPane1.setViewportView(radioText);

        jSlider1.setValue(0);
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radio/media/play.png"))); // NOI18N
        jButton5.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        toggleAM.setText("AM");
        toggleAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleAMActionPerformed(evt);
            }
        });

        toggleFM.setText("FM");
        toggleFM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleFMActionPerformed(evt);
            }
        });

        toggleRadio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radio/media/radio.png"))); // NOI18N
        toggleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleRadioActionPerformed(evt);
            }
        });

        toggleUSB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radio/media/usb.png"))); // NOI18N
        toggleUSB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleUSBActionPerformed(evt);
            }
        });

        toggleBluetooth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radio/media/bluetooth.png"))); // NOI18N
        toggleBluetooth.setSelected(true);
        toggleBluetooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleBluetoothActionPerformed(evt);
            }
        });

        radioTextBox.setText("Modo RADIO");

        bPair.setText("Pair");
        bPair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPairActionPerformed(evt);
            }
        });

        bEncendido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radio/media/on.png"))); // NOI18N
        bEncendido.setToolTipText("");
        bEncendido.setPreferredSize(new java.awt.Dimension(45, 45));
        bEncendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEncendidoActionPerformed(evt);
            }
        });

        fav1.setText("1");
        fav1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fav1ActionPerformed(evt);
            }
        });

        fav2.setText("2");
        fav2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fav2ActionPerformed(evt);
            }
        });

        fav4.setText("4");
        fav4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fav4ActionPerformed(evt);
            }
        });

        fav3.setText("3");
        fav3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fav3ActionPerformed(evt);
            }
        });

        fav6.setText("6");
        fav6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fav6ActionPerformed(evt);
            }
        });

        fav5.setText("5");
        fav5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fav5ActionPerformed(evt);
            }
        });

        favSiguiente.setText(">");
        favSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favSiguienteActionPerformed(evt);
            }
        });

        favAtras.setText("<");
        favAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favAtrasActionPerformed(evt);
            }
        });

        bScan.setText("Scan");
        bScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bScanActionPerformed(evt);
            }
        });

        bFavorite.setText("Favorite");
        bFavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFavoriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(toggleBluetooth)
                            .addComponent(toggleRadio)
                            .addComponent(toggleUSB)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bPair)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(radioTextBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggleAM)
                    .addComponent(toggleFM)
                    .addComponent(bEncendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bFavorite)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(favAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fav1))
                    .addComponent(bScan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fav2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fav3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fav4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fav5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fav6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(favSiguiente)
                        .addGap(115, 115, 115))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bEncendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(toggleAM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toggleFM))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toggleRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleBluetooth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleUSB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bPair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fav1)
                    .addComponent(fav2)
                    .addComponent(fav3)
                    .addComponent(fav4)
                    .addComponent(fav5)
                    .addComponent(fav6)
                    .addComponent(favSiguiente)
                    .addComponent(favAtras)
                    .addComponent(bFavorite))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(bScan)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(radio.isEncendido())
        {
            if (radio.getModo() == Modo.Radio) {
            radio.setDetenerse(true);
        } else if (radio.getModo() == Modo.Bluetooth) {
            radioPrint("Reproduciendo Bluetooth");
        } else if (radio.getModo() == Modo.USB) {
            radioPrint("Reproduciendo USB");
        }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void toggleAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleAMActionPerformed
        if(radio.isEncendido())
        {
        toggleAM.setSelected(true);
        toggleFM.setSelected(false);
        radio.setBandaActual(TipoBanda.AM);
        radio.setEmisoraActual(new Emisora(540f, ""));
        radioPrint(radio.getEmisoraActual().toString());
        }
        else
        {
        toggleAM.setSelected(true);
        toggleFM.setSelected(false);
        radio.setBandaActual(TipoBanda.AM);
        }
    }//GEN-LAST:event_toggleAMActionPerformed

    private void toggleFMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleFMActionPerformed
        if(radio.isEncendido())
        {
        toggleAM.setSelected(false);
        toggleFM.setSelected(true);
        radio.setBandaActual(TipoBanda.FM);
        radio.setEmisoraActual(new Emisora(88.1f, ""));
        radioPrint(radio.getEmisoraActual().toString());
        }
        else
        {
        toggleAM.setSelected(false);
        toggleFM.setSelected(true);
        radio.setBandaActual(TipoBanda.FM);
        }
    }//GEN-LAST:event_toggleFMActionPerformed

    private void toggleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleRadioActionPerformed
        if(radio.isEncendido())
        {
        toggleRadio.setSelected(true);
        toggleBluetooth.setSelected(false);
        toggleUSB.setSelected(false);
        textBoxPrint("Modo RADIO");
        radio.setModo(Modo.Radio);
        
        toggleAM.setSelected(false);
        toggleFM.setSelected(true);
        radio.setBandaActual(TipoBanda.FM);
        radio.setEmisoraActual(new Emisora(88.1f, ""));
        radioPrint(radio.getEmisoraActual().toString());
        }
        else
        {
        toggleRadio.setSelected(true);
        toggleBluetooth.setSelected(false);
        toggleUSB.setSelected(false);        
        radio.setModo(Modo.Radio);
        }
        
    }//GEN-LAST:event_toggleRadioActionPerformed

    private void toggleUSBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleUSBActionPerformed
        if(radio.isEncendido())
        {
        toggleRadio.setSelected(false);
        toggleBluetooth.setSelected(false);
        toggleUSB.setSelected(true);
        textBoxPrint("Modo USB");
        radio.setModo(Modo.USB);
        radioPrint("");
        }
        else
        {
            toggleRadio.setSelected(false);
        toggleBluetooth.setSelected(false);
        toggleUSB.setSelected(true);
        radio.setModo(Modo.USB);
        }
    }//GEN-LAST:event_toggleUSBActionPerformed

    private void toggleBluetoothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleBluetoothActionPerformed
        if(radio.isEncendido())
        {
        toggleRadio.setSelected(false);
        toggleBluetooth.setSelected(true);
        toggleUSB.setSelected(false);
        radio.setModo(Modo.Bluetooth);
        textBoxPrint("Modo BLUETOOTH");
        radioPrint("");
        }
        else
        {
        toggleRadio.setSelected(false);
        toggleBluetooth.setSelected(true);
        toggleUSB.setSelected(false);
        radio.setModo(Modo.Bluetooth);
        }
    }//GEN-LAST:event_toggleBluetoothActionPerformed

    private void fav6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fav6ActionPerformed
        deseleccionarFavoritos();
        fav6.setSelected(true);
        getFavorita(6);
    }//GEN-LAST:event_fav6ActionPerformed

    public void getFavorita(int i)
    {
        if(radio.getModo() == Modo.Radio)
        {
            if(radio.getBandaActual() == TipoBanda.AM)
            {
                if(radio.getMemoriaAM().size() >= i)
                {
                    radio.setEmisoraActual(radio.getMemoriaAM().get(i-1));
                    radioPrint(radio.getEmisoraActual().toString());
                }
                else
                {
                    radioPrint("Emisora favorita " + i + " no existe.");
                }
            }
            else
            {
                if(radio.getMemoriaFM().size() >= i)
                {
                    radio.setEmisoraActual(radio.getMemoriaFM().get(i-1));
                    radioPrint(radio.getEmisoraActual().toString());
                }
                else
                {
                    radioPrint("Emisora favorita " + i + " no existe.");
                }
            }
        }
    }
    
    private void fav1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fav1ActionPerformed
        deseleccionarFavoritos();
        fav1.setSelected(true);
        getFavorita(1);
    }//GEN-LAST:event_fav1ActionPerformed

    private void fav2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fav2ActionPerformed
        deseleccionarFavoritos();
        fav2.setSelected(true);
        getFavorita(2);
    }//GEN-LAST:event_fav2ActionPerformed

    private void fav4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fav4ActionPerformed
        deseleccionarFavoritos();
        fav4.setSelected(true);
        getFavorita(4);
    }//GEN-LAST:event_fav4ActionPerformed

    private void fav3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fav3ActionPerformed
        deseleccionarFavoritos();
        fav3.setSelected(true);
        getFavorita(3);
    }//GEN-LAST:event_fav3ActionPerformed

    private void fav5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fav5ActionPerformed
        deseleccionarFavoritos();
        fav5.setSelected(true);
        getFavorita(5);
    }//GEN-LAST:event_fav5ActionPerformed

    private void bScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bScanActionPerformed
        if(radio.getModo() == Modo.Radio)
        {
            if(radio.isDetenerse())
        {   
            radio.setDetenerse(false);
            scanFM();
        }
        else
        {
            radio.setDetenerse(true);
        }
        }
    }//GEN-LAST:event_bScanActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        if(radio.getModo() == Modo.Radio)
        {
            if(radio.getBandaActual() == TipoBanda.AM)
        {
            siguienteAM();
        }
        else
            siguienteFM();
        }
        
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        if(radio.getModo() == Modo.Radio)
        {
            if(radio.getBandaActual() == TipoBanda.AM)
        {
            anteriorAM();
        }
        else
            anteriorFM();
        }
        
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bEncendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEncendidoActionPerformed
        radio.setDetenerse(true);
        if(radio.isEncendido())
        {
            textBoxPrint("");
            radioPrint("");
            radio.setEncendido(false);
        }
        else
        {
            radio.setEncendido(true);
            if (radio.getModo() == Modo.Radio) {
                toggleAM.setSelected(false);
                toggleFM.setSelected(true);
                textBoxPrint("Modo RADIO");
                radio.setBandaActual(TipoBanda.FM);
                radio.setEmisoraActual(new Emisora(88.1f, ""));
                radioPrint(radio.getEmisoraActual().toString());
            } else if (radio.getModo() == Modo.Bluetooth) {
                textBoxPrint("Modo BLUETOOTH");
                radioPrint("");
            } else if (radio.getModo() == Modo.USB) {
                textBoxPrint("Modo USB");
                radioPrint("");
            }
        }
    }//GEN-LAST:event_bEncendidoActionPerformed

    private void bPairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPairActionPerformed
        if(radio.getModo() == Modo.Bluetooth)
        {
            radioPrint("Nuevo dispositivo emparejado");
        }
    }//GEN-LAST:event_bPairActionPerformed

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
      
        radio.getElEqualizador().setVolumen(jSlider1.getValue());
        
    }//GEN-LAST:event_jSlider1MouseReleased

    private void favAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favAtrasActionPerformed
        if(radio.getModo() == Modo.Radio)
        {
            Thread hilo = new Thread() {
                public void run() {
                    try {
                        textBoxPrint("Favoritos 1");

                        Thread.sleep(1500);                                                
                        
                        if(radio.getModo() == Modo.Radio)
                        {
                            textBoxPrint("Modo RADIO");
                        }
                        
                    } catch (InterruptedException v) {
                        System.out.println(v);
                    }
                }
            };

            hilo.start();
            
        }
    }//GEN-LAST:event_favAtrasActionPerformed

    private void favSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favSiguienteActionPerformed
        if(radio.getModo() == Modo.Radio)
        {
            Thread hilo = new Thread() {
                public void run() {
                    try {
                        textBoxPrint("Favoritos 2");

                        Thread.sleep(1500);                                                
                        
                        if(radio.getModo() == Modo.Radio)
                        {
                            textBoxPrint("Modo RADIO");
                        }
                        
                        
                    } catch (InterruptedException v) {
                        System.out.println(v);
                    }
                }
            };

            hilo.start();
            
        }
    }//GEN-LAST:event_favSiguienteActionPerformed

    private void bFavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFavoriteActionPerformed
       if(radio.getModo() == Modo.Radio)
       {
           if(radio.getBandaActual() == TipoBanda.AM)
           {
               radio.agregarAM(radio.getEmisoraActual());
           }
           else
               radio.agregarFM(radio.getEmisoraActual());
       }
    }//GEN-LAST:event_bFavoriteActionPerformed

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bEncendido;
    private javax.swing.JButton bFavorite;
    private javax.swing.JButton bPair;
    private javax.swing.JButton bScan;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JToggleButton fav1;
    private javax.swing.JToggleButton fav2;
    private javax.swing.JToggleButton fav3;
    private javax.swing.JToggleButton fav4;
    private javax.swing.JToggleButton fav5;
    private javax.swing.JToggleButton fav6;
    private javax.swing.JButton favAtras;
    private javax.swing.JButton favSiguiente;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea radioText;
    private javax.swing.JTextField radioTextBox;
    private javax.swing.JToggleButton toggleAM;
    private javax.swing.JToggleButton toggleBluetooth;
    private javax.swing.JToggleButton toggleFM;
    private javax.swing.JToggleButton toggleRadio;
    private javax.swing.JToggleButton toggleUSB;
    // End of variables declaration//GEN-END:variables
}
