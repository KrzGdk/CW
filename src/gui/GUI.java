/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import browser.CwBrowser;
import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import cw.Crossword;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Krzysiek
 */
public class GUI extends javax.swing.JFrame{

    /**
     * Creates new form GUI
     */
    public GUI(){
        browser = new CwBrowser(".");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dbFileChooser = new javax.swing.JFileChooser();
        cwLoadFile = new javax.swing.JFileChooser();
        cwSaveFile = new javax.swing.JFileChooser();
        cwSaveToPdf = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        heightSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        widthSpinner = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        dbLookupButton = new javax.swing.JButton();
        dbPathField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        generateButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        solveButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                drawCrossword(g);
            }
        };

        dbFileChooser.setDialogTitle("Wczytyanie bazy haseł...");
        dbFileChooser.setFileFilter(new FileNameExtensionFilter("Pliki tekstowe (*.txt)", "txt"));
        dbFileChooser.setAcceptAllFileFilterUsed(false);

        cwLoadFile.setDialogTitle("Wczytaj krzyżówkę...");
        cwLoadFile.setFileFilter(new FileNameExtensionFilter("Pliki krzyżówki (*.cw)", "cw"));
        cwLoadFile.setAcceptAllFileFilterUsed(false);

        cwSaveFile.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        cwSaveFile.setApproveButtonText("Zapisz");
        cwSaveFile.setDialogTitle("Wskaż folder do zapisania krzyżówki...");
        cwSaveFile.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        cwSaveToPdf.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        cwSaveToPdf.setApproveButtonText("OK");
        cwSaveToPdf.setDialogTitle("Wybierz folder eksportu do PDF");
        cwSaveToPdf.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generator krzyżówek");
        setMinimumSize(new java.awt.Dimension(300, 400));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Wymiary"));
        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Wysokość");

        heightSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 4, 12, 1));
        heightSpinner.setName("height"); // NOI18N

        jLabel2.setText("Szerokość");

        widthSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 4, 13, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(widthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(heightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(widthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Słownik"));

        dbLookupButton.setText("Przeglądaj...");
        dbLookupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbLookupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dbPathField)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(dbLookupButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(dbPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dbLookupButton)
                .addGap(24, 24, 24))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Kontrola"));

        generateButton.setText("Generuj");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Zapisz");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Wczytaj");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        printButton.setText("Drukuj");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        solveButton.setText("Rozwiąż");
        solveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(generateButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(printButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(solveButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(loadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton)
                    .addComponent(solveButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(250, 250, 250));
        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.setToolTipText("");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 198, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        int height = (int) heightSpinner.getValue();
        int width = (int) widthSpinner.getValue();
        if(dbPathField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Wskaż plik bazy haseł", "Generuj krzyżówkę", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            currentCrossword = browser.generate(height, width, dbPathField.getText());
            currentCrossword.getBoardCopy().printBoard();
            solve = false;
            mainPanel.repaint();
        }
    }//GEN-LAST:event_generateButtonActionPerformed

    private void dbLookupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbLookupButtonActionPerformed
        int returnVal = dbFileChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = dbFileChooser.getSelectedFile();
            if(!file.exists()){
                JOptionPane.showMessageDialog(null, "Plik nie istnieje", "Błąd pliku", JOptionPane.ERROR_MESSAGE);
            }
            else if(!file.toString().endsWith(".txt")){
                JOptionPane.showMessageDialog(null, "Plik ze słownikiem powinien mieć rozszerzenie txt", "Błąd formatu pliku", JOptionPane.ERROR_MESSAGE);
            }
            else{
                dbPathField.setText(file.toString());
            }
        } else {
            System.out.println("Loading database cancelled by user.");
        }
    }//GEN-LAST:event_dbLookupButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(currentCrossword != null){
            int returnVal = cwSaveFile.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = cwSaveFile.getSelectedFile();
                browser.setDir(file.toString());
                browser.save(currentCrossword);
            } else {
                System.out.println("Saving crossword cancelled by user.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Najpierw wygeneruj krzyżówkę", "Zapisz krzyżówkę", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        int returnVal = cwLoadFile.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = cwLoadFile.getSelectedFile();
            if(!file.exists()){
                JOptionPane.showMessageDialog(null, "Plik nie istnieje", "Błąd pliku", JOptionPane.ERROR_MESSAGE);
            }
            else if(!file.toString().endsWith(".cw")){
                JOptionPane.showMessageDialog(null, "Plik krzyżówki powinien mieć rozszerzenie cw", "Błąd formatu pliku", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try {
                    currentCrossword = browser.load(file.toString());
                    solve = false;
                    mainPanel.repaint();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("Loading crossword cancelled by user.");
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void solveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solveButtonActionPerformed
        if(currentCrossword != null){
            solve = true;
            mainPanel.repaint();
        }
        else{
            JOptionPane.showMessageDialog(null, "Brak krzyżówki do rozwiązania", "Rozwiąż krzyżówkę", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_solveButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        if(currentCrossword != null){
            if(currentCrossword.getId() != 0){
                int returnVal = cwSaveFile.showOpenDialog(this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = cwSaveFile.getSelectedFile();
                    drawCrosswordToPdf(file.getPath() + File.separator + currentCrossword.getId());
                } else {
                    System.out.println("Exporting crossword cancelled by user.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Musisz zapisać krzyżówkę przed eksportowaniem", "Eksportuj krzyżówkę", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Najpierw wygeneruj krzyżówkę", "Eksportuj krzyżówkę", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_printButtonActionPerformed
    private void drawCrosswordToPdf(String filename){        
        Document document = new Document();
        float PDFwidth = PageSize.A4.getWidth();
        float PDFheight = PageSize.A4.getHeight();
        
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
            
            document.setMargins(10, 0, (float)(currentCrossword.getBoardCopy().getHeight()+1)*cellSize, 0);
            document.open();
            
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(PDFwidth, PDFheight);
            Graphics2D g2 = new PdfGraphics2D(template, PDFwidth, PDFheight);
            int PDFmarginLeft = (int) PageSize.A4.getWidth()/2 - currentCrossword.getBoardCopy().getWidth()*cellSize/2;
            drawBoard(g2,PDFmarginLeft,marginTop);
            for(int i=1;i<currentCrossword.numOfEntries();i++){
                BaseFont times = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1250,BaseFont.EMBEDDED);
                Font font=new Font(times,10);
                String line=i + ". " + currentCrossword.getEntries().get(i).getClue();
                Paragraph para = new Paragraph(line,font);
                document.add(para);
            }
            g2.dispose();
            contentByte.addTemplate(template, 0, 0);
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        finally{
            if(document.isOpen()){
                document.close();
            }
        }
    }
    private void drawCrossword(Graphics g){
        if(currentCrossword != null){
            drawBoard(g, marginLeft, marginTop);
            drawClues(g, marginLeft+10+currentCrossword.getBoardCopy().getWidth()*cellSize, marginTop-10, cellSize);
        }
    }
    private void drawBoard(Graphics g, int marginL, int marginT){
        g.setColor(Color.BLACK);
        for(int i=0;i<currentCrossword.getBoardCopy().getHeight();i++){
            int delta = 0;
            boolean first = true;
            for(int j=0;j<currentCrossword.getBoardCopy().getWidth();j++){
                if(currentCrossword.getBoardCopy().getCell(i, j) != null){
                    if(first){ 
                        if(i<9) g.drawString((i+1) + ".", marginL-10+delta*cellSize, marginT+22+i*cellSize);
                        else g.drawString((i+1) + ".", marginL-18+delta*cellSize, marginT+22+i*cellSize);
                    }
                    g.drawRect(marginL+j*cellSize, marginT+i*cellSize, cellSize, cellSize);
                    if(solve) g.drawString(currentCrossword.getBoardCopy().getCell(i, j).getContent(), marginL+14+j*cellSize, marginT+23+i*cellSize);
                    first = false;
                }
                delta++;
            }
        }
        g.setColor(Color.RED);
        int sol = currentCrossword.getBoardCopy().getWidth() / 2;
        for(int j=0;j<currentCrossword.getBoardCopy().getHeight();j++){
            g.drawRect(marginL+sol*cellSize, marginT+j*cellSize, cellSize, cellSize);
        }
    }
    private void drawClues(Graphics g, int marginL, int marginT, int space){
        g.setColor(Color.BLACK);
        for(int i=1;i<currentCrossword.numOfEntries();i++){
            g.drawString((i) + "." + currentCrossword.getEntries().get(i).getClue(), marginL, marginT+i*space);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        * */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new GUI().setVisible(true);
            }
        });
    }
    
    private boolean solve = false;
    private Crossword currentCrossword = null;
    private CwBrowser browser;
    private final int cellSize = 35;
    private final int marginLeft = 20, marginTop = 10;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser cwLoadFile;
    private javax.swing.JFileChooser cwSaveFile;
    private javax.swing.JFileChooser cwSaveToPdf;
    private javax.swing.JFileChooser dbFileChooser;
    private javax.swing.JButton dbLookupButton;
    private javax.swing.JTextField dbPathField;
    private javax.swing.JButton generateButton;
    private javax.swing.JSpinner heightSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loadButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton solveButton;
    private javax.swing.JSpinner widthSpinner;
    // End of variables declaration//GEN-END:variables
}