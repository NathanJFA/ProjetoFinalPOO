package br.ufpb.pacote.controllers;

import java.util.Calendar;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import br.ufpb.pacote.code.entidades.Cliente;

public class ListagemHorariosController {

    ObservableList<String> horarios = FXCollections.observableArrayList();

    MainFrameController mainController = new MainFrameController();

    @FXML
    private Pane paneListagemHorarios;

    @FXML
    private TableView<String> tableHorarios;
    @FXML
    private TableColumn<String, String> colunaHorario;

    @FXML 
    protected void initialize(){
        

        
        MainFrameController.addOnChangeScreenListener(new MainFrameController.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen){
                if(newScreen.equals("listarHorario")){
                    System.out.println("Entrando no Frame listarHorarios...");
                    horarios = mainController.sistema.agendaDeHorarios.getHorariosAgendadosPropertySemSerProperty();
                    System.out.println("horarios tamanho " + horarios.size());
                    //colunaHorario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
                    //colunaHorario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
                    colunaHorario.setCellValueFactory(new Callback <CellDataFeatures<String, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(CellDataFeatures<String, String> p) {
                            // p.getValue() returns the Person instance for a particular TableView row
                            //return p.getValue().Property();
                            return new SimpleStringProperty(p.getValue());
                        }
                     });
                    
                     //atualizarTable();
                    tableHorarios.setItems(horarios);   
                }
            }
        });
    }

}
