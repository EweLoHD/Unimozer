/*
    Unimozer
    Unimozer intends to be a universal modelizer for Java™. It allows the user
    to draw UML diagrams and generates the relative Java™ code automatically
    and vice-versa.

    Copyright (C) 2009  Bob Fisch
 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or any
    later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package lu.fisch.unimozer.dialogs;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import lu.fisch.unimozer.Ini;
import lu.fisch.unimozer.Unimozer;

/**
 *
 * @author robertfisch
 */
public class ReplaceDialog extends javax.swing.JDialog
{
    public boolean OK = false;

    public static ReplaceDialog showModal(Frame frame, String title)
    {
        ReplaceDialog ce = new ReplaceDialog(frame,title,true);
        ce.chkMatchCase.setSelected(Boolean.valueOf(Ini.get("replaceMatchCase", "true")));
        ce.setLocationRelativeTo(frame);
        ce.setVisible(true);
        return ce;
    }

    public boolean getMatchCase()
    {
        return chkMatchCase.isSelected();
    }

    public boolean getWholeWord()
    {
        return chkWholeWord.isSelected();
    }

    public String getWhat()
    {
        return edtWhat.getText();
    }

    public String getWith()
    {
        return edtWith.getText();
    }

   
    /** Creates new form ClassEditor */
    public ReplaceDialog() {
        initComponents();
        Unimozer.switchButtons(btnOK, btnCancel);
        this.pack();
    }

    
    public ReplaceDialog(Frame frame, String title, boolean modal)
    {
        super(frame,title, modal);
        initComponents();
        Unimozer.switchButtons(btnOK, btnCancel);
        this.pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioVisibility = new javax.swing.ButtonGroup();
        edtWhat = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edtWith = new javax.swing.JTextField();
        chkMatchCase = new javax.swing.JCheckBox();
        chkWholeWord = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find & Replace");
        setResizable(false);

        edtWhat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtWhatKeyPressed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel2.setText("Find What:");

        jLabel3.setText("Replace With:");

        edtWith.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtWithKeyPressed(evt);
            }
        });

        chkMatchCase.setText("Match Case");

        chkWholeWord.setText("Whole words only");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(edtWith, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .add(edtWhat, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(btnCancel)
                        .add(171, 171, 171)
                        .add(btnOK))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(chkMatchCase, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .add(chkWholeWord, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(81, 81, 81))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(edtWhat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(edtWith, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(chkMatchCase)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(chkWholeWord)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnOK)
                    .add(btnCancel))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOKActionPerformed
    {//GEN-HEADEREND:event_btnOKActionPerformed
        if(!getWhat().trim().equals(""))
        {
            OK = true;
            Ini.set("replaceMatchCase", Boolean.toString(chkMatchCase.isSelected()));
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelActionPerformed
    {//GEN-HEADEREND:event_btnCancelActionPerformed
        OK = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void edtWhatKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_edtWhatKeyPressed
    {//GEN-HEADEREND:event_edtWhatKeyPressed
		if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			OK=false;
			setVisible(false);
		}
		else if(evt.getKeyCode() == KeyEvent.VK_ENTER) // && (evt.isShiftDown() || evt.isControlDown()))
		{
			btnOKActionPerformed(null);
		}
    }//GEN-LAST:event_edtWhatKeyPressed

    private void edtWithKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_edtWithKeyPressed
    {//GEN-HEADEREND:event_edtWithKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtWithKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox chkMatchCase;
    private javax.swing.JCheckBox chkWholeWord;
    private javax.swing.JTextField edtWhat;
    private javax.swing.JTextField edtWith;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.ButtonGroup radioVisibility;
    // End of variables declaration//GEN-END:variables

}
