package br.ufpb.pacote.controllers;

import java.util.List;
import java.util.Map.Entry;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import br.ufpb.pacote.code.servicos.SistemaBarbeariaCL;
import br.ufpb.pacote.code.entidades.Cliente;

public class PesquisarClienteController {
    MainFrameController mainController = new MainFrameController();
    //SistemaBarbeariaCL sistema = new SistemaBarbeariaCL();
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    @FXML
    private TableView<Cliente> tableExibeClientes;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaTelefone;

    @FXML
    private TableColumn<Cliente, String> colunaEmail;


    @FXML 
    protected void initialize(){
        /*
        colunaNome.setCellValueFactory(cellData -> cellData.getValue().getNomeStringProperty());
        colunaTelefone.setCellValueFactory(cellData -> cellData.getValue().getTelefoneStringProperty());
        colunaEmail.setCellValueFactory(cellData -> cellData.getValue().getEmailStringProperty());
        */
        updateTable();
        MainFrameController.addOnChangeScreenListener(new MainFrameController.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen){
                if(newScreen.equals("pesquisaCliente")){
                    System.out.println("Entrando no Frame pesquisaCliente...");
                    for(Cliente c: mainController.sistema.getClientes().values()){ 
                        clientes.add(c);
                        System.out.println(c.getNome());
                    }
                    //atualizarTable();
                    tableExibeClientes.setItems(clientes);   
            
                }
            }
        });
    }
    
    @FXML
    private TextField tfTelefoneAPesquisar;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Pane panePesquisar;


    @FXML
    void pesquisarClienteTelefone(ActionEvent event) {
        if(!tfTelefoneAPesquisar.getText().isEmpty()){
            Cliente c = mainController.sistema.pesquisarCliente(tfTelefoneAPesquisar.getText());
            if(c != null){
                ObservableList<Cliente> clientesTemporarios = FXCollections.observableArrayList();
                clientesTemporarios.add(c);
                tableExibeClientes.setItems(clientesTemporarios);
                updateTable();
            }else{
                System.out.println("ta sendo null");
            }
        }else{
            tableExibeClientes.setItems(clientes);
            updateTable();
        }
    }
    
    /*
    //AQUI É A EXIBIÇÃO DAS POSSIBILIDADES NA TABELA
    public void atualizarTable(){
        for(Entry<String, Cliente> p: mainController.sistema.getClientes().entrySet()) {
            clientes.add(p.getValue());
        }
        
        System.out.println(clientes.size());
    }
    */
    void updateTable(){

        colunaNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Cliente,String>,ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Cliente, String> p){
                return p.getValue().getNomeStringProperty();
            }
        });
        colunaTelefone.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Cliente,String>,ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Cliente, String> p){
                return p.getValue().getTelefoneStringProperty();
            }
        });
        colunaEmail.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Cliente,String>,ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Cliente, String> p){
                return p.getValue().getEmailStringProperty();
            }
        });
    }
}
