/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import deepspace.HangarToUI;
import deepspace.WeaponToUI;
import deepspace.ShieldToUI;
import java.util.ArrayList;
import java.awt.Component;

/**
 *
 * @author JuanAntonio
 */
public class HangarView extends javax.swing.JPanel {
    
    private int nShields;
    private int nWeapons;
    
    public HangarView() {
        initComponents();
    }
    
    void setHangar(HangarToUI h){
        ArrayList<WeaponToUI> weapons=h.getWeapons();
        nWeapons=weapons.size();
        ArrayList<ShieldToUI> shields=h.getShieldBoosters();
        nShields=shields.size();
        int capacity=h.getMaxElements();
        panel.removeAll();
        ShieldBoosterView sbv;
        for (ShieldToUI sb:shields){
            sbv=new ShieldBoosterView();
            sbv.setShieldBooster(sb);
            panel.add(sbv);
        }
        WeaponView wv;
        for (WeaponToUI w:weapons){
            wv=new WeaponView();
            wv.setWeapon(w);
            panel.add(wv);
        }
        capacidad.setText("Capacidad: "+capacity+" lugares");
        repaint();
        revalidate();
    }
    
   ArrayList<Integer> getSelectedWeapons(){
        ArrayList<Integer> selectedWeapons=new ArrayList();
        int i=0;
        for(Component c:panel.getComponents()){
            if(((CombatElementView)c).isSelected() && ((CombatElementView)c).isWeapon()){
                selectedWeapons.add(i);
            }
            i++;
        }
        //AJUSTE DE LOS ÍNDICES
        for(int j=0;j<selectedWeapons.size();j++){
            Integer k=selectedWeapons.remove(0);
            selectedWeapons.add(k-nShields);
        }
        return selectedWeapons;
        
    }
   
    ArrayList<Integer> getSelectedShields(){
        ArrayList<Integer> selectedShields=new ArrayList();
        int i=0;
        for(Component c:panel.getComponents()){
            if(((CombatElementView)c).isSelected() && !((CombatElementView)c).isWeapon()){
                selectedShields.add(i);
            }
            i++;
        }
        return selectedShields;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        capacidad = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hangar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AR DESTINE", 0, 18))); // NOI18N

        scrollPane.setViewportView(panel);

        capacidad.setFont(new java.awt.Font("AR DESTINE", 0, 12)); // NOI18N
        capacidad.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(capacidad)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(capacidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel capacidad;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
