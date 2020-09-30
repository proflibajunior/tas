package br.edu.materdei.tas.desktop.dialog;

import br.edu.materdei.tas.desktop.MainFrame;
import br.edu.materdei.tas.desktop.exception.NotValidateException;
import br.edu.materdei.tas.desktop.gui.core.MonetarioDocument;
import br.edu.materdei.tas.desktop.gui.core.TasDialogError;
import br.edu.materdei.tas.desktop.service.BackendService;
import java.awt.Component;
import java.awt.Cursor;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import net.sf.json.JSONObject;


public class ProdutoDialog extends GenericDialogImpl {
    private JSONObject produto;
    private Object[] grupos;
    
    /**
     * Creates new form TasDialogConfirm
     * @param parent
     * @param produto
     */
    public ProdutoDialog(java.awt.Frame parent, JSONObject produto) {
        super(parent, true);
        
        this.mainframe = (MainFrame) parent;
        this.fieldsEmpty = new ArrayList<>();
        
        initComponents();
        
        //Carrega os grupos
        loadGrupos();
        
        //Faz com que seja mostrado no componente o atributo nome
        cbGrupo.setRenderer( new DefaultListCellRenderer(){

            @Override  
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

                if(value != null) {
                    JSONObject provedor = (JSONObject) value;
                    setText( provedor.getString("nome"));
                }
                return this;
            }
        });
                
        //Define o formatador do campo Preço
        tfPreco.setDocument(new MonetarioDocument());
        
        //
        setProduto(produto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        barraTitulo = new javax.swing.JPanel();
        divTop = new javax.swing.JPanel();
        plLeft = new javax.swing.JPanel();
        plRight = new javax.swing.JPanel();
        divBottom = new javax.swing.JPanel();
        container1 = new javax.swing.JPanel();
        close = new br.edu.materdei.tas.desktop.gui.titlebar.TasCloseButton();
        titulo = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        abaGeral = new javax.swing.JPanel();
        tfCodigo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        cbGrupo = new javax.swing.JComboBox();
        tfPreco = new javax.swing.JTextField();
        cbAtivo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        abaDescricao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        botoes = new javax.swing.JPanel();
        cancelar = new br.edu.materdei.tas.desktop.gui.core.TasDialogButton();
        salvar = new br.edu.materdei.tas.desktop.gui.core.TasDialogButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        container.setBackground(new java.awt.Color(246, 246, 246));
        container.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 64, 34)));
        container.setLayout(new java.awt.BorderLayout());

        barraTitulo.setOpaque(false);
        barraTitulo.setPreferredSize(new java.awt.Dimension(348, 34));
        barraTitulo.setLayout(new java.awt.BorderLayout());

        divTop.setOpaque(false);
        divTop.setPreferredSize(new java.awt.Dimension(10, 7));

        javax.swing.GroupLayout divTopLayout = new javax.swing.GroupLayout(divTop);
        divTop.setLayout(divTopLayout);
        divTopLayout.setHorizontalGroup(
            divTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        divTopLayout.setVerticalGroup(
            divTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        barraTitulo.add(divTop, java.awt.BorderLayout.NORTH);

        plLeft.setOpaque(false);
        plLeft.setPreferredSize(new java.awt.Dimension(5, 10));

        javax.swing.GroupLayout plLeftLayout = new javax.swing.GroupLayout(plLeft);
        plLeft.setLayout(plLeftLayout);
        plLeftLayout.setHorizontalGroup(
            plLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        plLeftLayout.setVerticalGroup(
            plLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        barraTitulo.add(plLeft, java.awt.BorderLayout.WEST);

        plRight.setOpaque(false);
        plRight.setPreferredSize(new java.awt.Dimension(5, 10));

        javax.swing.GroupLayout plRightLayout = new javax.swing.GroupLayout(plRight);
        plRight.setLayout(plRightLayout);
        plRightLayout.setHorizontalGroup(
            plRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        plRightLayout.setVerticalGroup(
            plRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        barraTitulo.add(plRight, java.awt.BorderLayout.EAST);

        divBottom.setOpaque(false);
        divBottom.setPreferredSize(new java.awt.Dimension(10, 6));

        javax.swing.GroupLayout divBottomLayout = new javax.swing.GroupLayout(divBottom);
        divBottom.setLayout(divBottomLayout);
        divBottomLayout.setHorizontalGroup(
            divBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        divBottomLayout.setVerticalGroup(
            divBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        barraTitulo.add(divBottom, java.awt.BorderLayout.SOUTH);

        container1.setOpaque(false);
        container1.setPreferredSize(new java.awt.Dimension(277, 21));
        container1.setLayout(new java.awt.BorderLayout());

        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeMousePressed(evt);
            }
        });
        container1.add(close, java.awt.BorderLayout.EAST);

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastro de Produto");
        container1.add(titulo, java.awt.BorderLayout.CENTER);

        barraTitulo.add(container1, java.awt.BorderLayout.CENTER);

        container.add(barraTitulo, java.awt.BorderLayout.NORTH);

        content.setOpaque(false);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        abaGeral.setOpaque(false);

        tfCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCodigo.setText("jTextField1");

        tfNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNome.setText("jTextField1");

        cbGrupo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tfPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfPreco.setText("jTextField2");

        cbAtivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setText("Grupo");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setText("Preço");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("Ativo");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setText("Código");

        javax.swing.GroupLayout abaGeralLayout = new javax.swing.GroupLayout(abaGeral);
        abaGeral.setLayout(abaGeralLayout);
        abaGeralLayout.setHorizontalGroup(
            abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome)
                    .addComponent(cbGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(abaGeralLayout.createSequentialGroup()
                        .addGroup(abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 330, Short.MAX_VALUE)))
                .addContainerGap())
        );
        abaGeralLayout.setVerticalGroup(
            abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaGeralLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Geral", abaGeral);

        abaDescricao.setOpaque(false);

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        javax.swing.GroupLayout abaDescricaoLayout = new javax.swing.GroupLayout(abaDescricao);
        abaDescricao.setLayout(abaDescricaoLayout);
        abaDescricaoLayout.setHorizontalGroup(
            abaDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDescricaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );
        abaDescricaoLayout.setVerticalGroup(
            abaDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDescricaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Descrição", abaDescricao);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        container.add(content, java.awt.BorderLayout.CENTER);

        botoes.setOpaque(false);
        botoes.setPreferredSize(new java.awt.Dimension(10, 50));
        botoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 10, 10));

        cancelar.setButtonType(br.edu.materdei.tas.desktop.gui.core.TasDialogButton.DialogButtonType.DANGER_BUTTON);
        cancelar.setLabel("Cancelar");
        cancelar.setPreferredSize(new java.awt.Dimension(75, 30));
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelarMousePressed(evt);
            }
        });
        botoes.add(cancelar);

        salvar.setButtonType(br.edu.materdei.tas.desktop.gui.core.TasDialogButton.DialogButtonType.SUCCESS_BUTTON);
        salvar.setLabel("Salvar");
        salvar.setPreferredSize(new java.awt.Dimension(75, 30));
        salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                salvarMousePressed(evt);
            }
        });
        botoes.add(salvar);

        container.add(botoes, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMousePressed
        dispose();
    }//GEN-LAST:event_cancelarMousePressed

    private void salvarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarMousePressed
        try {
            validarDados();
            salvar();
        } catch (NotValidateException e) {
            TasDialogError dlgWarning = new TasDialogError(mainframe);
            dlgWarning.showError(TasDialogError.WARNING_ERROR, 
                                 "Preenchimento obrigatório", 
                                 e.getMessage(), 
                                 this.fieldsEmpty);
        }
    }//GEN-LAST:event_salvarMousePressed

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
        dispose();
    }//GEN-LAST:event_closeMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaDescricao;
    private javax.swing.JPanel abaGeral;
    private javax.swing.JPanel barraTitulo;
    private javax.swing.JPanel botoes;
    private br.edu.materdei.tas.desktop.gui.core.TasDialogButton cancelar;
    private javax.swing.JComboBox cbAtivo;
    private javax.swing.JComboBox cbGrupo;
    private br.edu.materdei.tas.desktop.gui.titlebar.TasCloseButton close;
    private javax.swing.JPanel container;
    private javax.swing.JPanel container1;
    private javax.swing.JPanel content;
    private javax.swing.JPanel divBottom;
    private javax.swing.JPanel divTop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel plLeft;
    private javax.swing.JPanel plRight;
    private br.edu.materdei.tas.desktop.gui.core.TasDialogButton salvar;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    private void setProduto(JSONObject produto) {
        this.produto = produto;
        tfCodigo.setText(produto.getString("codigo"));
        tfNome.setText(produto.getString("nome"));
        cbGrupo.getModel().setSelectedItem(produto.get("grupo"));
        
        //Preco
        if (produto.get("preco") != null) {
            /**
             * Para setar um valor ao campo de Preço, por ele usar um Document para 
             * formatar o valor digitado, é preciso converter para String e sem 
             * qualquer tipo de separador. */
            DecimalFormat df = new DecimalFormat("#.00");
            String preco = df.format(produto.getDouble("preco"));
            tfPreco.setText(preco.replace(",", ""));
        }
        
        //Ativo
        int ativoIndex = produto.getString("ativo").equals("S") ? 0 : 1;
        cbAtivo.setSelectedIndex(ativoIndex);
        taDescricao.setText(produto.getString("descricao"));
    }

    private void loadGrupos() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            this.mainframe.setStatus("Carregando grupos. Aguarde...");
           
            try {
                this.grupos = BackendService.findAll("grupos");
                
                cbGrupo.removeAllItems();
                for (Object object : this.grupos) {
                    JSONObject grupo = (JSONObject) object;
                    cbGrupo.addItem(grupo);
                }
                this.mainframe.setStatus("Pronto!");
            } catch (Exception e) {
                this.fail = true;
                
                TasDialogError dlgError = new TasDialogError(mainframe);
                dlgError.showError(TasDialogError.DANGER_ERROR, 
                                   "<html>Não foi possível carregar os Grupos. Clique em \"Detalhes\" Para visualizar o problema.</html>", 
                                   e.getMessage());
                this.mainframe.setStatus(new ImageIcon(getClass().getResource("/assets/system/icons/icon-warning-small.png")), 
                                             e.getMessage(), "Ops!");
                dispose();
            }
           
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    @Override
    public void salvar() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            this.mainframe.setStatus("Salvando registro. Aguarde...");            
            
            //Altera valor do objeto Produto
            produto.put("codigo", tfCodigo.getText());
            produto.put("nome", tfNome.getText());
            produto.put("descricao", taDescricao.getText());
            
            //Grupo
            JSONObject grupo = (JSONObject) cbGrupo.getModel().getSelectedItem();
            produto.put("grupo", grupo);
            
            //Preco
            String aux = tfPreco.getText().replace(".", "");
            Double preco = Double.valueOf(aux.replace(",", "."));
            produto.put("preco", preco);
            
            //Ativo
            String ativo = cbAtivo.getSelectedIndex() == 0 ? "S" : "N";
            produto.put("ativo", ativo);
           
            try {
                BackendService.save("produtos", this.produto);
                this.mainframe.setStatus("Pronto!");
            } catch (Exception e) {
                this.fail = true;
                
                TasDialogError dlgError = new TasDialogError(mainframe);
                dlgError.showError(TasDialogError.DANGER_ERROR, 
                                   "<html>Não foi possível salvar o registro. Clique em \"Detalhes\" Para visualizar o problema.</html>", 
                                   e.getMessage());
                this.mainframe.setStatus(new ImageIcon(getClass().getResource("/assets/system/icons/icon-warning-small.png")), 
                                             e.getMessage(), "Ops!");
            }
           
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            dispose();
        }
    }

    @Override
    public void validarDados() throws NotValidateException {
        
        this.fieldsEmpty = new ArrayList<>();
        
        if (tfCodigo.getText().equals("")) {
            this.fieldsEmpty.add("O campo \"Código\" deve ser preenchido.");
        }
        if (tfNome.getText().equals("")) {
            this.fieldsEmpty.add("O campo \"Nome\" deve ser preenchido.");
        }
        if (cbGrupo.getModel().getSelectedItem() == null) {
            this.fieldsEmpty.add("O campo \"Grupo\" deve ser preenchido.");
        }
        if (tfPreco.getText().equals("")) {
            this.fieldsEmpty.add("O campo \"Preço\" deve ser preenchido.");
        }
        if (cbAtivo.getSelectedIndex() < 0) {
            this.fieldsEmpty.add("O campo \"Ativo\" deve ser preenchido.");
        }
        
        //Verifica se ocorreu erro
        if (this.fieldsEmpty.size() > 0)
            throw new NotValidateException("<html>Alguns campos obrigatórios não foram preenchidos! Corrija e tente novamente.</html>");
    }
}